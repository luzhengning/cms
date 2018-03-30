package com.geek.cms.modules.sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geek.cms.modules.json.JsonMessage;
import com.geek.cms.modules.json.JsonUtil;
import com.geek.cms.modules.json.Json;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.dao.SysMenuDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.entity.example.RoleExample;
import com.geek.cms.modules.sys.service.SysMenuService;
import com.geek.cms.plugin.uiBsTree.BsTreeUtil;
import com.geek.cms.utils.StringUtil;
import com.sdicons.json.mapper.MapperException;


/**
 * 系统菜单 Controller
 * @author luzhengning
 * 
 */
@Controller
@RequestMapping("/sysmenu")
public class SysMenuController {
	
	@Autowired
	SysMenuDao sysMenudao;
	
	@RequestMapping("/grid")
	public ModelAndView test(HttpServletRequest request, HttpServletResponse response) throws MapperException{
		String id=request.getParameter("id");
		if(StringUtil.isBlank(id))id="0";
		Map<String, Object> model=new HashMap<String, Object>();
		model.put("id", id);
		return new ModelAndView("/UiPlugin/BSTree",model);
	}
	/**
	 * 查询系统菜单 
	 * @param roleId 角色id
	 * @param parentId 父级id
	 * @param depthNum 查询深度
	 */
	@RequestMapping("/load")
	public void load(HttpServletRequest request, HttpServletResponse response){
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
			//获取查询数据
			Map<String,String> param=getRequestParam(request);
			//设置该节点
			sysMenudao.setParentId(param.get("parentId"),request);
			List<SysMenu> sysMenu=sysMenudao.findListByRoleId(param.get("roleId"),param.get("parentId"),Integer.parseInt(param.get("depthNum")),request);
			if(!StringUtil.isBlank(sysMenu)) {
				json=Json.setSuccess(json);
				json.setData(JsonUtil.objectToJsonStr(sysMenu));
			}
		}catch (IOException ex) {
			json=Json.setException(json, ex);
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	
	/**
	 * boostarp样式的tree菜单json数据
	 * @throws MapperException
	 * @throws IOException
	 */
	@RequestMapping("/loadBsTree")
	public void loadBsTree(HttpServletRequest request,  
	        HttpServletResponse response) throws MapperException, IOException{
		try {
			//TODO roleId:管理员才能传null
			//获取查询数据
			Map<String,String> param=getRequestParam(request);
			sysMenudao.setParentId(param.get("parentId"),request);
			List<SysMenu> sysMenu=sysMenudao.findListByRoleId(param.get("roleId"),param.get("parentId"),Integer.parseInt(param.get("depthNum")),request);
			BsTreeUtil util=new BsTreeUtil();
			Map<String,Object> data = new HashMap<String,Object>(); 
			String text=JsonUtil.objectToJsonStr(util.SysMenuToBTreeJson(sysMenu));
			text=text.replace("\"nodes\":[],", "");
			response.getWriter().print(text);
		}catch(Exception ex) {
			response.getWriter().print(ex.getMessage());
		}
	}
	public ModelAndView toTree(){
		return new ModelAndView("");
	}
	
	@RequestMapping("/edit")
	public void edit(SysMenu menu,HttpServletRequest request, HttpServletResponse response) {
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out = response.getWriter();
			if("select".equals(menu.getIsEnable())) 
				menu.setIsEnable("1");
			else
				menu.setIsEnable("0");
			String[] roleIds=request.getParameterValues("roleIds");
			//处理角色ID
			if(!StringUtil.isBlank(roleIds))
				menu.setRoleId(StringUtil.arrayToStr(roleIds, ","));
			boolean result=false;
			if(StringUtil.isBlank(menu.getId()))
				result=sysMenudao.add(menu);//插入
			else
				result=sysMenudao.update(menu);//编辑
			if(result) {
				json=Json.setSuccess(json);
			}else {
				json=Json.setError(json);
			}
			
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,  
	        HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			String id=request.getParameter("id");
			if(sysMenudao.findByParentId(id).size()>0){
				json.setCode(Json.errorCode);
				json.setMsg("删除失败！请先删除子菜单。");
				return;
			}
			if(sysMenudao.delete(id)){
				json=Json.setSuccess(json);
			}else {
				json=Json.setError(json);
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
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
    public void  init(){  
        System.out.println("################servlet初始化");  
    }  
      
    public void  dostory(){  
        System.out.println("################servlet销毁");  
    }  
}
