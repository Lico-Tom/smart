package com.smart.task;

import com.smart.core.utils.ApplicationContextUtil;
import com.smart.task.domain.ScheduleTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;

/**
 * @author Lico-Tom
 * 2023/10/31 1:02
 * @version V1.0
 */
@Slf4j
public class TaskRunner implements Runnable {

    private final ScheduleTask info;

    private final ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();

    public TaskRunner(ScheduleTask info) {
        this.info = info;
    }

    @Override
    public void run() {
        try {
            Task task = (Task) applicationContext.getBean(Class.forName(info.getTaskName()));
            task.execute(info);
        } catch (Exception e) {
            log.error("[smart home] executing {} fail.", info.getTaskName(), e);
        }
    }
}
