package com.sc.crm.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.House;
import com.sc.crm.bean.Material;
import com.sc.crm.bean.MaterialSupplier;
import com.sc.crm.bean.Supplier;

public interface MaterialService {

	PageInfo<Material> selMatSupplier(int pn,int size,String materialName);
	
	void addMatSupplier(MaterialSupplier materialSupplier,Material material);
	
	List<House> selHouse();
	
	List<Supplier> selSupplierId();
	
	void delMaterial(Integer materialId);
}
