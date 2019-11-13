package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.sc.crm.bean.Order;
import com.sc.crm.dao.OrderMapper;
import com.sc.crm.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public List<Order> getOrderByClientId(Integer clientId) {
		OrderMapper mapper = st.getMapper(OrderMapper.class);
		List<Order> list = mapper.getOrderByClientId(clientId);
		return list;
	}

}
