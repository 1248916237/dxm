package com.sc.crm.dao;

import java.util.List;

import com.sc.crm.bean.House;

public interface HouseMapper {
    int deleteByPrimaryKey(Integer houseId);

    int insert(House record);

    int insertSelective(House record);

    House selectByPrimaryKey(Integer houseId);

    int updateByPrimaryKeySelective(House record);

    int updateByPrimaryKey(House record);
    
    List<House> selHouse();
    
    Integer selHouseNum();
}