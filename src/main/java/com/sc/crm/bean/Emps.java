package com.sc.crm.bean;

import java.util.Date;

public class Emps {
    private Integer empId;

    private String empName;

    private String empSex;

    private Date empBirthday;

    private String empHometown;

    private Date empStartwork;

    private String empAddress;

    private String empPhone;

    private String empQq;

    private String empPicture;

    private String empIdentity;

    private String empEducation;

    private Integer userId;
    
    private Dept dept;
    
    private User user;
    
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName == null ? null : empName.trim();
    }

    public String getEmpSex() {
        return empSex;
    }

    public void setEmpSex(String empSex) {
        this.empSex = empSex == null ? null : empSex.trim();
    }

    public Date getEmpBirthday() {
        return empBirthday;
    }

    public void setEmpBirthday(Date empBirthday) {
        this.empBirthday = empBirthday;
    }

    public String getEmpHometown() {
        return empHometown;
    }

    public void setEmpHometown(String empHometown) {
        this.empHometown = empHometown == null ? null : empHometown.trim();
    }

    public Date getEmpStartwork() {
        return empStartwork;
    }

    public void setEmpStartwork(Date empStartwork) {
        this.empStartwork = empStartwork;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress == null ? null : empAddress.trim();
    }

    public String getEmpPhone() {
        return empPhone;
    }

    public void setEmpPhone(String empPhone) {
        this.empPhone = empPhone == null ? null : empPhone.trim();
    }

    public String getEmpQq() {
        return empQq;
    }

    public void setEmpQq(String empQq) {
        this.empQq = empQq == null ? null : empQq.trim();
    }

    public String getEmpPicture() {
        return empPicture;
    }

    public void setEmpPicture(String empPicture) {
        this.empPicture = empPicture == null ? null : empPicture.trim();
    }

    public String getEmpIdentity() {
        return empIdentity;
    }

    public void setEmpIdentity(String empIdentity) {
        this.empIdentity = empIdentity == null ? null : empIdentity.trim();
    }

    public String getEmpEducation() {
        return empEducation;
    }

    public void setEmpEducation(String empEducation) {
        this.empEducation = empEducation == null ? null : empEducation.trim();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}