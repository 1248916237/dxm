package com.sc.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.RolePermission;

public interface RolePermissionService {
	
	Role getRoleById(String roleId);
	
	List<Role> getAllRole();
	
	List<Permission> getPermissionList();
	
	int addRole(Role role);
	
	int addRolePermission(RolePermission rolePermission);
	
	Permission getPermissionById(Integer permissionId);
	
	int updatePermission(Permission permission);
	
	int addPermission(Permission permission);
	
	int delPermission(Permission permission);
	
	List<Permission> getAllPermissionList();
	
	List<Permission> getPermissionListByParentid(Integer parentid);

}
