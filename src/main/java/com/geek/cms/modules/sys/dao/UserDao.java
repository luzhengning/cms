

package com.geek.cms.modules.sys.dao;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:21
 */
public abstract class UserDao extends BusService<User>{

	public UserDao(Class clz) {
		super(clz);
		super.tableName="sys_user";
		super.columnNames.add("role_id");
		super.columnNames.add("nickname");
		super.columnNames.add("NAME");
		super.columnNames.add("account");
		super.columnNames.add("password");
		super.columnNames.add("sex");
		super.columnNames.add("age");
		super.columnNames.add("birthday");
		super.columnNames.add("phone");
		super.columnNames.add("email");
		super.columnNames.add("address");
		super.columnNames.add("security_level");
		super.columnNames.add("account_level");
		super.columnNames.add("sort");
		super.columnNames.add("registration_time");
		super.columnNames.add("mark");
		super.columnNames.add("user_type");
		super.columnNames.add("is_enable");
		//生成sql
		setSql();
	}
	@Override
	public Object[] entityToObjects(User user) {
		Object[] params=new Object[]{
				user.getRole_id(),
				user.getNickname(),
				user.getName(),
				user.getAccount(),
				user.getPassword(),
				user.getSex(),
				user.getAge(),
				user.getBirthday(),
				user.getPhone(),
				user.getEmail(),
				user.getAddress(),
				user.getSecurity_level(),
				user.getAccount_level(),
				user.getSort(),
				user.getRegistration_time(),
				user.getMark(),
				user.getUser_type(),
				user.getIs_enable()
		};
		return params;
	}
	public abstract User login(User user);
	/*super.querySql="SELECT * FROM sys_user ";
	super.deleteSql="DELETE FROM sys_user ";
	super.updateSql="UPDATE sys_user SET role_id=?,nickname=?,NAME=?,account=?,sex=?,age=?,birthday=?,phone=?,email=?,address=?,security_level=?,account_level=?,sort=?,registration_time=?,mark=?,user_type=?,is_enable=? WHERE id=? ";
	super.insertSql="INSERT  INTO `sys_user`(`role_id`,`nickname`,`name`,`account`,`password`,`sex`,`age`,`birthday`,`phone`,`email`,`address`,`security_level`,`account_level`,`sort`,`registration_time`,`mark`,`user_type`,`is_enable`) " 
	          +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	super.countSql="SELECT COUNT(*) FROM sys_user ";*/
}
