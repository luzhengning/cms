package com.geek.cms.modules.sys.dao;

import java.util.List;

import com.geek.cms.modules.faramwer.service.BusService;
import com.geek.cms.modules.faramwer.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Permission;
import com.geek.cms.utils.db.DbUtil;

/**
 * 权限接口抽象类
 * @author luzhengning
 * 2017年11月1日 下午3:09:27
 */
public abstract class PermissionDao extends BusService<Permission> {

	public PermissionDao(Class clz) {
		super(clz);
		super.querySql="SELECT * FROM sys_permissions ";
		super.insertSql=
				"INSERT INTO `sys_permissions`(permission_name,permission_code,permission_mark,create_time,update_time,last_user,is_enable) " + 
				"VALUE(?,?,?,?,?,?,?)";
		super.deleteSql="DELETE FROM sys_permissions";
		super.updateSql="UPDATE sys_permissions SET permission_name=?,permission_code=?,permission_mark=?,create_time=?,update_time=?,last_user=?,is_enable=? WHERE id=?";
		super.countSql="SELECT COUNT(*) FROM sys_permissions ";
	}
	public abstract List<Permission> findByIds(String[] ids);
}
