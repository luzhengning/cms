package com.geek.cms.modules.faramwer.factoryMethod.product.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.SplitGridRequestUtil;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.utils.SqlUtil;
import com.geek.cms.utils.db.DbUtil;

/**
 * 数据访问类，提供了数据库操作和数据接口， 该类被业务模块中的Service类继承
 * @author luzhengning
 * 2017年11月1日 下午2:07:25
 */
public abstract class ServiceProduct<T> extends DbUtil<T> implements ServiceProductDao<T> {
	public ServiceProduct(Class clz) {
		super(clz);
	}
	public String querySql="";
	public String deleteSql="";
	public String updateSql="";
	public String insertSql="";
	public String countSql="";
	
	@Override
	public T load(String id) {
		return super.load(querySql+" where id=?", new Object[] {id});
	}
	@Override
	public boolean delete(String id) throws SQLException {
		return super.delete(deleteSql+" where id=?", new Object[] {id});
	}
	@Override
	public boolean delete(String[] paramNames,Object[] params,String andOr) throws SQLException {
		return super.delete(deleteSql+SqlUtil.namesArrayToSql(paramNames,andOr), params);
	}
	@Override
	public List<T> findList(GridRequestModel model) {
		String sql=querySql+" where 1=1 ";
		sql=(sql+model.getParamsNameSql());
		return super.find(sql,model.getParams());
	}

	@Override
	public List<T> findList(String[] paramNames, Object[] params,String andOr) {
		String sql=querySql+SqlUtil.namesArrayToSql(paramNames,andOr);
		return super.find(sql, params);
	}
	@Override
	public int maximum(GridRequestModel model) {
		String sql=countSql+" WHERE 1=1 ";
		if(model!=null){
			if(model.getParamsName()!=null){
					sql=sql+SplitGridRequestUtil.MapToQuerySql(model);
			}
		}
		return super.getNum(sql, model.getParams());
	}

	@Override
	public int maximum(String[] paramNames, Object[] params,String andOr) {
		return super.getNum(countSql+SqlUtil.namesArrayToSql(paramNames,andOr),params);
	}
	
	

}
