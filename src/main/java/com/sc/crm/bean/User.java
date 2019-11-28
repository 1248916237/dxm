package com.sc.crm.bean;

public class User {
    private Integer userId;

    private Integer deptId;

    private Integer userState;

    private String userPass;

    private String userSalt;

    private Integer empId;

    @Override
	public String toString() {
		return "User [userId=" + userId + ", deptId=" + deptId + ", userState=" + userState + ", userPass=" + userPass
				+ ", userSalt=" + userSalt + ", empId=" + empId + "]";
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getUserState() {
		return userState;
	}

	public void setUserState(Integer userState) {
		this.userState = userState;
	}

	public String getUserPass() {
		return userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserSalt() {
		return userSalt;
	}

	public void setUserSalt(String userSalt) {
		this.userSalt = userSalt;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	
}