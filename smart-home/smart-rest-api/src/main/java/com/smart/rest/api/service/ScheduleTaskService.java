package com.smart.rest.api.service;

import com.smart.rest.api.domain.ScheduleTask;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author lizhonghao
 * @description 针对表【t_schedule_task】的数据库操作Service
 * @createDate 2023-11-02 00:15:39
 */
public interface ScheduleTaskService extends IService<ScheduleTask> {

    /**
     * 多条件查询
     * @param scheduleTask
     * @return
     */
    List<ScheduleTask> fetchScheduleTasksByScheduleTask(ScheduleTask scheduleTask);
}
