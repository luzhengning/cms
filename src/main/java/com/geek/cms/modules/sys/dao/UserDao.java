

package com.geek.cms.modules.sys.dao;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.entity.example.RoleExample;
import com.geek.cms.modules.sys.entity.example.UserExample;
import com.geek.cms.plugin.grid.splitGridReq.GridColumn;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:21
 */
public abstract class UserDao implements BusServiceDao<User,UserExample> {

	/*public UserDao(Class clz) {
		super(clz);
		super.assemblySql.tableName="sys_user";
		super.assemblySql.columnNames.add(new GridColumn("角色id","role_id"));
		super.assemblySql.columnNames.add(new GridColumn("昵称","nickname"));
		super.assemblySql.columnNames.add(new GridColumn("姓名","NAME"));
		super.assemblySql.columnNames.add(new GridColumn("账号","account"));
		super.assemblySql.columnNames.add(new GridColumn("密码","password"));
		super.assemblySql.columnNames.add(new GridColumn("性别","sex"));
		super.assemblySql.columnNames.add(new GridColumn("年龄","age"));
		super.assemblySql.columnNames.add(new GridColumn("生日","birthday"));
		super.assemblySql.columnNames.add(new GridColumn("手机号码","phone"));
		super.assemblySql.columnNames.add(new GridColumn("邮箱","email"));
		super.assemblySql.columnNames.add(new GridColumn("地址","address"));
		super.assemblySql.columnNames.add(new GridColumn("安全等级","security_level"));
		super.assemblySql.columnNames.add(new GridColumn("账号等级","account_level"));
		super.assemblySql.columnNames.add(new GridColumn("排序","sort"));
		super.assemblySql.columnNames.add(new GridColumn("注册时间","registration_time"));
		super.assemblySql.columnNames.add(new GridColumn("备注","mark"));
		super.assemblySql.columnNames.add(new GridColumn("用户类型","user_type"));
		super.assemblySql.columnNames.add(new GridColumn("是否禁用","is_enable"));
		//生成sql
		setSql();
	}
	@Override
	public Object[] entityToObjects(User user) {
		Object[] params=new Object[]{
				user.getRoleId(),
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
				user.getSecurityLevel(),
				user.getAccountLevel(),
				user.getSort(),
				user.getRegistrationTime(),
				user.getMark(),
				user.getUserType(),
				user.getIsEnable()
		};
		return params;
	}*/
	public abstract User login(User user);
	/*super.querySql="SELECT * FROM sys_user ";
	super.deleteSql="DELETE FROM sys_user ";
	super.updateSql="UPDATE sys_user SET role_id=?,nickname=?,NAME=?,account=?,sex=?,age=?,birthday=?,phone=?,email=?,address=?,security_level=?,account_level=?,sort=?,registration_time=?,mark=?,user_type=?,is_enable=? WHERE id=? ";
	super.insertSql="INSERT  INTO `sys_user`(`role_id`,`nickname`,`name`,`account`,`password`,`sex`,`age`,`birthday`,`phone`,`email`,`address`,`security_level`,`account_level`,`sort`,`registration_time`,`mark`,`user_type`,`is_enable`) " 
	          +"VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
	super.countSql="SELECT COUNT(*) FROM sys_user ";*/
}
