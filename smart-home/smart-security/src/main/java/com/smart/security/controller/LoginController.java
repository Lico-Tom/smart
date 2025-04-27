package com.smart.security.controller;

import com.smart.core.utils.JwtTokenUtil;
import com.smart.security.domain.LoginParam;
import com.smart.security.domain.User;
import com.smart.security.dto.LoginDto;
import com.smart.security.dto.RoleData;
import com.smart.security.dto.TokenDto;
import com.smart.security.dto.UserDto;
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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Lico-Tom
 * 2023/12/12 0:02
 * @version V1.0
 */
@Validated
@RestController
@CrossOrigin
@RequestMapping(value = "/v1/smart/user", produces = "application/json")
public class LoginController {

    @Value("${jwt.tokenHeader}")
    private String tokenHeader;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    private final JwtTokenUtil jwtTokenUtil;

    private final UserService userService;

    private final RoleService roleService;

    @Autowired
    public LoginController(UserService userService, RoleService roleService, JwtTokenUtil jwtTokenUtil) {
        this.userService = userService;
        this.roleService = roleService;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    @Operation(description = "登录以后返回token")
    @PostMapping(value = "/login")
    public ResponseEntity<LoginDto> login(@Validated @RequestBody LoginParam loginParam) {
        String token = userService.login(loginParam.getUsername(), loginParam.getPassword());
        LoginDto loginDto = new LoginDto();
        loginDto.setCode(2000);
        loginDto.setData(new TokenDto(tokenHead + token));
        return new ResponseEntity<>(loginDto, HttpStatus.OK);
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
    public ResponseEntity<UserDto> getUserInfo(@RequestParam("token") String token) {
        String nameFromToken = jwtTokenUtil.getUserNameFromToken(token.substring(this.tokenHead.length()));
        User user = userService.getAdminByUsername(nameFromToken);
        UserDto userInfo = new UserDto();
        userInfo.setCode(20000);
        RoleData roleData = RoleData.builder()
                .roles(roleService.getRoleList(user.getId()))
                .introduction("I am a super administrator")
                .avatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif")
                .name("Super Admin").build();
        userInfo.setData(roleData);
        return new ResponseEntity<>(userInfo, HttpStatus.OK);
    }

    @Operation(description = "登出功能")
    @PostMapping(value = "/logout")
    public ResponseEntity<Void> logout() {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
