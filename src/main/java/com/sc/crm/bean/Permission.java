package com.sc.crm.bean;

import java.util.List;

public class Permission {
    private Integer permissionId;

    private String permissionName;

    private String permissionType;

    private String permissionUrl;

    private String permissionCode;

    private Integer permissionParentid;

    private String permissionParentids;

    private String permissionSotr;
    
    private List<Pee> perList;

	@Override
	public String toString() {
		return "Permission [permissionId=" + permissionId + ", permissionName=" + permissionName + ", permissionType="
				+ permissionType + ", permissionUrl=" + permissionUrl + ", permissionCode=" + permissionCode
				+ ", permissionParentid=" + permissionParentid + ", permissionParentids=" + permissionParentids
				+ ", permissionSotr=" + permissionSotr + ", perList=" + perList + "]";
	}

	public List<Pee> getPerList() {
		return perList;
	}

	public void setPerList(List<Pee> perList) {
		this.perList = perList;
	}

	public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName == null ? null : permissionName.trim();
    }

    public String getPermissionType() {
        return permissionType;
    }

    public void setPermissionType(String permissionType) {
        this.permissionType = permissionType == null ? null : permissionType.trim();
    }

    public String getPermissionUrl() {
        return permissionUrl;
    }

    public void setPermissionUrl(String permissionUrl) {
        this.permissionUrl = permissionUrl == null ? null : permissionUrl.trim();
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    public Integer getPermissionParentid() {
        return permissionParentid;
    }

    public void setPermissionParentid(Integer permissionParentid) {
        this.permissionParentid = permissionParentid;
    }

    public String getPermissionParentids() {
        return permissionParentids;
    }

    public void setPermissionParentids(String permissionParentids) {
        this.permissionParentids = permissionParentids == null ? null : permissionParentids.trim();
    }

    public String getPermissionSotr() {
        return permissionSotr;
    }

    public void setPermissionSotr(String permissionSotr) {
        this.permissionSotr = permissionSotr == null ? null : permissionSotr.trim();
    }
}