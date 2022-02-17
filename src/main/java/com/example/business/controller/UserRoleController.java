package com.example.business.controller;

import com.example.business.mapper.UserRolePOMapper;
import com.example.business.service.UserInfoService;
import com.example.business.service.UserRoleService;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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



    @RequiresRoles("admin")
    @ApiOperation(value = "给用户动态分配角色")
    @PostMapping("/{userid}/{roleid}")
    public ServerResponseVO assignRole(@PathVariable("userid") int userid,
                                       @PathVariable("roleid") int roleid){
        userRolePOMapper.assignRole(userid,roleid);
        return ServerResponseVO.success();
    }


}
