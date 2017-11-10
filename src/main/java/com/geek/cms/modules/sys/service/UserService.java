package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.dao.DbBasicDao;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.sys.dao.UserDao;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.plugin.grid.SplitGridRequestUtil;
import com.geek.cms.plugin.grid.splitGridReq.GridRequestModel;
import com.geek.cms.utils.db.DbUtil;

public class UserService extends UserDao {

	public UserService() {
		super(User.class);
	}

	public final static String querySql="SELECT * FROM sys_user ";
	

	/**
	 * 用户注册
	 */
	public boolean add(User user) {
		String sql="INSERT  INTO `sys_user`(`role_id`,`nickname`,`name`,`account`,`password`,`sex`,`age`,`birthday`,`phone`,`email`,`address`,`security_level`,`account_level`,`sort`,`registration_time`,`mark`,`user_type`,`is_enable`) " 
		          +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
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

	public boolean delete(String userId) throws SQLException {
		String sql="DELETE FROM sys_user WHERE id=?";
		return super.delete(sql, new Object[]{userId});
	}

	public boolean update(User user) {
		String sql="UPDATE sys_user SET role_id=?,nickname=?,NAME=?,account=?,sex=?,age=?,birthday=?,phone=?,email=?,address=?,security_level=?,account_level=?,sort=?,registration_time=?,mark=?,user_type=?,is_enable=? WHERE id=?";
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

	public User load(String id) {
		String sql=querySql+" WHERE id=?";
		return super.load(sql, new Object[]{id});
	}
	/**
	 * 登录
	 */
	public User login(User user) {
		String sql=querySql+" WHERE account=? AND PASSWORD=?";
		Object[] params=new Object[]{user.getAccount(),user.getPassword()};
		return super.load(sql, params);
	}
	public int maximum(GridRequestModel model) {
		String sql="SELECT COUNT(*) FROM sys_user where 1=1 ";
		if(model!=null){
			if(model.getParamsName()!=null){
					sql=sql+SplitGridRequestUtil.MapToQuerySql(model);
			}
		}
		return super.getNum(sql, model.getParams());
	}

	public List<User> findList(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return null;
	}

	public int maximum(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return 0;
	}

	public List<User> findList(GridRequestModel model) {
		String sql=querySql+" where 1=1 ";
		sql=(sql+model.getParamsNameSql());
		return super.find(sql,model.getParams());
	}

	public List<User> findBySql(String sql, Object[] params) {
		sql=querySql+" where "+sql;
		return super.find(sql, params);
	}








	

}
