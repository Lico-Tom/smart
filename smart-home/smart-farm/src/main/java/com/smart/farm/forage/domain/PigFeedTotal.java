package com.smart.farm.forage.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 采购饲料表
 * @author lizhonghao
 * @TableName t_pig_feed_total
 */
@TableName(value ="t_pig_feed_total")
@Data
public class PigFeedTotal implements Serializable {
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
     * 售卖单位
     */
    private String sellingUnit;

    /**
     * 电话号码
     */
    private Integer phoneNumber;

    /**
     * 购入总量/包
     */
    private Integer buyTotal;

    /**
     * 剩余总量/包
     */
    private Integer residueTotal;

    /**
     * 购入时/单价
     */
    private Integer price;

    /**
     * 生产日期
     */
    private Date productionDate;

    /**
     * 保质期/天
     */
    private Integer shelfLife;

    /**
     * 距离多久过期告警/天
     */
    private Integer expiredAlert;

    /**
     * 单据图片
     */
    private byte[] bills;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}