package com.smart.mail.entity;

import lombok.Data;

import java.io.Serializable;


/**
 *
 * 邮件相关人员表：配置所有相关人员的的属性表，一个人一个记录
 * @author lizhonghao
 */
@Data
public class Personnel implements Serializable {

    /**
     * 序列ID
     */
    private Long id;
    /**
     * 邮件记录id
     */
    private Long mid;
    /**
     * 邮箱地址
     */
    private String email;
    /**
     * 所在的本次邮件是作为发送人0，收件人1，抄送人2，密送人3
     */
    private Integer type;
}