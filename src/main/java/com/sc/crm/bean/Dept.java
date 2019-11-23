package com.sc.crm.bean;

public class Dept {
    private Integer deptId;

    private String deptName;

    private Long deptSalary;

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName == null ? null : deptName.trim();
    }

    public Long getDeptSalary() {
        return deptSalary;
    }

    public void setDeptSalary(Long deptSalary) {
        this.deptSalary = deptSalary;
    }
}