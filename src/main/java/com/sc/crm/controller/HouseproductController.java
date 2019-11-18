package com.sc.crm.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.HouseProduct;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.service.HouseproductService;

@Controller
public class HouseproductController {
	
	@Resource
	private HouseproductService houseproductService;
	
	
	
	@RequestMapping("/addhouseproduct")
	@ResponseBody
	public ResultBean addhouseproduct(HouseProduct houseproduct)
	{
		houseproductService.addHouseproduct(houseproduct);
		
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
		
	}
	
	
	
	@RequestMapping("/getHouseProduct")
	public String getHouseproductList(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			Map<String, Object> data
			)
	{
		PageInfo<HouseProduct> houseproductList = houseproductService.getHouseproductList(pn, size);
		data.put("pageinfo", houseproductList);
		return "forward:/houseproduct.jsp";
	}
	
	
	@RequestMapping("/delHouseProduct")
	@ResponseBody
	public ResultBean delHouseProduct(HouseProduct houseproduct){
		
		houseproductService.delHouseProduct(houseproduct);
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
				
	}
	
	@RequestMapping("/updateHouseProduct")
	public String updateHouseProduct(Integer houseProductId,Map<String, Object> data) {
		List<HouseProduct> list = houseproductService.updateHouseProduct(houseProductId);
		data.put("list", list.get(0));
		return "forward:/updatehouseproduct.jsp";
		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public ResultBean updHouseProduct(HouseProduct houseproduct){
		
		System.out.println("进入修改方法");
		houseproductService.updateByPrimaryKeySelective(houseproduct);
		System.out.println("修改方法执行陈宫=");
		ResultBean bean = new ResultBean();
		bean.setResultState(1);
		return bean;
				
	}
	
	@RequestMapping("/selHouseProduct")
	public String selHouseProduct(
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="5")Integer size,
			HouseProduct houseproduct,
			String productName,
			Map<String, Object> data
			)
	{
		System.out.println(houseproduct);
		System.out.println(productName);
		PageInfo<HouseProduct> houseproductList = houseproductService.selHouseproductList(pn, size, houseproduct, productName);
		data.put("pageinfo", houseproductList);
		return "forward:/houseproduct.jsp";
	}
	
	
	

}
