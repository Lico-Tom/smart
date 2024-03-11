package com.smart.security.domain;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登录参数
 *
 * @author lizhonghao
 * @date 2023/12/3
 */
@Data
@EqualsAndHashCode
public class LoginParam {
    @NotEmpty
    @SchemaProperty(name = "用户名")
    private String username;
    @NotEmpty
    @SchemaProperty(name = "密码")
    private String password;
}
