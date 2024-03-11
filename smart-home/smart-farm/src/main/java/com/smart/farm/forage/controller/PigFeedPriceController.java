package com.smart.farm.forage.controller;

import com.smart.farm.forage.service.PigFeedPriceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 0:46
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-feed-price")
public class PigFeedPriceController {

    private final PigFeedPriceService pigFeedPriceService;

    @Autowired
    public PigFeedPriceController(PigFeedPriceService pigFeedPriceService) {
        this.pigFeedPriceService = pigFeedPriceService;
    }
}
