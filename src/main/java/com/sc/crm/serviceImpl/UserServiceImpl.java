package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Emps;
import com.sc.crm.bean.User;
import com.sc.crm.bean.UserRole;
import com.sc.crm.dao.EmpsMapper;
import com.sc.crm.dao.UserMapper;
import com.sc.crm.dao.UserRoleMapper;
import com.sc.crm.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public List<Emps> getEmpsListJust(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		List<Emps> list = mapper.getEmpsListJust(emps);
		return list;
	}

	@Override
	public Emps getEmpsByEmpsId(Integer empsId) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		Emps emps = mapper.selectByPrimaryKey(empsId);
		return emps;
	}

	@Override
	public int delEmps(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		int i = mapper.deleteByPrimaryKey(emps.getEmpId());
		return i;
	}

	@Override
	public int addUser(User user) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		int i = mapper.insertSelective(user);
		return i;
	}

	@Override
	public int addUserRole(UserRole userRole) {
		UserRoleMapper mapper = st.getMapper(UserRoleMapper.class);
		int i = mapper.insertSelective(userRole);
		return i;
	}

	@Override
	public int updateUser(User user) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		int i = mapper.updateByPrimaryKeySelective(user);
		return i;
	}

	@Override
	public User getUserById(User user) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		User userById = mapper.selectByPrimaryKey(user.getUserId());
		return userById;
	}

}
