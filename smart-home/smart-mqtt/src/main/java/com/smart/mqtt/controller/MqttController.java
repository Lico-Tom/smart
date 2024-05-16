package com.smart.mqtt.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.mqtt.domain.Mqtt;
import com.smart.mqtt.service.MqttService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/v1/mqtt")
public class MqttController {

    private final MqttService mqttService;

    @Autowired
    public MqttController(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    @GetMapping("/list")
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "请求成功")
    )
    public ResponseEntity<IPage<Mqtt>> fetchAllScheduleTask(Mqtt mqtt,
                                                            @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                                                            @RequestParam(value = "currentPage", defaultValue = "1") String currentPage) {
        IPage<Mqtt> mqtts = mqttService.list(mqtt, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return new ResponseEntity<>(mqtts, HttpStatus.OK);
    }


}
