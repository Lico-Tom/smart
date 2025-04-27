package com.smart.task.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.task.domain.ScheduleTask;
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
     */
    List<ScheduleTask> fetchScheduleTasksByScheduleTask(ScheduleTask scheduleTask);

    /**
     * 分页查询
     */
    IPage<ScheduleTask> list(ScheduleTask scheduleTask, int pageSize, int currentPage);
}
