package com.geek.cms.common.util;

public class SqlUtils {
	
	/**
	 * update语句
	 * @param tableName 表名
	 * @param field  	列名
	 * @param criteria  条件列 可以为空
	 * @return
	 */
	public static String generateUpdateSql(String tableName,String[] field,String[] criteria){
		String updateSql="UPDATE "+tableName+" SET ";
		for(String str:field){
			updateSql+=(str+"=?,");
		}
		updateSql=(updateSql.substring(0, updateSql.length()-1));
		if(criteria!=null){
			updateSql+=" WHERE ";
			for(String str:criteria){
				updateSql+=(str+"=?,");
			}
			updateSql=(updateSql.substring(0, updateSql.length()-1));
		}
		return updateSql;
	}
}
