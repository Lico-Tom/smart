package com.smart.mqtt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.Mqtt;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_mqtt(mqtt详情表)】的数据库操作Service
* @createDate 2024-03-13 01:08:54
*/
public interface MqttService extends IService<Mqtt> {

    IPage<Mqtt> list(Mqtt mqtt, int pageSize, int currentPage);
}
