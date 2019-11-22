package com.sc.crm.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Client;
import com.sc.crm.bean.Order;
import com.sc.crm.bean.OrderInfo;
import com.sc.crm.bean.OrderProduct;
import com.sc.crm.bean.Product;
import com.sc.crm.bean.ResultBean;
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
			HttpServletRequest res,
			Map<String, Object> data)
			
	{
		String clientId = res.getParameter("clientId");
		if (clientId != null && clientId.equals("000")) {
			PageInfo<Order> pageInfo = orderService.getOrderList(pn,size,null);
			data.put("pageInfo", pageInfo);
		}else {
			PageInfo<Order> pageInfo = orderService.getOrderList(pn,size,clientId);
			data.put("pageInfo", pageInfo);
		}
		
		PageInfo<Client> clientList = clientService.getClientList(pn, 50, null);
		data.put("clientList", clientList);
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
	
	@RequestMapping("/orderPro")
	public String getListOrderIm(HttpServletRequest res,Map<String, Object> data)
	{
		
		PageInfo<Client> pageInfo = clientService.getClientList(1, 20, null);
		data.put("clientList", pageInfo);
		
		List<Product> proList = orderService.getProList();
		data.put("proList", proList);
		
		return "forward:/order_add.jsp";
	}
	
	@RequestMapping("/order_state")
	@ResponseBody
	public ResultBean orderState(Order order)
	{
		order.setOrderState(2);
		int i = orderService.setPayDate(order);
		ResultBean bean = new ResultBean();
		bean.setResultState(0);
		return bean;
	}
	
	@SuppressWarnings("null")
	@RequestMapping("/order_paydate")
	@ResponseBody
	public ResultBean setPayDate(HttpServletRequest res,Map<String, Object> data) throws ParseException
	{
		String payDate = res.getParameter("payDate");
		String orderId = res.getParameter("orderId");
		System.out.println(payDate);
		
		ResultBean bean = new ResultBean();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Order order = new Order();
		
		if (payDate==null && payDate.length()==0) {
			bean.setResultState(0);
			return bean;
		}
		else {
			order.setOrderId(orderId);
			order.setOrderPayment(1);
			order.setOrderState(2);
			order.setPayDate(sdf.parse(payDate));
			int i = orderService.setPayDate(order);
			bean.setResultState(0);
			return bean;
		}
	}
	
	
	
	@RequestMapping("/order_add")
	@ResponseBody
	public ResultBean addOrder(HttpServletRequest res,Map<String, Object> data,@RequestBody OrderInfo orderInfo)
	{
		
		Date date = new Date();
		Long allPrice=0l;
		System.out.println("½øÈëorder_add"+date.toString());
		
		Order order = new Order();
		order.setOrderId(orderInfo.getId());
		order.setOrderDate(date);
		order.setOrderPayment(orderInfo.getOrderPayment());
		order.setClientId(orderInfo.getClientId());
		order.setOrderWay(orderInfo.getOrderWay());
		order.setOrderState(orderInfo.getOrderState());
		
		List<OrderProduct> orderProductList = orderInfo.getOrderProductList();
		for (OrderProduct ordPro : orderProductList) {
			ordPro.setOrderId(orderInfo.getId());
			Integer num = ordPro.getProductNum();
			Long price = orderService.getProductOrder(ordPro.getProductId()).getProductPrice();
			Long numL = num.longValue();
			allPrice=allPrice + numL*price;
			ordPro.setProductPrice(price);
			orderService.addOrderProduct(ordPro);
		}
		
		order.setOrderAllPrice(allPrice);
		orderService.addOrder(order);
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
	}
	
	
}
