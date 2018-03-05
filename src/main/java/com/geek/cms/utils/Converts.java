package com.geek.cms.utils;

import java.util.ArrayList;
import java.util.List;

public class Converts {
	/**
	 * 数组转List<Integer>
	 * @param strs
	 * @return
	 */
	public static List<Integer> ArrayToListInteger(String[] strs){
<<<<<<< HEAD
		if(strs==null)return null;
=======
>>>>>>> refs/remotes/origin/master
		List<Integer> list=new ArrayList<Integer>();
		for(int i=0;i<strs.length;i++) {
			if(strs[i]==null||strs[i].trim().length()==0)continue;
			list.add(Integer.parseInt(strs[i]));
		}
		return list;
	}
}
