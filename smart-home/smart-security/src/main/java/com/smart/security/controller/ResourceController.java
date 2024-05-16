package com.smart.security.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.smart.security.domain.Resource;
import com.smart.security.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
 * 2023/12/4 22:57
 * @version V1.0
 */
@CrossOrigin
@RestController
@RequestMapping("/v1/smart/resource")
public class ResourceController {

    private final ResourceService resourceService;

    public ResourceController(ResourceService resourceService) {
        this.resourceService = resourceService;
    }

    @Operation(description = "获取角色相关资源")
    @GetMapping(value = "/listResource/{roleId}")
    public ResponseEntity<List<Resource>> listResource(@PathVariable Long roleId) {
        return new ResponseEntity<>(resourceService.listResource(roleId), HttpStatus.OK);
    }

    @Operation(description = "给角色分配资源")
    @PostMapping(value = "/allocResource")
    public ResponseEntity<Void> allocResource(@RequestParam Long roleId, @RequestParam List<Long> resourceIds) {
        boolean isAlloc = resourceService.allocResource(roleId, resourceIds);
        return new ResponseEntity<>(isAlloc ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "添加后台资源")
    @PostMapping(value = "")
    public ResponseEntity<Void> create(@RequestBody Resource resource) {
        return new ResponseEntity<>(resourceService.save(resource) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "修改后台资源")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody Resource resource) {
        resource.setId(id);
        boolean isUpdate = resourceService.saveOrUpdate(resource);
        return new ResponseEntity<>(isUpdate ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "根据ID获取资源详情")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Resource> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(resourceService.getById(id), HttpStatus.OK);
    }

    @Operation(description = "根据ID删除后台资源")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return new ResponseEntity<>(resourceService.removeById(id) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "分页模糊查询后台资源")
    @GetMapping(value = "/list")
    public ResponseEntity<IPage<Resource>> list(Resource resource,
                                               @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                                               @RequestParam(value = "currentPage", defaultValue = "1") String currentPage) {
        IPage<Resource> resourceList = resourceService.list(resource, Integer.parseInt(pageSize), Integer.parseInt(currentPage));
        return new ResponseEntity<>(resourceList, HttpStatus.OK);
    }

    @Operation(description = "查询所有后台资源")
    @GetMapping(value = "/listAll")
    public ResponseEntity<List<Resource>> listAll() {
        return new ResponseEntity<>(resourceService.list(), HttpStatus.OK);
    }
}
