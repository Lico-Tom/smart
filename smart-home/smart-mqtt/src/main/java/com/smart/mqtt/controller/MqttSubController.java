package com.smart.mqtt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.MqttSub;
import com.smart.mqtt.service.MqttSubService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Lico-Tom
 * 2024/3/14 0:38
 * @version V1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/mqtt-sub")
public class MqttSubController {

    private MqttSubService mqttSubService;

    public MqttSubController(MqttSubService mqttSubService) {
        this.mqttSubService = mqttSubService;
    }

    @RequestMapping("/list")
    public ResponseEntity<IPage<MqttSub>> list(MqttSub mqttSub,
                                              @RequestParam(value = "pageSize") String pageSize,
                                              @RequestParam(value = "currentPage") String currentPage){
        IPage<MqttSub> page = mqttSubService.list(mqttSub, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return ResponseEntity.ok(page);
    }
}
