package com.smart.mail.entity;

import lombok.Data;

import java.io.Serializable;

/**
 *
 * 邮件发送记录表：只要发送一个邮件，就在此产生一个记录
 * @author lizhonghao
 */
@Data
public class Recoder implements Serializable {

    /**
     * 主键，记录ID
     */
    private Long id;
    /**
     * 每一个邮件对应一个mid,201810110001
     */
    private Long mid;
    /**
     * 邮件内容：包括收件人、主题、内容
     */
    private String mail;
    /**
     * 每发送一个邮件，不论成功还是失败，都要插入一条记录
     */
    private String status;
    /**
     * 相关人员列表
     */
    private String persons;
    /**
     * 邮件中的文件对象
     */
    private String files;

}