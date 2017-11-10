package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.SplitGridRequestUtil;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;

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

	





}
