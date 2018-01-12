package com.geek.cms.modules.sys.dao;

import java.util.List;

import com.geek.cms.core.database.AssemblySql;
import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.utils.db.DbUtil;

/**
 * 权限接口抽象类，该类被Service类继承
 * @author luzhengning
 * 2017年11月1日 下午3:09:27
 */
public abstract class PermissionDao extends BusService<Permission> {

	
	public PermissionDao(Class clz) {
		super(clz);
		super.tableName="sys_permissions";
		super.columnNames.add("permission_name");
		super.columnNames.add("permission_code");
		super.columnNames.add("permission_mark");
		super.columnNames.add("create_time");
		super.columnNames.add("update_time");
		super.columnNames.add("last_user");
		super.columnNames.add("is_enable");
		//生成sql
		setSql();
	}
	@Override
	public Object[] entityToObjects(Permission t) {
		Object[] params=new Object[]{
				t.getPermission_name(),
				t.getPermission_code(),
				t.getPermission_mark(),
				t.getCreate_time(),
				t.getUpdate_time(),
				t.getLast_user(),
				t.getIs_enable()
		};
		return params;
	}
	public abstract List<Permission> findByIds(String[] ids);
	
	/*super.querySql="SELECT * FROM sys_permissions ";
	super.insertSql=
			"INSERT INTO `sys_permissions`(permission_name,permission_code,permission_mark,create_time,update_time,last_user,is_enable) " + 
			"VALUE(?,?,?,?,?,?,?)";
	super.deleteSql="DELETE FROM sys_permissions";
	super.updateSql="UPDATE sys_permissions SET permission_name=?,permission_code=?,permission_mark=?,create_time=?,update_time=?,last_user=?,is_enable=? WHERE id=?";
	super.countSql="SELECT COUNT(*) FROM sys_permissions ";*/
}
