package com.smart.task.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.rest.api.domain.ScheduleTask;
import com.smart.rest.api.service.ScheduleTaskService;
import com.smart.task.mapper.ScheduleTaskMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* @author lizhonghao
* @description 针对表【t_schedule_task】的数据库操作Service实现
* @createDate 2023-11-02 00:15:39
*/
@Service
@Transactional(rollbackFor = {})
public class ScheduleTaskServiceImpl extends ServiceImpl<ScheduleTaskMapper, ScheduleTask>
    implements ScheduleTaskService {

    @Override
    public List<ScheduleTask> fetchScheduleTasksByScheduleTask(ScheduleTask scheduleTask) {
        return null;
    }
}




