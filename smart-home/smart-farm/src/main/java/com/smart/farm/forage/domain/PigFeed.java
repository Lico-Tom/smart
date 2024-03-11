package com.smart.farm.forage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 每包猪饲料表
 * @author lizhonghao
 * @TableName t_pig_feed
 */
@TableName(value ="t_pig_feed")
@Data
public class PigFeed implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 批次ID
     */
    private Integer totalId;

    /**
     * 1表示没过期，0表示过期
     */
    private Integer isExpired;

    /**
     * 消费日期
     */
    private Date consumerDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}