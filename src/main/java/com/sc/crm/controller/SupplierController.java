package com.sc.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.swing.plaf.synth.SynthStyle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Supplier;
import com.sc.crm.service.SupplierService;

@Controller
public class SupplierController {

	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("/addSupplier")
	@ResponseBody
	public Boolean addSupplier(Supplier supplier)
	{
		 boolean addSupplier = supplierService.addSupplier(supplier);
		 System.out.println(addSupplier);
		return addSupplier;
//		return "forward:/add-supplier.jsp";
	}
	
	@RequestMapping("/selSupplier")
	public String selSupplier(Map<String, Object> data,
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="3")Integer size,
			String supplierName
			)
	{
		 PageInfo<Supplier> selSupplier = supplierService.selSupplier(supplierName,pn,size);
		data.put("selSupplier", selSupplier);
		return "forward:/supplier-list.jsp";
		
	}
	
	@RequestMapping("/delSupplier")
	@ResponseBody
	public boolean delSupplier(Integer supplierId)
	{
		boolean delSupplier = supplierService.delSupplier(supplierId);
		
		return delSupplier;
	}
	
	@RequestMapping("/selSupplierById")
	public String selSupplierById(Integer supplierId,Map<String, Object> data)
	{
		Supplier selSupplierById = supplierService.selSupplierById(supplierId);
		data.put("selSupById", selSupplierById);
		return "forward:/supplier-update.jsp";
		
	}
	
	@RequestMapping("/updateSupplier")
	@ResponseBody
	public boolean updateSupplier(Supplier supplier)
	{
		boolean updateSupplier = supplierService.updateSupplier(supplier);
		return updateSupplier;
		
	}
	
}
