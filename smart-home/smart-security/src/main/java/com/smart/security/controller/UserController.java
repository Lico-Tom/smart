package com.smart.security.controller;

import cn.hutool.core.collection.CollUtil;
import com.smart.security.UpdatePasswordStatus;
import com.smart.security.domain.LoginParam;
import com.smart.security.domain.Role;
import com.smart.security.domain.UpdatePasswordParam;
import com.smart.security.domain.User;
import com.smart.security.domain.UserParam;
import com.smart.security.service.RoleService;
import com.smart.security.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Lico-Tom
 * 2023/12/3 10:14
 * @version V1.0
 */
@Validated
@RestController
@RequestMapping("/v1/smart/user")
public class UserController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @Operation(description = "用户注册")
    @PostMapping(value = "/register")
    public ResponseEntity<User> register(@Validated @RequestBody UserParam userParam) {
        User user = userService.register(userParam);
        return new ResponseEntity<>(user, user == null ? HttpStatus.NOT_FOUND : HttpStatus.OK);
    }

    @Operation(description = "登录以后返回token")
    @PostMapping(value = "/login")
    public ResponseEntity<Object> login(@Validated @RequestBody LoginParam loginParam) {
        String token = userService.login(loginParam.getUsername(), loginParam.getPassword());
        if (token == null) {
            return new ResponseEntity<>("用户名或密码错误", HttpStatus.FORBIDDEN);
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", token);
        tokenMap.put("tokenHead", tokenHead);
        return new ResponseEntity<>(tokenMap, HttpStatus.OK);
    }

    @Operation(description = "刷新token")
    @GetMapping(value = "/refreshToken")
    public ResponseEntity<Object> refreshToken(HttpServletRequest request) {
        String token = request.getHeader(tokenHeader);
        String refreshToken = userService.refreshToken(token);
        if (refreshToken == null) {
            return new ResponseEntity<>("token已经过期！", HttpStatus.FORBIDDEN);
        }
        Map<String, String> tokenMap = new HashMap<>(2);
        tokenMap.put("token", refreshToken);
        tokenMap.put("tokenHead", tokenHead);
        return new ResponseEntity<>(tokenMap, HttpStatus.OK);
    }

    @Operation(description = "获取当前登录用户信息")
    @GetMapping(value = "/info")
    public ResponseEntity<Map<String, Object>> getAdminInfo(Principal principal) {
        if (principal == null) {
            return new ResponseEntity<>(new HashMap<>(0), HttpStatus.UNAUTHORIZED);
        }
        String username = principal.getName();
        User user = userService.getAdminByUsername(username);
        Map<String, Object> data = new HashMap<>(4);
        data.put("username", user.getUsername());
        data.put("menus", roleService.getMenuList(user.getId()));
        data.put("icon", user.getIcon());
        List<Role> roleList = userService.getRoleList(user.getId());
        if (CollUtil.isNotEmpty(roleList)) {
            List<String> roles = roleList.stream().map(Role::getName).collect(Collectors.toList());
            data.put("roles", roles);
        }
        return new ResponseEntity<>(data, HttpStatus.OK);
    }

    @Operation(description = "登出功能")
    @PostMapping(value = "/logout")
    public ResponseEntity<Void> logout() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(description = "根据用户名或姓名分页获取用户列表")
    @GetMapping(value = "/list")
    public ResponseEntity<List<User>> list(@RequestParam(value = "keyword", required = false) String keyword,
                                           @RequestParam(value = "pageSize", defaultValue = "5") Integer pageSize,
                                           @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum) {
        List<User> users = userService.list(keyword, pageSize, pageNum);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Operation(description = "获取指定用户信息")
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getItem(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    @Operation(description = "修改指定用户信息")
    @PostMapping(value = "/update/{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody User user) {
        user.setId(id);
        boolean isSave = userService.saveOrUpdate(user);
        return new ResponseEntity<>(isSave ? HttpStatus.NOT_FOUND : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "修改指定用户密码")
    @PostMapping(value = "/updatePassword")
    public ResponseEntity<String> updatePassword(@Validated @RequestBody UpdatePasswordParam updatePasswordParam) {
        int status = userService.updatePassword(updatePasswordParam);
        String describe = UpdatePasswordStatus.describeOf(status);
        return new ResponseEntity<>(describe, HttpStatus.OK);
    }


    @Operation(description = "删除指定用户信息")
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDel = userService.removeById(id);
        return new ResponseEntity<>(isDel ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "修改帐号状态")
    @PostMapping(value = "/updateStatus/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        User user = userService.getById(id);
        user.setStatus(status);
        userService.saveOrUpdate(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(description = "给用户分配角色")
    @PostMapping(value = "/role/update")
    public ResponseEntity<Void> updateRole(@RequestParam("userId") Long userId,
                                           @RequestParam("roleIds") List<Long> roleIds) {
        boolean isUpdate = userService.updateRole(userId, roleIds);
        return new ResponseEntity<>(isUpdate ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
    }

    @Operation(description = "获取指定用户的角色")
    @GetMapping(value = "/role/{userId}")
    public ResponseEntity<List<Role>> getRoleList(@PathVariable Long userId) {
        List<Role> roleList = userService.getRoleList(userId);
        return new ResponseEntity<>(roleList, HttpStatus.OK);
    }
}
