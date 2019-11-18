package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.HouseProduct;
import com.sc.crm.dao.HouseProductMapper;
import com.sc.crm.service.HouseproductService;
@Service("houseproductService")
public class HouseproductServiceImpl implements HouseproductService{
	
	@Resource
	private SqlSessionTemplate st;
	

	@Override
	public void addHouseproduct(HouseProduct houseproduct) {
		
		HouseProductMapper mapper = st.getMapper(HouseProductMapper.class);
		mapper.insert(houseproduct);
			
	}


	@Override
	public PageInfo<HouseProduct> getHouseproductList(int pn, int size) {
		HouseProductMapper mapper = st.getMapper(HouseProductMapper.class);
		PageHelper.startPage(pn, size);
		List<HouseProduct> houseproductList = mapper.getHouseProductList();
		PageInfo<HouseProduct> pageInfo = new PageInfo<HouseProduct>(houseproductList);
		return pageInfo;
	}


	@Override
	public void delHouseProduct(HouseProduct houseproduct) {
		HouseProductMapper mapper = st.getMapper(HouseProductMapper.class);
		mapper.deleteByPrimaryKey(houseproduct.getHouseProductId());
	}


	@Override
	public List<HouseProduct> updateHouseProduct(Integer houseProductId) {
		HouseProductMapper mapper = st.getMapper(HouseProductMapper.class);
		List<HouseProduct> list = mapper.updateHouseProductList(houseProductId);
		return list;
	}


	@Override
	public void updateByPrimaryKeySelective(HouseProduct houseproduct) {
		HouseProductMapper mapper = st.getMapper(HouseProductMapper.class);
		mapper.updateByPrimaryKeySelective(houseproduct);
	}


	@Override
	public PageInfo<HouseProduct> selHouseproductList(int pn,int size,HouseProduct houseproduct,
			String productName) {
		HouseProductMapper mapper = st.getMapper(HouseProductMapper.class);
		PageHelper.startPage(pn, size);
		List<HouseProduct> selHouseProductList = mapper.selHouseProductList(houseproduct, productName);
		PageInfo<HouseProduct> pageInfo = new PageInfo<HouseProduct>(selHouseProductList);
		return pageInfo;
	
	}
	
	
}
