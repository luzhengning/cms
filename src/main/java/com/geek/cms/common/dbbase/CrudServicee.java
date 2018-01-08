package com.geek.cms.common.dbbase;

import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.utils.db.DbUtil;

public abstract class CrudService<T> extends DbUtil<T>   {

	public CrudService(Class clz) {
		super(clz);
	}

}
