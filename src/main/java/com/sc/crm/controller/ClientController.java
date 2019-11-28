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
import com.sc.crm.bean.ClientLoss;
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
			String cilentName,
			Map<String, Object> data)
	{
		System.out.println(cilentName);
		PageInfo<Client> pageInfo = clientService.getClientList(pn, size,cilentName);
		data.put("clientList", pageInfo);
		return "forward:/client.jsp";
	}
	
	@RequestMapping("/client_add")
	@ResponseBody
	public ResultBean addClient(Client client)
	{
		clientService.addClient(client);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	
	@RequestMapping("/client_update")
	public String getClientById(Client client,Map<String, Object> data)
	{
		Integer id = client.getClientId();
		Client clientById = clientService.getClientById(id);
		data.put("clientById", clientById);
		return "forward:/client_update.jsp";
	}
	
	@RequestMapping("/loss_update")
	public String getClientLossById(Client client,Map<String, Object> data)
	{
		Integer id = client.getClientId();
		Client clientById = clientService.getClientById(id);
		data.put("clientById", clientById);
		return "forward:/loss_update.jsp";
	}
	
	@RequestMapping("/loss_agin")
	@ResponseBody
	public ResultBean setLossWay(ClientLoss clientLoss)
	{
		System.out.println("进入controller");
		Integer clientId = clientLoss.getClientId();
		Client client = clientService.getClientById(clientId);
		client.setClientState(1);
		
		clientService.updateByPrimaryKey(client);
		clientService.setClientLossWay(clientLoss);
		   
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	
	@RequestMapping("/update_agin")
	@ResponseBody
	public ResultBean updateByPrimaryKey(Client client)
	{
		clientService.updateByPrimaryKey(client);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	@RequestMapping("/del_client")
	@ResponseBody
	public ResultBean delClientById(HttpServletRequest res,Client client)
	{
		String ss = res.getParameter("clientId");
		Integer id = client.getClientId();
		System.out.println(ss+"---  "+id);
		clientService.delClientById(id);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(1);
		return resultBean;
	}
	
	
	
	@RequestMapping("/client_order")
	public String chaOrderByClientId(HttpServletRequest res,Map<String, Object> data)
	{
		String clientId = res.getParameter("clientId");
		List<Order> list = orderService.getOrderByClientId(clientId);
		System.out.println(list.size()+"----"+clientId);
		
		if (list.size()==0) {
			data.put("orderList", null);
		}
		else {
			data.put("orderList", list);
		}
		Client client = clientService.getClientById(Integer.valueOf(clientId));
		data.put("client", client);
		
		return "forward:/client_order.jsp";
	}

	@RequestMapping("/client_loss")
	public String clientLossList(
			@RequestParam(defaultValue="1")int pn,@RequestParam(defaultValue="5")int size,
			String cilentName,
			Map<String, Object> data)
	{
		System.out.println(cilentName);
		PageInfo<Client> pageInfo = clientService.getClientLossList(pn, size,cilentName);
		data.put("clientList", pageInfo);
		return "forward:/clientLoss.jsp";
	}
	
	
}
