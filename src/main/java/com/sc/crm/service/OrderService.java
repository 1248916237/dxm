package com.sc.crm.service;

import java.util.List;

import com.sc.crm.bean.Order;

public interface OrderService {
	
	List<Order> getOrderByClientId(String clientId);
 
}
