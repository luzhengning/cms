package com.geek.cms.modules.sys.entity;

import java.util.List;

/**
 * 角色
 * @author Administrator
 *
 */
public class Role {
	private String id;
	private String role_name;
	private String role_mark;
	private String permission_id;
	private String create_time;
	private String update_time;
	private String create_by;
	private String is_enable;
	
	public Role(String id){
		this.id=id;
	}
	public Role(){}
	
	/**
	 * 权限
	 */
	private List<Permission> permissions;
	
	public List<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
	
	public String getPermission_id() {
		if(permission_id!=null)
		return permission_id;
		else return "";
	}
	public void setPermission_id(String permission_id) {
		this.permission_id = permission_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
	public String getRole_mark() {
		return role_mark;
	}
	public void setRole_mark(String role_mark) {
		this.role_mark = role_mark;
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

	public String getCreate_by() {
		return create_by;
	}
	public void setCreate_by(String create_by) {
		this.create_by = create_by;
	}
	public String getIs_enable() {
		return is_enable;
	}
	public void setIs_enable(String is_enable) {
		this.is_enable = is_enable;
	}
	
}
