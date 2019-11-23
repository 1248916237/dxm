package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.HouseMaterial;

public interface HouseMaterialMapper {
    int deleteByPrimaryKey(Integer houseMaterialId);

    int insert(HouseMaterial record);

    int insertSelective(HouseMaterial record);

    HouseMaterial selectByPrimaryKey(Integer houseMaterialId);

    int updateByPrimaryKeySelective(HouseMaterial record);

    int updateByPrimaryKey(HouseMaterial record);

	List<HouseMaterial> getHouseMaterialList();

	List<HouseMaterial> selHouseMaterialList( HouseMaterial housematerial);
	

}