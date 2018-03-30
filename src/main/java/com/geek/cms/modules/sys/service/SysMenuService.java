package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.cms.modules.sys.dao.SysMenuDao;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.entity.example.PermissionsExample;
import com.geek.cms.modules.sys.entity.example.SysMenuExample;
import com.geek.cms.modules.sys.entity.example.SysMenuExample.Criteria;
import com.geek.cms.modules.sys.entity.example.SysMenuExample.Criterion;
import com.geek.cms.modules.sys.mapper.SysMenuMapper;
import com.geek.cms.plugin.grid.gridReq.GridRequest;
import com.geek.cms.utils.StringUtil;

/**
 * 后台左侧菜单
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:47
 */
@Service
public class SysMenuService extends SysMenuDao {
	@Autowired
	SysMenuMapper sysMenuMapper;
	//父级id
	private String ParentIds="";

	
	/**
	 * 根据角色id查询菜单
	 * @param sysMenuId   传null忽略角色
	 * @param parentId 传0查询顶级节点
	 * @param depthNum 查询深度，小于0查询全部
	 * @return
	 */
	public List<SysMenu> findListByRoleId(Object sysMenuId,String parentId,int depthNum,HttpServletRequest request) {
		//String sql=querySql+"WHERE parent_id=? ORDER BY sort_num DESC";
		SysMenuExample example=new SysMenuExample();
		example.setOrderByClause("sort_num DESC");
		example.or().andParentIdEqualTo(Integer.parseInt(parentId));
		//父级
		List<SysMenu> menu=sysMenuMapper.selectByExample(example);
		if(menu==null)return null;
		for(int i=0;i<menu.size();i++){
			System.out.println(menu.get(i).getName());
			//根据角色筛选菜单
			if(sysMenuId!=null){
				//数据验证
				if(menu.get(i).getRoleId()==null){
					menu.remove(i);
					i--;
					continue;
				}
				//数据验证
				if(menu.get(i).getRoleId().trim().length()==0){
					menu.remove(i);
					i--;
					continue;
				}
				//查询角色信息，如果没有就移除
				if(!sysMenuExits(sysMenuId.toString(),menu.get(i).getRoleId().split(","))){
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
			List<SysMenu> childMenu=findListByRoleId(sysMenuId,menu.get(i).getId().toString(),depthNum,request);
			//添加子级
			menu.get(i).setChildMenu(childMenu);
		}
		return menu;
	}
	/**
	 * 查询角色是否存在
	 * @param sysMenu 要查询的角色
	 * @param sysMenus 角色列表
	 * @return
	 */
	public boolean sysMenuExits(String sysMenu,String[] sysMenus){
		if(sysMenus==null)return false;
		for(String str:sysMenus){
			if(str.equals(sysMenu))return true;
		}
		return false;
	}

	
	@Override
	public boolean add(SysMenu t) {
		int result=sysMenuMapper.insert(t);
		return isSuccess(result);
	}

	@Override
	public boolean delete(String idkey) throws SQLException {
		if(StringUtil.isBlank(idkey))return false;
		int id=Integer.parseInt(idkey);
		int result=sysMenuMapper.deleteByPrimaryKey(id);
		return isSuccess(result);
	}

	@Override
	public boolean delete(SysMenuExample example) throws SQLException {
		int result=sysMenuMapper.deleteByExample(example);
		return isSuccess(result);
	}

	@Override
	public boolean update(SysMenu t) {
		int result=sysMenuMapper.updateByPrimaryKey(t);
		return isSuccess(result);
	}

	@Override
	public SysMenu load(String id) {
		if(StringUtil.isBlank(id))return null;
		int key=Integer.parseInt(id);
		return sysMenuMapper.selectByPrimaryKey(key);
	}

	@Override
	public List<SysMenu> findList(GridRequest model) {
		return sysMenuMapper.selectByExample(paramsToExample(model));
	}
	@Override
	public List<SysMenu> findList(SysMenuExample example) {
		return sysMenuMapper.selectByExample(example);
	}

	@Override
	public int maximum(GridRequest model) {
		return sysMenuMapper.countByExample(paramsToExample(model));
	}

	@Override
	public int maximum(SysMenuExample example) {
		return sysMenuMapper.countByExample(example);
	}
	/**
	 * 查询父级下的子菜单
	 */
	public List<SysMenu> findByParentId(String parentId){
		Integer id=Integer.parseInt(parentId);
		SysMenuExample example=new SysMenuExample();
		example.or().andParentIdEqualTo(id);
		return sysMenuMapper.selectByExample(example);
	}
	
	private boolean isSuccess(int result) {
		if(result>0)return true;
		return false;
	}
	public SysMenuExample paramsToExample(GridRequest model) {
		SysMenuExample example=new SysMenuExample();
		if(model==null)return example;
		example.setPage(model.getSplitPage());
		//查询的字段，与查询参数对应
		String[] paramsName=model.getParamsName();
		//条件
		String[] condition=model.getCondition();
		//或与
		String orWith=model.getOrWith();
		//参数
		Object[] params=model.getParams();
		if(paramsName==null||condition==null||orWith==null||params==null)return example;
		Criteria criteria1 = example.createCriteria();
		for(int i=0;i<paramsName.length;i++) {
			if("or".equals(orWith)) {
				example.or().criteria.add(new Criterion(paramsName[i]+" "+condition[i]+" ",params[i]));
				continue;
			}
			criteria1.criteria.add(new Criterion(paramsName[i]+" "+condition[i]+" ",params[i]));
		}
		
		return example;
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
	public void setParentId(String ParentId,HttpServletRequest request){
		request.getSession().setAttribute("ParentId",ParentId);
	}
	private String getParentId(HttpServletRequest request){
		return request.getSession().getAttribute("ParentId").toString();
	}
}
