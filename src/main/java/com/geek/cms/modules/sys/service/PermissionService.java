package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.sys.dao.PermissionDao;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.SplitGridRequestUtil;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;

/**
 * 权限操作service
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:12
 */
public class PermissionService extends PermissionDao {

	public PermissionService() {
		super(Permission.class);
	}
	@Override
	public boolean add(Permission t) {
		Object[] params=new Object[]{
				t.getPermission_name(),
				t.getPermission_code(),
				t.getPermission_mark(),
				t.getCreate_time(),
				t.getUpdate_time(),
				t.getLast_user(),
				t.getIs_enable()
		};
		return super.add(insertSql, params);
	}
	@Override
	public boolean update(Permission t) {
		Object[] params=new Object[]{
				t.getPermission_name(),
				t.getPermission_code(),
				t.getPermission_mark(),
				t.getCreate_time(),
				t.getUpdate_time(),
				t.getLast_user(),
				t.getIs_enable(),
				t.getId()
		};
		return super.update(updateSql, params);
	}
	@Override
	public List<Permission> findByIds(String[] ids) {
		String sql=querySql;
		if(ids!=null) {
			if(ids.length>0) {
				sql+=" where 1=1 ";
				for(int i=0;i<ids.length;i++) {
					sql=sql+" OR id=?";
				}
			}
		}
		return super.find(sql, ids);
	}



}
