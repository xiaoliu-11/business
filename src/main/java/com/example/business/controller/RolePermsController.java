package com.example.business.controller;

import com.example.business.entity.PermissionPO;
import com.example.business.entity.UserInfoPO;
import com.example.business.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: 刘树国
 * @create: 2022-02-16
 */
@Api("角色权限模块")
@RestController
@RequestMapping("/perms")
public class RolePermsController {
    @Autowired
    private UserInfoService userInfoService;

    @ApiOperation(value = "根据角色id查询角色对应的权限")
    @PostMapping("/getPermsByRoleId/{id}")
    public List<PermissionPO> getUserInfoById(@PathVariable("id") int id) {
        return userInfoService.findPermissionByRoleId(id);
    }

}
