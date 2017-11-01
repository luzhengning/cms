package com.geek.cms.modules.faramwer.factoryMethod.product.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;

public interface ServiceProductDao<T>  {
	public boolean add(T t);
	public boolean delete(String id) throws SQLException;
	public boolean delete(String sql,Object[] params) throws SQLException;
	public boolean update(T t);
	public T load(String id);
	public List<T> findList(GridRequestModel model);
	public List<T> findList(String sql,Object[] params);
	public int maximum(GridRequestModel model);
	public int maximum(String sql,Object[] params);
	
	
}
