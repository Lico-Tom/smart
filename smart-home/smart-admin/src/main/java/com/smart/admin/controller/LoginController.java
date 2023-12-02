package com.smart.admin.controller;

import com.smart.admin.domain.Admin;
import com.smart.admin.service.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @author Lico-Tom
 * 2023/11/26 9:58
 * @version V1.0
 */

@Tag(name = "LoginController", description = "用户管理")
@RestController
@RequestMapping("/user")
public class LoginController {

    private final AdminService adminService;

    @Autowired
    public LoginController(AdminService adminService) {
        this.adminService = adminService;
    }

    @Operation(description = "注册")
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username,
                                           @RequestParam String password,
                                           @RequestParam String telephone,
                                           @RequestParam String authCode) {
        adminService.register(username, password, telephone, authCode);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @Operation(description = "登录")
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {
        String token = adminService.login(username, password);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }

    @Operation(description = "获取会员信息")
    @GetMapping(value = "/info")
    @ResponseBody
    public ResponseEntity<Admin> info(Principal principal) {
        if(principal==null){
            return null;
        }
        Admin admin = adminService.getCurrentMember();
        return new ResponseEntity<>(admin, HttpStatus.OK);
    }

}
