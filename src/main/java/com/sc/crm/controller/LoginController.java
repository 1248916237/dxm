package com.sc.crm.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	
	@RequestMapping("/login")
	public String logins(HttpServletRequest req)
	{
		String msg=(String)req.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
		int state = 0;
		if(msg == null)
		{state = 4;System.out.println( "msg:" + msg);
		}
		else if(msg.equals("UnknownAccountException"))
		{state = 1;System.out.println("未知错误");
		}
		else if(msg.equals("IncorrectCredentialsException"))
		{state = 2;System.out.println("密码错误");
		}
		else if(msg.equals("AuthenticationException"))
		{state = 3;System.out.println("用户名错误");
		}
		return "redirect:/login.jsp?state="+state;
	}
	
	@RequestMapping("/main")
	public String mains()
	{
		System.out.println("登录成功");
		return "redirect:/main.jsp";
	}
	
	@RequestMapping("/adds")
	@RequiresPermissions(value= {"paper:all","user:del"})
	//@RequiresRoles(value={"ssa","sasx"})
	public String adds()
	{
		System.out.println("进入权限");
		return "redirect:/quanxian.jsp";
	}
}
