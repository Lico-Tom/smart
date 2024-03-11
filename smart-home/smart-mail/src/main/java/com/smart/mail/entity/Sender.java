package com.smart.mail.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * 邮件发送人表：配置发送人的属性表
 *
 * @author lizhonghao
 */
@Data
public class Sender implements Serializable {

    private Long id;
    /**
     * 发件人员工ID
     */
    private Long sid;
    /**
     * 发件人职位
     */
    private String position;
    /**
     * 发件人邮箱
     */
    private String email;

}