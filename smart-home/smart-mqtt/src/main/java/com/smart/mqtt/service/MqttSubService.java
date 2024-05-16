package com.smart.mqtt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.MqttSub;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_mqtt_sub(mqtt 订阅详情表)】的数据库操作Service
* @createDate 2024-03-13 01:09:28
*/
public interface MqttSubService extends IService<MqttSub> {

    /**
     * 分页查询
     * @param mqttSub
     * @param pageSize
     * @param currentPage
     * @return
     */
    IPage<MqttSub> list(MqttSub mqttSub, int pageSize, int currentPage);
}
