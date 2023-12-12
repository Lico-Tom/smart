package com.smart.security.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
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
import org.springframework.web.bind.annotation.CrossOrigin;
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

/**
 * @author Lico-Tom
 * 2023/12/3 10:14
 * @version V1.0
 */
@Validated
@RestController
@CrossOrigin
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

    @Operation(description = "删除指定用户信息")
    @PostMapping(value = "/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean isDel = userService.removeById(id);
        return new ResponseEntity<>(isDel ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
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

    @Operation(description = "修改帐号状态")
    @PostMapping(value = "/updateStatus/{id}")
    public ResponseEntity<Void> updateStatus(@PathVariable Long id, @RequestParam(value = "status") Integer status) {
        User user = userService.getById(id);
        user.setStatus(status);
        userService.saveOrUpdate(user);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(description = "根据用户名或姓名分页获取用户列表")
    @GetMapping(value = "/list")
    public ResponseEntity<IPage<User>> list(User user,
                                            @RequestParam(value = "pageSize", defaultValue = "5") String pageSize,
                                            @RequestParam(value = "currentPage", defaultValue = "1") String currentPage) {
        IPage<User> userPage = userService.list(Integer.parseInt(currentPage), Integer.parseInt(pageSize), user);
        return new ResponseEntity<>(userPage, HttpStatus.OK);
    }

}
