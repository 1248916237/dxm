package com.sc.crm.service;

import java.util.List;

import com.sc.crm.bean.Role;
import com.sc.crm.bean.User;

public interface LoginService {
	User chaUserByName(String userWorkId);
	List<Role> chaRoleList(Integer userId);
}
