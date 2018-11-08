package com.ways.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import net.sf.json.JSONObject;


public class MenuUtil {
	public static void getMenusList(List resList,List tarList,String parentId){
		for(int i=0;i<resList.size();i++){
			JSONObject obj = (JSONObject) resList.get(i) ;
			Map map = new HashMap() ;
			map.put("label", obj.get("label")!=null?obj.get("label").toString():"") ;
			map.put("premissionId", obj.get("premissionId")!=null?obj.get("premissionId").toString():"") ;
			map.put("module", obj.get("module")!=null?obj.get("module").toString():"") ;
			map.put("parentId", parentId) ;
			map.put("sortId", i+1) ;
			if(obj.get("params")!=null){
				map.put("params", obj.get("params").toString()) ;
			}
			map.put("uuid", UUID.randomUUID().toString().replaceAll("-", "")) ;
			tarList.add(map) ;
			if(obj.get("menus")!=null){
				getMenusList((List)obj.get("menus"),tarList,(String) map.get("uuid")) ;
			}
		}
	}
	
	public static void getMemoList(List resList,List tarList){
		for(int i=0;i<resList.size();i++){
			JSONObject obj = (JSONObject) resList.get(i) ;
			Map map = new HashMap() ;
			map.put("label", obj.get("name")!=null?obj.get("name").toString():"") ;
			map.put("uuid", obj.get("id")) ;
			tarList.add(map) ;
			if(obj.get("children")!=null){
				getMemoList((List)obj.get("children"),tarList) ;
			}
		}
	}
}
