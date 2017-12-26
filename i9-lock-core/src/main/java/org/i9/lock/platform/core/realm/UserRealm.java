package org.i9.lock.platform.core.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.i9.lock.platform.model.Manager;
import org.i9.lock.platform.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * 创建时间：2017年11月15日 上午9:39:37
 * @author  lby
 * @version  
 * 
 */
public class UserRealm extends AuthorizingRealm{
    
    @Autowired
    private ManagerService managerService;
    
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        String currentLoginName = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Manager manager = managerService.findManagerByName(currentLoginName);
        if (manager == null) {
            throw new AuthorizationException();  
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        String username = (String) authcToken.getPrincipal();
        Manager manager = managerService.findManagerByName(username);
        if (manager == null) {
            throw new UnknownAccountException();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                manager.getUsename(), manager.getPassword(), getName());
        return authenticationInfo;
    }

}
