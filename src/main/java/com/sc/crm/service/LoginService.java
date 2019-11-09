package com.sc.crm.service;

import java.util.List;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.User;

public interface LoginService {
	
	User chaUserById(String userId);
	
	List<Role> chaRoleList(Integer userId);
	
    List<Permission> perListPer(Integer userId);
}
