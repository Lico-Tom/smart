package com.smart.farm.poultry.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 体温表
 * @author lizhonghao
 * @TableName t_pig_temperature
 */
@TableName(value ="t_pig_temperature")
@Data
public class PigTemperature implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 猪id
     */
    private Long pigId;

    /**
     * 体温°C
     */
    private Integer temperature;

    /**
     * 称重时间
     */
    private Date detectionTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}