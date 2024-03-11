package com.smart.farm.forage.controller;

import com.smart.farm.forage.service.PigPigstyFeedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2023/12/14 0:49
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-pigsty-feed")
public class PigPigstyFeedController {

    private final PigPigstyFeedService pigPigstyFeedService;

    @Autowired
    public PigPigstyFeedController(PigPigstyFeedService pigPigstyFeedService) {
        this.pigPigstyFeedService = pigPigstyFeedService;
    }
}
