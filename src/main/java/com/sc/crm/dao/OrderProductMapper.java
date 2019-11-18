package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.OrderProduct;

public interface OrderProductMapper {
    int deleteByPrimaryKey(Integer orderProductId);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    OrderProduct selectByPrimaryKey(Integer orderProductId);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
    
    List<OrderProduct> getOrderProductById(@Param("orderId")String orderId);
}