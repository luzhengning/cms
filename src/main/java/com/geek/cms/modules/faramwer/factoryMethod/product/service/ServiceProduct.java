package com.geek.cms.modules.faramwer.factoryMethod.product.service;

import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.utils.db.DbUtil;

/**
 * 数据访问类，提供了数据库操作和数据接口， 该类被业务模块中的Service类继承
 * @author luzhengning
 * 2017年11月1日 下午2:07:25
 */
public abstract class ServiceProduct<T> extends DbUtil<T> implements ServiceProductDao<T> {
	public ServiceProduct(Class clz) {
		super(clz);
	}

}
