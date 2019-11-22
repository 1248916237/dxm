package com.sc.crm.serviceImpl;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Emps;
import com.sc.crm.dao.EmpsMapper;
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

}
