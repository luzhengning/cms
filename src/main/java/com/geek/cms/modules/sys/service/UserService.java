package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.dao.DbBasicDao;
import com.geek.cms.modules.faramwer.service.BusService;
import com.geek.cms.modules.sys.dao.UserDao;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.plugin.grid.splitGridReq.SplitGridRequestUtil;
import com.geek.cms.utils.db.DbUtil;

public class UserService extends UserDao {

	public UserService() {
		super(User.class);
	}

	/**
	 * 用户注册
	 */
	public boolean add(User user) {
		String sql=insertSql;
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
				return super.add(sql, params);
	}


	public boolean update(User user) {
		String sql=updateSql;
		Object[] params=new Object[]{
				user.getRole_id(),
				user.getNickname(),
				user.getName(),
				user.getAccount(),
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
				user.getIs_enable(),
				user.getId()
		};
		return super.update(sql, params);
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
