package com.geek.cms.plugin.grid.splitGridReq;

import java.util.ArrayList;
import java.util.List;

/**
 * 表格显示的列名
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
	
	public GridColumn(String columnCnTitle,String  columnEnTitle){
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
	public static List<String> gridColumnToListString(List<GridColumn> column){
		List<String> list=new ArrayList<String>();
		for(int i=0;i<column.size();i++) {
			list.add(column.get(i).getColumnEnTitle());
		}
		return list;
	}
}
