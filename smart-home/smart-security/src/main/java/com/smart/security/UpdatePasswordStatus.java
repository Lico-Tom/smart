package com.smart.security;

import java.util.Arrays;

/**
 * @author Lico-Tom
 * 2023/12/3 17:17
 * @version V1.0
 */
public enum UpdatePasswordStatus {

    SUCCESS(0, "修改密码成功"),
    NOT_VALIDATED(-1, "提交参数不合法"),
    NOT_USER(-2, "找不到该用户"),
    NOT_PASSWORD(-3, "旧密码错误");

    private int code;
    private String describe;

    UpdatePasswordStatus(int code, String describe) {
        this.code = code;
        this.describe = describe;
    }

    public static String describeOf(int code) {
        UpdatePasswordStatus updatePasswordStatus = Arrays.stream(values())
                .filter(value -> value.code == code)
                .findFirst().get();
        return updatePasswordStatus != null ? updatePasswordStatus.describe : null;
    }

    public int getCode() {
        return code;
    }

    public String getDescribe() {
        return describe;
    }
}
