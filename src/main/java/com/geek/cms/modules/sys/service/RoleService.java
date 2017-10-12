package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;

public class RoleService  extends CrudService<Role> implements RoleDao {

	public RoleService() {
		super(Role.class);
	}

	public boolean add(Role t) {
		String sql="";
		return false;
	}

	public boolean delete(String id) throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean update(Role t) {
		// TODO 自动生成的方法存根
		return false;
	}

	public Role load(String id) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public List<Role> findList(GridRequestModel model) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Role> findBySql(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return null;
	}
}
