package com.sc.crm.service;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.HouseMaterial;

public interface HousematerialService {
	
	public PageInfo<HouseMaterial> getHousematerialList(int pn,int size);
	
	public void delHouseMaterial(HouseMaterial housematerail);
	
	public void addHouseMaterial(HouseMaterial housematerail);
	
	public HouseMaterial selHouseMaterialById(Integer houseMaterialId);
	
	public void updateHouseMaterial(HouseMaterial housemeterial);
	
	public PageInfo<HouseMaterial> selHouseMaterialList(int pn,int size,HouseMaterial housematerail,String material); 
	
	
}
