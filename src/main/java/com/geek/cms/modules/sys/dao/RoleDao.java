package com.geek.cms.modules.sys.dao;

import java.util.ArrayList;
import java.util.List;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.example.RoleExample;
import com.geek.cms.plugin.grid.gridReq.GridColumn;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:12
 */
public abstract class RoleDao implements BusServiceDao<Role,RoleExample> {
	public List<GridColumn> assemblySql=new ArrayList<GridColumn>();
	public RoleDao() {
		//assemblySql.tableName="sys_role";
		assemblySql.add(new GridColumn("ID", "id","id"));
		assemblySql.add(new GridColumn("角色名称", "role_name","roleName"));
		assemblySql.add(new GridColumn("备注", "role_mark","roleMark"));
		assemblySql.add(new GridColumn("权限id", "permission_id","permissionId"));
		assemblySql.add(new GridColumn("创建时间", "create_time","createTime"));
		assemblySql.add(new GridColumn("修改时间", "update_time","updateTime"));
		assemblySql.add(new GridColumn("修改人", "last_user","lastUser"));
		assemblySql.add(new GridColumn("是否禁用", "is_enable","isEnable"));
	}
	/*@Override
	public Object[] entityToObjects(Role t) {
		Object[] params=new Object[] {
				t.getRoleName(),
				t.getRoleMark(),
				t.getPermissionId(),
				t.getCreateTime(),
				t.getUpdateTime(),
				t.getLastUser(),
				t.getIsEnable()
		};
		return params;
	}*/
	public abstract List<Role> findByIds(String[] ids);
	
	/*super.querySql="SELECT * FROM sys_role ";
	super.deleteSql="DELETE FROM sys_role";
	super.updateSql="UPDATE sys_role SET role_name=?,role_mark=?,permission_id=?,create_time=?,update_time=?,last_user=?,is_enable=? WHERE id=? ";
	super.insertSql="INSERT INTO sys_role(role_name,role_mark,permission_id,create_time,update_time,last_user,is_enable) VALUE(?,?,?,?,?,?,?) ";
	super.countSql="SELECT COUNT(*) FROM sys_role";*/
}
