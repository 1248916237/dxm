package com.sc.crm.dao;

import com.sc.crm.bean.ProductMaterial;

public interface ProductMaterialMapper {
    int deleteByPrimaryKey(Integer productMaterialId);

    int insert(ProductMaterial record);

    int insertSelective(ProductMaterial record);

    ProductMaterial selectByPrimaryKey(Integer productMaterialId);

    int updateByPrimaryKeySelective(ProductMaterial record);

    int updateByPrimaryKey(ProductMaterial record);
}