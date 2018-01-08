package com.geek.cms.modules.cms.dao;

import com.geek.cms.modules.cms.entity.CmsContent;
import com.geek.cms.modules.core.service.BusService;
import com.geek.cms.modules.sys.entity.Permission;

public interface CmsProductDao {
	public void insert();
	public void delete();
	public void update();
	public void query();
}
