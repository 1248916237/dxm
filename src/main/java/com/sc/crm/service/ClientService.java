package com.sc.crm.service;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Client;
import com.sc.crm.bean.ClientLoss;

public interface ClientService {
	
    PageInfo<Client> getClientList(Integer pn,Integer size,String cilentName);
    
    PageInfo<Client> getClientLossList(Integer pn,Integer size,String cilentName);
    
    Client getClientById(Integer id);
    
    void updateByPrimaryKey(Client client);
    
    int delClientById(Integer id);
    
    int addClient(Client client);
    
    int setClientLossWay(ClientLoss clientLoss);

}
