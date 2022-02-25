package com.example.business.controller;


import com.example.business.entity.UserInfoPO;
import com.example.business.service.UserInfoService;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("用户接口模块")
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserInfoService userInfoService;

    @RequiresRoles("admin")
    @ApiOperation(value = "根据id查询用户信息")
    @PostMapping("/getuserinfoById/{id}")
    public ServerResponseVO<UserInfoPO> getUserInfoById(@PathVariable("id") int id) {
        return ServerResponseVO.success(userInfoService.selectUserById(id));
    }

    @RequiresRoles("admin")
    @ApiOperation(value = "根据用户名查询用户信息")
    @PostMapping("/getuserinfoByName/{username}")
    public ServerResponseVO<UserInfoPO> getUserInfoByName(@PathVariable("username") String username) {
        return ServerResponseVO.success(userInfoService.selectUserByUsername(username));
    }

    @RequiresRoles("admin")
    @ApiOperation(value = "添加用户")
    @PostMapping("/save")
    public ServerResponseVO<UserInfoPO> saveUserInfo(@RequestBody UserInfoPO userInfoPO) {
        userInfoService.register(userInfoPO);
        return ServerResponseVO.success();
    }

}
