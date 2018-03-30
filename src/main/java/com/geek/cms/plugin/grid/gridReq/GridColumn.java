package com.geek.cms.plugin.grid.gridReq;

import java.util.ArrayList;
import java.util.List;

/**
 * 表单列表
 * @author luzhengning
 *
 */
public class GridColumn {
	/**
	 * 英文列，对应数据库字段
	 */
	public String columnEnTitle;
	/**
	 * 中文列名
	 */
	public String columnCnTitle;
	/**
	 * 类字段
	 */
	public String columnClzTitle;
	/**
	 * 字段类型，表单用
	 */
	public String type;
	/**
	 * 
	 */
	public String attribute;
	
	public String formValue;
	
	public GridColumn(String columnCnTitle,String  columnEnTitle,String columnClzTitle){
		this.columnCnTitle=columnCnTitle;	
		this.columnEnTitle=columnEnTitle;
		this.columnClzTitle=columnClzTitle;
	}
	public GridColumn(String columnCnTitle,String  columnEnTitle,String columnClzTitle,String type,String attribute){
		this.columnCnTitle=columnCnTitle;	
		this.columnEnTitle=columnEnTitle;
		this.columnClzTitle=columnClzTitle;
		this.type=type;
		this.attribute=attribute;
	}
	
	public String getFormValue() {
		return formValue;
	}
	public void setFormValue(String formValue) {
		this.formValue = formValue;
	}
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	

	public String getAttribute() {
		return attribute;
	}
	public void setAttribute(String attribute) {
		this.attribute = attribute;
	}
	public String getColumnClzTitle() {
		return columnClzTitle;
	}

	public void setColumnClzTitle(String columnClzTitle) {
		this.columnClzTitle = columnClzTitle;
	}

	public String getColumnEnTitle() {
		return columnEnTitle;
	}
	public void setColumnEnTitle(String columnEnTitle) {
		this.columnEnTitle = columnEnTitle;
	}
	public String getColumnCnTitle() {
		return columnCnTitle;
	}
	public void setColumnCnTitle(String columnCnTitle) {
		this.columnCnTitle = columnCnTitle;
	}
	public static List<String> gridColumnToListString(List<GridColumn> column){
		List<String> list=new ArrayList<String>();
		for(int i=0;i<column.size();i++) {
			list.add(column.get(i).getColumnEnTitle());
		}
		return list;
	}
}
