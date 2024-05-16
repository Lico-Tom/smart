package com.smart.mqtt;

import com.smart.core.utils.ApplicationContextUtil;
import com.smart.mqtt.domain.MqttHistory;
import com.smart.mqtt.service.MqttHistoryService;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

/**
 * @author Lico-Tom
 * 2024/3/12 0:12
 * @version V1.0
 */
@Slf4j
public class MqttCallbackImpl implements MqttCallback {

    private final MqttHistoryService mqttHistoryService;

    public MqttCallbackImpl() {
        this.mqttHistoryService = ApplicationContextUtil.getApplicationContext().getBean(MqttHistoryService.class);
    }

    @Override
    public void connectionLost(Throwable cause) {
        log.info("断开了MQTT连接 ：{}", cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) {
        MqttHistory mqttHistory = new MqttHistory();
        mqttHistory.setMqttMsg(new String(message.getPayload()));
        mqttHistory.setMqttQos(message.getQos());
        mqttHistory.setMqttTopic(topic);
        mqttHistory.setIsSuccess(true);
        mqttHistoryService.save(mqttHistory);
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        log.info("发布消息成功");
    }
}
