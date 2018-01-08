package com.geek.cms.common.dbbase;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.utils.db.DbUtil;

public abstract interface CrudDao<T> {
	public abstract boolean add(T t);
	public abstract boolean delete(String id) throws SQLException;
	public abstract boolean update(T t);
	public abstract T load(String id);
}
