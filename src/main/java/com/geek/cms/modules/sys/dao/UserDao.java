package com.geek.cms.modules.sys.dao;

import java.util.List;

import com.geek.cms.common.dbbase.CrudDao;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;
import com.geek.cms.utils.db.DbUtil;

public abstract interface UserDao extends CrudDao<User>{
	public abstract User login(User user);
	public abstract int maximum(GridRequestModel model);
	public abstract List<User> findList(String sql, Object[] params);
	public abstract int maximum(String sql, Object[] params);
	public abstract List<User> findList(GridRequestModel model);
	public abstract List<User> findBySql(String sql, Object[] params);
}
