package com.sc.crm.realm;

import java.util.List;
import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import com.sc.crm.bean.Pee;
import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.User;
import com.sc.crm.service.LoginService;

public class Myrealm extends AuthorizingRealm{
	
	@Resource
	private LoginService loginService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		User user = (User)principals.getPrimaryPrincipal();
		Integer id = user.getUserId();
		List<Role> roleList = loginService.chaRoleList(id);
		
		
		List<Permission> listPer = loginService.perListPer(id);
		for (Permission permission : listPer) {
			List<Pee> perList = permission.getPerList();
			for (Pee pee : perList) {
				String perName = pee.getPerName();
//				System.out.println("---" + pee.getPerId()+"-" + perName);
			}
		}
		
		
		SecurityUtils.getSubject().getSession().setAttribute("listPer", listPer);
		//SecurityUtils.getSubject().getSession().setAttribute("roleList", roleList);
		
		for (Role role : roleList) {
			String roleName = role.getRoleName();
			info.addRole(roleName);
			
			List<Permission> list = role.getPermissionList();
			for (Permission permission : list) {
				String perName = permission.getPermissionName();
				info.addStringPermission(perName);
			}
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		try {
			String principal = (String)token.getPrincipal();
			User user = loginService.chaUserById(principal);
			if (user == null || user.getUserState()==0) {
				return null;
			}
			else {
				SimpleAuthenticationInfo info = 
						new SimpleAuthenticationInfo(user, user.getUserPass(), ByteSource.Util.bytes(user.getUserSalt()), "myrealm");
				return info;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

}
