package com.sc.crm.dao;

import com.sc.crm.bean.Role;

public interface RoleMapper {
    int insert(Role record);

    int insertSelective(Role record);
}