package com.smart.mqtt.mapper;

import com.smart.mqtt.domain.Mqtt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_mqtt(mqtt详情表)】的数据库操作Mapper
* @createDate 2024-03-13 01:08:54
* @Entity com.smart.mqtt.domain.Mqtt
*/
@Mapper
public interface MqttMapper extends BaseMapper<Mqtt> {

}




