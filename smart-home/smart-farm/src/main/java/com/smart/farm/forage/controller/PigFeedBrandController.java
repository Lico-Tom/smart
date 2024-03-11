package com.smart.farm.forage.controller;

import com.smart.farm.forage.service.PigFeedBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 0:43
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-feed-brand")
public class PigFeedBrandController {

    private final PigFeedBrandService pigFeedBrandService;

    @Autowired
    public PigFeedBrandController(PigFeedBrandService pigFeedBrandService) {
        this.pigFeedBrandService = pigFeedBrandService;
    }
}
