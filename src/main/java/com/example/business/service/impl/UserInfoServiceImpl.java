package com.example.business.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.business.entity.PermissionPO;
import com.example.business.entity.UserInfoPO;
import com.example.business.enums.ServerResponseEnum;
import com.example.business.mapper.UserInfoMapper;
import com.example.business.mapper.UserRolePOMapper;
import com.example.business.service.UserInfoService;
import com.example.business.utils.RedisUtil;
import com.example.business.utils.SaltUtils;
import com.example.business.vo.req.UserloginReqVO;
import com.example.business.vo.response.ServerResponseVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;


@Service("userDetailsService")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfoPO> implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRolePOMapper userRolePOMapper;

    @Resource
    private RedisUtil redisUtil;


    //用户注册
    @Override
    public void register(UserInfoPO userInfoPO) {
        //处理业务,实现注册，密码加密
        //1,生成salt
        String salt = SaltUtils.getSalt(8);
        //2.将随机盐保存到mysl
        userInfoPO.setSalt(salt);
        Md5Hash md5Hash = new Md5Hash(userInfoPO.getPassword(), salt, 1024);
        userInfoPO.setPassword(md5Hash.toHex());

        userInfoMapper.insert(userInfoPO);
    }


    //用户登录
    @Override
    public ServerResponseVO<UserInfoPO> userLogin(UserloginReqVO userloginReqVO) {
        /**
         * TODO 用户登录逻辑
         */
        //获得主体对象
        try {
            Subject subject = SecurityUtils.getSubject();
            subject.login(new UsernamePasswordToken(userloginReqVO.getUsername(), userloginReqVO.getPassword()));
        }catch (UnknownAccountException e) {
            return  ServerResponseVO.error(ServerResponseEnum.ACCOUNT_NOT_EXIST);
        }catch (IncorrectCredentialsException e){
            return  ServerResponseVO.error(ServerResponseEnum.INCORRECT_CREDENTIALS);
        }catch (AuthenticationException e){
            return  ServerResponseVO.error(ServerResponseEnum.ERROR);
        }
        return ServerResponseVO.success(SecurityUtils.getSubject().getPrincipals().oneByType(UserInfoPO.class));
    }

    //根据用户名查询角色
    @Override
    public UserInfoPO findRolesByUserName(String username) {
        return userInfoMapper.findRolesByUserName(username);
    }


    //根据id查询用户
    @Override
    public UserInfoPO selectUserById(int id) {
        return userInfoMapper.selectUserById(id);
    }


    //根据用户名查询用户信息
    @Override
    public UserInfoPO selectUserByUsername(String username) {
        return userInfoMapper.selectUserByUsername(username);
    }

    @Override
    public List<PermissionPO> findPermissionByRoleId(int id) {
        return userInfoMapper.findPermissionByRoleId(id);
    }

}
