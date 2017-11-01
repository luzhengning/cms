package com.geek.cms.modules.cms.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.modules.cms.dao.CmsProductDao;
import com.geek.cms.modules.cms.entity.CmsContent;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;
import com.geek.cms.utils.db.DbUtil;

public class CmsService extends ServiceProduct<CmsContent>{
	public CmsService() {
		super(CmsContent.class);
	}

	@Override
	public boolean add(CmsContent t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean delete(String id) throws SQLException {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public boolean update(CmsContent t) {
		// TODO 自动生成的方法存根
		return false;
	}

	@Override
	public CmsContent load(String id) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<CmsContent> findList(GridRequestModel model) {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public List<CmsContent> findList(String sql, Object[] params) {
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
