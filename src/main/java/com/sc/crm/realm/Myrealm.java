package com.sc.crm.realm;

import java.security.Security;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

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
		System.out.println("进入到MyRealm进行权限添加");
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		User user = (User)principals.getPrimaryPrincipal();
		Integer id = user.getUserId();
		List<Role> roleList = loginService.chaRoleList(id);
		
		
		List<Permission> listPer = loginService.perListPer(id);
		for (Permission permission : listPer) {
			System.out.println(permission.getPermissionName());
			List<Pee> perList = permission.getPerList();
			for (Pee pee : perList) {
				String perName = pee.getPerName();
				System.out.println("---" + pee.getPerId()+"-" + perName);
			}
		}
		
		System.out.println(id+"--权限数量--"+listPer.size());
		
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
		//System.out.println("进入到MyRealm验证了");
		String principal = (String)token.getPrincipal();
		User user = loginService.chaUserById(principal);
		if (user == null) {
			return null;
		}
		else {
			SimpleAuthenticationInfo info = 
					new SimpleAuthenticationInfo(user, user.getUserPass(), ByteSource.Util.bytes(user.getUserSalt()), "myrealm");
			return info;
		}
		
	}

}
