package com.geek.cms.utils.db;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.geek.cms.modules.sys.entity.User;

public class DBTemplate<T> {
	/*private JdbcTemplate template=new JdbcTemplate(DbSource.getDataSource());  
	private Class clz;
	public List<User> getUser() {  
        String sql = "select * FROM sys_user ";  
        return (List<User>) template.query(sql, new BeanPropertyRowMapper(User.class));  
    }  
	public DBTemplate(Class clz){
		this.clz=clz;
	}

	*//**
	 * 插入
	 *//*
	protected boolean add(String sql,Object params[]) {
		try {
			int result=template.update(sql, params);
			if(result>=1)return true;
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return false;
	}
	*//**
	 * 删除
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 *//*
	protected boolean delete(String sql,Object params[]) throws SQLException {
		try {
			int result=template.update(sql, params);
			if(result>=1)return true;
		}finally{
			DbSource.close();
		}
		return false;
	}

	protected boolean update(String sql,Object params[]) {
		try {
			int result=template.update(sql, new PreparedStatementSetter(clz.class));
			if(result>=1)return true;
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally{
			DbSource.close();
		}
		return false;
	}

	protected T load(String sql,Object params[]) {
		if(isLog)System.out.println(new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds() + "DbUtil.load():"+sql+" @:"+paramsToStr(params));
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
		if(isLog)System.out.println(new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds() + "DbUtil.find():"+sql+" @:"+paramsToStr(params));
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
		if(isLog)System.out.println(new Date().getHours()+":"+new Date().getMinutes()+":"+new Date().getSeconds() + "DbUtil.getNum():"+sql+" @:"+paramsToStr(params));
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


	*//**
	 * 开始执行
	 * @param callBack
	 * @return
	 *//*
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

	*//**
	 * 查询
	 *//*
	protected Object executeTransaction(final String sql) {

		Object obj = execute(new CallBack() {
			public Object toTemplate() {
				return null;
			}
		});
		return obj;
	}
	*//**
	 * 查询参数转字符串
	 * @param params
	 * @return
	 *//*
	private String paramsToStr(Object[] params) {
		if(params==null)return "";
		String value="";
		for(int i=0;i<params.length;i++) {
			value+=params[i].toString()+",";
		}
		return value.substring(0, value.length()-1);
	}*/
}
