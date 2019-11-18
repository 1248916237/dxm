package com.sc.crm.dao;

import com.sc.crm.bean.ClientLoss;

public interface ClientLossMapper {
    int deleteByPrimaryKey(Integer lossId);

    int insert(ClientLoss record);

    int insertSelective(ClientLoss record);

    ClientLoss selectByPrimaryKey(Integer lossId);

    int updateByPrimaryKeySelective(ClientLoss record);

    int updateByPrimaryKey(ClientLoss record);
}