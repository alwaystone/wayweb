package com.ways.utils;

import java.util.ArrayList;
import java.util.List;

import com.ways.user.entity.User;

public class Test {
	public static void main(String[] args) {
		
		User user = new User() ;
		System.out.println(user);
		System.out.println(user.hashCode());
		user.setAddress("111111111111111111111");
		System.out.println(user);
		System.out.println(user.hashCode());
		List list = new ArrayList() ;
		list.add(1) ;
	}
}
