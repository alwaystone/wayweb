package com.ways.user.controller;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ways.user.entity.LoginUser;
import com.ways.user.service.UserLoginService;
import com.ways.utils.Md5Util;
@Controller 
@RequestMapping("userLoginController")
public class UserLoginController {
	@Autowired
	private UserLoginService userLoginService ;
	@RequestMapping("/getUserLoginInfo")
	@ResponseBody
	public Map getUserLoginInfo(HttpServletRequest request,HttpServletResponse response, @RequestBody Map paramsMap){
		/*System.out.println(paramsMap.get("userId"));
		System.out.println(paramsMap.get("password"));
		
		LoginUser loginUser = new LoginUser() ;//userLoginService.getLoginInfo();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
		loginUser.setId(sdf.format(new Date()));
		loginUser.setLoginName("admin");
		loginUser.setUserId("asdfasdfasdfasd");
		request.getSession().setAttribute("user", loginUser);
		*/
		/*String username = paramsMap.get("username").toString() ;
		String password = paramsMap.get("password").toString() ;
		Map map = new HashMap() ;
		List list = new ArrayList() ;
		map.put("a", "aaaa") ;
		map.put("list", list) ;*/
		HttpSession session = request.getSession() ;
		response.setHeader("Set-Cookie","JSESSIONID="+request.getSession().getId());
		Map map = new HashMap() ;
		map.put("username", "admin") ;
		map.put("password", Md5Util.getMD5String("1")) ;
		Map resoultMap = userLoginService.getLoginInfo(map); 
		session.setAttribute("user", map);
        return resoultMap;
	}
}
