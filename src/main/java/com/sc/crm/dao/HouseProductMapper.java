package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.HouseProduct;

public interface HouseProductMapper {
    int deleteByPrimaryKey(Integer houseProductId);

    int insert(HouseProduct record);

    int insertSelective(HouseProduct record);

    HouseProduct selectByPrimaryKey(Integer houseProductId);

    int updateByPrimaryKeySelective(HouseProduct record);

    int updateByPrimaryKey(HouseProduct record);
    
    List<HouseProduct> getHouseProductList();
    
    List<HouseProduct> updateHouseProductList(Integer houseProductId);
    
    List<HouseProduct> selHouseProductList(@Param("houseproduct")HouseProduct houseproduct,@Param("productName")String productName);
}