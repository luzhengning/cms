package com.geek.cms.utils;

import java.util.List;

public class StringUtil {
	
	/**
	 * 通过指定字符连接String数组
	 * @param values
	 * @param s
	 * @return
	 */
	public static String arrayToStr(String[] values,String s){
		if(values==null)return "";
		String result="";
		for(String str:values){
			result+=str+s;
		}
		return result.substring(0, result.length() - 1);
	}
	/**
	 * 指定字符串分割字符
	 * @param values 要转数组的字符串
	 * @param s 字符串中的分割符
	 * @return
	 */
	public static String[] strToArray(String values,String s){
		if(values==null)return null;
		if(values.length()==0)return null;
		return values.split(s);
	}
	/**
	 * List转String数组
	 * @param list
	 * @return
	 */
	public static String[] ListToArray(List<String> list) {
		if(list==null)return null;
		String[] strs=new String[list.size()];
		list.toArray(strs);
		return strs;
	}
	/**
	 * 通过指定字符循环连接字符串，例如 ?,?,?,?
	 * @param text
	 * @param c
	 * @param length
	 * @return
	 */
	public static String connCharToString(String text,String c,int length) {
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<length;i++) {
			sb.append(text);
			sb.append(c);
		}
		return sb.substring(0, sb.length()-1).toString();
	}
	/**
	 * 通过指定字符连接List，例如 id=?,name=?,age=?
	 * @param list
	 * @param c
	 * @return
	 */
	public static String connListToString(List<String> list,String c) {
		StringBuilder sb=new StringBuilder();
		for(String str:list){
			sb.append(str);
			sb.append(c);
		}
		return sb.substring(0, sb.length()-1).toString();
	}
}
