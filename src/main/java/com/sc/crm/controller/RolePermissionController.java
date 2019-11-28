package com.sc.crm.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.RolePermission;
import com.sc.crm.service.RolePermissionService;

@Controller
public class RolePermissionController {
	
	@Resource
	private RolePermissionService rolePermissionService;
	
	@RequestMapping("/getRoleList")
	public String getRolePermission(@RequestParam(defaultValue="1")String roleId,HashMap<String, Object> data) 
	{
		
		List<Role> allRole = rolePermissionService.getAllRole();
		data.put("allRole", allRole);
		
		List<Permission> permissionList = rolePermissionService.getPermissionList();
		data.put("permissionList", permissionList);
		
		System.out.println(roleId);
		Role roleById = rolePermissionService.getRoleById(roleId);
		data.put("roleById", roleById);
		
		return "forward:/rolePermission.jsp";
	}
	
	@RequestMapping("/addRole")
	public String addRole(HashMap<String, Object> data) 
	{
		List<Permission> permissionList = rolePermissionService.getPermissionList();
		data.put("permissionList", permissionList);
		return "forward:/addRole.jsp";
	}
	
	@RequestMapping("/addRolePerList")
	@ResponseBody
	public ResultBean addRolePer(@RequestBody Role role,HashMap<String, Object> data) 
	{
		rolePermissionService.addRole(role);
		Integer roleId = role.getRoleId();
		String[] perId = role.getPerId();
		
		for (int j = 0; j < perId.length; j++) {
			RolePermission rolePermission = new RolePermission();
			rolePermission.setRoleId(roleId);
			rolePermission.setPermissionId(Integer.valueOf(perId[j]));
			rolePermissionService.addRolePermission(rolePermission);
		}
		
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(11);
		resultBean.setResultMsg("³É¹¦ÁË");
		return resultBean;
	}
	
	
}
