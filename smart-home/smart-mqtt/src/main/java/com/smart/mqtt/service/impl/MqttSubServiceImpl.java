package com.smart.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.mqtt.domain.MqttSub;
import com.smart.mqtt.service.MqttSubService;
import com.smart.mqtt.mapper.MqttSubMapper;
import org.springframework.stereotype.Service;

/**
* @author lizhonghao
* @description 针对表【t_mqtt_sub(mqtt 订阅详情表)】的数据库操作Service实现
* @createDate 2024-03-13 01:09:28
*/
@Service
public class MqttSubServiceImpl extends ServiceImpl<MqttSubMapper, MqttSub> implements MqttSubService{

    private final MqttSubMapper mqttMapper;

    public MqttSubServiceImpl(MqttSubMapper mqttMapper) {
        this.mqttMapper = mqttMapper;
    }

    @Override
    public IPage<MqttSub> list(MqttSub mqttSub, int pageSize, int currentPage) {
        QueryWrapper<MqttSub> wrapper = new QueryWrapper<>();
        wrapper.eq(mqttSub.getId() != null, "id", mqttSub.getId());
        wrapper.eq(mqttSub.getMqttId() != null, "mqtt_id", mqttSub.getMqttId());
        wrapper.eq(mqttSub.getMqttTopic() != null, "mqtt_topic", mqttSub.getMqttTopic());
        Page<MqttSub> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return mqttMapper.selectPage(page, wrapper);
    }
}




