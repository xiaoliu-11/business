package com.example.business.controller;

import com.example.business.entity.UserInfoPO;
import com.example.business.service.UserInfoService;
import com.example.business.service.UserOrderPOService;
import com.example.business.vo.response.ServerResponseVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: 刘树国
 * @create: 2022-02-09
 */

@Controller
@RequestMapping("/user")
@Api("用户登录接口的模块")
public class LoginController {


   @Autowired
   private UserInfoService userInfoService;



    @ApiOperation(value = "登录")
    @PostMapping("/login")
    public String login(String username, String password) {
        //获得主体对象
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(new UsernamePasswordToken(username, password));
            return "redirect:/index.jsp";
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            System.out.println("用户名错误");
        } catch (IncorrectCredentialsException e) {
            e.printStackTrace();
            System.out.println("密码错误");
        }
        return "redirect:/login.jsp";
    }


    //退出登录

    @GetMapping("/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login.jsp";
    }



    //用户注册
    @RequestMapping("/register")
   public String register(UserInfoPO userInfoPO){
       try {
           userInfoService.register(userInfoPO);
           return  "redirect:/login.jsp";
       } catch (Exception e) {
           e.printStackTrace();
           return  "redirect:/register.jsp";
       }
   }


   //用户认证登录
    public ServerResponseVO<UserInfoPO> findByUserName(){
        return ServerResponseVO.success();
    }

    //
    //@RequiresRoles("")//用来判断角色


}
