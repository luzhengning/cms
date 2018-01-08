package com.geek.cms.modules.core.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;

import com.geek.cms.core.database.AssemblySql;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.plugin.grid.splitGridReq.SplitGridRequestUtil;
import com.geek.cms.utils.SqlUtil;
import com.geek.cms.utils.db.DbUtil;

/**
 * 数据访问类，提供了基本数据操作接口， 该类被业务模块中的Service类或Dao类继承
 * @author luzhengning
 * 2017年11月1日 下午2:07:25
 */
public abstract class BusService<T> extends DbUtil<T> implements BusServiceDao<T> {
	public BusService(Class clz) {
		super(clz);
	}
	//以下变量在业务模块的Dao中赋值，注意SQL返回值类型必须和以下一致
	//表名
	public String tableName="";
    //列名
	public List<String> columnNames=new ArrayList<String>();
	//返回业务实体
	public String querySql="";
	//返回Boolean类型
	public String deleteSql="";
	//返回Boolean类型
	public String updateSql="";
	//返回Boolean类型
	public String insertSql="";
	//返回Int类型
	public String countSql="";
	
	public T load(String id) {
		return super.load(querySql+" where id=?", new Object[] {id});
	}
	public boolean add(T t) {
		Object[] params=entityToObjects(t);
		return super.add(insertSql, params);
	}
	public boolean update(T t,String id) {
		Object[] params=entityToObjects(t);
		params=ArrayUtils.add(params, id);
		return super.update(updateSql, params);
	}
	public boolean delete(String id) throws SQLException {
		return super.delete(deleteSql+" where id=?", new Object[] {id});
	}
	public boolean delete(String[] paramNames,Object[] params,String andOr) throws SQLException {
		return super.delete(deleteSql+SqlUtil.namesArrayToQuerySql(paramNames,andOr), params);
	}
	public List<T> findList(GridRequestModel model) {
		String sql=querySql+" where 1=1 ";
		sql=(sql+model.getParamsNameSql());
		return super.find(sql,model.getParams());
	}
	public List<T> findList(String[] paramNames, Object[] params,String andOr) {
		String sql=querySql+SqlUtil.namesArrayToQuerySql(paramNames,andOr);
		return super.find(sql, params);
	}
	public int maximum(GridRequestModel model) {
		String sql=countSql+" where 1=1 ";
		if(model!=null){
			if(model.getParamsName()!=null){
					sql=sql+SplitGridRequestUtil.MapToQuerySql(model);
			}
		}
		return super.getNum(sql, model.getParams());
	}
	public int maximum(String[] paramNames, Object[] params,String andOr) {
		return super.getNum(countSql+SqlUtil.namesArrayToQuerySql(paramNames,andOr),params);
	}
	/**
	 * 生成sql
	 */
	protected void setSql() {
		AssemblySql assemblySql=new AssemblySql();
		assemblySql.tableName=this.tableName;
		assemblySql.columnNames=this.columnNames;
		this.querySql=assemblySql.querySql();
		this.insertSql=assemblySql.insertSql();
		this.deleteSql=assemblySql.deleteSql();
		this.updateSql=assemblySql.updateSql();
		this.countSql=assemblySql.countSql();
	}
	/**
	 * 该方法由Dao类实现
	 * @param t
	 * @return
	 */
	public abstract Object[] entityToObjects(T t);
}
