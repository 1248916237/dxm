package com.sc.crm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Purchase;
import com.sc.crm.bean.User;

public interface PurchaseService {

	PageInfo<Purchase> selectPurchase(int pn,int size);
	
	boolean delPurchase(Integer purchaseId);
	
	PageInfo<Purchase> waitPurchase(int pn,int size);
	
	boolean updateState(Integer purchaseId);
}
