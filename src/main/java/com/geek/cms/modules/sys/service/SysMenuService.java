package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.geek.cms.common.dbbase.CrudService;
import com.geek.cms.dao.DbBasicDao;
import com.geek.cms.modules.sys.dao.SysMenuDao;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;
import com.geek.cms.utils.db.DbUtil;

/**
 * 后台左侧菜单   这是测试啊测试啊测试啊XXXXXXXXXXXXXX
 * @author 路正宁
 *
 */
public class SysMenuService extends CrudService<SysMenu> implements SysMenuDao {

	//父级id
	private String ParentId="";
	/**
	 * depth 查询的深度，小于0继续查询
	 * @param depth
	 */
	public SysMenuService() {
		super(SysMenu.class);
	}
	
	/**
	 * 根据角色id查询菜单
	 * @param roleId   传null忽略角色
	 * @param parentId 传0查询顶级节点
	 * @param depthNum 查询深度，小于0查询全部
	 * @return
	 */
	public List<SysMenu> findListByRoleId(Object roleId,Object parentId,int depthNum,HttpServletRequest request) {
		String sql="SELECT * FROM sys_tree_menu WHERE parent_id=? ORDER BY sort_num DESC";
		Object[] params=null;
		if(parentId!=null){
			params=new Object[]{parentId};
		}
		//父级
		List<SysMenu> menu=super.find(sql, params);
		if(menu==null)return null;
		for(int i=0;i<menu.size();i++){
			//根据角色筛选菜单
			if(roleId!=null){
				//数据验证
				if(menu.get(i).getRole_id()==null){
					menu.remove(i);
					i--;
					continue;
				}
				//数据验证
				if(menu.get(i).getRole_id().trim().length()==0){
					menu.remove(i);
					i--;
					continue;
				}
				//查询角色信息，如果没有就移除
				if(!roleExits(roleId.toString(),menu.get(i).getRole_id().split(","))){
					menu.remove(i);
					i--;
					continue;
				}
			}
			//深度控制
			if(depthNum>0){
				//判断是否是顶级菜单，从顶级菜单查询必须将计数器置为0，避免等级菜单下的节点重复计数
				//注意:该顶级节点的父节点相同，如果与当前父节点相同，那么开始下一个等级节点轮循
				if(getParentId(request).equals(parentId)){
					setDepthCount(0, request);
				}
				//设置计数器
				int count=getDepthCount(request);
				count++;
				setDepthCount(count,request);
				//如果达到
				if(getDepthCount(request)==depthNum){
					//返回处理其余的菜单
					continue;
				}
			}
			//查询子级
			List<SysMenu> childMenu=findListByRoleId(roleId,menu.get(i).getId(),depthNum,request);
			//添加子级
			menu.get(i).setChildMenu(childMenu);
		}
		return menu;
	}
	//查询角色是否存在
	private boolean roleExits(String role,String[] Roles){
		if(Roles==null)return false;
		for(String str:Roles){
			if(str.equals(role))return true;
		}
		return false;
	}
	public boolean add(SysMenu menu) {
		String sql="INSERT INTO sys_tree_menu(name,parent_id,url,sort_num,role_id,index_select,create_time,create_by,is_enable) "
				+ "VALUES(?,?,?,?,?,?,?,?,?)";
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
		return super.add(sql, params);
	}
	public boolean delete(String id) throws SQLException {
		String sql="DELETE FROM sys_tree_menu WHERE id=?";
		Object[] params={id};
		return super.delete(sql, params);
	}
	public boolean update(SysMenu menu) {
		String sql="UPDATE sys_tree_menu SET NAME=?,parent_id=?,url=?,sort_num=?,role_id=?,index_select=?,update_time=?,create_by=?,is_enable=? WHERE id=?";
		Object[] params={
				menu.getName(),
				menu.getParent_id(),
				menu.getUrl(),
				menu.getSort_num(),
				menu.getRole_id(),
				menu.getIndex_select(),
				menu.getUpdate_time(),
				menu.getCreate_by(),
				menu.getIs_enable(),
				menu.getId()};
		return  super.update(sql, params);
	}
	public SysMenu load(String id) {
		String sql="SELECT * FROM sys_tree_menu where id=?";
		return super.load(sql, new Object[]{id});
	}
	public int maximum(GridRequestModel model) {
		// TODO 自动生成的方法存根
		return 0;
	}
	public List<SysMenu> findList(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return null;
	}
	public int maximum(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return 0;
	}
	@Override
	public List<SysMenu> findList(GridRequestModel model) {
		// TODO 自动生成的方法存根
		return null;
	}
	@Override
	public List<SysMenu> findBySql(String sql, Object[] params) {
		// TODO 自动生成的方法存根
		return null;
	}
	public boolean setIndex(String id){
		String sql="UPDATE sys_tree_menu SET index_select=? WHERE id=?";
		return super.update(sql, new Object[]{"1",id});
	}
	public boolean clearIndexSelect(){
		String sql="UPDATE sys_tree_menu SET index_select=?";
		return super.update(sql, new Object[]{""});
	}
	public void setParentId(Object parentId,HttpServletRequest request){
		setParentId(parentId.toString(),request);
		request.getSession().setAttribute("depthCount", 0);
	}
	/**
	 *  菜单查询计数器，用来计数等级节点
	 * @param depthCount
	 * @param request
	 */
	private void setDepthCount(int depthCount,HttpServletRequest request){
		request.getSession().setAttribute("depthCount",depthCount);
	}
	/**
	 * 菜单查询计数器，用来计数等级节点
	 * @param request
	 * @return
	 */
	private int getDepthCount(HttpServletRequest request){
		Object obj=request.getSession().getAttribute("depthCount");
		String count=obj.toString();
		return Integer.parseInt(count);
	}
	private void setParentId(String ParentId,HttpServletRequest request){
		request.getSession().setAttribute("ParentId",ParentId);
	}
	private String getParentId(HttpServletRequest request){
		return request.getSession().getAttribute("ParentId").toString();
	}
}
