package com.geek.cms.plugin.grid.gridReq;

import com.geek.cms.plugin.grid.Page.SplitPage;

/**
 * 表格请求到服务端的数据
 * @author luzhengning
 *
 */
public class GridRequest {
	//分页sql
	private String limit;
	//查询参数
	private Object[] params;
	//查询的字段，与查询参数对应
	private String[] paramsName;
	//条件
	private String[] condition;
	//或与
	private String orWith;
    //分页对象
	private SplitPage splitPage;
	//sql语句，最后生成的查询条件
	private String paramsNameSql;
	
	
	public String getOrWith() {
		return orWith;
	}
	public void setOrWith(String orWith) {
		this.orWith = orWith;
	}
	public String getParamsNameSql() {
		if(paramsNameSql!=null)
			return paramsNameSql;
		else
			return "";
	}
	public void setParamsNameSql(String paramsNameSql) {
		this.paramsNameSql = paramsNameSql;
	}
	/**
	 * 分页sql
	 * @return
	 */
	public String getLimit() {
		if(limit!=null) return limit;
		else return "";
	}
	/**
	 * 分页sql
	 * @return
	 */
	public void setLimit(String limit) {
		this.limit = limit;
	}
	/**
	 * 查询的参数
	 * @return
	 */
	public Object[] getParams() {
		return params;
	}
	/**
	 * 查询的参数
	 * @return
	 */
	public void setParams(Object[] params) {
		this.params = params;
	}
	
	public String[] getParamsName() {
		return paramsName;
	}
	public void setParamsName(String[] paramsName) {
		this.paramsName = paramsName;
	}
	public String[] getCondition() {
		return condition;
	}
	public void setCondition(String[] condition) {
		this.condition = condition;
	}
	/**
	 * 分页对象
	 * @return
	 */
	public SplitPage getSplitPage() {
		//if(splitPage==null) return new SplitPage();
		return splitPage;
	}
	/**
	 * 分页对象
	 * @return
	 */
	public void setSplitPage(SplitPage splitPage) {
		this.splitPage = splitPage;
	}
	
}
