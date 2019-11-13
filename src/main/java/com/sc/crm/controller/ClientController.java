package com.sc.crm.controller;

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
import com.sc.crm.bean.ResultBean;
import com.sc.crm.service.ClientService;
import com.sc.crm.service.OrderService;

@Controller
public class ClientController {
	
	@Resource
	private ClientService clientService;
	
	@Resource
	private OrderService orderService;
	
	@RequestMapping("/client_list")
	public String clientList(
			@RequestParam(defaultValue="1")int pn,@RequestParam(defaultValue="5")int size,
			Map<String, Object> data)
	{
		PageInfo<Client> pageInfo = clientService.getClientList(pn, size);
		data.put("clientList", pageInfo);
		return "forward:/client.jsp";
	}
	
	
	@RequestMapping("/client_update")
	public String getClientById(Client client,Map<String, Object> data)
	{
		Integer id = client.getClientId();
		Client clientById = clientService.getClientById(id);
		data.put("clientById", clientById);
		return "forward:/client_update.jsp";
	}
	
	@RequestMapping("/update_agin")
	@ResponseBody
	public ResultBean updateByPrimaryKey(Client client)
	{
		Integer id = client.getClientId();
		clientService.updateByPrimaryKey(client);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	@RequestMapping("/client_order")
	public String chaOrderByClientId(HttpServletRequest res,Map<String, Object> data)
	{
		String clientId = res.getParameter("clientId");
		System.out.println(clientId);
		List<Order> list = orderService.getOrderByClientId(Integer.valueOf(clientId));
		data.put("orderList", list);
		return "forward:/aa.jsp";
	}

}
