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
	/**
	 * 字符串转数组
	 * @param values 要转数组的字符串
	 * @param s 字符串中的分割符
	 * @return
	 */
	public static String[] stringToArray(String values,String s){
		if(values==null)return null;
		if(values.length()==0)return null;
		return values.split(s);
	}
}
