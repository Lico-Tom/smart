package com.smart.task.ins;

import com.smart.task.TaskSchedule;
import com.smart.task.domain.ScheduleTask;
import com.smart.task.service.ScheduleTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Lico-Tom
 * 2023/10/31 6:36
 * @version V1.0
 */
@Component
public class DaemonTask {

    private final TaskSchedule taskSchedule;

    private final ScheduleTaskService scheduleTaskService;


    @Autowired
    public DaemonTask(TaskSchedule taskSchedule, ScheduleTaskService scheduleTaskService) {
        this.taskSchedule = taskSchedule;
        this.scheduleTaskService = scheduleTaskService;
    }

    //@Scheduled(cron = "0/3 * * * * ?")
    @PostConstruct
    private void initDaemonTask() {
        List<ScheduleTask> taskInfos = scheduleTaskService.list();
        taskInfos.forEach(taskSchedule::start);
    }
}
