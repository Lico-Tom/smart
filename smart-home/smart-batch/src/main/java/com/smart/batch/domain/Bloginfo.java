package com.smart.batch.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @author lizhonghao
 * @TableName t_bloginfo
 */

@Data
@TableName(value ="t_bloginfo")
public class Bloginfo implements Serializable {

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 博客作者标识
     */
    private String blogauthor;

    /**
     * 博客链接
     */
    private String blogurl;

    /**
     * 博客标题
     */
    private String blogtitle;

    /**
     * 博客栏目
     */
    private String blogitem;

}