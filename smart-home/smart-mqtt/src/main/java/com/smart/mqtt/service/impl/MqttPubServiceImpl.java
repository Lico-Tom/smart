package com.smart.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.mqtt.domain.MqttPub;
import com.smart.mqtt.service.MqttPubService;
import com.smart.mqtt.mapper.MqttPubMapper;
import org.springframework.stereotype.Service;

/**
 * @author lizhonghao
 * @description 针对表【t_mqtt_pub(mqtt 发布详情表)】的数据库操作Service实现
 * @createDate 2024-03-13 00:36:19
 */
@Service
public class MqttPubServiceImpl extends ServiceImpl<MqttPubMapper, MqttPub> implements MqttPubService {

    final MqttPubMapper mqttPubMapper;

    public MqttPubServiceImpl(MqttPubMapper mqttPubMapper) {
        this.mqttPubMapper = mqttPubMapper;
    }

    @Override
    public IPage<MqttPub> list(MqttPub mqttPub, int pageSize, int currentPage) {
        QueryWrapper<MqttPub> wrapper = new QueryWrapper<>();
        wrapper.eq(mqttPub.getId() != null, "id", mqttPub.getId());
        wrapper.eq(mqttPub.getMqttId() != null, "mqtt_id", mqttPub.getMqttId());
        wrapper.eq(mqttPub.getMqttTopic() != null, "mqtt_topic", mqttPub.getMqttTopic());
        Page<MqttPub> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return mqttPubMapper.selectPage(page, wrapper);
    }
}




