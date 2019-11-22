package com.sc.crm.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sc.crm.bean.Emps;
import com.sc.crm.bean.User;
import com.sc.crm.service.EmpsService;

@Controller
public class EmpsController {

	@Resource
	private EmpsService empsService;
	
	@RequestMapping("/selByUserId")
	public String selByUserId(Map<String, Object> data)
	{
		Subject subject = SecurityUtils.getSubject();
		User principal = (User) subject.getPrincipal();
		Emps selByUserId = empsService.selByUserId(principal.getUserId());
		data.put("selByUserId", selByUserId);
		return "forward:/admin-info.jsp";
		
	}
	
	@RequestMapping("/upload")
	public String upload(String test,MultipartFile img,HttpServletRequest req,Emps emps) throws IllegalStateException, IOException
	{
		String showPath = null;
		//判断文件是否存在
		if(img != null && !img.isEmpty())
		{
			String realPath = req.getServletContext().getRealPath("/images");
			File dir = new File(realPath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			
			//获取原始文件名
			String originalFilename = img.getOriginalFilename();
			
			//截取出后缀名
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String fileName =  System.currentTimeMillis() + ext;
			String savePath = realPath + "/" + fileName;
			
			//存储文件到服务器
			img.transferTo(new File(savePath));
			showPath = "images/"+fileName;
			
		
		}
		
//		System.out.println(showPath);
		Subject subject = SecurityUtils.getSubject();
		User principal = (User) subject.getPrincipal();
		emps.setUserId(principal.getUserId());
		emps.setEmpPicture(showPath);
		empsService.updateImg(emps);
		
		return "";
	}
	
}
