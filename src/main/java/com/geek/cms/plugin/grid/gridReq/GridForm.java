package com.geek.cms.plugin.grid.gridReq;

import java.util.List;

import com.geek.cms.utils.ClzzUtil;
/**
 * 表单与实体处理类
 * @author luzhengning
 * 2018年3月23日 下午2:41:16
 */
public class GridForm {
	/**
	 * 获取对象中的值，保存到表单列表中
	 * @param list
	 * @param obj
	 * @return
	 */
	public static List<GridColumn> formValue(List<GridColumn> list,Object obj){
		//获取属性名称
		String[] objName=ClzzUtil.getFiledName(obj);
		for(int i=0;i<list.size();i++) {
			for(int j=0;j<objName.length;j++) {
				if(list.get(i).columnClzTitle.equals(objName[j])) {
					list.get(i).setFormValue(ClzzUtil.getFieldValueByName(objName[j], obj).toString());
					break;
				}
			}
		}
		return list;
	}
}
