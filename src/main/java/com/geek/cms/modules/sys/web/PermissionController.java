package com.geek.cms.modules.sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geek.cms.modules.json.Json;
import com.geek.cms.modules.json.JsonMessage;
import com.geek.cms.modules.json.JsonUtil;
import com.geek.cms.modules.sys.dao.PermissionsDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.plugin.grid.Page.SplitJsonModel;
import com.geek.cms.plugin.grid.Page.SplitPage;
import com.geek.cms.plugin.grid.gridReq.Grid;
import com.geek.cms.plugin.grid.gridReq.GridRequest;
import com.geek.cms.plugin.grid.gridReq.SplitGridRequestUtil;
import com.geek.cms.utils.StringUtil;
import com.geek.cms.utils.TimeUtil;
import com.sdicons.json.mapper.MapperException;

/**
 * 权限Controller类
 * @author luzhengning
 * 2018年1月9日 下午1:52:49
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
	//业务类
	@Autowired
	PermissionsDao permissionDao;
	/**
	 * 权限表单
	 * @param request
	 * @param response
	 * @return
	 * @throws MapperException 
	 */
	@RequestMapping("/grid")
	public ModelAndView grid(HttpServletRequest request,HttpServletResponse response) throws MapperException {
		//String user=request.getParameter("user");
		//创建表格对象
		Grid grid=new Grid();
		//页名
		grid.setTitle("权限管理");
		//路径 查询普通用户
		grid.setLoadJsonUrl("/permission/load");
		//编辑路径
		grid.setEditUrl("/permission/form");
		//删除路径
		grid.setDeleteUrl("/permission/delete");
		//要显示的列
		grid.setGridColumn(permissionDao.assemblySql);
		//分页初始化
		SplitPage page=new SplitPage();
		page.setTotalRow(permissionDao.maximum(new GridRequest()));
		page.setPageRow(10);
		grid.setPage(page);
		Map<String, Object> model=grid.getModel(grid);
		
		return new ModelAndView("/UiPlugin/grid",model);
	}
	@RequestMapping("/load")
	public void loadJson(HttpServletRequest request, HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			response.setCharacterEncoding("UTF-8");
			out=response.getWriter();
			GridRequest model=SplitGridRequestUtil.getModel(request, permissionDao);
			List<Permissions> list=permissionDao.findList(model);
			SplitJsonModel<Permissions> jsonModel=new SplitJsonModel<Permissions>(list, model.getSplitPage());
			if(!StringUtil.isBlank(jsonModel)) {
				json=Json.setSuccess(json);
				json.setData(JsonUtil.objectToJsonStr(jsonModel));
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/form")
	public ModelAndView roleForm(HttpServletRequest request) throws MapperException{
		Map<String, Object> model=new HashMap<String, Object>();
		String id=request.getParameter("id");
		if(id==null){
			//添加权限
			model.put("submitUrl", "/permission/add");
			model.put("permission", new Permissions(0));
		}else{
			//编辑权限
			Permissions permission=permissionDao.load(id);
			model.put("permission", permission);
			model.put("submitUrl", "/permission/edit");
		}
		return new ModelAndView("Admin/form/permissionForm",model);
	}
	@RequestMapping("/edit")
	public void edit(Permissions per,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			if(StringUtil.isBlank(per)) {
				json.setMsg("参数异常！");
				return;
			}
			per.setUpdateTime(TimeUtil.getTime());
			if(permissionDao.update(per)){
				json=Json.setSuccess(json);
				json.setMsg("编辑成功！");
			}else{
				json=Json.setError(json);
				json.setMsg("编辑失败！");
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/add")
	public void add(Permissions per,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			if(StringUtil.isBlank(per)) {
				json.setMsg("参数异常！");
				return;
			}
			per.setCreateTime(TimeUtil.getTime());
			per.setUpdateTime(TimeUtil.getTime());
			if(permissionDao.add(per)){
				json=Json.setSuccess(json);
				json.setMsg("保存成功！");
			}else{
				json=Json.setError(json);
				json.setMsg("保存失败！");
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			String id=request.getParameter("id");
			if(permissionDao.delete(id)){
				json=Json.setSuccess(json);
				json.setMsg("删除成功！");
			}else{
				json=Json.setError(json);
				json.setMsg("删除失败！");
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	
}
