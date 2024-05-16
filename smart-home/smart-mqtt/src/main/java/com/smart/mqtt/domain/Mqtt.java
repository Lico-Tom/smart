package com.smart.mqtt.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mqtt详情表
 * @author lizhonghao
 * @TableName t_mqtt
 */
@TableName(value ="t_mqtt")
@Data
public class Mqtt implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * mqtt地址
     */
    private String mqttAddr;

    /**
     * 账号
     */
    private String mqttUsername;

    /**
     * 加密密码
     */
    private String mqttPasswd;

    /**
     * 连接超时时间
     */
    private Integer connectTimeout;

    /**
     * 存活时间
     */
    private Integer keepaliveInterval;

    /**
     * 自动尝试连接 0 true 1 false
     */
    private Boolean automaticReconnect;

    /**
     * 重连是是否记住状态
     */
    private Boolean cleanSession;

    /**
     * 描述
     */
    private String mqttDescribe;

    /**
     * 是否有效地址
     */
    private Boolean isValid;

    /**
     * 创建时间
     */
    private Date detectionTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}