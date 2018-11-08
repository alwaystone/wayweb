package com.ways.listener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Service;

import com.ways.user.service.EhCacheTestService;
import com.ways.user.service.UserService;
@Service
public class InitDataListener implements ApplicationListener<ContextRefreshedEvent>{
	
	@Autowired
	private UserService userService ;
	@Autowired
	private EhCacheTestService ehCacheTestService ; 
	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		if(arg0.getApplicationContext().getParent() == null){  
			
             //需要执行的逻辑代码，当spring容器初始化完成后就会执行该方法。  
            System.out.println("加载了....................................");
            
            ehCacheTestService.getTimestamp("param") ;
        }  
	}

}
