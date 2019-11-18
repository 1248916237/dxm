package com.sc.crm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.HouseProduct;

public interface HouseproductService {
	
	public void addHouseproduct(HouseProduct houseproduct);
	
	public PageInfo<HouseProduct> getHouseproductList(int pn,int size);
	
	public void delHouseProduct(HouseProduct houseproduct);
	
	public List<HouseProduct> updateHouseProduct(Integer houseProductId);
	
	public void updateByPrimaryKeySelective(HouseProduct houseproduct);
	
	public PageInfo<HouseProduct> selHouseproductList(int pn,int size,HouseProduct houseproduct,
			String productName);
		
	}
		
	
		

