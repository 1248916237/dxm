package com.sc.crm.bean;

import java.util.Arrays;
import java.util.List;

public class Role {
    private Integer roleId;

    private String roleName;
    
    private String[] perId;
    
    @Override
	public String toString() {
		return "Role [roleId=" + roleId + ", roleName=" + roleName + ", perId=" + Arrays.toString(perId)
				+ ", permissionList=" + permissionList + "]";
	}

	public String[] getPerId() {
		return perId;
	}

	public void setPerId(String[] perId) {
		this.perId = perId;
	}

	private List<Permission> permissionList;

    public List<Permission> getPermissionList() {
		return permissionList;
	}

	public void setPermissionList(List<Permission> permissionList) {
		this.permissionList = permissionList;
	}

	public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }
}