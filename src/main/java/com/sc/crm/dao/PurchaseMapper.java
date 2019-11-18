package com.sc.crm.dao;

import java.util.List;

import com.sc.crm.bean.Material;
import com.sc.crm.bean.Purchase;
import com.sc.crm.bean.User;

public interface PurchaseMapper {
    int deleteByPrimaryKey(Integer purchaseId);

    int insert(Purchase record);

    int insertSelective(Purchase record);

    Purchase selectByPrimaryKey(Integer purchaseId);

    int updateByPrimaryKeySelective(Purchase record);

    int updateByPrimaryKey(Purchase record);
    
    List<Purchase> selectPurchase();
    
    List<Material> selectMaterialById(Integer id);
    
    List<Purchase> waitPurchase();
}