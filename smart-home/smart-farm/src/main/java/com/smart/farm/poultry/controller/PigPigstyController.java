package com.smart.farm.poultry.controller;

import com.smart.farm.poultry.service.PigPigstyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 0:58
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-pigsty")
public class PigPigstyController {

    private final PigPigstyService pigPigstyService;

    @Autowired
    public PigPigstyController(PigPigstyService pigPigstyService) {
        this.pigPigstyService = pigPigstyService;
    }
}
