package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Client;
import com.sc.crm.dao.ClientMapper;
import com.sc.crm.service.ClientService;

@Service("clientService")
public class ClientServiceImpl implements ClientService{
	
	@Resource
	private SqlSessionTemplate st;

	@Override
	public PageInfo<Client> getClientList(Integer pn, Integer size) {
		PageHelper.startPage(pn, size);
		
		ClientMapper mapper = st.getMapper(ClientMapper.class);
		List<Client> list = mapper.getClientList();
		
		PageInfo<Client> info = new PageInfo<>(list);
		return info;
	}

	@Override
	public Client getClientById(Integer id) {
		ClientMapper mapper = st.getMapper(ClientMapper.class);
		Client client = mapper.selectByPrimaryKey(id);
		return client;
	}

	@Override
	public void updateByPrimaryKey(Client client) {
		ClientMapper mapper = st.getMapper(ClientMapper.class);
		mapper.updateByPrimaryKey(client);
	}
	




}
