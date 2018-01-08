package com.geek.cms.modules.sys.service;

import java.util.List;

import com.geek.cms.modules.sys.dao.PermissionDao;
import com.geek.cms.modules.sys.entity.Permission;

/**
 * 权限操作service
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:12
 */
public class PermissionService extends PermissionDao {

	public PermissionService() {
		super(Permission.class);
	}
	/**
	 * 查询多个权限
	 */
	@Override
	public List<Permission> findByIds(String[] ids) {
		if(ids==null) return null;
		String[] idNames=new String[ids.length];
		for(int i=0;i<ids.length;i++) {
			idNames[i]="id";
		}
		return super.findList(idNames, ids, "OR");
	}
	
}
