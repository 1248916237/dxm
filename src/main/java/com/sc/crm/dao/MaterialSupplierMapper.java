package com.sc.crm.dao;

import com.sc.crm.bean.MaterialSupplier;

public interface MaterialSupplierMapper {
    int deleteByPrimaryKey(Integer materialSupplierId);

    int insert(MaterialSupplier record);

    int insertSelective(MaterialSupplier record);

    MaterialSupplier selectByPrimaryKey(Integer materialSupplierId);

    int updateByPrimaryKeySelective(MaterialSupplier record);

    int updateByPrimaryKey(MaterialSupplier record);
}