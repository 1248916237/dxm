package com.sc.crm.dao;

import com.sc.crm.bean.PurchaseMaterial;

public interface PurchaseMaterialMapper {
    int deleteByPrimaryKey(Integer purchaseMaterialId);

    int insert(PurchaseMaterial record);

    int insertSelective(PurchaseMaterial record);

    PurchaseMaterial selectByPrimaryKey(Integer purchaseMaterialId);

    int updateByPrimaryKeySelective(PurchaseMaterial record);

    int updateByPrimaryKey(PurchaseMaterial record);
}