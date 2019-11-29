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
		ResultBean resultBean = new ResultBean();
		if (role.getRoleName()==null || role.getRoleName().length()==0 || role.getRoleName()==" ") 
		{
			resultBean.setResultMsg("角色名不能为空");
			resultBean.setResultState(0);
			return resultBean;
		} else {
			for (int j = 0; j < perId.length; j++) {
				RolePermission rolePermission = new RolePermission();
				rolePermission.setRoleId(roleId);
				rolePermission.setPermissionId(Integer.valueOf(perId[j]));
				rolePermissionService.addRolePermission(rolePermission);
			}
			resultBean.setResultState(1);
			resultBean.setResultMsg("成功了");
			return resultBean;
		}
	}
	
	@RequestMapping("/getPermissionList")
	public String getPermissionList(HashMap<String, Object> data) 
	{
		
		List<Role> allRole = rolePermissionService.getAllRole();
		data.put("allRole", allRole);
		
		List<Permission> permissionList = rolePermissionService.getPermissionList();
		data.put("permissionList", permissionList);
		
		return "forward:/permissionList.jsp";
	}
	
	@RequestMapping("/updatePermission")
	public String updatePermission(Permission permission,HashMap<String, Object> data)
	{
		Permission permissionById = rolePermissionService.getPermissionById(permission.getPermissionId());
		data.put("permissionById", permissionById);
		
		List<Permission> permissionList = rolePermissionService.getPermissionList();
		data.put("permissionList", permissionList);
		return "forward:/updatPermission.jsp";
	}
	
	@RequestMapping("/update_permission_agin")
	@ResponseBody
	public ResultBean updatePermissionAgin(Permission permission)
	{
		System.out.println(permission);
		int i = rolePermissionService.updatePermission(permission);
		
		ResultBean bean = new ResultBean();
		bean.setResultState(i);
		return bean;
	}
	
	@RequestMapping("/addPermission")
	public String addPermission(HashMap<String, Object> data)
	{
		List<Permission> permissionList = rolePermissionService.getAllPermissionList();
		data.put("permissionList", permissionList);
		return "forward:/addPermission.jsp";
	}
	
	@RequestMapping("/addPermissionAgin")
	@ResponseBody
	public ResultBean addPermissionAgin(Permission permission)
	{
		int i = rolePermissionService.addPermission(permission);
		ResultBean bean = new ResultBean();
		bean.setResultState(i);
		return bean;
	}
	
	@RequestMapping("/delPermission")
	@ResponseBody
	public ResultBean delPermission(Permission permission)
	{
		int i = rolePermissionService.delPermission(permission);
		Integer permissionId = permission.getPermissionId();
		List<Permission> list = rolePermissionService.getPermissionListByParentid(permissionId);
		for (Permission per : list) {
			rolePermissionService.delPermission(per);
		}
		ResultBean bean = new ResultBean();
		bean.setResultState(i);
		return bean;
	}
}
