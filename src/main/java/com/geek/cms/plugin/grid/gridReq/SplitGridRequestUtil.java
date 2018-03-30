package com.geek.cms.plugin.grid.gridReq;

import javax.servlet.http.HttpServletRequest;

import com.geek.cms.modules.core.service.BusServiceDao;
import com.geek.cms.plugin.grid.Page.SplitPage;



public class SplitGridRequestUtil {
	//页面分页处理
	public static <T,E> SplitPage getSplitPage(GridRequest model,BusServiceDao<T,E> dao, HttpServletRequest request){
		SplitPage splitPage=null;
		String limit="";
		String flag=request.getParameter("pageNo");
		if(flag!=null){
			splitPage=new SplitPage();
			splitPage.setTotalRow(dao.maximum(model));
			int row=Integer.parseInt(request.getParameter("pageRow").toString());
			splitPage.setPageRow(row);
			splitPage.setCurrentNum(Integer.parseInt(request.getParameter("currentNum").toString()));
			limit=splitPage.toNewPage(flag);
		}
		return splitPage;
	}
	/**
	 * 获取table3查询参数
	 * @param request
	 * @return
	 */
	public static Object[] getReqeustParams(HttpServletRequest request){
		Object[] params=null;
		String[] searchValue=request.getParameterValues("searchValue");
		if(searchValue!=null){
			if(searchValue.length>0){
				if(searchValue[0].trim().length()>0){
					params=new Object[searchValue.length];
					for(int i=0;i<searchValue.length;i++){
						params[i]=searchValue[i];
					}
				}
			}
		}
		return params;
	}
	/**
	 * 查询：
	 * columnName : 字段名称
	 * condition  : 条件
	 * searchValue: 查询参数
	 * searchOrWith:或与
	 * 分页：
	 * 
	 * @param request
	 * @param dao
	 * @return
	 */
	public static <T,E> GridRequest getModel(HttpServletRequest request,BusServiceDao<T,E> dao){
		GridRequest model=new GridRequest();
		//字段值
		model.setParams(SplitGridRequestUtil.getReqeustParams(request));
		//字段名
		model.setParamsName(request.getParameterValues("columnName"));
		//条件
		model.setCondition(request.getParameterValues("condition"));
		//与或
		model.setOrWith(request.getParameter("searchOrWith"));
		//生成查询条件
		model.setParamsNameSql(MapToQuerySql(model));
		//分页
		model.setSplitPage(SplitGridRequestUtil.getSplitPage(model, dao, request));
		model.setLimit("");
		if(model.getSplitPage()!=null)model.setLimit(model.getSplitPage().limit);
		model.setParamsNameSql(model.getParamsNameSql()+model.getLimit());
		return model;
	}
	/**
	 * map key:字段 value:条件 转sql
	 * @param paramsName
	 * @return
	 */
	public static String MapToQuerySql(GridRequest model){
		/*if(model==null)return "";
		if(model.getParams()==null)return "";
		String sql="";
		if(model.getParamsName()!=null){
			sql=sql+" AND ";
			model.getOrWith()[model.getOrWith().length-1]="";
			for(int i=0;i<model.getParams().length;i++){
				sql=(sql+model.getParamsName()[i]+" "+model.getCondition()[i]+" ? "+model.getOrWith()[i]+" ");
			}
		}
		return sql;*/
		return null;
	}
}
