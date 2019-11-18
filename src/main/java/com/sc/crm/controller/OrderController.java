package com.sc.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Client;
import com.sc.crm.bean.Order;
import com.sc.crm.bean.OrderProduct;
import com.sc.crm.service.ClientService;
import com.sc.crm.service.OrderService;

@Controller
public class OrderController {

	@Resource
	private OrderService orderService;
	
	@Resource
	private ClientService clientService;
	
	
	@RequestMapping("/order_list")
	public String getOrderList(
			@RequestParam(defaultValue="1")int pn,@RequestParam(defaultValue="5")int size,
			String clientId,
			Map<String, Object> data)
			
	{
		PageInfo<Order> pageInfo = orderService.getOrderList(pn,size,clientId);
		data.put("pageInfo", pageInfo);
		return "forward:/orderList.jsp";
	}
	
	@RequestMapping("/client_info")
	public String getClientById(Client client,Map<String, Object> data)
	{
		Integer id = client.getClientId();
		Client clientById = clientService.getClientById(id);
		data.put("clientById", clientById);
		return "forward:/client_info.jsp";
	}
	
	@RequestMapping("/order_info")
	public String chaOrderByClientId(HttpServletRequest res,Map<String, Object> data)
	{
		String orderId = res.getParameter("orderId");
		List<Order> list = orderService.getOrderById(orderId);
		data.put("ordProList", list);
		
		return "forward:/order_info.jsp";
	}
	
	@RequestMapping("/order_update")
	public String updateOrderByOrderId(HttpServletRequest res,Map<String, Object> data)
	{
		String orderId = res.getParameter("orderId");
		List<Order> list = orderService.getOrderById(orderId);
		data.put("ordProList", list);
		
		return "forward:/order_update.jsp";
	}
	
	
}
