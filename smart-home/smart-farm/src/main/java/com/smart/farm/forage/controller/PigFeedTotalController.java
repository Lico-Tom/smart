package com.smart.farm.forage.controller;

import com.smart.farm.forage.service.PigFeedTotalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 0:48
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-feed-total")
public class PigFeedTotalController {

    private final PigFeedTotalService pigFeedTotalService;

    @Autowired
    public PigFeedTotalController(PigFeedTotalService pigFeedTotalService) {
        this.pigFeedTotalService = pigFeedTotalService;
    }
}
