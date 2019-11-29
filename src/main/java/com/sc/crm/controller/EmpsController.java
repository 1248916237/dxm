package com.sc.crm.controller;

import java.io.File;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.sc.crm.bean.Emps;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.bean.User;
import com.sc.crm.service.EmpsService;
import com.sc.crm.util.Md5;

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
	
	@RequestMapping("/editPass")
	@ResponseBody
	public ResultBean editPass(HttpServletRequest res,Map<String, Object> data) throws NoSuchAlgorithmException
	{
		Subject subject = SecurityUtils.getSubject();
		User user = (User) subject.getPrincipal();
		
		ResultBean bean = new ResultBean();
		
		String pass = res.getParameter("pass");
		String repass = res.getParameter("repass");
		
		String userPass = user.getUserPass();
		String userSalt = user.getUserSalt();
		String pass2 = Md5.getMd5Pass(pass, userSalt);
		
		if (!userPass.equals(pass2)) {
			bean.setResultMsg("���������벻��ȷ");
			bean.setResultState(0);
			System.out.println("�����벻��ȷ"+ bean);
			return bean;
		} else {
			//������
			String md5Pass = Md5.getMd5Pass(repass, userSalt);
			user.setUserPass(md5Pass);
			empsService.updatePass(user);
			
			System.out.println("��������"+ bean);
			bean.setResultState(1);
			return bean;
		}
	}
	
	@RequestMapping("/upload")
	public String upload(String test,MultipartFile img,HttpServletRequest req,Emps emps) throws IllegalStateException, IOException
	{
		String showPath = null;
		//�ж��ļ��Ƿ����
		if(img != null && !img.isEmpty())
		{
			String realPath = req.getServletContext().getRealPath("/images");
			File dir = new File(realPath);
			if(!dir.exists())
			{
				dir.mkdirs();
			}
			
			//��ȡԭʼ�ļ���
			String originalFilename = img.getOriginalFilename();
			
			//��ȡ����׺��
			String ext = originalFilename.substring(originalFilename.lastIndexOf("."));
			
			String fileName =  System.currentTimeMillis() + ext;
			String savePath = realPath + "/" + fileName;
			
			//�洢�ļ���������
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
	
	@RequestMapping("/selUser")
	public String selUser(Map<String, Object> data,Integer userId)
	{
		
		Emps selUser = empsService.selByUserId(userId);
		data.put("selUser", selUser);
		return "forward:/purchase-userinfo.jsp";
		
	}
	
	@RequestMapping("/selNum")
	public String selNum(Map<String, Object> data)
	{
		int selCliNum = empsService.selCliNum();
		data.put("selCliNum",selCliNum);
		
		int selCliLossNum = empsService.selCliLossNum();
		data.put("selCliLossNum", selCliLossNum);
		
		Integer selOrderNum = empsService.selOrderNum();
		data.put("selOrderNum", selOrderNum);
		
		Integer selWaitPurNum = empsService.selWaitPurNum();
		data.put("selWaitPurNum", selWaitPurNum);
		
		Integer selSupplierNum = empsService.selSupplierNum();
		data.put("selSupplierNum", selSupplierNum);
		
		Integer selHouseNum = empsService.selHouseNum();
		data.put("selHouseNum", selHouseNum);
		
		Integer selUserNum = empsService.selUserNum();
		data.put("selUserNum", selUserNum);
		
		Integer selProductNum = empsService.selProductNum();
		data.put("selProductNum", selProductNum);
		
		return "forward:/welcome.jsp";
		
	}
	
}
