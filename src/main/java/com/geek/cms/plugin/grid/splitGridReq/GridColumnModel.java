package com.geek.cms.plugin.grid.splitGridReq;

/**
 * 表格显示的列名
 * @author luzhengning
 *
 */
public class GridColumnModel {
	/**
	 * 英文列，对应数据库字段
	 */
	public String columnEnTitle;
	/**
	 * 中文列名
	 */
	public String columnCnTitle;
	
	public GridColumnModel(String columnCnTitle,String  columnEnTitle){
		this.columnCnTitle=columnCnTitle;	
		this.columnEnTitle=columnEnTitle;
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
	
}
