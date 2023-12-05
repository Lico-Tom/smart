package com.smart.security.controller;

import com.smart.security.domain.Menu;
import com.smart.security.dto.MenuNode;
import com.smart.security.service.MenuService;
import io.swagger.v3.oas.annotations.Operation;
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
 * 2023/12/4 22:55
 * @version V1.0
 */
@RestController
@RequestMapping("/v1/smart/menu")
public class MenuController {

    private final MenuService menuService;

    @Autowired
    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @Operation(description = "获取角色相关菜单")
    @GetMapping(value = "/listMenu/{roleId}")
    public ResponseEntity<List<Menu>> listMenu(@PathVariable Long roleId) {
        return new ResponseEntity<>(menuService.listMenu(roleId), HttpStatus.OK);
    }

    @Operation(description = "给角色分配菜单")
    @PostMapping(value = "/allocMenu")
    public ResponseEntity<Void> allocMenu(@RequestParam Long roleId,
                                          @RequestParam List<Long> menuIds) {
        boolean isAlloc = menuService.allocMenu(roleId, menuIds);
        return new ResponseEntity<>(isAlloc ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "添加后台菜单")
    @PostMapping(value = "")
    public ResponseEntity<Void> create(@RequestBody Menu menu) {
        return new ResponseEntity<>(menuService.save(menu) ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "修改后台菜单")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id,
                                       @RequestBody Menu menu) {
        menu.setId(id);
        return new ResponseEntity<>(menuService.saveOrUpdate(menu) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "根据ID获取菜单详情")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Menu> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.getById(id), HttpStatus.OK);
    }

    @Operation(description = "根据ID删除后台菜单")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.removeById(id) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "分页查询后台菜单")
    @GetMapping(value = "/{parentId}")
    public ResponseEntity<List<Menu>> list(@PathVariable Long parentId,
                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<Menu> menuList = menuService.list(parentId, pageSize, pageNum);
        return new ResponseEntity<>(menuList, HttpStatus.OK);
    }

    @Operation(description = "树形结构返回所有菜单列表")
    @GetMapping(value = "/treeList")
    public ResponseEntity<List<MenuNode>> treeList() {
        return new ResponseEntity<>(menuService.treeList(), HttpStatus.OK);
    }

    @Operation(description = "修改菜单显示状态")
    @PostMapping(value = "/updateHidden/{id}")
    public ResponseEntity<Void> updateHidden(@PathVariable Long id,
                                             @RequestParam("hidden") Integer hidden) {
        return new ResponseEntity<>(menuService.updateHidden(id, hidden) ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }
}
