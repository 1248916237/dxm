package com.sc.crm.dao;

import java.util.Date;
import java.util.List;

import javax.xml.crypto.Data;

import org.apache.ibatis.annotations.Param;

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
    
    List<Purchase> selectPurchase(@Param("time1")Date time1,@Param("time2")Date time2);
    
    List<Material> selectMaterialById(Integer id);
    
    List<Purchase> waitPurchase(@Param("userId")Integer userId);
    
}