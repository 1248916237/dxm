package com.sc.crm.service;

import java.util.List;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;

public interface RolePermissionService {
	
	List<Role> getRoleList();
	
	List<Permission> getPermissionList();

}
