package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Dept;
import com.sc.crm.bean.Emps;
import com.sc.crm.bean.User;
import com.sc.crm.dao.DeptMapper;
import com.sc.crm.dao.EmpsMapper;
import com.sc.crm.dao.UserMapper;
import com.sc.crm.service.EmpsService;

@Service("empsService")
public class EmpsServiceImpl implements EmpsService{

	@Resource
    private SqlSessionTemplate st;
	
	@Override
	public Emps selByUserId(Integer userId) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		Emps selByUserId = mapper.selByUserId(userId);
		return selByUserId;
	}

	@Override
	public void updateImg(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		mapper.updateByPrimaryKeySelective(emps);
	}

	@Override
	public List<Emps> getEmpsList(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		List<Emps> empsList = mapper.getEmpsList(emps);
		return empsList;
	}

	@Override
	public List<Dept> getDeptList() {
		DeptMapper mapper = st.getMapper(DeptMapper.class);
		List<Dept> deptList = mapper.getDeptList();
		return deptList;
	}

	@Override
	public int updateEmps(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		int i = mapper.updateByPrimaryKeySelective(emps);
		return i;
	}

	@Override
	public int addEmps(Emps emps) {
		EmpsMapper mapper = st.getMapper(EmpsMapper.class);
		int i = mapper.insertSelective(emps);
		return i;
	}

	@Override
	public int delUser(User user) {
		UserMapper mapper = st.getMapper(UserMapper.class);
		int i = mapper.updateByPrimaryKeySelective(user);
		return i;
	}

}
