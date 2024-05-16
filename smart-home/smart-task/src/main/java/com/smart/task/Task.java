package com.smart.task;

import com.smart.task.domain.ScheduleTask;

/**
 * @author Lico-Tom
 * 2023/10/31 0:52
 * @version V1.0
 */
public interface Task {
    /**
     * 任务执行接口
     * @param info 定时任务信息
     */
   void execute(ScheduleTask info);
}
