package com.geek.cms.modules.sys.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.utils.db.DbUtil;

/**
 * 数据访问类，提供了数据库操作和数据接口， 该类被业务模块中的Service类继承
 * @author luzhengning
 * 2017年11月1日 下午2:07:25
 */
public abstract class SysMenuDao extends BusService<SysMenu> {
	public SysMenuDao(Class clz) {
		super(clz);
		super.tableName="sys_tree_menu";
		super.columnNames.add("name");
		super.columnNames.add("parent_id");
		super.columnNames.add("url");
		super.columnNames.add("sort_num");
		super.columnNames.add("role_id");
		super.columnNames.add("index_select");
		super.columnNames.add("update_time");
		super.columnNames.add("create_by");
		super.columnNames.add("is_enable");
		//生成sql
		setSql();
	}
	public Object[] entityToObjects(SysMenu menu) {
		Object[] params={
				menu.getName(),
				menu.getParent_id(),
				menu.getUrl(),
				menu.getSort_num(),
				menu.getRole_id(),
				menu.getIndex_select(),
				menu.getCreate_time(),
				menu.getCreate_by(),
				menu.getIs_enable()};
		return null;
	}
	public abstract List<SysMenu> findListByRoleId(Object roleId,Object parentId,int depthNum,HttpServletRequest request);
	
	public boolean setIndex(String id){
		String sql="UPDATE sys_tree_menu SET index_select=? WHERE id=?";
		return super.update(sql, new Object[]{"1",id});
	}
	public boolean clearIndexSelect(){
		String sql="UPDATE sys_tree_menu SET index_select=?";
		return super.update(sql, new Object[]{""});
	}
	/*super.querySql="SELECT * FROM sys_tree_menu ";
	super.deleteSql="DELETE FROM sys_tree_menu ";
	super.updateSql="UPDATE sys_tree_menu SET NAME=?,parent_id=?,url=?,sort_num=?,role_id=?,index_select=?,update_time=?,create_by=?,is_enable=? WHERE id=? ";
	super.insertSql="INSERT INTO sys_tree_menu(name,parent_id,url,sort_num,role_id,index_select,create_time,create_by,is_enable) VALUES(?,?,?,?,?,?,?,?,?) ";
	super.countSql="SELECT COUNT(*) FROM sys_tree_menu ";*/
}
