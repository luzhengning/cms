package com.geek.cms.modules.sys.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.geek.cms.modules.sys.dao.SysMenuDao;
import com.geek.cms.modules.sys.entity.SysMenu;

/**
 * 后台左侧菜单
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:47
 */
public class SysMenuService extends SysMenuDao {

	//父级id
	private String ParentId="";

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
		String sql=querySql+"WHERE parent_id=? ORDER BY sort_num DESC";
		//sql中的查询参数
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
	/**
	 * 查询角色是否存在
	 * @param role 要查询的角色
	 * @param roles 角色列表
	 * @return
	 */
	public boolean roleExits(String role,String[] roles){
		if(roles==null)return false;
		for(String str:roles){
			if(str.equals(role))return true;
		}
		return false;
	}

	/**
	 * 设置查询的父节点
	 * @param parentId
	 * @param request
	 */
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
