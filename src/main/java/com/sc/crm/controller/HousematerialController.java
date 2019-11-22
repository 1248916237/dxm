package com.sc.crm.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.HouseMaterial;
import com.sc.crm.bean.HouseProduct;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.service.HousematerialService;

@Controller
public class HousematerialController {
	
	@Resource 
	private HousematerialService housematerialservice;
	
	@RequestMapping("/getHouseMaterial")
	public String getHouseMaterial(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			Map<String, Object> data){
			PageInfo<HouseMaterial> pageInfo = housematerialservice.getHousematerialList(pn, size);
			data.put("pageinfo", pageInfo);
			return "forward:/housematerial.jsp";
	}
	
	
	@RequestMapping("/delHouseMaterial")
	@ResponseBody
	public ResultBean delHouseProduct(HouseMaterial housematerial){
		
		housematerialservice.delHouseMaterial(housematerial);
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
				
	}
	
	@RequestMapping("/addHouseMaterial")
	@ResponseBody
	public ResultBean addhouseproduct(HouseMaterial housematerial)
	{
		housematerialservice.addHouseMaterial(housematerial);
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
		
	}
	
	
	@RequestMapping("/updateHouseMaterial")
	public String updateHouseProduct(Integer houseMaterialId,Map<String, Object> data) {
		HouseMaterial sel = housematerialservice.selHouseMaterialById(houseMaterialId);
		data.put("sel", sel);
		return "forward:/updatehousematerial.jsp";
		
	}
	
	@RequestMapping("/updatehm")
	@ResponseBody
	public ResultBean updHouseProduct(HouseMaterial housematerial){
		
		housematerialservice.updateHouseMaterial(housematerial);
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
				
	}
	
	@RequestMapping("/selHouseMaterial")
	public String selHouseProduct(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			HouseMaterial housematerial,
			String materialName,
			Map<String, Object> data
			)
	{
		System.out.println(housematerial);
		PageInfo<HouseMaterial> list = housematerialservice.selHouseMaterialList(pn, size, housematerial, materialName);
		data.put("pageinfo",list );
		return "forward:/housematerial.jsp";
	}

}
