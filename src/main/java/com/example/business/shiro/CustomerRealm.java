package com.example.business.shiro;

import com.example.business.entity.PermissionPO;
import com.example.business.entity.RolePO;
import com.example.business.entity.UserInfoPO;
import com.example.business.service.UserInfoService;
import com.example.business.utils.RedisUtil;
import com.example.business.vo.user.UserRoleVO;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author: 刘树国
 * @create: 2022-02-09
 */


//自定义的realm
public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    private UserInfoService userInfoService;

    @Resource
    private RedisUtil redisUtil;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        //获得身份信息
        String primaryPrincipal = (String) principals.getPrimaryPrincipal();

        //根据身份信息获得角色和认证信息
      /*  if ("lsglsg".equals(primaryPrincipal)) {
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            simpleAuthorizationInfo.addRole("admin");
            //设置admin角色可以有哪些操作权限
            simpleAuthorizationInfo.addStringPermission("admin:save:*");
            simpleAuthorizationInfo.addStringPermission("admin:update:*");
*/

        UserInfoPO userInfoPO = userInfoService.findRolesByUserName(primaryPrincipal);

           //授权角色信息
        if(!CollectionUtils.isEmpty(userInfoPO.getRoles())){
            SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
            userInfoPO.getRoles().forEach(rolePO -> {
                simpleAuthorizationInfo.addRole(rolePO.getRole());
                // 查询权限信息
                List<PermissionPO> permissionByRoleId = userInfoService.findPermissionByRoleId(rolePO.getId());
                if(!CollectionUtils.isEmpty(permissionByRoleId)){
                    permissionByRoleId.forEach(perm->{
                        simpleAuthorizationInfo.addStringPermission(perm.getPermission());
                    });
                }


            });
       return  simpleAuthorizationInfo;
        }
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("=============================");
        String principal = (String) authenticationToken.getPrincipal();

        //获得service对象
        UserInfoPO userInfoPO = userInfoService.selectUserByUsername(principal);
        System.out.println("**************");
        redisUtil.setValue("user",userInfoPO);
        System.out.println("**************");
        System.out.println("数据存入redis");
        if (!ObjectUtils.isEmpty(userInfoPO)) {
            return new SimpleAuthenticationInfo(userInfoPO.getUsername(), userInfoPO.getPassword(), ByteSource.Util.bytes(userInfoPO.getSalt()), this.getName());
        }

        return null;
    }
}
