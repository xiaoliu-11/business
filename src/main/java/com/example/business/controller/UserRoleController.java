package com.example.business.controller;

import com.example.business.annotation.LogAnnotation;
import com.example.business.mapper.UserRolePOMapper;
import com.example.business.vo.req.UserRoleReqVO;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author: 刘树国
 * @create: 2022-02-16
 */

@Api("订单接口模块")
@RestController
@RequestMapping("/role")
public class UserRoleController {
    @Autowired
    private UserRolePOMapper userRolePOMapper;


    @LogAnnotation(value = "给用户动态分配角色")  //自定义注解
    @RequiresRoles("admin")
    @ApiOperation(value = "给用户动态分配角色")
    @PostMapping("/{userid}/{roleid}")
    public ServerResponseVO assignRole(@Valid @RequestBody UserRoleReqVO userRoleReqVO) {
        userRolePOMapper.assignRole(userRoleReqVO.getUserid(), userRoleReqVO.getRoleid());
        return ServerResponseVO.success();
    }


}
