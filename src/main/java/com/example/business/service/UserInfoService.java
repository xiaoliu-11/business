package com.example.business.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.business.entity.PermissionPO;
import com.example.business.entity.UserInfoPO;
import com.example.business.vo.req.UserloginReqVO;
import com.example.business.vo.response.ServerResponseVO;

import java.util.List;


public interface UserInfoService extends IService<UserInfoPO> {

    void register(UserInfoPO userInfoPO);

    ServerResponseVO<UserInfoPO> userLogin(UserloginReqVO userloginReqVO);


    //根据用户名查询所有角色
    UserInfoPO findRolesByUserName(String username);


    //根据id查询用户
    UserInfoPO selectUserById(int id);

    //根据用户名查询用户信息
    UserInfoPO selectUserByUsername(String username);

    //根据角色id查询权限信息方法
    List<PermissionPO> findPermissionByRoleId(int id);


}
