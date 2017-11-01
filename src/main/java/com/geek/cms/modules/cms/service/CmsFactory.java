package com.geek.cms.modules.cms.service;

import com.geek.cms.modules.faramwer.factoryMethod.ServiceFactory;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;

public class CmsFactory extends ServiceFactory {
	
	public final static String CMS="CMS";
	public final static String CMSS="CMMS";

	public ServiceProduct create(String type) {
		try {
			switch(type) {
			case CMS:
				return new CmsService();
			case CMSS:
				return null;
			}
			throw new Exception("工厂未生产:"+type);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return null;
		}
	}

}
