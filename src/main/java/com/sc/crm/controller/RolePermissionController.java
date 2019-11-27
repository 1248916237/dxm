package com.sc.crm.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.service.RolePermissionService;

@Controller
public class RolePermissionController {
	
	@Resource
	private RolePermissionService rolePermissionService;
	
	@RequestMapping("getRolePermission")
	public String getRolePermission(HashMap<String, Object> data) 
	{
		List<Permission> permissionList = rolePermissionService.getPermissionList();
		data.put("permissionList", permissionList);
		
		List<Role> roleList = rolePermissionService.getRoleList();
		data.put("roleList", roleList);
		
		return "forward:/rolePermission.jsp";
	}

}
