package com.sc.crm.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sc.crm.bean.Purchase;
import com.sc.crm.bean.User;
import com.sc.crm.service.PurchaseService;

@Controller
public class PurchaseController {

	@Resource
	private PurchaseService purchaseService;
	
	@RequestMapping("/selectMaterial")
	public String selMaterial(Map<String, Object> data,
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="2")Integer size,
			@DateTimeFormat(pattern="yyyy-MM-dd")Date time1,@DateTimeFormat(pattern="yyyy-MM-dd")Date time2
			)
	{
//		Subject subject = SecurityUtils.getSubject();
//		User principal = (User) subject.getPrincipal();
//		List<Purchase> selMaterial = purchaseService.selMaterialByUserId(principal.getUserId());
		
		
		PageInfo<Purchase> selMaterial = purchaseService.selectPurchase(pn, size,time1,time2);
		data.put("selMaterial", selMaterial);
		return "forward:/purchase-list.jsp";
	}
	
	@RequestMapping("/delPurchase")
	@ResponseBody
	public boolean delPurchase(Purchase purchase)
	{
//		Subject subject = SecurityUtils.getSubject();
//		Purchase principal = (Purchase) subject.getPrincipal();
		boolean delPurchase = purchaseService.delPurchase(purchase.getPurchaseId());
		return delPurchase;
		
	}
	
	@RequestMapping("/waitPurchase")
	public String waitPurchase(
			Map<String, Object> data,
			@RequestParam(name="pn",defaultValue="1")Integer pn,
			@RequestParam(name="size",defaultValue="2")Integer size
			)
	{
		PageInfo<Purchase> waitPurchase = purchaseService.waitPurchase(pn, size);
		data.put("waitPurchase", waitPurchase);
		
		return "forward:/wait-purchase-list.jsp";	
	}
	
	@RequestMapping("/updateState")
	@ResponseBody
	public boolean updateState(Integer purchaseId)
	{
		boolean updateState = purchaseService.updateState(purchaseId);
		return updateState;
	}
	
}
