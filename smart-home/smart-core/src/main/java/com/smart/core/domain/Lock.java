package com.smart.core.domain;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author lizhonghao
 * @TableName t_lock
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ExcelIgnoreUnannotated
@TableName(value ="t_lock")
public class Lock implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 任务ID
     */
    @TableId
    @TableField(value = "task_id")
    private String taskId;

    /**
     * 锁存活时间
     */
    @TableField(value = "expire")
    private Integer expire;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

}