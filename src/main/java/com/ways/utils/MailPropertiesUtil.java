package com.ways.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class MailPropertiesUtil {
	public static Properties getMailPropertis(String path){
		URL url = MailPropertiesUtil.class.getResource(path) ;
		
		InputStream is=MailPropertiesUtil.class.getClassLoader().getResourceAsStream(path);  
		String filePath=MailPropertiesUtil.class.getClassLoader().getResource(path).getFile();  
	        System.out.println(filePath);  
        //获取的是TestJava类所在的相对路径下 ,com/test/servlet/jdbc_connection.properties"  
        BufferedReader br= new BufferedReader(new InputStreamReader(is));  
        Properties props = new Properties();  
        try {  
            props.load(br);  
            for (Object s : props.keySet())   
                System.out.println(s);  
        } catch (IOException e) {
        	e.printStackTrace();
        }  
		return null ;
	}
}
