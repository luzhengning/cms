package com.geek.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Properties;

import javax.servlet.http.HttpSessionListener;

public class test{

	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket s = new Socket("10.255.17.148",8080); //1.1协议保持连接
		//模拟浏览器，给tomcat服务器端发送符合http协议的请求消息
		PrintWriter out = new PrintWriter(s.getOutputStream(),true);
		out.println("/cms/admin/administrators HTTP/1.1");
		out.println("Accept:*/*");
		out.println("Host;10.255.17.148:8080");
		out.println("connection:close");
		out.println();
		out.println();
		
		//接收服务器信息
		InputStream in = s.getInputStream();
		byte[] buf = new byte[1024];
		int len = in.read(buf);
		//System.out.println(len);
		String str = new String (buf,0,len);
		System.out.println(str);
		
		s.close();
	}

}
