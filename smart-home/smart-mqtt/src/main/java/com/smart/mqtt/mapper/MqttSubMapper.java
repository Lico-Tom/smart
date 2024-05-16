package com.smart.mqtt.mapper;

import com.smart.mqtt.domain.MqttSub;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_mqtt_sub(mqtt 订阅详情表)】的数据库操作Mapper
* @createDate 2024-03-13 01:09:28
* @Entity com.smart.mqtt.domain.MqttSub
*/
@Mapper
public interface MqttSubMapper extends BaseMapper<MqttSub> {

}




