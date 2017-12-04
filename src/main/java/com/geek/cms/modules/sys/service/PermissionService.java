package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.modules.faramwer.service.BusService;
import com.geek.cms.modules.sys.dao.PermissionDao;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.plugin.grid.splitGridReq.SplitGridRequestUtil;

/**
 * 权限操作service
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:12
 */
public class PermissionService extends PermissionDao {

	public PermissionService() {
		super(Permission.class);
	}
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
	/**
	 * 查询多个权限
	 */
	@Override
	public List<Permission> findByIds(String[] ids) {
		if(ids==null) return null;
		String[] idNames=new String[ids.length];
		for(int i=0;i<ids.length;i++) {
			idNames[i]="id";
		}
		return super.findList(idNames, ids, "OR");
	}
}
