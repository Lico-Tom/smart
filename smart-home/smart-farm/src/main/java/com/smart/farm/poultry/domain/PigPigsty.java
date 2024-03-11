package com.smart.farm.poultry.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 猪栏表
 * @author lizhonghao
 * @TableName t_pig_pigsty
 */
@TableName(value ="t_pig_pigsty")
@Data
public class PigPigsty implements Serializable {
    /**
     * ID
     */
    @TableId
    private Long id;

    /**
     * 猪栏的长
     */
    private Integer length;

    /**
     * 猪栏的宽
     */
    private Long wide;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}