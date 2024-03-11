package com.smart.farm.forage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 猪饲料表
 * @author lizhonghao
 * @TableName t_pig_pigsty_feed
 */
@TableName(value ="t_pig_pigsty_feed")
@Data
public class PigPigstyFeed implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 猪饲料品牌ID
     */
    private Long brandId;

    /**
     * 猪栏编号
     */
    private Long pigstyNumber;

    /**
     * 每天使用的饲料量
     */
    private Integer feedWeight;

    /**
     * 天
     */
    private Date day;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}