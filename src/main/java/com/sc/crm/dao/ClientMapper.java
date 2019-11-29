package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Client;

public interface ClientMapper {
    int deleteByPrimaryKey(Integer clientId);

    int insert(Client record);

    int insertSelective(Client record);

    Client selectByPrimaryKey(Integer clientId);

    int updateByPrimaryKeySelective(Client record);

    int updateByPrimaryKey(Client record);
    
    List<Client> getClientList(@Param("clientName")String cilentName);
    
    int delClientById(@Param("clientId")Integer clientId);
    
    List<Client> getClientLossList(@Param("clientName")String cilentName);
    
    int selCliNum();
    
    int selCliLossNum();
}