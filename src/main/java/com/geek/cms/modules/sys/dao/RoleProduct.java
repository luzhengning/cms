package com.geek.cms.modules.sys.dao;

import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProductDao;
import com.geek.cms.utils.db.DbUtil;

/**
 * 
 * @author luzhengning
 * 2017年11月1日 下午4:05:12
 */
public abstract class RoleProduct<T> extends ServiceProduct<T> {

	public RoleProduct(Class clz) {
		super(clz);
	}

}
