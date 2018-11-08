package com.ways.user.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ways.user.entity.User;
import com.ways.user.service.EhCacheTestService;
import com.ways.user.service.UserService;
import com.ways.utils.MenuUtil;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
@RequestMapping("/userController")
public class UserController {
	@Autowired
	public UserService userService ;
	@Autowired
	public EhCacheTestService ehCacheTestService ;
	
	@RequestMapping("/testGetSessionInfo") 
	@ResponseBody
	public String testGetSessionInfo(HttpServletRequest request) throws IOException{
		Properties configuration = new Properties();  
        InputStream is = UserController.class.getResourceAsStream("/mail.properties");  
        configuration.load(is);  
        System.out.println("properties中 sys.time="+configuration.get("host"));

		/*LoginUser lu = (LoginUser) request.getSession().getAttribute("user") ;
		Cookie[] cookies = request.getCookies() ;
		
		for(Cookie c :cookies){
			System.out.println(c.getName());
			
		}
		System.out.println(JSONObject.fromObject(lu).toString());
		HttpSession HttpSession = request.getSession() ;*/
		//JSONObject jo =  JSONObject.fromObject() ;
		//System.out.println(jo.toString());
		return "test" ;
	}
	
	@RequestMapping("/testEhcacheFun") 
	@ResponseBody
	public Map testEhcacheFun(HttpServletRequest request) throws IOException{
		
		List<Map> list = userService.findAll() ;
		System.out.println(list.size());
		System.out.println(ehCacheTestService.getTimestamp("param"));
		Map map = new HashMap() ;
		map.put("ehcacheTime", ehCacheTestService.getTimestamp("param")) ;
		return map ;
	}
	@RequestMapping("/deltestEhcacheFun") 
	@ResponseBody
	public Map deltestEhcacheFun(HttpServletRequest request) throws IOException{
		System.out.println(ehCacheTestService.delTimestamp("param"));
		Map map = new HashMap() ;
		map.put("deltestEhcacheFun", "清除完成") ;
		return map ;
	}
	
	@RequestMapping("/insertUser") 
	public String test(ModelMap map){
		User user = new User() ;
		user.setName("admin");
		user.setSex("1");
		user.setCreateId("0");
		user.setCreateTime(new Date()) ; 
		user.setCreateName("admin");
		userService.insertUser(user);
		return "test" ;
	}
	
	@RequestMapping("/saveUser") 
	@ResponseBody
	public String saveUser(@RequestParam Map map){
		Set keys = map.keySet() ;
		User user = new User() ;
		user.setName(map.get("name")!=null?map.get("name").toString():null);
		user.setUserCode(map.get("code")!=null?map.get("code").toString():null);
		user.setPhone(map.get("phone")!=null?map.get("phone").toString():null);
		user.setAddress(map.get("address")!=null?map.get("address").toString():null);
		user.setCreateId("0");
		user.setCreateTime(new Date()) ; 
		user.setCreateName("admin");
		userService.insertUser(user);
		return "success" ;
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public Map getUserList(ModelAndView model) throws IllegalAccessException, InvocationTargetException{
		Map param =new HashMap() ;
		List list = userService.getUserList(param) ;
		LinkedList linkList = new LinkedList(list) ;
		//linkList.remove(2) ;
		//ArrayList al = new ArrayList(linkList) ;
		model.addObject("aaa", list) ;
		/*for(int i=list.size()-1;i>=0;i--){
			list.remove(i) ;
		}*/
	
		List listCopy = new ArrayList() ;
		BeanUtils.copyProperties(listCopy, list);	
		//model.setViewName("userList");
		param.clear();
		param.put("total", "10") ;
		param.put("rows", list) ;
		param.put("linkList", linkList) ;
		param.put("singleLink", linkList.get(2)) ;
		//param.put("rowsOthers", linkList) ;
		return param ;
	}
	
	@RequestMapping("/getUserById")
	@ResponseBody
	public User getUserById(ModelAndView model){
		Map param =new HashMap() ;
		User user = userService.getUserById("402895075d788dae015d788dd82a0000") ;
		//model.setViewName("userList");
		return user ;
	}
	
	@RequestMapping("/getUserRoleResources")
	@ResponseBody
	public JSONArray getUserRoleResources(HttpServletRequest request){
		/*String jsonArray =
		"[{\"id\":1,\"text\":\"Folder1\",\"iconCls\":\"icon-save\",\"children\":[{"+
			"\"text\":\"File1\",\"checked\":true,\"url\":\"/page/test.html\"},{\"text\":\"Books\","+
			"\"state\":\"open\",\"attributes\":{\"url\":\"/page/test.html\","+
			"\"price\":100},\"children\":[{\"text\":\"PhotoShop\",\"checked\":true"+
			"}]}]},{\"text\":\"Languages\",\"state\":\"closed\",\"children\":[{"+
			"\"text\":\"Java\"},{\"text\":\"C#\",\"url\":\"/ways/page/userRoleResource/userRoleResourceList.html\"}]}]" ;
		Map map = new HashMap() ;
		//JsonObject jsonObject = new JsonObject() ;
		JSONObject jsonObject = new JSONObject() ;
		JSONArray tree = JSONArray.fromObject(jsonArray) ;
		return tree ;*/
		Map userMap = (Map) request.getSession().getAttribute("user") ;
		
		System.out.println(userMap.get("username").toString());
		Map map = new HashMap() ;
		map.put("user_id", "user1") ;
		userService.getUserRoleResources(map) ;
		
		return null ;
	}
	
	@RequestMapping("getMenuList")
	@ResponseBody
	public List getMenuList(){
		try {
			FileInputStream fis = new FileInputStream( new File("e:"+File.separator+"menus.json")) ;
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8") ;
			BufferedReader br = new BufferedReader(isr) ;
			StringBuilder baseStr = new StringBuilder() ;
			String lineStr = "" ;
			while((lineStr=br.readLine())!=null){
				//System.out.println(lineStr);
				baseStr.append(lineStr) ;
			}
			
			br.close();
			isr.close();
			fis.close();
			
			//JSONObject json = JSONObject.parseObject(baseStr.toString()) ;
			JSONObject json = JSONObject.fromObject(baseStr.toString()) ;//parseObject(baseStr.toString()) ;
			List<JSONObject> list = (List<JSONObject>) json.get("data") ;
			List tarList = new ArrayList() ;
			MenuUtil mfu = new MenuUtil() ;
			mfu.getMenusList(list,tarList,"menu0") ;
			
			System.out.println(tarList);
			
			userService.insertMenus(tarList) ;
			return tarList ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null ;
	}
	
	
	//getMemoList
	
	@RequestMapping("getMemoList")
	@ResponseBody
	public List getMemoList(){
		try {
			FileInputStream fis = new FileInputStream( new File("e:"+File.separator+"memo.txt")) ;
			InputStreamReader isr = new InputStreamReader(fis,"UTF-8") ;
			BufferedReader br = new BufferedReader(isr) ;
			StringBuilder baseStr = new StringBuilder() ;
			String lineStr = "" ;
			while((lineStr=br.readLine())!=null){
				//System.out.println(lineStr);
				baseStr.append(lineStr) ;
			}
			
			br.close();
			isr.close();
			fis.close();
			
			//JSONObject json = JSONObject.parseObject(baseStr.toString()) ;
			JSONObject json = JSONObject.fromObject(baseStr.toString()) ;//parseObject(baseStr.toString()) ;
			List<JSONObject> list = (List<JSONObject>) json.get("data") ;
			List tarList = new ArrayList() ;
			MenuUtil mfu = new MenuUtil() ;
			mfu.getMemoList(list,tarList) ;
			
			System.out.println(tarList);
			
			userService.insertMenus(tarList) ;
			return tarList ;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null ;
	}
}
