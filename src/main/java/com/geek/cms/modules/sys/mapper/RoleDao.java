package com.geek.cms.modules.sys.dao;

import java.util.List;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:12
 */
public abstract class RoleDao extends BusService<Role> {
	//角色查询语句
	

	public RoleDao(Class clz) {
		super(clz);
		super.tableName="sys_role";
		super.columnNames.add("role_name");
		super.columnNames.add("role_mark");
		super.columnNames.add("permission_id");
		super.columnNames.add("create_time");
		super.columnNames.add("update_time");
		super.columnNames.add("last_user");
		super.columnNames.add("is_enable");
		//生成sql
		setSql();
	}
	@Override
	public Object[] entityToObjects(Role t) {
		Object[] params=new Object[] {
				t.getRole_name(),
				t.getRole_mark(),
				t.getPermission_id(),
				t.getCreate_time(),
				t.getUpdate_time(),
				t.getLast_user(),
				t.getIs_enable()
		};
		return params;
	}
	public abstract List<Role> findByIds(String[] ids);
	
	/*super.querySql="SELECT * FROM sys_role ";
	super.deleteSql="DELETE FROM sys_role";
	super.updateSql="UPDATE sys_role SET role_name=?,role_mark=?,permission_id=?,create_time=?,update_time=?,last_user=?,is_enable=? WHERE id=? ";
	super.insertSql="INSERT INTO sys_role(role_name,role_mark,permission_id,create_time,update_time,last_user,is_enable) VALUE(?,?,?,?,?,?,?) ";
	super.countSql="SELECT COUNT(*) FROM sys_role";*/
}
