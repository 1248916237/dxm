package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Product;
import com.sc.crm.bean.ProductMaterial;

public interface ProductMapper {
    int deleteByPrimaryKey(Integer productId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Integer productId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
    
    List<Product> getProList();
    
    List<Product> selProduct(Product product);
    
    List<ProductMaterial> selProductMaterial(String productId);
    
    Integer selProductNum();
}