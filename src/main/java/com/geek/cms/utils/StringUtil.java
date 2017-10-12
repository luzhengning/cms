package com.geek.cms.utils;

public class StringUtil {
	
	/**
	 * 通过指定字符连接String数组
	 * @param values
	 * @param s
	 * @return
	 */
	public static String arrayJoinString(String[] values,String s){
		if(values==null)return "";
		String result="";
		for(String str:values){
			result+=str+s;
		}
		return result.substring(0, result.length() - 1);
	}
}
