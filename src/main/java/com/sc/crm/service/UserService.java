package com.sc.crm.service;

import java.util.List;

import com.sc.crm.bean.Emps;
import com.sc.crm.bean.User;
import com.sc.crm.bean.UserRole;

public interface UserService {

	List<Emps> getEmpsListJust(Emps emps);
	
	Emps getEmpsByEmpsId(Integer empsId);
	
	int delEmps(Emps emps);
	
	int addUser(User user);
	
	int addUserRole(UserRole userRole);
	
	User getUserById(User user);
	
	int updateUser(User user);
}
