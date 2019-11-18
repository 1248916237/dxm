package com.sc.crm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Order;
import com.sc.crm.bean.OrderProduct;

public interface OrderService {
	
	List<Order> getOrderByClientId(String clientId);
	
	PageInfo<Order> getOrderList(int pn,int size,String cilentId);
	
	List<OrderProduct> getOrderProductById(String orderId);
	
	List<Order> getOrderById(String orderId);
 
}
