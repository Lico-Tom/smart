package com.smart.security.dto;

import lombok.Data;

/**
 * @author Lico-Tom
 * 2023/12/12 21:23
 * @version V1.0
 */
@Data
public class LoginDto {

    private int code;
    private TokenDto data;
}
