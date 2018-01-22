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
 * Ȩ��Controller��
 * @author luzhengning
 * 2018��1��9�� ����1:52:49
 */
@Controller
@RequestMapping("/permission")
public class PermissionController {
	//ҵ����
	@Autowired
	PermissionsDao permissionDao;
	/**
	 * Ȩ�ޱ�
	 * @param request
	 * @param response
	 * @return
	 * @throws MapperException 
	 */
	@RequestMapping("/grid")
	public ModelAndView grid(HttpServletRequest request,HttpServletResponse response) throws MapperException {
		//String user=request.getParameter("user");
		//����������
		Grid grid=new Grid();
		//ҳ��
		grid.setTitle("Ȩ�޹���");
		//·�� ��ѯ��ͨ�û�
		grid.setLoadJsonUrl("/permission/load");
		//�༭·��
		grid.setEditUrl("/permission/form");
		//ɾ��·��
		grid.setDeleteUrl("/permission/delete");
		//Ҫ��ʾ����
		//grid.setGridColumn(permissionService.assemblySql.columnNames);
		//��ҳ��ʼ��
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
