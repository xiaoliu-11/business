package com.example.business.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author: 刘树国
 * @create: 2022-02-09
 */

@Getter
@AllArgsConstructor
public enum ServerResponseEnum {

    SUCCESS(200, "成功!"),

    ERROR(999,"失败"),

    ACCOUNT_NOT_EXIST(11, "账号不存在"),

    DUPLICATE_ACCOUNT(12, "账号重复"),

    ACCOUNT_IS_DISABLED(13, "账号被禁用"),

    INCORRECT_CREDENTIALS(14, "账号或密码错误"),

    NOT_LOGIN_IN(15, "账号未登录"),

    UNAUTHORIZED(16, "没有权限");

    Integer code;
    String message;
}
