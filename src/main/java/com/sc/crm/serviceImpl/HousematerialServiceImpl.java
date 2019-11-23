package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.HouseMaterial;

import com.sc.crm.dao.HouseMaterialMapper;
import com.sc.crm.service.HousematerialService;

@Service("/housematerialservice")
public class HousematerialServiceImpl implements HousematerialService{

	
	@Resource SqlSessionTemplate st;
	
	@Override
	public PageInfo<HouseMaterial> getHousematerialList(int pn, int size) 
	{
		HouseMaterialMapper mapper = st.getMapper(HouseMaterialMapper.class);
		PageHelper.startPage(pn, size);
		List<HouseMaterial> list = mapper.getHouseMaterialList();
		PageInfo<HouseMaterial> pageInfo = new PageInfo<HouseMaterial>(list);
		return pageInfo;
	}

	@Override
	public void delHouseMaterial(HouseMaterial housematerail) {
		HouseMaterialMapper mapper = st.getMapper(HouseMaterialMapper.class);
		mapper.deleteByPrimaryKey(housematerail.getHouseMaterialId());
		
	}

	@Override
	public void addHouseMaterial(HouseMaterial housematerial) {
		
		HouseMaterialMapper mapper = st.getMapper(HouseMaterialMapper.class);
		mapper.insert(housematerial);
	}

	@Override
	public HouseMaterial selHouseMaterialById(Integer houseMaterialId) {
		HouseMaterialMapper mapper = st.getMapper(HouseMaterialMapper.class);
		HouseMaterial key = mapper.selectByPrimaryKey(houseMaterialId);
		return key;
	}

	@Override
	public void updateHouseMaterial(HouseMaterial housemeterial) {
		HouseMaterialMapper mapper = st.getMapper(HouseMaterialMapper.class);
		mapper.updateByPrimaryKeySelective(housemeterial);
		
	}

	@Override
	public PageInfo<HouseMaterial> selHouseMaterialList(int pn, int size, HouseMaterial housematerail) {
		HouseMaterialMapper mapper = st.getMapper(HouseMaterialMapper.class);
		PageHelper.startPage(pn, size);
		List<HouseMaterial> list = mapper.selHouseMaterialList(housematerail);
		PageInfo<HouseMaterial> pageInfo = new PageInfo<HouseMaterial>(list);
		return pageInfo;	
	}
	

}
