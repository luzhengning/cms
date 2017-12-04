package com.geek.cms.modules.sys.service;

import java.util.List;

import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.entity.Role;

public class RoleService extends RoleDao {

	
	
	public RoleService() {
		super(Role.class);
	}

	public boolean add(Role t) {
		Object[] params=new Object[] {
				t.getRole_name(),
				t.getRole_mark(),
				t.getPermission_id(),
				t.getCreate_time(),
				t.getUpdate_time(),
				t.getLast_user(),
				t.getIs_enable()
		};
		return super.add(insertSql, params);
	}
	public boolean update(Role t) {
		Object[] params=new Object[] {
				t.getRole_name(),
				t.getRole_mark(),
				t.getPermission_id(),
				t.getCreate_time(),
				t.getUpdate_time(),
				t.getLast_user(),
				t.getIs_enable(),
				t.getId()
		};
		return super.update(updateSql, params);
	}
	/**
	 * 查询多个角色
	 */
	@Override
	public List<Role> findByIds(String[] ids) {
		if(ids==null) return null;
		String[] idNames=new String[ids.length];
		for(int i=0;i<ids.length;i++) {
			idNames[i]="id";
		}
		return super.findList(idNames, ids, "OR");
	}


	





}
