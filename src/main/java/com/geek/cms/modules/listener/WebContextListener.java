package com.geek.cms.modules.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;  
import javax.servlet.ServletContextListener;
/**
 * 在web项目启动时执行,需要实现ServletContextListener接口。
 * 其中contextInitialized方法是项目在启动初始化的时候就会执行的方法，contextDestroyed是在消亡的时候执行的方法，
 * 加载解析自定义的配置文件、初始化数据库信息等等，这里我们需要把随项目启动时执行的代码放在contextInitialized方法中。
 * 需要在web.xml中为这个监听器添加配置
 *	<listener>  
 *	  <listener-class>com.geek.cms.modules.listener.WebContextListener</listener-class>  
 *	</listener> 
 * @author luzhengning
 * 2017年10月24日 下午3:20:29
 */
public class WebContextListener implements ServletContextListener {
	public void contextInitialized(ServletContextEvent servletContextEvent) { 
		ServletContext servletContext=servletContextEvent.getServletContext();
		System.out.println("项目名称："+servletContext.getContextPath());
		System.out.println("项目路径:"+servletContext.getRealPath("/"));
		System.out.println("Tomcat路径："+System.getProperty("catalina.base"));
		System.out.println("项目启动：上下文监听：com.geek.cms.modules.listener.WebContextListener");
		
		//备注：1.计数项目启动次数
    }
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("listener监听：contextDestroyed");
	}

}
