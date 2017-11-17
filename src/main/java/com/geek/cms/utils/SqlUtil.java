package com.geek.cms.utils;

import java.util.Map;


public class SqlUtil {
	/**
	 * 字段转查询条件语句，‘ where 1=1 AND id=? AND name=? ...’
	 * 当只有一个字段时，andOr无作用
	 * @param names
	 * @return
	 */
	public static String namesArrayToQuerySql(String[] names,String andOr) {
		String sql=" where ";
		for(int i=0;i<names.length;i++) {
			if((names.length-1)==i)
				sql+=names[i]+"=?";
			else
				sql+=names[i]+"=? "+andOr+" ";
		}
		return sql;
	}
	
}
