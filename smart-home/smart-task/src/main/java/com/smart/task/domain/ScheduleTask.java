package com.smart.task.domain;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import com.smart.core.constant.Constant;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lizhonghao
 * @TableName t_schedule_task
 */

@Data
@Valid
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
@Schema(name = "t_schedule_task")
@TableName(value = "t_schedule_task")
public class ScheduleTask implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @NotNull
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")
    @ExcelProperty(value = "任务id", index = 1)
    @SchemaProperty(name = "id")
    private Long id;

    /**
     * 任务名称
     */
    @NotNull
    @TableField(value = "task_name")
    @ExcelProperty(value = "任务名称", index = 2)
    @SchemaProperty(name = "taskName")
    private String taskName;

    /**
     * 定时任务表达式
     */
    @TableField(value = "cron_expression")
    @ExcelProperty(value = "定时任务表达式", index = 3)
    @SchemaProperty(name = "cronExpression")
    private String cronExpression;

    /**
     * 详情
     */
    @NotNull
    @TableField(value = "details")
    @ExcelProperty(value = "详情", index = 4)
    @SchemaProperty(name = "details")
    private String details;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    @ExcelProperty(value = "创建时间", index = 5)
    @SchemaProperty(name = "createTime")
    private Date createTime;

    /**
     * 更新时间
     */
    @TableField(value = "modify_time")
    @ExcelProperty(value = "更新时间", index = 6)
    @SchemaProperty(name = "modifyTime")
    private Date modifyTime;

}