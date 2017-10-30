package com.geek.cms.modules.cms.service;

import com.geek.cms.modules.cms.dao.CmsProductDao;
import com.geek.cms.modules.faramwer.dpatterns.factoryMethod.ServiceFactory;
import com.geek.cms.modules.faramwer.dpatterns.factoryMethod.ServiceProduct;

public class CmsFactory extends ServiceFactory<CmsProductDao> {
	public CmsProductDao create() {
		return new CmsProduct();
	}
}
