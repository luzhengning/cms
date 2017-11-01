package com.geek.cms.modules.sys.service;

import com.geek.cms.modules.cms.service.CmsService;
import com.geek.cms.modules.faramwer.factoryMethod.ServiceFactory;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProductDao;
import com.geek.cms.modules.sys.dao.PermissionProduct;
import com.geek.cms.modules.sys.dao.RoleProduct;
import com.geek.cms.modules.sys.dao.SysMenuProduct;
import com.geek.cms.modules.sys.dao.UserProduct;

public class SysFactory extends ServiceFactory  {
	public final static String user="user";
	public final static String role="role";
	public final static String menu="menu";
	public final static String permission="permission";
	
	public ServiceProductDao create(String type) {
		try {
			switch(type) {
			case user:
				return new UserService();
			case role:
				return new RoleService();
			case menu:
				return new SysMenuService();
			case permission:
				return new PermissionService();
			}
			throw new Exception("工厂未生产:"+type);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return null;
		}
	}
	public PermissionProduct getPermissionService() {
		return new PermissionService();
	}
	public RoleProduct getRoleService() {
		return new RoleService();
	}
	public SysMenuProduct getSysMenuService() {
		return new SysMenuService();
	}
	public UserProduct getUserService() {
		return new UserService();
	}
}
