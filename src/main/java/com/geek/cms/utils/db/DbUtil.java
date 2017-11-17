package com.geek.cms.utils.db;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.geek.cms.dao.DbUtilDao;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;


/**
 * 数据访问工具类
 * @author luzhengning
 *
 * @param <T>
 */
public abstract class DbUtil<T> {
	
	public static boolean isLog=true;
	
	private QueryRunner runner=new QueryRunner(DbSource.getDataSource());
	private Class clz;
	
	public DbUtil(Class clz){
		this.clz=clz;
	}

	/**
	 * 插入
	 */
	protected boolean add(String sql,Object params[]) {
		if(isLog)System.out.println("DbUtil.add():"+sql+" @:"+paramsToStr(params));
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

	protected boolean delete(String sql,Object params[]) throws SQLException {
		if(isLog)System.out.println("DbUtil.delete():"+sql+" @:"+paramsToStr(params));
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

	protected boolean update(String sql,Object params[]) {
		if(isLog)System.out.println("DbUtil.update():"+sql+" @:"+paramsToStr(params));
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

	protected T load(String sql,Object params[]) {
		if(isLog)System.out.println("DbUtil.load():"+sql+" @:"+paramsToStr(params));
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
	protected List<T> find(String sql,Object params[]){
		if(isLog)System.out.println("DbUtil.find():"+sql+" @:"+paramsToStr(params));
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
	protected int getNum(String sql,Object[] params){
		if(isLog)System.out.println("DbUtil.getNum():"+sql+" @:"+paramsToStr(params));
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


	/**
	 * 开始执行
	 * @param callBack
	 * @return
	 */
	protected Object execute(CallBack callBack) {
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
	protected Object executeTransaction(final String sql) {

		Object obj = execute(new CallBack() {
			public Object toTemplate() {
				return null;
			}
		});
		return obj;
	}
	/**
	 * 查询参数转字符串
	 * @param params
	 * @return
	 */
	private String paramsToStr(Object[] params) {
		if(params==null)return "";
		String value="";
		for(int i=0;i<params.length;i++) {
			value+=params[i].toString()+",";
		}
		return value.substring(0, value.length()-1);
	}
}
