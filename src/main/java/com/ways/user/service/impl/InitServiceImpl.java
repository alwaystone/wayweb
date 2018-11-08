package com.ways.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ways.user.entity.User;
import com.ways.user.service.EhCacheTestService;
import com.ways.user.service.InitService;
import com.ways.user.service.UserService;
@Transactional
@Service("initService")
public class InitServiceImpl implements InitService {
	@Autowired
	private UserService userService ;
	@Autowired
	private EhCacheTestService ehCacheTestService ;
	@Override
	public void getUserById(String id) {
		// TODO Auto-generated method stub
		//return userService.getUserById(id);
		ehCacheTestService.getTimestamp("param") ;
	}

}
