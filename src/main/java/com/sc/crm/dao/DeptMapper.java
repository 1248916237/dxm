package com.sc.crm.dao;

import java.util.List;

import com.sc.crm.bean.Dept;

public interface DeptMapper {
    int deleteByPrimaryKey(Integer deptId);

    int insert(Dept record);

    int insertSelective(Dept record);

    Dept selectByPrimaryKey(Integer deptId);

    int updateByPrimaryKeySelective(Dept record);

    int updateByPrimaryKey(Dept record);
    
    List<Dept> getDeptList();
}