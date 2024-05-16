package com.smart.mqtt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.MqttPub;
import com.smart.mqtt.service.MqttPubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2024/3/14 0:37
 * @version V1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/mqtt-pub")
public class MqttPubController {

    private final MqttPubService mqttPubService;

    @Autowired
    public MqttPubController(MqttPubService mqttPubService) {
        this.mqttPubService = mqttPubService;
    }

    @RequestMapping("/list")
    public ResponseEntity<IPage<MqttPub>> list(MqttPub mqttPub,
                                               @RequestParam(value = "pageSize") String pageSize,
                                               @RequestParam(value = "currentPage") String currentPage) {
        IPage<MqttPub> page = mqttPubService.list(mqttPub, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return ResponseEntity.ok(page);
    }
}
