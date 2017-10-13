package com.geek.cms.modules.sys.service;

import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.sys.dao.PermissionDao;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;

/**
 * 权限操作service
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:12
 */
public class PermissionService extends CrudService<Permission> implements PermissionDao {

	public PermissionService() {
		super(Permission.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Permission> findList(GridRequestModel model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Permission> findBySql(String sql, Object[] params) {
		// TODO Auto-generated method stub
		return null;
	}

}
