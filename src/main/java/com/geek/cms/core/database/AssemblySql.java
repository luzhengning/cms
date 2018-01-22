package com.geek.cms.core.database;

import java.util.ArrayList;
import java.util.List;

import com.geek.cms.plugin.grid.splitGridReq.GridColumn;
import com.geek.cms.utils.StringUtils;
/**
 * 组装Sql，该类在BusService类中调用
 * @author luzhengning
 * 2018年1月8日 上午11:52:36
 */
public class AssemblySql {
	//表名
	public String tableName="";
	//列名，注意顺序，id不需要添加
	public List<GridColumn> columnNames=new ArrayList<GridColumn>();
	/**
	 * 插入语句
	 * @return
	 */
	public String insertSql() {
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO ");
		//list转string[]
		String[] columns=StringUtils.ListToArray(GridColumn.gridColumnToListString(columnNames));
		sql.append(tableName+"("+StringUtils.arrayToStr(columns, ",")+") ");
		sql.append("Values("+StringUtils.connCharToString("?", ",",columnNames.size())+") ");
		return sql.toString();
	}
	/**
	 * 删除语句
	 * @return
	 */
	public String deleteSql() {
		StringBuilder sql=new StringBuilder();
		sql.append("DELETE FROM ");
		sql.append(tableName+" ");
		return sql.toString();
	}
	/**
	 * 修改语句
	 * @return
	 */
	public String updateSql() {
		StringBuilder sb=new StringBuilder();
		sb.append("Update ");
		sb.append(tableName);
		sb.append(" Set ");
		sb.append(StringUtils.connListToString(GridColumn.gridColumnToListString(columnNames), "=?,"));
		sb.append(" Where id=?");
		return sb.toString();
	}
	/**
	 * 查询语句
	 * @return
	 */
	public String querySql() {
		StringBuilder sql=new StringBuilder();
		sql.append("Select * from ");
		sql.append(tableName+" ");
		return sql.toString();
	}
	/**
	 * 
	 * @return
	 */
	public String countSql() {
		StringBuilder sql=new StringBuilder();
		sql.append("SELECT COUNT(*) FROM ");
		sql.append(tableName);
		return sql.toString();
	}
	
	
	
}
