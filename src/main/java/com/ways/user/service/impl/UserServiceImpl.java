package com.ways.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.JsonArray;
import com.ways.user.dao.UserDao;
import com.ways.user.entity.User;
import com.ways.user.service.UserService;

import net.sf.json.JSONArray;

@Transactional
@Service("userService")
public class UserServiceImpl implements UserService{
	@Autowired
	public UserDao userDao ;
	
	public void insertUser(User user) {
		userDao.insertUser(user);
	}

	public List<User> getUserList(Map param) {
		return userDao.getUserList(param);
	}

	public User getUserById(String id) {
		return userDao.getUserById(id);
	}

	@Override
	public List<Map> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public List getUserRoleResources(Map map) {
		List<Map> resourceList = userDao.getUserRoleResources(map);
		List targetList = new ArrayList() ;
		
		for(Map tempMap : resourceList){
			tempMap.put("children", new ArrayList()) ;
		}
		userRoleResourceFormat(resourceList,targetList,1,"menu0") ;
		JSONArray ja =JSONArray.fromObject(targetList) ;
		
		System.out.println(ja.toString());
		return targetList;
	}
	
	private String userRoleResourceFormat(List<Map> resourceList,List<Map> targetList,int level,String parentId){
		for(Map map : resourceList){
			/*map.put("children", new ArrayList()) ;
			System.out.println("------------------------------------------");
			System.out.println(map.get("children").hashCode());
			System.out.println("------------------------------------------");*/
			if(Integer.parseInt(map.get("level").toString())==level&&parentId.equals(map.get("parent_id"))){
				targetList.add(map) ;
				//resourceList.remove(map) ;
				userRoleResourceFormat(resourceList,(List) map.get("children"),level+1,(String) map.get("menu_id")) ;
			}
		}
		System.out.println(targetList.hashCode());
		for(Map map : targetList){
			System.out.println(map.hashCode());
		}
		System.out.println("===============================================================");
		return null ;
	}

	@Override
	public int insertMenus(List list) {
		// TODO Auto-generated method stub
		return userDao.insertMenus(list);
	}
}