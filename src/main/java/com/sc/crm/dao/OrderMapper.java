package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Order;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> getOrderByClientId(@Param("clientId")Integer clientId);
}