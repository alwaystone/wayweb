package com.ways.user.service.impl;

import javax.jws.WebService;

import com.ways.user.service.IHelloWorld;
@WebService(endpointInterface = "com.ways.user.service.IHelloWorld") 
public class HelloWorldImpl implements IHelloWorld {
	@Override
	public String sayHello(String username) {
		return "Hello " + username;
	}
 
	@Override 
	public void setUser(String username) {
		 
	}


}
