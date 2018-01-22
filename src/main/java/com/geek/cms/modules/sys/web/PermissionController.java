package com.geek.cms.modules.sys.web;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geek.cms.modules.sys.dao.PermissionsDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.plugin.grid.splitGridReq.Grid;
import com.geek.cms.plugin.grid.splitGridReq.GridRequest;
import com.geek.cms.plugin.grid.splitPage.SplitJsonModel;
import com.geek.cms.plugin.grid.splitPage.SplitPage;
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
		//grid.setGridColumn(permissionService.assemblySql.columnNames);
		//分页初始化
		SplitPage page=new SplitPage();
		page.setTotalRow(permissionDao.maximum(new GridRequest()));
		page.setPageRow(10);
		grid.setPage(page);
		Map<String, Object> model=grid.getModel(grid);
		
		return new ModelAndView("/UiPlugin/grid",model);
	}
	@RequestMapping("/load")
	public void load() {
		/*List<Permissions> list=permissionDao.findList(new GridRequest());
		SplitJsonModel<Permissions> jsonModel=new SplitJsonModel<Permissions>(list, page);*/
	}
}
