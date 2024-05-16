package com.smart.task.mapper;

import com.smart.task.domain.ScheduleTask;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_schedule_task】的数据库操作Mapper
* @createDate 2023-11-02 00:15:39
* @Entity com.smart.task.domain.TScheduleTask
*/
@Mapper
public interface ScheduleTaskMapper extends BaseMapper<ScheduleTask> {

}




