package com.sc.crm.service;

import java.util.Date;
import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Material;
import com.sc.crm.bean.Purchase;
import com.sc.crm.bean.PurchaseInfo;
import com.sc.crm.bean.PurchaseMaterial;
import com.sc.crm.bean.User;

public interface PurchaseService {

	PageInfo<Purchase> selectPurchase(int pn,int size,Date time1,Date time2);
	
	boolean delPurchase(Integer purchaseId);
	
	PageInfo<Purchase> waitPurchase(Integer userId,int pn,int size);
	
	boolean updateState(Integer purchaseId);
	
	void addPurMatList(PurchaseMaterial purMaterial);
	
	void addPurchase(PurchaseInfo purchaseInfo);

	List<Material> selMaterial();
	
	List<User> selUserId();
	
	void delWaitPurchase(Integer purchaseId);
}
