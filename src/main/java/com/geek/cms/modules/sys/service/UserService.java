package com.geek.cms.modules.sys.service;

import com.geek.cms.modules.sys.dao.UserDao;
import com.geek.cms.modules.sys.entity.User;

public class UserService extends UserDao {

	public UserService() {
		super(User.class);
	}

	


	/**
	 * 登录
	 */
	public User login(User user) {
		String sql=querySql+" WHERE account=? AND PASSWORD=?";
		Object[] params=new Object[]{user.getAccount(),user.getPassword()};
		return super.load(sql, params);
	}







	

}
