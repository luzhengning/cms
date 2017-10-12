package com.geek.cms.modules.sys.dao;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.geek.cms.common.dbbase.CrudDao;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.plugin.entity.splitGridReq.GridRequestModel;

public interface SysMenuDao extends CrudDao<SysMenu> {
	public List<SysMenu> findListByRoleId(Object roleId,Object parentId,int depthNum,HttpServletRequest request);
	public int maximum(GridRequestModel model);
	public List<SysMenu> findList(String sql, Object[] params);
	public int maximum(String sql, Object[] params);
}
