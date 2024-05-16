package com.smart.mqtt.mapper;

import com.smart.mqtt.domain.MqttPub;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author lizhonghao
* @description 针对表【t_mqtt_pub(mqtt 发布详情表)】的数据库操作Mapper
* @createDate 2024-03-13 00:36:19
* @Entity com.smart.mqtt.domain.MqttPub
*/
@Mapper
public interface MqttPubMapper extends BaseMapper<MqttPub> {

}




