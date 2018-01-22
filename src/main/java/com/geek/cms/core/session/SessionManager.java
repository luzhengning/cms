package com.geek.cms.core.session;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;


/**
 * session操作
 * @author luzhengning
 * 2017年12月11日 下午2:52:58
 */
public class SessionManager implements HttpSession {

	public long getCreationTime() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public String getId() {
		// TODO 自动生成的方法存根
		return null;
	}

	public long getLastAccessedTime() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public ServletContext getServletContext() {
		// TODO 自动生成的方法存根
		return null;
	}

	public void setMaxInactiveInterval(int interval) {
		// TODO 自动生成的方法存根
		
	}

	public int getMaxInactiveInterval() {
		// TODO 自动生成的方法存根
		return 0;
	}

	public HttpSessionContext getSessionContext() {
		// TODO 自动生成的方法存根
		return null;
	}

	public Object getAttribute(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	public Object getValue(String name) {
		// TODO 自动生成的方法存根
		return null;
	}

	public Enumeration<String> getAttributeNames() {
		// TODO 自动生成的方法存根
		return null;
	}

	public String[] getValueNames() {
		// TODO 自动生成的方法存根
		return null;
	}

	public void setAttribute(String name, Object value) {
		// TODO 自动生成的方法存根
		
	}

	public void putValue(String name, Object value) {
		// TODO 自动生成的方法存根
		
	}

	public void removeAttribute(String name) {
		// TODO 自动生成的方法存根
		
	}

	public void removeValue(String name) {
		// TODO 自动生成的方法存根
		
	}

	public void invalidate() {
		// TODO 自动生成的方法存根
		
	}

	public boolean isNew() {
		// TODO 自动生成的方法存根
		return false;
	}

	
}
