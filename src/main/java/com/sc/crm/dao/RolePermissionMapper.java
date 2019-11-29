package com.sc.crm.dao;

import com.sc.crm.bean.RolePermission;

public interface RolePermissionMapper {
    int deleteByPrimaryKey(Integer permissionRoleId);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Integer permissionRoleId);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);
}