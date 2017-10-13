package com.geek.cms.modules.sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geek.cms.common.uiPlugin.syszTree.BsTreeUtil;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.service.SysMenuService;
import com.geek.cms.utils.JsonUtil;
import com.sdicons.json.mapper.MapperException;


/**
 * 系统菜单 Controller
 * @author luzhengning
 * 
 */
@Controller
@RequestMapping("/sysmenu")
public class SysMenuController {
	SysMenuService service=new SysMenuService();
	
	/**
	 * 查询系统菜单 
	 * @param roleId 角色id
	 * @param parentId 父级id
	 * @param depthNum 查询深度
	 */
	@RequestMapping("/load")
	public void load(HttpServletRequest request,  
	        HttpServletResponse response){
		//获取查询数据
		Map<String,String> param=getRequestParam(request);
		//设置该节点
		service.setParentId(param.get("parentId"),request);
		List<SysMenu> sysMenu=service.findListByRoleId(param.get("roleId"),param.get("parentId"),Integer.parseInt(param.get("depthNum")),request);
		PrintWriter out=null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String text="";
		try {
			text=JsonUtil.objectToJsonStr(sysMenu);
		} catch (MapperException e) {
			e.printStackTrace();
		}
		out.print(text);
	}
	
	/**
	 * boostarp样式的tree菜单json数据
	 * @throws MapperException 
	 * @throws IOException 
	 */
	@RequestMapping("/loadBsTree")
	public void loadBsTree(HttpServletRequest request,  
	        HttpServletResponse response) throws MapperException, IOException{
		//获取查询数据
		Map<String,String> param=getRequestParam(request);
		service.setParentId(param.get("parentId"),request);
		List<SysMenu> sysMenu=service.findListByRoleId(param.get("roleId"),param.get("parentId"),Integer.parseInt(param.get("depthNum")),request);
		BsTreeUtil util=new BsTreeUtil();
		Map<String,Object> data = new HashMap<String,Object>(); 
		String text=JsonUtil.objectToJsonStr(util.SysMenuToBTreeJson(sysMenu));
		text=text.replace("\"nodes\":[],", "");
		response.getWriter().print(text);
	}
	public ModelAndView toTree(){
		return new ModelAndView("");
	}
	/**
	 * 获取request中的查询数据,data[0]=roleId;data[1]=parentId;data[2]=depthNum;
	 * @return
	 */
	private Map<String,String> getRequestParam(HttpServletRequest request){
		Map<String,String> data=new HashMap<String, String>();
		//角色
		String roleId=request.getParameter("roleId");
		//菜单组
		String parentId=request.getParameter("parentId");
		//查询深度
		String depthNum=request.getParameter("depthNum");
		if(roleId!=null){
			if(roleId.trim().length()==0){
				roleId=null;
			}
		}else{
			roleId=null;
		}
		if(parentId!=null){
			if(parentId.trim().length()==0){
				parentId="-1";
			}
		}else{
			parentId="-1";
		}
		if(depthNum!=null){
			if(!StringUtils.isNumeric(depthNum)){
				depthNum="-1";
			}
		}else{
			depthNum="-1";
		}
		data.put("roleId", roleId);
		data.put("parentId", parentId);
		data.put("depthNum", depthNum);
		return data;
	}
	@PostConstruct  
	@PostMapping
    public void  init(){  
        System.out.println("################servlet初始化");  
    }  
      
    @PreDestroy  
    public void  dostory(){  
        System.out.println("################servlet销毁");  
    }  
}
