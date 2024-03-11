package com.smart.farm.poultry.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.farm.poultry.domain.PigState;
import com.smart.farm.poultry.service.PigStateService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lico-Tom
 * 2023/12/14 1:00
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/pig-state")
public class PigStateController {

    private final PigStateService pigStateService;

    @Autowired
    public PigStateController(PigStateService pigStateService) {
        this.pigStateService = pigStateService;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody PigState pigState) {
        pigStateService.save(pigState);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        pigStateService.removeById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PigState pigState) {
        pigStateService.saveOrUpdate(pigState);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<IPage<PigState>> getPigState(PigState pigState,
                                                       @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                                                       @RequestParam(value = "currentPage", defaultValue = "1") String currentPage) {
        return new ResponseEntity<>(pigStateService.list(pigState, Integer.parseInt(pageSize), Integer.parseInt(currentPage)), HttpStatus.OK);
    }
}
