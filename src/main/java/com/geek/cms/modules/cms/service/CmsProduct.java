package com.geek.cms.modules.cms.service;

import com.geek.cms.modules.cms.dao.CmsProductDao;
import com.geek.cms.modules.faramwer.dpatterns.factoryMethod.ServiceProduct;

public class CmsProduct implements CmsProductDao{


	public void insert() {
		System.out.println("插入数据！");
	}

	public void delete() {
		System.out.println("删除数据！");
	}

	public void update() {
		System.out.println("修改数据！");
	}

	public void query() {
		System.out.println("查询数据！");
	}

}
