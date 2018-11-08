package com.ways.listener;

import java.net.MalformedURLException;
import java.net.URL;

import javax.servlet.ServletContextEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.ContextLoaderListener;

import com.ways.user.dao.UserDao;
import com.ways.user.entity.User;
import com.ways.user.service.UserService;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class WebContextListener extends ContextLoaderListener {
	
	//@Autowired
	//public UserService userService ;
    //public static CacheManager cacheManager ;
    @Override
    public void contextInitialized(ServletContextEvent event) {
        try {
			printKeyLoadMessage() ;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    @CachePut(value="menuCache",key="#mytestStr",condition="#true")
    private String printKeyLoadMessage() throws MalformedURLException{
        StringBuilder sb = new StringBuilder();
        sb.append("\r\n======================================================================\r\n");
        sb.append("\r\n    欢迎使用  - EhCache缓存系统搭建\r\n");
        sb.append("\r\n======================================================================\r\n");
        System.out.println(sb.toString());
        
        //URL configurationFileURL = new URL("resources/applicationContext.xml") ;
        //CacheManager cacheManager = CacheManager.newInstance("/WEB-INF/classes/src/main/resources/ehcache.xml") ;
        /*URL url = this.getClass().getResource("/ehcache.xml") ;
        cacheManager = new CacheManager(url); */
        //Element element = new Element("test", "test my ehcache!") ;
        //cacheManager.put(element);
        System.out.println("Ending............................................");
        //User user = userService.getUserById("1111") ;
        return "testMenuaaaa";
    }
    // 系统初始化执行方法  
    public void contextDestroyed(ServletContextEvent e) {  
    	System.out.println("系统停止...");  
    }  
    
}
