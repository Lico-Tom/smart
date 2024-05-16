package com.smart.security.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.security.domain.Resource;
import com.smart.security.domain.ResourceCategory;
import com.smart.security.service.ResourceCategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lico-Tom
 * 2024/4/28 23:40
 * @version V1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/smart/resource-category")
public class ResourceCategoryController {

    private final ResourceCategoryService resourceCategoryService;

    public ResourceCategoryController(ResourceCategoryService resourceCategoryService) {
        this.resourceCategoryService = resourceCategoryService;
    }

    @Operation(description = "分页模糊查询后台资源")
    @GetMapping(value = "/list")
    public ResponseEntity<IPage<ResourceCategory>> list(ResourceCategory resourceCategory,
                                                @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                                                @RequestParam(value = "currentPage", defaultValue = "1") String currentPage) {
        IPage<ResourceCategory> resourceList = resourceCategoryService.list(resourceCategory, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return new ResponseEntity<>(resourceList, HttpStatus.OK);
    }
}
