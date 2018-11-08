package com.ways.utils;

import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ways.user.dao.UserDao;
import com.ways.user.entity.User;

/**
 * 用户工具类
 */
public class UserUtils {

	String xmlPath = "resources/applicationContext.xml";
	ApplicationContext applicationContext = new ClassPathXmlApplicationContext(xmlPath);
	private UserDao userDao = applicationContext.getBean(UserDao.class);

    private static Map<String, Object> cacheMap;
    /**
     * 根据ID获取用户
     * @param id
     * @return 取不到返回null
     */
    public static User getUser(String id){
        User user = (User)CacheUtils.get("userCache", "id_" + id);
        if (user ==  null){
            //user = userDao.getUserById(id);
            if (user == null){
                return null;
            }
            CacheUtils.put("userCache", "id_" + user.getUserId(), user);
            CacheUtils.put("userCache", "ln" + user.getName(), user);
        }
        return user;
    }
    
    /**
     * 根据登录名获取用户
     * @param loginName
     * @return 取不到返回null
     */
    public static User getByLoginName(String loginName){
        User user = (User)CacheUtils.get("userCache", "ln" + loginName);
        if (user == null){
           /* user = userDao.getByLoginName(new User(null, loginName));
            if (user == null){
                return null;
            }
            CacheUtils.put("userCache", "id_" + user.getId(), user);
            CacheUtils.put("userCache", "ln" + user.getLoginName(), user);*/
        }
        return user;
    }
    
    
    /**
     * 清除用户缓存
     * @param user
     */
    public static void clearCache(User user){
        CacheUtils.remove("userCache", "id_" + user.getUserId());
        CacheUtils.remove("userCache", "ln" + user.getName());
    }
}