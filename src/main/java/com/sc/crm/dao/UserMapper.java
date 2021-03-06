package com.sc.crm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sc.crm.bean.Permission;
import com.sc.crm.bean.Role;
import com.sc.crm.bean.User;

public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    
    int delUser(@Param("userId")Integer userId);
    
	User chaUserById(@Param("userId")String userId);
	
	List<Role> chaRoleList(@Param("userId")Integer userId);
	
    List<Permission> perListPer(@Param("userId")Integer userId);
    
    List<User> selUserId();
	
    Integer selUserNum();
}