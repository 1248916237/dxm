package com.sc.crm.dao;

import com.sc.crm.bean.Material;

public interface MaterialMapper {
    int deleteByPrimaryKey(Integer materialId);

    int insert(Material record);

    int insertSelective(Material record);

    Material selectByPrimaryKey(Integer materialId);

    int updateByPrimaryKeySelective(Material record);

    int updateByPrimaryKey(Material record);
}