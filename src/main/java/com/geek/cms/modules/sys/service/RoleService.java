package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.faramwer.service.BusService;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.plugin.grid.splitGridReq.SplitGridRequestUtil;

public class RoleService extends RoleDao {

	
	
	public RoleService() {
		super(Role.class);
	}

	@Override
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
	@Override
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
