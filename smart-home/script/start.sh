#!/bin/bash

if [ -z "$MYSQL_IP" ]; then
    # 根据mysql pod的名字获取mysql的ip地址并写入环境变量
    MYSQL_IP=$(nslookup "$MYSQL_POD_NAME" | awk '/^Address: / {print $2}')
    echo "export MYSQL_IP=$MYSQL_IP" >> /etc/profile
fi

# 刷新环境变量
source /etc/profile

# 启动java程序
java -jar "${HOME_DIR}"/smart-home.jar