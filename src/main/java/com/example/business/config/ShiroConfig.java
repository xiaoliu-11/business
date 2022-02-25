package com.example.business.config;

import com.example.business.shiro.CustomerRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: 刘树国
 * @create: 2022-02-09
 * 用来整合有关shiro的配置类
 */

@Configuration
public class ShiroConfig {
    //1.创建shiroFilter,负责拦截所有的请求

    @Bean
    public ShiroFilterFactoryBean getShiroFilterFactoryBean(DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //给filter设置安全管理
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //配置系统受限资源
        //配置系统公共资源

        Map<String, String> map = new HashMap<>();
        map.put("/user/login", "anon");//anon是公共资源。
        map.put("user/register", "anon");//anon是公共资源。
        map.put("/user/noauth","anon");//anon是公共资源。

        map.put("/swagger-ui.html", "anon");
        map.put("/swagger-resources/**", "anon");
        map.put("/v2/**", "anon");
        map.put("/webjars/**", "anon");

        map.put("/index.jsp", "authc");//authc 这个资源子要认证和受权
        map.put("/role/**", "roles");
        map.put("/**", "authc");


        //默认认证界面路径
        //shiroFilterFactoryBean.setLoginUrl("/login.jsp");
        shiroFilterFactoryBean.setLoginUrl("/user/noauth");


        // 设置未授权的提示页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/user/noauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);


        return shiroFilterFactoryBean;

    }

    //2.创建安全管理
    @Bean
    public DefaultWebSecurityManager getDefaultWebSecurityManager(Realm realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //给安全管理设置
        defaultWebSecurityManager.setRealm(realm);


        return defaultWebSecurityManager;

    }

    //3。创建自定义的Realm
    @Bean
    public Realm getRealm() {
        CustomerRealm customerRealm = new CustomerRealm();
        //修改凭证校验匹配
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //设置密码加密位md5
        credentialsMatcher.setHashAlgorithmName("MD5");
        //设置散列次数
        credentialsMatcher.setHashIterations(1024);

        customerRealm.setCredentialsMatcher(credentialsMatcher);


        //开缓存
//        customerRealm.setCacheManager(new EhCacheManager());
//        customerRealm.setCachingEnabled(true);//全局缓存
//        customerRealm.setAuthenticationCachingEnabled(true);//认证缓存
//        customerRealm.setAuthenticationCacheName("authenticationCache");
//        customerRealm.setAuthorizationCachingEnabled(true);//开授权缓存
//        customerRealm.setAuthorizationCacheName("authorizationCache");

        return customerRealm;
    }


//========================================================================================

    /**
     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions)
     *
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启aop注解支持
     *
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(DefaultWebSecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}

