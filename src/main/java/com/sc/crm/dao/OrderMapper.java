package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Order;
import com.sc.crm.bean.OrderProduct;

public interface OrderMapper {
    int deleteByPrimaryKey(String orderId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
    
    List<Order> getOrderByClientId(@Param("clientId")String clientId,@Param("orderId")String orderId); 
    
    List<Order> getOrderList(@Param("clientId")String clientId);
    
    
}