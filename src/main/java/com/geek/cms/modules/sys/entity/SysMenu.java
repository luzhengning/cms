package com.geek.cms.modules.sys.entity;

import java.util.List;

/**
 * 系统左侧菜单
 * @author Administrator
 *
 */
public class SysMenu {
	private String id;
	private String name;
	private String parent_id;
	private String url;
	private String sort_num;
	private String create_time;
	private String update_time;
	private String role_id;
	private String index_select;
	private String create_by;
	private String is_enable;
	
	
	public String getIndex_select() {
		return index_select;
	}
	public void setIndex_select(String index_select) {
		this.index_select = index_select;
	}
	private List<SysMenu> childMenu;
	
	
	public List<SysMenu> getChildMenu() {
		return childMenu;
	}
	public void setChildMenu(List<SysMenu> childMenu) {
		this.childMenu = childMenu;
	}
	public String getRole_id() {
		return role_id;
	}
	public void setRole_id(String role_id) {
		this.role_id = role_id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getParent_id() {
		return parent_id;
	}
	public void setParent_id(String parent_id) {
		this.parent_id = parent_id;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSort_num() {
		return sort_num;
	}
	public void setSort_num(String sort_num) {
		this.sort_num = sort_num;
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
