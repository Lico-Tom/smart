package com.smart.mqtt.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * mqtt 订阅详情表
 * @author lizhonghao
 * @TableName t_mqtt_sub
 */
@TableName(value ="t_mqtt_sub")
@Data
public class MqttSub implements Serializable {
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
     * 订阅主题名
     */
    private String mqttTopic;

    /**
     * 订阅模式
     */
    private int mqttQos;

    /**
     * 是否有效订阅
     */
    private Boolean isValid;

    /**
     * 创建时间
     */
    private Date detectionTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}