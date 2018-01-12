package com.geek.cms.plugin.uiBsTree;

import java.util.ArrayList;
import java.util.List;

import com.geek.cms.modules.sys.entity.SysMenu;


/**
 * Bootstrap树形菜单工具类
 * @author luzhengning
 * 2017年11月10日 下午1:36:10
 */
public class BsTreeUtil {
	/**
	 * 数据菜单对象转Bootstrap树形菜单对象
	 * @param list
	 * @return
	 */
	public List<BsTreeModel> SysMenuToBTreeJson(List<SysMenu> list){
		List<BsTreeModel> parentList=new ArrayList<BsTreeModel>();
		if(list==null)return null;
		//父级
		for(int i=0;i<list.size();i++){
			BsTreeModel treeModel=new BsTreeModel();
			treeModel.setHref("#");
			treeModel.setText(SysMenuToJsonTextParent(list.get(i)));
			//子级
			if(list.get(i).getChildMenu()!=null){
				treeModel.setNodes(SysMenuToBTreeJson(list.get(i).getChildMenu()));
			}
			parentList.add(treeModel);
		}
		return parentList;
	}
	/**
	 * 设置BS树形菜单节点内容和左侧按钮组
	 * @param sysMenu
	 * @return
	 */
	private String SysMenuToJsonTextParent(SysMenu sysMenu){
		String text="<span>"+sysMenu.getName()+"</span><span>&nbsp;&nbsp;&nbsp;&nbsp;"+sysMenu.getUrl()+" "+("select".equals(sysMenu.getIndexSelect())?"[首页]":"")+"</span>"
		+ "<span  style=\"float:right;text-decoration:none;\">"
		 +"<a id=\"modal-385581\" href=\"#modal-container-385581\" data-toggle=\"modal\" style=\"text-decoration:none;\" value=\""+sysMenu.getName()+","+sysMenu.getUrl()+","+arrayToString(sysMenu.getRoleId(),"@")+","+sysMenu.getSortNum()+","+sysMenu.getId()+","+sysMenu.getParentId()+","+sysMenu.getCreateTime()+","+sysMenu.getIndexSelect()+"\" onclick=\"editBtn(this)\">"
		 		+"<span class=\"label label-success\" value=\"110\">编辑</span>"
		 +"</a>&nbsp;&nbsp;"
		  +"<a href=\"#modal-container-385583\" data-toggle=\"modal\" style=\"text-decoration:none;\" value=\""+sysMenu.getId()+"\" onclick=\"addBtn("+sysMenu.getId()+")\">"
		 		+"<span class=\"label label-info\" >添加子节点</span>"
		 +"</a>&nbsp;&nbsp;"
		 +"<a href=\"#modal-container-385582\" data-toggle=\"modal\" style=\"text-decoration:none;\">"
		 		+"<span class=\"label label-danger\" value=\"110\"  onclick=\"deleteBtn("+sysMenu.getId()+")\">删除</span>"  //0菜单名称	1路径		2角色id	3排序		4菜单id	5父级id 6创建时间  7是否首页
	     +"</a>"
		 +"</span>";
		return text;
	}
	/**
	 * 通过指定的字符将字符串连接起来
	 * @param values
	 * @param s
	 * @return
	 */
	private String arrayToString(String values,String s){
		if(values==null)return "";
		String[] array=values.split(",");
		String result="";
		for(String str:array){
			result+=str+s;
		}
		return result.substring(0, result.length() - 1);
	}
}
