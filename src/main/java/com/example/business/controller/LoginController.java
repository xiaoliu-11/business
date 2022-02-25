package com.example.business.controller;

import com.example.business.entity.UserInfoPO;
import com.example.business.enums.ServerResponseEnum;
import com.example.business.service.UserInfoService;
import com.example.business.vo.req.UserloginReqVO;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: 刘树国
 * @create: 2022-02-09
 */

@RestController
@RequestMapping("/user")
@Api("用户登录接口的模块")
public class LoginController {


    @Autowired
    private UserInfoService userInfoService;


    @ApiOperation(value = "用户登录", notes = "用户登录")
    @PostMapping("/login")
    public ServerResponseVO<UserInfoPO> login(@Validated @RequestBody UserloginReqVO userloginReqVO) {
        return ServerResponseVO.success(userInfoService.userLogin(userloginReqVO));
    }


    //退出登录
    @ApiOperation(value = "用户退出登录", notes = "用户退出登录")
    @PostMapping("/logout")
    public ServerResponseVO logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return ServerResponseVO.success();
    }


    //用户注册
    @PostMapping("/register")
    public ServerResponseVO<?> register(@RequestBody UserInfoPO userInfoPO) {
        userInfoService.register(userInfoPO);
        return ServerResponseVO.success("用户注册成功");
    }


    //用户没认证
    @PostMapping("/noauth")
    public ServerResponseVO<?> noAuth() {
        return ServerResponseVO.error(ServerResponseEnum.NOT_LOGIN_IN);
    }
}



