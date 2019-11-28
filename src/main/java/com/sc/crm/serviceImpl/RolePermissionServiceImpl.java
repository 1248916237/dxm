package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.RolePermission;
import com.sc.crm.dao.PermissionMapper;
import com.sc.crm.dao.RoleMapper;
import com.sc.crm.dao.RolePermissionMapper;
import com.sc.crm.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Resource
	private SqlSessionTemplate st;

	@Override
	public List<Permission> getPermissionList() {
		PermissionMapper mapper = st.getMapper(PermissionMapper.class);
		List<Permission> permissionList = mapper.getPermissionList();
		return permissionList;
	}

	@Override
	public List<Role> getAllRole() {
		RoleMapper mapper = st.getMapper(RoleMapper.class);
		List<Role> allRole = mapper.getAllRole();
		return allRole;
	}

	@Override
	public Role getRoleById(String roleId) {
		RoleMapper mapper = st.getMapper(RoleMapper.class);
		Role roleById = mapper.getRoleById(roleId);
		return roleById;
		
	}

	@Override
	public int addRole(Role role) {
		RoleMapper mapper = st.getMapper(RoleMapper.class);
		int i = mapper.insertSelective(role);
		return i;
	}

	@Override
	public int addRolePermission(RolePermission rolePermission) {
		RolePermissionMapper mapper = st.getMapper(RolePermissionMapper.class);
		int i = mapper.insertSelective(rolePermission);
		return i;
	}




}
