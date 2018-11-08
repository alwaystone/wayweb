package com.ways.user.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ways.user.dao.UserLoginDao;
import com.ways.user.entity.LoginUser;
import com.ways.user.service.UserLoginService;
@Transactional
@Service("userLoginService")
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired
	private UserLoginDao userLoginDao ;
	
	@Override
	public Map getLoginInfo(Map map) {
		Map resultMap = userLoginDao.getLoginInfo(map);
		return resultMap ;
	}

}
