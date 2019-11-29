package com.sc.crm.serviceImpl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Material;
import com.sc.crm.bean.Purchase;
import com.sc.crm.bean.PurchaseInfo;
import com.sc.crm.bean.PurchaseMaterial;
import com.sc.crm.bean.User;
import com.sc.crm.dao.MaterialMapper;
import com.sc.crm.dao.PurchaseMapper;
import com.sc.crm.dao.PurchaseMaterialMapper;
import com.sc.crm.dao.UserMapper;
import com.sc.crm.service.PurchaseService;

@Service("purchaseService")
public class PurchaseServiceImpl implements PurchaseService{

	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public PageInfo<Purchase> selectPurchase(int pn,int size,Date time1,Date time2) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		PageHelper.startPage(pn, size);
		List<Purchase> selectPurchase = mapper.selectPurchase(time1,time2);
		
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
	public PageInfo<Purchase> waitPurchase(Integer userId,int pn, int size) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		PageHelper.startPage(pn, size);
		List<Purchase> waitPurchase = mapper.waitPurchase(userId);
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

	@Override
	public void addPurMatList(PurchaseMaterial purMaterial) {
		PurchaseMaterialMapper mapper = st.getMapper(PurchaseMaterialMapper.class);
		 mapper.insertSelective(purMaterial);
	}

	@Override
	public void addPurchase(PurchaseInfo purchaseInfo) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		PurchaseMaterialMapper mapper1 = st.getMapper(PurchaseMaterialMapper.class);
		
		Purchase purchase = new Purchase();
		purchase.setUserId(purchaseInfo.getUserId());
		Date date = new Date();
		purchase.setPurchaseDate(date);
        purchase.setPurchaseState(0);
		mapper.insertSelective(purchase);
		
		List<PurchaseMaterial> purMaterialList = purchaseInfo.getPurMaterialList();
        for(PurchaseMaterial purMaterial : purMaterialList)
        {
           purMaterial.setPurchaseId(purchase.getPurchaseId());
           mapper1.insertSelective(purMaterial);
        }
		
	}

	@Override
	public List<Material> selMaterial() {
		MaterialMapper mapper = st.getMapper(MaterialMapper.class);
		List<Material> selMaterial = mapper.selMaterial();
		return selMaterial;
	}

	@Override
	public List<User> selUserId() {
		UserMapper mapper = st.getMapper(UserMapper.class);
		List<User> selUserId = mapper.selUserId();
		return selUserId;
	}

	@Override
	public void delWaitPurchase(Integer purchaseId) {
		PurchaseMapper mapper = st.getMapper(PurchaseMapper.class);
		mapper.deleteByPrimaryKey(purchaseId);
		
	}


}
