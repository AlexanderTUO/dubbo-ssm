package com.tyk.core.config;

import com.tyk.core.sys.bean.Permission;
import com.tyk.core.sys.bean.Role;
import com.tyk.core.sys.bean.User;
import com.tyk.core.sys.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class MyRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;


    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = principalCollection.toString();
        User user = userService.findByUserName(username);
        if (user == null) {
            return null;
        }
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roleSet = new HashSet<>();
        Set<String> permissionSet = new HashSet<>();
        if (!CollectionUtils.isEmpty(user.getRoles())) {
            for (Role role : user.getRoles()) {
                roleSet.add(role.getRoleName());
                if (!CollectionUtils.isEmpty(role.getPermissions())) {
                    for (Permission permission : role.getPermissions()) {
                        permissionSet.add(permission.getUrl());
                    }
                }
            }
        }
        authorizationInfo.addStringPermissions(permissionSet);
        authorizationInfo.addRoles(roleSet);
        return authorizationInfo;
    }


    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        User user = userService.findByUserName(username);
        if (user == null) {
            System.out.println("用户不存在");
            return null;
        }
        Object principal = user.getUserName();
        Object credential = user.getPassword();
        String realName = this.getName();
        ByteSource byteSource = ByteSource.Util.bytes(user.getSalt());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(principal, credential, byteSource, realName);
        return authenticationInfo;
    }
}
