package com.geek.cms.utils.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.geek.cms.dao.DbUtilDao;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;


/**
 * 数据访问工具类
 * @author luzhengning
 *
 * @param <T>
 */
public abstract class DbUtil<T> implements DbUtilDao<T> {
	
	private QueryRunner runner=new QueryRunner(DbSource.getDataSource());
	private Class clz;
	
	public DbUtil(Class clz){
		this.clz=clz;
	}

	/**
	 * 插入
	 */
	public boolean add(String sql,Object params[]) {
		try {
			int result=runner.update(sql, params);
			if(result>=1)return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return false;
	}

	public boolean delete(String sql,Object params[]) throws SQLException {
		try {
			if(runner.update(sql, params)>=1)return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			throw e;
		}finally{
			DbSource.close();
		}
		return false;
	}

	public boolean update(String sql,Object params[]) {
		try {
			if(runner.update(sql, params)>=1)return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return false;
	}

	public T load(String sql,Object params[]) {
		try {
			return (T)(runner.query(sql,new BeanHandler(clz),params));
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return null;
	}
	public List<T> find(String sql,Object params[]){
		try {
			return runner.query(sql, new BeanListHandler(clz), params);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return null;
	}
	public int getNum(String sql,Object[] params){
		try {
			int count = ((Long)runner.query(sql, params,new ScalarHandler(1))).intValue();
			return count;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return 0;
	}

	public abstract List<T> findList(GridRequestModel model);
	
	public abstract List<T> findBySql(String sql,Object[] params);

	/**
	 * 开始执行
	 * @param callBack
	 * @return
	 */
	private Object execute(CallBack callBack) {
		try {
			// 开启事务
			DbSource.startTransaction();
			Object obj = callBack.toTemplate();
			DbSource.commit();
			return obj;
		} catch (Exception ex) {
			DbSource.rollback();
			return null;
		}finally{
			DbSource.close();
		}
	}

	/**
	 * 查询
	 */
	public Object executeTransaction(final String sql) {

		Object obj = execute(new CallBack() {
			public Object toTemplate() {
				return null;
			}
		});
		return obj;
	}
}
