package com.geek.cms.plugin.grid.splitGridReq;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.geek.cms.plugin.grid.splitPage.SplitPage;
import com.geek.cms.utils.JsonUtil;
import com.sdicons.json.mapper.MapperException;


/**
 * 初始化表格
 * @author 路正宁
 */
public class Grid {
	//表格标题
	private String title;
	//表格数据加载路径
	private String loadJsonUrl;
	//编辑路径
	private String editUrl;
	//删除路径
	private String deleteUrl;
	//分页json
	private String pageJsonData;
	//表格列标题
	private List<GridColumn> gridColumn;
	//分页对象
	private SplitPage page;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLoadJsonUrl() {
		return loadJsonUrl;
	}
	public void setLoadJsonUrl(String loadJsonUrl) {
		this.loadJsonUrl = loadJsonUrl;
	}
	public String getPageJsonData() {
		return pageJsonData;
	}
	public void setPageJsonData(String pageJsonData) {
		this.pageJsonData = pageJsonData;
	}
	public List<GridColumn> getGridColumn() {
		return gridColumn;
	}
	public void setGridColumn(List<GridColumn> gridColumn) {
		this.gridColumn = gridColumn;
	}
	public SplitPage getPage() {
		return page;
	}
	public void setPage(SplitPage page) {
		this.page = page;
	}
	
	public String getEditUrl() {
		return editUrl;
	}
	public void setEditUrl(String editUrl) {
		this.editUrl = editUrl;
	}
	public String getDeleteUrl() {
		return deleteUrl;
	}
	public void setDeleteUrl(String deleteUrl) {
		this.deleteUrl = deleteUrl;
	}
	public Map<String, Object> getModel(Grid grid) throws MapperException{
		Map<String, Object> model=new HashMap<String, Object>();
		//头名称
		model.put("title", grid.getTitle());
		//数据路径
		model.put("loadJsonUrl", grid.getLoadJsonUrl());
		model.put("editUrl",grid.getEditUrl());
		model.put("deleteUrl",grid.getDeleteUrl());
		//要显示的列
		model.put("column", grid.getGridColumn());
		//分页初始化
		model.put("page", grid.getPage());
		model.put("pageJsonData", JsonUtil.objectToJsonStr(grid.getPage()));
		return model;
	}
}
