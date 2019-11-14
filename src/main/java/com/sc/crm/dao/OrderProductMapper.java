package com.sc.crm.dao;

import com.sc.crm.bean.OrderProduct;

public interface OrderProductMapper {
    int deleteByPrimaryKey(Integer orderProductId);

    int insert(OrderProduct record);

    int insertSelective(OrderProduct record);

    OrderProduct selectByPrimaryKey(Integer orderProductId);

    int updateByPrimaryKeySelective(OrderProduct record);

    int updateByPrimaryKey(OrderProduct record);
}