

package com.geek.cms.modules.sys.dao;

import com.geek.cms.modules.faramwer.service.BusService;
import com.geek.cms.modules.faramwer.service.BusServiceDao;
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
		super.querySql="SELECT * FROM sys_user ";
		super.deleteSql="DELETE FROM sys_user ";
		super.updateSql="UPDATE sys_user SET role_id=?,nickname=?,NAME=?,account=?,sex=?,age=?,birthday=?,phone=?,email=?,address=?,security_level=?,account_level=?,sort=?,registration_time=?,mark=?,user_type=?,is_enable=? WHERE id=? ";
		super.insertSql="INSERT  INTO `sys_user`(`role_id`,`nickname`,`name`,`account`,`password`,`sex`,`age`,`birthday`,`phone`,`email`,`address`,`security_level`,`account_level`,`sort`,`registration_time`,`mark`,`user_type`,`is_enable`) " 
		          +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
		super.countSql="SELECT COUNT(*) FROM sys_user ";
	}
	public abstract User login(User user);

}
