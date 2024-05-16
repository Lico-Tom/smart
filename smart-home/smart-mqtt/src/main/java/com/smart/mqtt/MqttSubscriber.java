package com.smart.mqtt;

import com.smart.mqtt.domain.Mqtt;
import com.smart.mqtt.domain.MqttSub;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


/**
 * @author Lico-Tom
 * 2024/3/11 23:47
 * @version V1.0
 */
@Slf4j
@Component
public class MqttSubscriber {

    private final Random random = new SecureRandom();

    private final String clientId = "DC" + random.nextLong();

    private final Map<String, MqttClient> mqttClientMap = new HashMap<>();

    public void subMqttTopic(Mqtt mqtt, List<MqttSub> mqttSubs) {
        MqttClient mqttClient = mqttClientMap.getOrDefault(mqtt.getMqttAddr(), null);
        if (mqttClient == null) {
            try {
                // 设置连接参数
                MqttConnectOptions mqttConnectOptions = new MqttConnectOptions();
                mqttConnectOptions.setUserName(mqtt.getMqttUsername());
                mqttConnectOptions.setPassword(mqtt.getMqttPasswd().toCharArray());
                mqttConnectOptions.setConnectionTimeout(mqtt.getConnectTimeout());
                mqttConnectOptions.setAutomaticReconnect(mqtt.getAutomaticReconnect());
                mqttConnectOptions.setCleanSession(mqtt.getCleanSession());
                mqttConnectOptions.setKeepAliveInterval(mqtt.getKeepaliveInterval());
                mqttClient = new MqttClient(mqtt.getMqttAddr(), clientId, new MemoryPersistence());
            } catch (MqttException e) {
                // todo 重试3次 延时
                subMqttTopic(mqtt, mqttSubs);
                throw new RuntimeException(e);
            }
        }

        String[] mqttTopics = new String[mqttSubs.size()];
        int[] mqttQoss = new int[mqttSubs.size()];
        for (int i = 0; i < mqttSubs.size(); i++) {
            mqttTopics[i] = mqttSubs.get(i).getMqttTopic();
            mqttQoss[i] = mqttSubs.get(i).getMqttQos();
        }
        try {
            mqttClient.subscribe(mqttTopics, mqttQoss);
        } catch (MqttException e) {
            // todo 订阅失败 重试3次
        }
        mqttClient.setCallback(new MqttCallbackImpl());
    }
}
