package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;

public interface PermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(Permission record);

    int insertSelective(Permission record);

    Permission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
    
    List<Permission> getPermissionList();
    
    List<Permission> getAllPermissionList();
    
    List<Permission> getPermissionListByParentid(@Param("parentid")Integer parentid);
}