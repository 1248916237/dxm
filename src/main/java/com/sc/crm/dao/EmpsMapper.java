package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Emps;

public interface EmpsMapper {
    int deleteByPrimaryKey(Integer empId);

    int insert(Emps record);

    int insertSelective(Emps record);

    Emps selectByPrimaryKey(Integer empId);

    int updateByPrimaryKeySelective(Emps record);

    int updateByPrimaryKey(Emps record);
    
    Emps selByUserId(@Param("userId")Integer userId);
    
    List<Emps> getEmpsList(Emps emps);
}