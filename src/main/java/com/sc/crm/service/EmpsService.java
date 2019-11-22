package com.sc.crm.service;

import com.sc.crm.bean.Emps;

public interface EmpsService {

	Emps selByUserId(Integer userId);
	
	void updateImg(Emps emps);
}
