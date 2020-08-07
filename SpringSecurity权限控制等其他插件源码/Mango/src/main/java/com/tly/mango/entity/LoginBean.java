package com.tly.mango.entity;

import lombok.Data;
/**
 * 登录接口封装对象
 * */
@Data
public class LoginBean {

    private String account;
    private String password;
    private String captcha;
}
