package com.smart.farm.forage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 猪饲料品牌表
 * @author lizhonghao
 * @TableName t_pig_feed_brand
 */
@TableName(value ="t_pig_feed_brand")
@Data
public class PigFeedBrand implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 猪饲料品牌名
     */
    private String brandName;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}