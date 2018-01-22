package com.geek.cms.modules.sys.dao;

import java.util.List;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.example.RoleExample;
import com.geek.cms.plugin.grid.splitGridReq.GridColumn;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:12
 */
public abstract class RoleDao implements BusServiceDao<Role,RoleExample> {
	//角色查询语句
	

	/*public RoleDao(Class clz) {
		super(clz);
		super.assemblySql.tableName="sys_role";
		super.assemblySql.columnNames.add(new GridColumn("角色名称", "role_name"));
		super.assemblySql.columnNames.add(new GridColumn("备注", "role_mark"));
		super.assemblySql.columnNames.add(new GridColumn("角色id", "permission_id"));
		super.assemblySql.columnNames.add(new GridColumn("创建时间", "create_time"));
		super.assemblySql.columnNames.add(new GridColumn("修改时间", "update_time"));
		super.assemblySql.columnNames.add(new GridColumn("修改人", "last_user"));
		super.assemblySql.columnNames.add(new GridColumn("是否禁用", "is_enable"));
		//生成sql
		setSql();
	}
	@Override
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
