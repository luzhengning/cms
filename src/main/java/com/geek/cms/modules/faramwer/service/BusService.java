package com.geek.cms.modules.faramwer.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.plugin.grid.splitGridReq.SplitGridRequestUtil;
import com.geek.cms.utils.SqlUtil;
import com.geek.cms.utils.db.DbUtil;

/**
 * 数据访问类，提供了数据库操作和数据接口， 该类被业务模块中的Service类继承
 * @author luzhengning
 * 2017年11月1日 下午2:07:25
 */
public abstract class BusService<T> extends DbUtil<T> implements BusServiceDao<T> {
	public BusService(Class clz) {
		super(clz);
	}
	//以下变量在业务模块的Dao中赋值，注意返回值类型必须和以下一致
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
		return super.delete(deleteSql+SqlUtil.namesArrayToQuerySql(paramNames,andOr), params);
	}
	@Override
	public List<T> findList(GridRequestModel model) {
		String sql=querySql+" where 1=1 ";
		sql=(sql+model.getParamsNameSql());
		return super.find(sql,model.getParams());
	}

	@Override
	public List<T> findList(String[] paramNames, Object[] params,String andOr) {
		String sql=querySql+SqlUtil.namesArrayToQuerySql(paramNames,andOr);
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
		return super.getNum(countSql+SqlUtil.namesArrayToQuerySql(paramNames,andOr),params);
	}
	
	

}
