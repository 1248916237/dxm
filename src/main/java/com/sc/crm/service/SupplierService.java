package com.sc.crm.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Supplier;

public interface SupplierService {

    boolean addSupplier(Supplier supplier);
    
    PageInfo<Supplier> selSupplier(int pn,int size);
    
    boolean delSupplier(Integer supplierId);
    
    Supplier selSupplierById(Integer supplierId);
    
    boolean updateSupplier(Supplier supplier);
}
