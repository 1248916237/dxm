package com.sc.crm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Client;

public interface ClientService {
	
    PageInfo<Client> getClientList(Integer pn,Integer size,String cilentName);
    
    Client getClientById(Integer id);
    
    void updateByPrimaryKey(Client client);
    
    int delClientById(Integer id);
    
    int addClient(Client client);
    
    List<Client> getClientListByLike(String str);

}
