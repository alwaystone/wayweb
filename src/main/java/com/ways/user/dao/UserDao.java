package com.ways.user.dao;

import java.util.List;
import java.util.Map;

import com.ways.user.entity.User;

public interface UserDao{
	public List<Map> findAll() ;
	
	public void insertUser(User user) ;
	
	public List<User> getUserList(Map param) ;
	
	public User getUserById(String id) ;

	public List getUserRoleResources(Map map) ;
	
	public int insertMenus(List list) ;
}
