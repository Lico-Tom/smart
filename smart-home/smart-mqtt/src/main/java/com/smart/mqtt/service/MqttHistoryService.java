package com.smart.mqtt.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.MqttHistory;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author lizhonghao
* @description 针对表【t_mqtt_history(mqtt 发布详情表)】的数据库操作Service
* @createDate 2024-03-13 00:35:47
*/
public interface MqttHistoryService extends IService<MqttHistory> {

    /**
     * 分页查询mqtt历史记录
     *
     * @param pageSize
     * @param currentPage
     * @param mqttHistory
     * @return
     */
    IPage<MqttHistory> list(int pageSize, int currentPage, MqttHistory mqttHistory);
}
