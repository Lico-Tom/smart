package com.smart.security.domain;

import io.swagger.v3.oas.annotations.media.SchemaProperty;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

/**
 * 修改用户名密码参数
 *
 * @author lizhonghao
 * @date 2023/12/3
 */
@Getter
@Setter
public class UpdatePasswordParam {
    @NotEmpty
    @SchemaProperty(name = "用户名")
    private String username;
    @NotEmpty
    @SchemaProperty(name = "旧密码")
    private String oldPassword;
    @NotEmpty
    @SchemaProperty(name = "新密码")
    private String newPassword;
}
