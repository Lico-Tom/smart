package com.smart.security.controller;

import com.smart.security.domain.Role;
import com.smart.security.service.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Lico-Tom
 * 2023/12/4 22:23
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @Operation(description = "添加角色")
    @PostMapping(value = "/create")
    public ResponseEntity<Void> create(@RequestBody Role role) {
        return new ResponseEntity<>(roleService.save(role) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "修改角色")
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody Role role) {
        role.setId(id);
        return new ResponseEntity<>(roleService.saveOrUpdate(role) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "批量删除角色")
    @DeleteMapping(value = "/delete")
    public ResponseEntity<Void> delete(@RequestParam("ids") List<Long> ids) {
        return new ResponseEntity<>(roleService.removeBatchByIds(ids) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "获取所有角色")
    @GetMapping(value = "/listAll")
    public ResponseEntity<List<Role>> listAll() {
        return new ResponseEntity<>(roleService.list(), HttpStatus.OK);
    }

    @Operation(description = "根据角色名称分页获取角色列表")
    @GetMapping(value = "/list")
    public ResponseEntity<List<Role>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        return new ResponseEntity<>(roleService.list(keyword, pageSize, pageNum), HttpStatus.OK);
    }

    @Operation(description = "修改角色状态")
    @PostMapping(value = "/updateStatus/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id,
                                       @RequestParam(value = "status") Integer status) {
        boolean isUpdate = roleService.updateStatusById(id, status);
        return new ResponseEntity<>(isUpdate ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }


    @Operation(description = "给用户分配角色")
    @PostMapping(value = "/role/update")
    public ResponseEntity<Void> updateRole(@RequestParam("userId") Long userId,
                                           @RequestParam("roleIds") List<Long> roleIds) {
        boolean isUpdate = roleService.updateRole(userId, roleIds);
        return new ResponseEntity<>(isUpdate ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "获取指定用户的角色")
    @GetMapping(value = "/role/{userId}")
    public ResponseEntity<List<Role>> getRoleList(@PathVariable Long userId) {
        List<Role> roleList = roleService.getRoleList(userId);
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }

}
