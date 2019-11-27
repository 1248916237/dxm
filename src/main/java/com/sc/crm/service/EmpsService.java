package com.sc.crm.service;

import java.util.List;

import com.sc.crm.bean.Dept;
import com.sc.crm.bean.Emps;
import com.sc.crm.bean.User;

public interface EmpsService {

	Emps selByUserId(Integer userId);
	
	void updateImg(Emps emps);
	
	List<Emps> getEmpsList(Emps emps);
	
	List<Dept> getDeptList();
	
	int updateEmps(Emps emps);
	
	int addEmps(Emps emps);
	
	int delUser(User user);
	
	int updatePass(User user);
}
