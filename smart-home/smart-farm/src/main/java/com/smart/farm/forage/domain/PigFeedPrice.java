package com.smart.farm.forage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 猪饲料价格表
 * @author lizhonghao
 * @TableName t_pig_feed_price
 */
@TableName(value ="t_pig_feed_price")
@Data
public class PigFeedPrice implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 猪饲料品牌
     */
    private Integer brandId;

    /**
     * 价格
     */
    private Integer price;

    /**
     * 天
     */
    private Date day;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}