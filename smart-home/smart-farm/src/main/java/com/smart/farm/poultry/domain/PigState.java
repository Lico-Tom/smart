package com.smart.farm.poultry.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 猪属性表
 * @author lizhonghao
 * @TableName t_pig_state
 */
@TableName(value ="t_pig_state")
@Data
public class PigState implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 生产该仔的母猪
     */
    private Long parent;

    /**
     * 出生体重
     */
    private Integer startWeight;

    /**
     * 出栏体重
     */
    private Long endWeight;

    /**
     * 出栏单价
     */
    private Long price;

    /**
     * 购买者
     */
    private String purchaser;

    /**
     * 电话号码
     */
    private Integer phoneNumber;

    /**
     * 饲养花费
     */
    private Long spend;

    /**
     * 猪栏编号
     */
    private Long pigstyNumber;

    /**
     * 出生日期
     */
    private Date birthday;

    /**
     * 出栏日期
     */
    private Date sellDate;

    /**
     * 单据图片
     */
    private byte[] bills;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}