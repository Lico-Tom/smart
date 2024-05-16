package com.smart.mqtt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.smart.mqtt.domain.Mqtt;
import com.smart.mqtt.service.MqttService;
import com.smart.mqtt.mapper.MqttMapper;
import org.springframework.stereotype.Service;

/**
 * @author lizhonghao
 * @description 针对表【t_mqtt(mqtt详情表)】的数据库操作Service实现
 * @createDate 2024-03-13 01:08:54
 */
@Service
public class MqttServiceImpl extends ServiceImpl<MqttMapper, Mqtt> implements MqttService {

    private final MqttMapper mqttMapper;

    public MqttServiceImpl(MqttMapper mqttMapper) {
        this.mqttMapper = mqttMapper;
    }

    @Override
    public IPage<Mqtt> list(Mqtt mqtt, int pageSize, int currentPage) {
        QueryWrapper<Mqtt> wrapper = new QueryWrapper<>();
        wrapper.eq(mqtt.getId() != null, "id", mqtt.getId());
        wrapper.eq(mqtt.getMqttAddr() != null, "mqtt_addr", mqtt.getMqttAddr());
        wrapper.eq(mqtt.getMqttUsername() != null, "mqtt_username", mqtt.getMqttUsername());
        wrapper.eq(mqtt.getIsValid() != null, "is_valid", mqtt.getIsValid());
        Page<Mqtt> page = new Page<>(currentPage, pageSize, count(wrapper));
        wrapper.last("LIMIT " + pageSize + " OFFSET " + (pageSize * (currentPage - 1)));
        return mqttMapper.selectPage(page, wrapper);
    }

}




