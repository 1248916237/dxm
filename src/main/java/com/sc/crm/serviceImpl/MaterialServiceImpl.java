package com.sc.crm.serviceImpl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.House;
import com.sc.crm.bean.Material;
import com.sc.crm.bean.MaterialSupplier;
import com.sc.crm.bean.Supplier;
import com.sc.crm.dao.HouseMapper;
import com.sc.crm.dao.MaterialMapper;
import com.sc.crm.dao.MaterialSupplierMapper;
import com.sc.crm.dao.SupplierMapper;
import com.sc.crm.service.MaterialService;

@Service("materialService")
public class MaterialServiceImpl implements MaterialService{

	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public PageInfo<Material> selMatSupplier(int pn,int size,String materialName) {
		MaterialMapper mapper = st.getMapper(MaterialMapper.class);
		PageHelper.startPage(pn, size);
		List<Material> selMatSupplier = mapper.selMatSupplier(materialName);
		PageInfo<Material> pageInfo = new PageInfo<Material>(selMatSupplier);
		return pageInfo;
	}

	@Override
	public void addMatSupplier(MaterialSupplier materialSupplier,Material material) {
		  MaterialSupplierMapper mapper = st.getMapper(MaterialSupplierMapper.class);
		  MaterialMapper mapper2 = st.getMapper(MaterialMapper.class);
		
//		System.out.println(materialSupplier.getMaterialPrice());
		  material.setMaterialName(material.getMaterialName());
		  material.setMaterialIntro(material.getMaterialIntro());
		  material.setHouseId(material.getHouseId());
		  mapper2.insertSelective(material);
//		  System.out.println(material);
		  
		  materialSupplier.setMaterialId(material.getMaterialId());
		  materialSupplier.setSupplierId(materialSupplier.getSupplierId());
		  materialSupplier.setMaterialPrice(materialSupplier.getMaterialPrice());
		  mapper.insertSelective(materialSupplier);
	}

	@Override
	public List<House> selHouse() {
		HouseMapper mapper = st.getMapper(HouseMapper.class);
		List<House> selHouse = mapper.selHouse();
		return selHouse;
	}

	@Override
	public List<Supplier> selSupplierId() {
		SupplierMapper mapper = st.getMapper(SupplierMapper.class);
		List<Supplier> selSupplierId = mapper.selSupplierId();
		return selSupplierId;
	}

	@Override
	public void delMaterial(Integer materialId) {
		MaterialMapper mapper = st.getMapper(MaterialMapper.class);
		mapper.deleteByPrimaryKey(materialId);
		
	}

}
