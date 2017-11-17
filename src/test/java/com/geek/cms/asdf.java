package com.geek.cms;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class asdf {
	public void print() {
	    Properties properties = new Properties();  
	    InputStream inputStream = null;  
	    try {  
	        //加载配置文件  
	        inputStream = getClass().getResourceAsStream("/com/geek/cms/config/conf.properties");  
	        properties.load(inputStream);  
	         //解析配置文件，其中production_url为配置文件中一个参数的key  
	         String url = (String) properties.get("production_url");  
	         System.out.println(url);
	    } catch (IOException e) {  
	        // TODO Auto-generated catch block  
	        e.printStackTrace();  
	    }  
	}
}
