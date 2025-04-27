package com.smart.task;

import com.smart.task.domain.ScheduleTask;
import com.smart.task.domain.DaemonTaskEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ScheduledFuture;

/**
 * @author Lico-Tom
 * 2023/10/31 22:57
 * @version V1.0
 */
@Slf4j
@Component
public class TaskSchedule {

    private final ThreadPoolTaskScheduler threadPoolTaskScheduler;

    private final ApplicationEventPublisher eventPublisher;

    private final ConcurrentMap<Long, ScheduledFuture<?>> taskScheduleMap = new ConcurrentHashMap<>();

    @Autowired
    public TaskSchedule(ThreadPoolTaskScheduler threadPoolTaskScheduler,
                        ApplicationEventPublisher eventPublisher) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;
        this.eventPublisher = eventPublisher;
    }

    public void start(ScheduleTask scheduleTask) {
        // 判断是否是正在运行的任务
        if (!taskScheduleMap.containsKey(scheduleTask.getId())) {
            // 判断是否是修改了正则表达式的任务，需要删除原有的任务在启动新的任务
            for (Long ks : taskScheduleMap.keySet()) {
                if (Objects.equals(ks, scheduleTask.getId())) {
                    ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(new TaskRunner(scheduleTask),
                            new CronTrigger(scheduleTask.getCronExpression()));
                    scheduleTask.setCronExpression(scheduleTask.getCronExpression());
                    stop(scheduleTask);
                    taskScheduleMap.put(scheduleTask.getId(), scheduledFuture);
                    break;
                }
            }
        }
        eventPublisher.publishEvent(new DaemonTaskEntity());
    }

    /**
     * 停止任务进程并从内存中删除任务ID
     * @param scheduleTask
     */
    public void stop(ScheduleTask scheduleTask) {
        ScheduledFuture<?> scheduledFuture = taskScheduleMap.get(scheduleTask.getId());
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            taskScheduleMap.remove(scheduleTask.getId());
        }
        eventPublisher.publishEvent(new DaemonTaskEntity());
    }

}
