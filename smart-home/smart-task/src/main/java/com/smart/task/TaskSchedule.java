package com.smart.task;

import com.smart.rest.api.domain.ScheduleTask;
import com.smart.task.entity.DaemonTaskEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
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

    private final ConcurrentMap<String, ScheduledFuture<?>> taskScheduleMap = new ConcurrentHashMap<>();

    private final Base64.Encoder encoder = Base64.getEncoder();

    private final Base64.Decoder decoder = Base64.getDecoder();

    @Autowired
    public TaskSchedule(ThreadPoolTaskScheduler threadPoolTaskScheduler,
                        ApplicationEventPublisher eventPublisher) {
        this.threadPoolTaskScheduler = threadPoolTaskScheduler;
        this.eventPublisher = eventPublisher;
    }

    public void start(ScheduleTask scheduleTask) {
        String key = encode(scheduleTask);
        // 判断是否是正在运行的任务
        if (!taskScheduleMap.containsKey(key)) {
            // 判断是否是修改了正则表达式的任务，需要删除原有的任务在启动新的任务
            for (String ks : taskScheduleMap.keySet()) {
                String[] deKey = new String(decoder.decode(ks), StandardCharsets.UTF_8).split("\\+");
                if (deKey[0].equals(String.valueOf(scheduleTask.getId()))) {
                    ScheduledFuture<?> scheduledFuture = threadPoolTaskScheduler.schedule(new TaskRunner(scheduleTask),
                            new CronTrigger(scheduleTask.getCronExpression()));
                    scheduleTask.setCronExpression(deKey[1]);
                    stop(scheduleTask);
                    taskScheduleMap.put(key, scheduledFuture);
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
        String key = encode(scheduleTask);
        ScheduledFuture<?> scheduledFuture = taskScheduleMap.get(key);
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
            taskScheduleMap.remove(key);
        }
        eventPublisher.publishEvent(new DaemonTaskEntity());
    }

    private String encode(ScheduleTask scheduleTask) {
        String code = String.format("%d+%s", scheduleTask.getId(), scheduleTask.getCronExpression());
        return new String(encoder.encode(code.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
    }

}
