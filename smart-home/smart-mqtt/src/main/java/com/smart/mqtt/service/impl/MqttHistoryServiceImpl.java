package com.smart.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.mqtt.domain.MqttHistory;
import com.smart.mqtt.service.MqttHistoryService;
import com.smart.mqtt.mapper.MqttHistoryMapper;
import org.springframework.stereotype.Service;

/**
 * @author lizhonghao
 * @description 针对表【t_mqtt_history(mqtt 发布详情表)】的数据库操作Service实现
 * @createDate 2024-03-13 00:35:47
 */
@Service
public class MqttHistoryServiceImpl extends ServiceImpl<MqttHistoryMapper, MqttHistory> implements MqttHistoryService {


    private final MqttHistoryMapper mqttHistoryMapper;

    MqttHistoryServiceImpl(MqttHistoryMapper mqttHistoryMapper) {
        this.mqttHistoryMapper = mqttHistoryMapper;
    }

    @Override
    public IPage<MqttHistory> list(int pageSize, int currentPage, MqttHistory mqttHistory) {
        QueryWrapper<MqttHistory> wrapper = new QueryWrapper<>();
        wrapper.eq(mqttHistory.getId() != null, "id", mqttHistory.getId());
        wrapper.eq(mqttHistory.getMqttTopic() != null, "mqtt_topic", mqttHistory.getMqttTopic());
        wrapper.eq(mqttHistory.getPubIp() != null, "pub_ip", mqttHistory.getPubIp());
        wrapper.eq(mqttHistory.getSubIp() != null, "sub_ip", mqttHistory.getSubIp());
        Page<MqttHistory> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return mqttHistoryMapper.selectPage(page, wrapper);
    }
}




