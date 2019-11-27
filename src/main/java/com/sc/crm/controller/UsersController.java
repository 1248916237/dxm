package com.sc.crm.controller;

import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crm.bean.Dept;
import com.sc.crm.bean.Emps;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.bean.User;
import com.sc.crm.service.EmpsService;

@Controller
public class UsersController {

	@Resource
	private EmpsService empsService;
	
	@RequestMapping("/getEmpsList")
	private String getAllEmps(Emps emps,HashMap<String, Object> data) {
		List<Emps> empsList = empsService.getEmpsList(emps);
		data.put("empsList", empsList);
		return "forward:/empsList.jsp";
	}
	
	@RequestMapping("/emps_update")
	private String updateEmps(Emps emps,HashMap<String, Object> data) {
		
		List<Emps> empsList = empsService.getEmpsList(emps);
		data.put("empsList", empsList);
		
		List<Dept> deptList = empsService.getDeptList();
		data.put("deptList", deptList);
		return "forward:/emps_update.jsp";
	}
	
	@RequestMapping("/emps_update_agin")
	@ResponseBody
	public ResultBean updateByPrimaryKey(Emps emps)
	{
		int i = empsService.updateEmps(emps);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(i);
		return resultBean;
	}
	
	@RequestMapping("/emps_add")
	private String getDeptList(HashMap<String, Object> data) {
		List<Dept> deptList = empsService.getDeptList();
		data.put("deptList", deptList);
		return "forward:/emps_add.jsp";
	}
	
	@RequestMapping("/emps_add_agin")
	@ResponseBody
	public ResultBean empsAdd(HttpServletRequest res,Emps emps)
	{
		System.out.println("进入用户添加");
		String deptId = res.getParameter("deptId");
		int i = empsService.addEmps(emps);
		System.out.println(deptId+emps);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(i);
		return resultBean;
	}
	
	@RequestMapping("/del_userId")
	@ResponseBody
	public ResultBean delUser(User user)
	{
		int i = empsService.delUser(user);
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(i);
		return resultBean;
	}
}
