package com.geek.cms.modules.sys.dao;

import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProduct;
import com.geek.cms.modules.faramwer.factoryMethod.product.service.ServiceProductDao;
import com.geek.cms.utils.db.DbUtil;

/**
 * 权限接口抽象类
 * @author luzhengning
 * 2017年11月1日 下午3:09:27
 */
public abstract class PermissionProduct<T> extends ServiceProduct<T> {

	public PermissionProduct(Class clz) {
		super(clz);
	}

}
