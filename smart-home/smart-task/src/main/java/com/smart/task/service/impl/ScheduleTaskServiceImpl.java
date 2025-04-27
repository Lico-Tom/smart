package com.smart.task.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.task.domain.ScheduleTask;
import com.smart.task.mapper.ScheduleTaskMapper;
import com.smart.task.service.ScheduleTaskService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author lizhonghao
 * @description 针对表【t_schedule_task】的数据库操作Service实现
 * @createDate 2023-11-02 00:15:39
 */
@Service
public class ScheduleTaskServiceImpl extends ServiceImpl<ScheduleTaskMapper, ScheduleTask>
        implements ScheduleTaskService {

    private final ScheduleTaskMapper scheduleMapper;

    public ScheduleTaskServiceImpl(ScheduleTaskMapper scheduleMapper) {
        this.scheduleMapper = scheduleMapper;
    }

    @Override
    public List<ScheduleTask> fetchScheduleTasksByScheduleTask(ScheduleTask scheduleTask) {
        return null;
    }

    @Override
    public IPage<ScheduleTask> list(ScheduleTask scheduleTask, int pageSize, int currentPage) {
        QueryWrapper<ScheduleTask> wrapper = new QueryWrapper<>();
        wrapper.eq(scheduleTask.getId() != null, "id", scheduleTask.getId());
        wrapper.eq(scheduleTask.getTaskName() != null, "task_name", scheduleTask.getTaskName());
        wrapper.eq(scheduleTask.getCronExpression() != null, "cron_expression", scheduleTask.getCronExpression());
        Page<ScheduleTask> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return scheduleMapper.selectPage(page, wrapper);
    }
}




