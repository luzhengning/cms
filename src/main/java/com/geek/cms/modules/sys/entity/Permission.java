package com.geek.cms.modules.sys.entity;

/**
 * 权限
 * @author Administrator
 *
 */
public class Permission {
	private String id;
	private String permission_name;
	private String permission_code;
	private String permission_mark;
	private String create_time;
	private String update_time;
	private String last_user;
	private String is_enable;
	
	public Permission(){}
	public Permission(String id){this.id=id;}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getPermission_name() {
		return permission_name;
	}
	public void setPermission_name(String permission_name) {
		this.permission_name = permission_name;
	}
	public String getPermission_code() {
		return permission_code;
	}
	public void setPermission_code(String permission_code) {
		this.permission_code = permission_code;
	}
	public String getPermission_mark() {
		return permission_mark;
	}
	public void setPermission_mark(String permission_mark) {
		this.permission_mark = permission_mark;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(String update_time) {
		this.update_time = update_time;
	}
	
	public String getLast_user() {
		return last_user;
	}
	public void setLast_user(String last_user) {
		this.last_user = last_user;
	}
	public String getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(String is_enable) {
		this.is_enable = is_enable;
	}
	
	
}
