package com.smart.mqtt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.MqttHistory;
import com.smart.mqtt.service.MqttHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2024/3/14 0:36
 * @version V1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/mqtt-history")
public class MqttHistoryController {

    private final MqttHistoryService mqttHistoryService;

    @Autowired
    public MqttHistoryController(MqttHistoryService mqttHistoryService) {
        this.mqttHistoryService = mqttHistoryService;
    }

    @RequestMapping("/list")
    public ResponseEntity<IPage<MqttHistory>> list(MqttHistory mqttHistory,
                                                   @RequestParam(value = "pageSize") String pageSize,
                                                   @RequestParam(value = "currentPage") String currentPage) {
        IPage<MqttHistory> page = mqttHistoryService.list(Integer.parseInt(pageSize), Integer.parseInt(currentPage), mqttHistory);
        return ResponseEntity.ok(page);
    }
}
