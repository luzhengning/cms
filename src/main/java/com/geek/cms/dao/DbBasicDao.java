package com.geek.cms.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;
/**
 * 数据访问接口
 * @author 路正宁
 *
 * @param <T>
 */
public interface DbBasicDao<T> {
	public boolean add(T t);
	public boolean delete(String id) throws SQLException;
	public boolean update(T t);
	public T load(String id);
	public List<T> findList(GridRequestModel model);
	public int maximum(GridRequestModel model);
	public List<T> findList(String sql,Object[] params);
	public int maximum(String sql,Object[] params);
	public boolean delete(String sql,Object[] params) throws SQLException;
}
