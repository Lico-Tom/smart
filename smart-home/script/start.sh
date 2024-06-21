#!/bin/bash

if [ -z "$MYSQL_IP" ]; then
    # 根据mysql pod的名字获取mysql的ip地址并写入环境变量
    MYSQL_IP=$(nslookup "$MYSQL_POD_NAME" | awk '/^Address: / {print $2}')
    echo "export MYSQL_IP=$MYSQL_IP" >> /etc/profile
fi

# 刷新环境变量
source /etc/profile

# 添加opt参数
JAVA_OPTS="${JAVA_OPTS} -Dspring.profiles.active=prod"

# 设置 JVM启动时的初始堆内存(xms)，这有助于避免JVM在启动后不久就因为内存需求增长而进行垃圾回收，从而提高启动性能。
JAVA_OPTS="${JAVA_OPTS} -Xms${XMS:-4g}"

# 设置 JVM可以使用的最大堆内存(xmx)，确保应用程序有足够的内存来执行，同时也防止了JVM消耗过多的系统资源。
JAVA_OPTS="${JAVA_OPTS} -Xmx${XMX:-4g}"

# 适配 最大元空间(MetaspaceSize) 和 最大元空间(MaxMetaspaceSize) 参数
#为元数据区设置最大512MB的内存限制，JDK 8及之后版本的参数，用于限制元数据区的大小，元数据区是永久代的替代品。
JAVA_OPTS="${JAVA_OPTS} -XX:MaxMetaspaceSize=${MAX_METASPACE_SIZE:-256m} -XX:MetaspaceSize=${METASPACE_SIZE:-256m}"

# 适配 垃圾回收器设置
JAVA_OPTS="${JAVA_OPTS} -XX:+UseG1GC -XX:MaxGCPauseMillis=200 -XX:ParallelGCThreads=8"

#线程和锁优化 ThreadStackSize 避免栈溢出
JAVA_OPTS="${JAVA_OPTS} -XX:ThreadStackSize=256k"
#UseBiasedLocking 偏向锁 启用偏向锁，减少无竞争情况下的同步开销，提高并发性能，特别是在有大量线程竞争同一锁的情况下。
JAVA_OPTS="${JAVA_OPTS} -XX:UseBiasedLocking=true"
#启用G1 GC的MMU（内存管理单元）统计信息，有助于监控和调优G1 GC的性能。
JAVA_OPTS="${JAVA_OPTS} -XX:+UseG1MMUStatistics"

# 适配 性能监控和调试
#输出详细的GC日志，有助于分析和调优GC行为，是性能调优的重要工具。
JAVA_OPTS="${JAVA_OPTS} -XX:+PrintGCDetails"
#输出有关应用程序锁的信息，有助于识别锁竞争问题，对于解决并发问题至关重要。
JAVA_OPTS="${JAVA_OPTS} -XX:+PrintConcurrentLocks"
#在内存溢出时生成堆转储文件，便于事后分析内存问题，有助于诊断内存泄漏等问题。
JAVA_OPTS="${JAVA_OPTS} -XX:+HeapDumpOnOutOfMemoryError"
#设置堆转储文件的路径，方便分析和调试，确保在需要时能够快速定位问题。
JAVA_OPTS="${JAVA_OPTS} -XX:HeapDumpPath=${HOME_DIR}/logs/heap_dump.hprof"

# 启动java程序
java -jar "${JAVA_OPTS}" "${HOME_DIR}"/smart-home.jar