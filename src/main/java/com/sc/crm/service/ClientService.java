package com.sc.crm.service;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Client;

public interface ClientService {
	
    PageInfo<Client> getClientList(Integer pn,Integer size);
    
    Client getClientById(Integer id);
    
    void updateByPrimaryKey(Client client);

}
