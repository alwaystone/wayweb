package com.ways.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ways.user.entity.User;
import com.ways.user.service.EhCacheTestService;
import com.ways.user.service.UserService;
@Transactional
@Service("ehCacheTestService")
public class EhCacheTestServiceImpl implements EhCacheTestService {
	@Autowired
	private UserService userService ;
	
	@Cacheable(value="menuCache",key="#param")
    public Map getTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        User user = userService.getUserById("1111") ;
        Map map = new HashMap() ;
        map.put("user", user) ;
        map.put("time", timestamp.toString()) ;
        System.out.println(map.toString());
        return map;
    }
	
	@CacheEvict(value="menuCache",key="#param")
    public String delTimestamp(String param) {
        Long timestamp = System.currentTimeMillis();
        return timestamp.toString();
    }
}
