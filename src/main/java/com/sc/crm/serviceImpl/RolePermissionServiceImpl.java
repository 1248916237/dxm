package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.dao.PermissionMapper;
import com.sc.crm.dao.RoleMapper;
import com.sc.crm.service.RolePermissionService;

@Service("rolePermissionService")
public class RolePermissionServiceImpl implements RolePermissionService {
	
	@Resource
	private SqlSessionTemplate st;

	@Override
	public List<Role> getRoleList() {
		RoleMapper mapper = st.getMapper(RoleMapper.class);
		List<Role> roleList = mapper.getRoleList();
		return roleList;
	}

	@Override
	public List<Permission> getPermissionList() {
		PermissionMapper mapper = st.getMapper(PermissionMapper.class);
		List<Permission> permissionList = mapper.getPermissionList();
		return permissionList;
	}

}
