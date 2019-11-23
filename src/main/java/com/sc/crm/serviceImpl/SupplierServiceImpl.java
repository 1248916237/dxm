package com.sc.crm.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Supplier;
import com.sc.crm.dao.SupplierMapper;
import com.sc.crm.service.SupplierService;

@Service("supplierService")
public class SupplierServiceImpl implements SupplierService{

	@Resource
	private SqlSessionTemplate st;
	
	@Override
	public boolean addSupplier(Supplier supplier) {
		SupplierMapper mapper = st.getMapper(SupplierMapper.class);
		 int insert = mapper.insert(supplier);
		if(insert == 1)
		{
			return true;
		}else
		{
			return false;
		}
		 
	}

	@Override
	public PageInfo<Supplier> selSupplier(String supplierName,int pn,int size) {
		SupplierMapper mapper = st.getMapper(SupplierMapper.class);
		PageHelper.startPage(pn, size);
		List<Supplier> selSupplier = mapper.selSupplier(supplierName);
		PageInfo<Supplier> pageInfo = new PageInfo<>(selSupplier);
		return pageInfo;
	}

	@Override
	public boolean delSupplier(Integer supplierId) {
	  SupplierMapper mapper = st.getMapper(SupplierMapper.class);
	  int primaryKey = mapper.deleteByPrimaryKey(supplierId);
	  if(primaryKey == 1)
	  {
		  return true;
	  }else
	  {
		  return false;
	  }
		
	}

	@Override
	public Supplier selSupplierById(Integer supplierId) {
		 SupplierMapper mapper = st.getMapper(SupplierMapper.class);
		   Supplier selectByPrimaryKey = mapper.selectByPrimaryKey(supplierId);
		 return selectByPrimaryKey;
	}

	@Override
	public boolean updateSupplier(Supplier supplier) {
		SupplierMapper mapper = st.getMapper(SupplierMapper.class);
		int updateBy= mapper.updateByPrimaryKeySelective(supplier);
		if(updateBy == 1)
		{
			return true;
		}else
		{
			return false;
		}
	}


}
