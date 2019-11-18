package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Material;
import com.sc.crm.bean.Purchase;
import com.sc.crm.bean.User;
import com.sc.crm.dao.PurchaseMapper;
import com.sc.crm.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public PageInfo<Purchase> selectPurchase(int pn,int size) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		PageHelper.startPage(pn, size);
		List<Purchase> selectPurchase = mapper.selectPurchase();
		
		for (Purchase p : selectPurchase) {
			List<Material> material = mapper.selectMaterialById(p.getPurchaseId());
			p.setMaterialList(material);
		}
		
		PageInfo<Purchase> pageInfo = new PageInfo<Purchase>(selectPurchase);
		return pageInfo;
	}

	@Override
	public boolean delPurchase(Integer purchaseId) {
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);
		purchase.setPurchaseState(0);
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		int updateBy = mapper.updateByPrimaryKeySelective(purchase);
		if(updateBy == 1)
		{
			return true;
		}else
		{
			return false;
		}
		
	}

	@Override
	public PageInfo<Purchase> waitPurchase(int pn, int size) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		PageHelper.startPage(pn, size);
		List<Purchase> waitPurchase = mapper.waitPurchase();
	    for (Purchase p : waitPurchase) {
	    	List<Material> selectMaterial= mapper.selectMaterialById(p.getPurchaseId());
	    	p.setMaterialList(selectMaterial);
		}
	    
	    PageInfo<Purchase> pageInfo = new PageInfo<Purchase>(waitPurchase);
		return pageInfo;
	}

	@Override
	public boolean updateState(Integer purchaseId) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		Purchase purchase = new Purchase();
		purchase.setPurchaseId(purchaseId);
		purchase.setPurchaseState(1);
		int selective = mapper.updateByPrimaryKeySelective(purchase);
		if(selective == 1)
		{
			return true;
		}else
		{
			return false;
		}
		
	}

}
