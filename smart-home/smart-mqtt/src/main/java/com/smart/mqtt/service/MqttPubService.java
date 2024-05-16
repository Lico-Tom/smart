package com.smart.mqtt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.MqttPub;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_mqtt_pub(mqtt 发布详情表)】的数据库操作Service
* @createDate 2024-03-13 00:36:19
*/
public interface MqttPubService extends IService<MqttPub> {

    /**
     * 查询mqtt发布列表
     * @param mqttPub
     * @param pageSize
     * @param currentPage
     * @return
     */
     IPage<MqttPub> list(MqttPub mqttPub, int pageSize, int currentPage);
}
