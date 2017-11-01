package com.geek.cms.modules.faramwer.factoryMethod;

import com.geek.cms.modules.cms.service.CmsService;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProductDao;
import com.geek.cms.utils.db.DbUtil;


/**
 * ServiceProduct工厂
 * @author luzhengning
 * 2017年11月1日 上午11:38:31
 */
public abstract class ServiceFactory {

	public ServiceProductDao create(String type) {
		try {
			throw new Exception("未创建ServiceProduct！");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
