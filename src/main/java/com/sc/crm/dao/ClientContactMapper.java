package com.sc.crm.dao;

import com.sc.crm.bean.ClientContact;

public interface ClientContactMapper {
    int deleteByPrimaryKey(Integer contactId);

    int insert(ClientContact record);

    int insertSelective(ClientContact record);

    ClientContact selectByPrimaryKey(Integer contactId);

    int updateByPrimaryKeySelective(ClientContact record);

    int updateByPrimaryKey(ClientContact record);
}