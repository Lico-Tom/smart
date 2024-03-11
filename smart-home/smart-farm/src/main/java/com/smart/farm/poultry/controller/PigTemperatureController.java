package com.smart.farm.poultry.controller;

import com.smart.farm.poultry.service.PigTemperatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 1:02
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-temperature")
public class PigTemperatureController {

    private final PigTemperatureService pigTemperatureService;

    @Autowired
    public PigTemperatureController(PigTemperatureService pigTemperatureService) {
        this.pigTemperatureService = pigTemperatureService;
    }
}
