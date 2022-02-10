package com.example.business.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.business.entity.PermissionPO;
import com.example.business.entity.RolePO;
import com.example.business.entity.UserInfoPO;
import com.example.business.vo.user.UserRoleVO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description 用户信息Mapper
 * @Author liushuguo
 * @CreateTime 2022/02/08
 */


@Repository
public interface UserInfoMapper extends BaseMapper<UserInfoPO> {

    //添加用户
    void saveUserInfo(UserInfoPO userInfoPO);

    //根据用户名查询所有角色
    UserInfoPO findRolesByUserName(String username);

    //根据id查询用户
    UserInfoPO selectUserById(int id);

    //根据用户名查询用户信息
    UserInfoPO selectUserByUsername(String username);

    //根据角色id查询权限信息方法
    List<PermissionPO> findPermissionByRoleId(int id);



}
