package com.smart.mqtt.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mqtt 发布详情表
 * @author lizhonghao
 * @TableName t_mqtt_history
 */
@TableName(value ="t_mqtt_history")
@Data
public class MqttHistory implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 订阅者的ip
     */
    private String subIp;

    /**
     * 消费者的ip
     */
    private String pubIp;

    /**
     * 发布主题名
     */
    private String mqttTopic;

    /**
     * 订阅模式
     */
    private int mqttQos;

    /**
     * 是否发送或接收成功
     */
    private Boolean isSuccess;

    /**
     * 发送或接收的消息
     */
    private String mqttMsg;

    /**
     * 创建时间
     */
    private Date detectionTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}