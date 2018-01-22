package com.geek.cms.modules.sys.dao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.entity.example.RoleExample;
import com.geek.cms.modules.sys.entity.example.SysMenuExample;
import com.geek.cms.plugin.grid.splitGridReq.GridColumn;
import com.geek.cms.utils.db.DbUtil;

/**
 * 数据访问类，提供了数据库操作和数据接口， 该类被业务模块中的Service类继承
 * @author luzhengning
 * 2017年11月1日 下午2:07:25
 */
public abstract class SysMenuDao  implements BusServiceDao<SysMenu,SysMenuExample> {
	/*public SysMenuDao(Class clz) {
		super(clz);
		super.assemblySql.tableName="sys_tree_menu";
		super.assemblySql.columnNames.add(new GridColumn("名称","name"));
		super.assemblySql.columnNames.add(new GridColumn("父级id","parent_id"));
		super.assemblySql.columnNames.add(new GridColumn("地址","url"));
		super.assemblySql.columnNames.add(new GridColumn("排序","sort_num"));
		super.assemblySql.columnNames.add(new GridColumn("角色","role_id"));
		super.assemblySql.columnNames.add(new GridColumn("首页","index_select"));
		super.assemblySql.columnNames.add(new GridColumn("修改时间","update_time"));
		super.assemblySql.columnNames.add(new GridColumn("创建时间","create_by"));
		super.assemblySql.columnNames.add(new GridColumn("是否禁用","is_enable"));
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
	}*/
	public abstract List<SysMenu> findListByRoleId(Object sysMenuId,String parentId,int depthNum,HttpServletRequest request);
	public abstract void setParentId(String ParentId,HttpServletRequest request);
	

	/*super.querySql="SELECT * FROM sys_tree_menu ";
	super.deleteSql="DELETE FROM sys_tree_menu ";
	super.updateSql="UPDATE sys_tree_menu SET NAME=?,parent_id=?,url=?,sort_num=?,role_id=?,index_select=?,update_time=?,create_by=?,is_enable=? WHERE id=? ";
	super.insertSql="INSERT INTO sys_tree_menu(name,parent_id,url,sort_num,role_id,index_select,create_time,create_by,is_enable) VALUES(?,?,?,?,?,?,?,?,?) ";
	super.countSql="SELECT COUNT(*) FROM sys_tree_menu ";*/
}
