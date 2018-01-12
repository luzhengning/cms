package com.geek.cms.modules.core.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.modules.core.mybatis.BaseMybatisDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.plugin.grid.splitGridReq.GridRequest;
/**
 * 基本业务接口
 * @author luzhengning
 * 2018年1月11日 下午1:40:48
 */
public interface BusServiceDao<T,E>  {
	public boolean add(T t);
	public boolean delete(String id) throws SQLException;
	public boolean delete(E e) throws SQLException;
	public boolean update(T t);
	public T load(String id);
	public List<T> findList(GridRequest model);
	public List<T> findList(E e);
	public int maximum(GridRequest model);
	public int maximum(E e);
}
