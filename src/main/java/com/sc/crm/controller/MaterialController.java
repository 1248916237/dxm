package com.sc.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.House;
import com.sc.crm.bean.Material;
import com.sc.crm.bean.MaterialSupplier;
import com.sc.crm.bean.Supplier;
import com.sc.crm.service.MaterialService;
import com.sc.crm.service.SupplierService;

@Controller
public class MaterialController {

	@Resource
	private MaterialService materialService;
	
	@Resource
	private SupplierService supplierService;
	
	@RequestMapping("/selMatSupplier")
	public String selMatSupplier(Map<String, Object> data,
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="3")Integer size,
			String materialName
			)
	{
		 PageInfo<Material> selMatSupplier = materialService.selMatSupplier(pn,size,materialName);
		data.put("selMatSupplier", selMatSupplier);
		return "forward:/material-list.jsp";
		
	}
	
	@RequestMapping("/addMatSupplier")
	@ResponseBody
	public boolean addMatSupplier(MaterialSupplier materialSupplier,Material material)
	{
		materialService.addMatSupplier(materialSupplier,material);
		
		return true;
	}
	
	@RequestMapping("/selHouse")
	public String selHouseSupplierId(Map<String, Object> data)
	{
		List<House> selHouse = materialService.selHouse();
		data.put("selHouse", selHouse);
		
		List<Supplier> selSupplierId = materialService.selSupplierId();
		data.put("selSupplierId", selSupplierId);
		return "forward:/material-add.jsp";
		
	}
	
	@RequestMapping("/delMaterial")
	@ResponseBody
	public boolean delMaterial(Integer materialId,Map<String, Object> data)
	{
		materialService.delMaterial(materialId);
		
		return true;
		
	}
	
}
