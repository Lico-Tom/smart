package com.smart.security.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 后台用户和角色关系表
 * @author lizhonghao
 * @TableName t_user_role_relation
 */
@TableName(value ="t_user_role_relation")
@Data
public class UserRoleRelation implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 
     */
    private Long adminId;

    /**
     * 
     */
    private Long roleId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}