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
 * @TableName t_mqtt_pub
 */
@TableName(value ="t_mqtt_pub")
@Data
public class MqttPub implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * mqtt的id
     */
    private Long mqttId;

    /**
     * 发布主题名
     */
    private String mqttTopic;

    /**
     * 订阅模式
     */
    private Boolean mqttQos;

    /**
     * 是否有效发布主题
     */
    private Boolean isValid;

    /**
     * 控制等级
     */
    private Boolean level;

    /**
     * 创建时间
     */
    private Date detectionTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}