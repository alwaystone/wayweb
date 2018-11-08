package com.ways.user.service.impl;

import javax.jws.WebService;

import com.ways.user.service.ICalculateService;

@WebService(endpointInterface = "com.ways.user.service.ICalculateService")
public class CalculateServiceImpl implements ICalculateService {

	@Override
	public int add(int num1, int num2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
