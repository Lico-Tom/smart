package com.smart.farm.poultry.controller;

import com.smart.farm.poultry.service.PigWeightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 1:04
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-weight")
public class PigWeightController {

    private final PigWeightService pigWeightService;

    @Autowired
    public PigWeightController(PigWeightService pigWeightService) {
        this.pigWeightService = pigWeightService;
    }
}
