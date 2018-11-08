package com.ways.utils;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ServletContextAware;

import com.ways.user.dao.UserDao;
import com.ways.user.entity.User;

@Component
public class InitDict implements InitializingBean, ServletContextAware{
	@Autowired
	public UserDao userDao ;
	
	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("init data ending........................");
	}
	
	public void loadDataTest(){
		System.out.println("TEST LOADING........................");
	}
	
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		//User user = userDao.getUserById("1111") ;
		//System.out.println(user.getUserId());
		System.out.println("init data........................");
	}

}
