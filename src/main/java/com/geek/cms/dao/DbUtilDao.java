package com.geek.cms.dao;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;

/**
 * 数据库工具类接口
 * @author 路正宁
 *
 * @param <T>
 */
/**
 * @author Administrator
 *
 * @param <T>
 */
public interface DbUtilDao<T> {
	
	/**
	 * 插入
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean add(String sql,Object params[]);
	/**
	 * 删除
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean delete(String sql,Object params[]) throws SQLException;
	/**
	 * 更新
	 * @param sql
	 * @param params
	 * @return
	 */
	public boolean update(String sql,Object params[]);
	/**
	 * 加载一个实体
	 * @param sql
	 * @param params
	 * @return
	 */
	public T load(String sql,Object params[]);
	 /**
	  * 查找
	 * @param sql
	 * @param params
	 * @return
	 */
	public List<T> find(String sql,Object params[]);
	/**
	 * 分页查找
	 * @param model
	 * @return
	 */
	public List<T> findList(GridRequestModel model);
	
	/**
	 * 记录数
	 * @param sql
	 * @param params
	 * @return
	 */
	public int getNum(String sql,Object[] params);
	/**
	 * 执行事务
	 * @param sql
	 * @return
	 */
	public Object executeTransaction(final String sql);
}
