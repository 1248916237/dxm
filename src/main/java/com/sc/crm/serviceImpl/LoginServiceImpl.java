package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.User;
import com.sc.crm.dao.PermissionMapper;
import com.sc.crm.dao.UserMapper;
import com.sc.crm.service.LoginService;

@Service("loginService")
public class LoginServiceImpl implements LoginService{
	
	@Resource
	private SqlSessionTemplate st;

	@Override
	public User chaUserById(String userId) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		User user = mapper.chaUserById(userId);
		return user;
	}

	@Override
	public List<Role> chaRoleList(Integer id) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		List<Role> roleList = mapper.chaRoleList(id);
		return roleList;
	}

	@Override
	public List<Permission> perListPer(Integer userId) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		List<Permission> perListPer = mapper.perListPer(userId);
		return perListPer;
	}

}
