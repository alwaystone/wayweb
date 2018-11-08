package com.ways.utils;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ways.user.entity.User;
import com.ways.user.service.EhCacheTestService;
import com.ways.user.service.InitService;

@Component
public class InitDict01{
	@Autowired
	public InitService initService ;
	//@Autowired
	//private EhCacheTestService ehCacheTestService ; 
    //@PostConstruct
	public void initData() {
		// TODO Auto-generated method stub
		//ehCacheTestService.getTimestamp("param") ;
		initService.getUserById("1111") ;
		System.out.println("01 loading data..........................");
	}
	
}
