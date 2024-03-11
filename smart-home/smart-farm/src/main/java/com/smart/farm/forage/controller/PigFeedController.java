package com.smart.farm.forage.controller;

import com.smart.farm.forage.service.PigFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 0:47
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-feed")
public class PigFeedController {

    private final PigFeedService pigFeedService;

    @Autowired
    public PigFeedController(PigFeedService pigFeedService) {
        this.pigFeedService = pigFeedService;
    }
}
