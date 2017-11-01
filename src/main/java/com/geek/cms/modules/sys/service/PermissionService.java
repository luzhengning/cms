package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.sys.dao.PermissionProduct;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;

/**
 * 权限操作service
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:12
 */
public class PermissionService extends PermissionProduct<Permission> {

	public PermissionService() {
		super(Permission.class);
	}

	@Override
	public boolean add(Permission t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(String id) throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(Permission t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public Permission load(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Permission> findList(GridRequestModel model) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<Permission> findList(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public int maximum(GridRequestModel model) {
		// TODO 自动生成的方法存根
		return 0;
	}

	@Override
	public int maximum(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return 0;
	}



}
