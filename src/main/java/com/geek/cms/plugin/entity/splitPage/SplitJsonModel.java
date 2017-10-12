package com.geek.cms.plugin.entity.splitPage;

import java.util.List;

public class SplitJsonModel<T> {
	
	
	private List<T> list;
	private SplitPage page;
	
	public SplitJsonModel(List<T> list,SplitPage page){
		this.list=list;
		this.page=page;
	}
	
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}
	public SplitPage getPage() {
		return page;
	}
	public void setPage(SplitPage page) {
		this.page = page;
	}
	
}
