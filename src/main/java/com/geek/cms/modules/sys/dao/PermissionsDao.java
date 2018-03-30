package com.geek.cms.modules.sys.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.geek.cms.modules.core.mybatis.BaseMybatisDao;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.modules.sys.entity.example.PermissionsExample;
import com.geek.cms.plugin.grid.gridReq.GridColumn;
import com.geek.cms.plugin.grid.gridReq.GridRequest;

/**
 * 权限接口抽象类，该类被Service类继承
 * @author luzhengning
 * 2017年11月1日 下午3:09:27
 */
public abstract class PermissionsDao  implements BusServiceDao<Permissions,PermissionsExample> {
	public List<GridColumn> assemblySql=new ArrayList<GridColumn>();
	public PermissionsDao() {
		assemblySql.add(new GridColumn("ID","id","id"));
		assemblySql.add(new GridColumn("名称","permission_name","permissionName"));
		assemblySql.add(new GridColumn("编号","permission_code","permissionCode"));
		assemblySql.add(new GridColumn("备注","permission_mark","permissionMark"));
		assemblySql.add(new GridColumn("创建时间","create_time","createTime"));
		assemblySql.add(new GridColumn("修改时间","update_time","updateTime"));
		assemblySql.add(new GridColumn("最后修改人","last_user","lastUser"));
		assemblySql.add(new GridColumn("是否禁用","is_enable","isEnable"));
	}
	/*@Override
	public Object[] entityToObjects(Permissions t) {
		Object[] params=new Object[]{
				t.getPermissionName(),
				t.getPermissionCode(),
				t.getPermissionMark(),
				t.getCreateTime(),
				t.getUpdateTime(),
				t.getLastUser(),
				t.getIsEnable()
		};
		return params;
	}*/
	public abstract List<Permissions> findByIds(String[] ids);
	
	/*super.querySql="SELECT * FROM sys_permissions ";
	super.insertSql=
			"INSERT INTO `sys_permissions`(permission_name,permission_code,permission_mark,create_time,update_time,last_user,is_enable) " + 
			"VALUE(?,?,?,?,?,?,?)";
	super.deleteSql="DELETE FROM sys_permissions";
	super.updateSql="UPDATE sys_permissions SET permission_name=?,permission_code=?,permission_mark=?,create_time=?,update_time=?,last_user=?,is_enable=? WHERE id=?";
	super.countSql="SELECT COUNT(*) FROM sys_permissions ";*/
}
