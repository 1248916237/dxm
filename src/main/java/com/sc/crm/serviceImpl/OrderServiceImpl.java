package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Order;
import com.sc.crm.bean.OrderProduct;
import com.sc.crm.dao.OrderMapper;
import com.sc.crm.dao.OrderProductMapper;
import com.sc.crm.service.OrderService;

@Service("orderService")
public class OrderServiceImpl implements OrderService{
	
	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public List<Order> getOrderByClientId(String clientId) {
		OrderMapper mapper = st.getMapper(OrderMapper.class);
		List<Order> list = mapper.getOrderByClientId(clientId,null);
		return list;
	}

	@Override
	public PageInfo<Order> getOrderList(int pn, int size, String clientId) {
		PageHelper.startPage(pn, size);
		OrderMapper mapper = st.getMapper(OrderMapper.class);
		List<Order> list = mapper.getOrderList(clientId);
		
		OrderProductMapper mapper2 = st.getMapper(OrderProductMapper.class);
		
		for (Order order : list) {
			List<OrderProduct> orderProductListById = mapper2.getOrderProductById(order.getOrderId());
			order.setOpList(orderProductListById);
		}
		PageInfo<Order> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public List<OrderProduct> getOrderProductById(String orderId) {
		OrderProductMapper mapper = st.getMapper(OrderProductMapper.class);
		List<OrderProduct> orderProductById = mapper.getOrderProductById(orderId);
		return orderProductById;
	}

	@Override
	public List<Order> getOrderById(String orderId) {
		OrderMapper mapper = st.getMapper(OrderMapper.class);
		List<Order> list = mapper.getOrderByClientId(null,orderId);
		return list;
	}

}
