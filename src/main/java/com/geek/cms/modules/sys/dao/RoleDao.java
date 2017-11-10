package com.geek.cms.modules.sys.dao;

import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProductDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:12
 */
public abstract class RoleDao extends ServiceProduct<Role> {
	//角色查询语句
	

	public RoleDao(Class clz) {
		super(clz);
		super.querySql="SELECT * FROM sys_role ";
		super.deleteSql="DELETE FROM sys_role";
		super.updateSql="UPDATE sys_role SET role_name=?,role_mark=?,permission_id=?,create_time=?,update_time=?,last_user=?,is_enable=? WHERE id=? ";
		super.insertSql="INSERT INTO sys_role(role_name,role_mark,permission_id,create_time,update_time,last_user,is_enable) VALUE(?,?,?,?,?,?,?) ";
		super.countSql="SELECT COUNT(*) FROM sys_role";
	}

}
