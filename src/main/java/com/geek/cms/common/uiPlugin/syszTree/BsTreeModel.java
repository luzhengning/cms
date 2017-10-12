package com.geek.cms.common.uiPlugin.syszTree;

import java.util.List;

public class BsTreeModel {
	private String text;
	private String href;
	private List<BsTreeModel> nodes;
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getHref() {
		return href;
	}
	public void setHref(String href) {
		this.href = href;
	}

	public List<BsTreeModel> getNodes() {
		return nodes;
	}
	public void setNodes(List<BsTreeModel> nodes) {
		this.nodes = nodes;
	}
	
}
