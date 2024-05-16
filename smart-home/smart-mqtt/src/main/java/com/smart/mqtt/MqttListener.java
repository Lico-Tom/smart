package com.smart.mqtt;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.smart.mqtt.domain.Mqtt;
import com.smart.mqtt.domain.MqttSub;
import com.smart.mqtt.service.MqttService;
import com.smart.mqtt.service.MqttSubService;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Lico-Tom
 * 2024/3/12 0:17
 * @version V1.0
 */
@Slf4j
@Aspect
@Component
public class MqttListener implements ApplicationListener<ContextRefreshedEvent> {

    private final MqttService mqttService;

    private final MqttSubService mqttSubService;

    private final MqttSubscriber mqttConnect;

    public MqttListener(MqttService mqttService, MqttSubscriber mqttConnect, MqttSubService mqttSubService) {
        this.mqttService = mqttService;
        this.mqttConnect = mqttConnect;
        this.mqttSubService = mqttSubService;
    }

    @Pointcut(value = "execution(public boolean com.baomidou.mybatisplus.extension.service.IService.save*(com.smart.mqtt.domain.Mqtt))")
    public void listen2SaveMqttPoint() {
    }

    @Pointcut(value = "execution(public boolean com.baomidou.mybatisplus.extension.service.IService.save*(com.smart.mqtt.domain.MqttSub))")
    public void listen2SaveMqttSubPoint() {
    }

    @Around(value = "listen2SaveMqttPoint()", argNames = "proceedingJoinPoint")
    public boolean listen2SaveMqttPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean bool = (boolean) proceedingJoinPoint.proceed();
        if (bool) {
            Mqtt mqtt = (Mqtt) proceedingJoinPoint.getArgs()[0];
            QueryWrapper<MqttSub> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("is_valid", 0);
            queryWrapper.eq("mqtt_id", mqtt.getId());
            List<MqttSub> mqttSubs = mqttSubService.list(queryWrapper);
            mqttConnect.subMqttTopic(mqtt, mqttSubs);
        }
        return bool;
    }

    @Around(value = "listen2SaveMqttSubPoint()", argNames = "proceedingJoinPoint")
    public boolean listen2SaveMqttSubPoint(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        boolean bool = (boolean) proceedingJoinPoint.proceed();
        if (bool) {
            MqttSub mqttSub = (MqttSub) proceedingJoinPoint.getArgs()[0];
            Mqtt mqtt = mqttService.getById(mqttSub.getMqttId());
            QueryWrapper<MqttSub> wrapper = new QueryWrapper<>();
            wrapper.eq("is_valid", 0);
            wrapper.eq("id", mqttSub.getMqttId());
            List<MqttSub> mqttSubs = new ArrayList<>();
            mqttSubs.add(mqttSub);
            mqttConnect.subMqttTopic(mqtt, mqttSubs);
        }
        return bool;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        QueryWrapper<Mqtt> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_valid", 0);
        List<Mqtt> mqtts = mqttService.list(queryWrapper);
        for (Mqtt mqtt : mqtts) {
            QueryWrapper<MqttSub> wrapper = new QueryWrapper<>();
            queryWrapper.eq("is_valid", 0);
            List<MqttSub> mqttSubs = mqttSubService.list(wrapper);
            mqttConnect.subMqttTopic(mqtt, mqttSubs);
        }
    }


}
