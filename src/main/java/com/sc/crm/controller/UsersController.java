package com.sc.crm.controller;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sc.crm.bean.Dept;
import com.sc.crm.bean.Emps;
import com.sc.crm.bean.ResultBean;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.User;
import com.sc.crm.bean.UserRole;
import com.sc.crm.service.EmpsService;
import com.sc.crm.service.RolePermissionService;
import com.sc.crm.service.UserService;
import com.sc.crm.util.Md5;

@Controller
public class UsersController {

	@Resource
	private EmpsService empsService;
	
	@Resource
	private UserService userService;
	
	@Resource
	private RolePermissionService rolePermissionService;
	
	
	@RequestMapping("/getEmpsList")
	private String getAllEmps(Emps emps,HashMap<String, Object> data) {
		//List<Emps> empsList = empsService.getEmpsList(emps);
		
		List<Emps> empsListJust = userService.getEmpsListJust(emps);
		
		data.put("empsList", empsListJust);
		return "forward:/empsList.jsp";
	}
	
	@RequestMapping("/getUserList")
	private String getUserList(Emps emps,HashMap<String, Object> data) {
		List<Emps> empsList = empsService.getEmpsList(emps);
		data.put("empsList", empsList);
		return "forward:/userList.jsp";
	}
	
	@RequestMapping("/emps_update")
	private String updateEmps(Emps emps,HashMap<String, Object> data) {
		
		Emps empsByEmpsId = userService.getEmpsByEmpsId(emps.getEmpId());
		data.put("empsByEmpsId", empsByEmpsId);
		
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
	
	@RequestMapping("/userUpdate")
	private String updateUser(User user,HashMap<String, Object> data) {
		
		User userById = userService.getUserById(user);
		data.put("userById", userById);
		
		List<Dept> deptList = empsService.getDeptList();
		data.put("deptList", deptList);
		return "forward:/user_update.jsp";
	}
	
	@RequestMapping("/user_update_agin")
	@ResponseBody
	public ResultBean updateUserAgin(User user)
	{
		int i = userService.updateUser(user);
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
	
	@RequestMapping("/user_add")
	private String userAdd(HashMap<String, Object> data) {
		
		List<Emps> empsList = userService.getEmpsListJust(null);
		data.put("empsList", empsList);
		
		List<Dept> deptList = empsService.getDeptList();
		data.put("deptList", deptList);
		
		List<Role> allRole = rolePermissionService.getAllRole();
		data.put("allRole", allRole);
		
		return "forward:/user_add.jsp";
	}
	
	@RequestMapping("/user_add_agin")
	@ResponseBody
	public ResultBean userAddAgin(@RequestBody User user) throws NoSuchAlgorithmException
	{
		System.out.println("进入用户添加" + user);
		String userSalt = "abc";
		String userPass = Md5.getMd5Pass("123",userSalt);
		user.setUserState(1);
		user.setUserSalt(userSalt);
		user.setUserPass(userPass);
		
		userService.addUser(user);
		Integer userId = user.getUserId();
		Integer[] roleShu = user.getRoleShu();
		for (int i = 0; i < roleShu.length; i++) {
			UserRole userRole = new UserRole();
			Integer roleId = roleShu[i];
			userRole.setRoleId(roleId);
			userRole.setUserId(userId);
			userService.addUserRole(userRole);
		}
		ResultBean resultBean = new ResultBean();
		resultBean.setResultState(0);
		resultBean.setResultMsg("成功");
		return resultBean;
	}
	
	@RequestMapping("/del_emps")
	@ResponseBody
	public ResultBean delEmps(Emps emps)
	{
		int i = userService.delEmps(emps);
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
