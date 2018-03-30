package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.cms.modules.core.mybatis.BaseMybatisDao;
import com.geek.cms.modules.sys.dao.PermissionsDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.modules.sys.entity.example.PermissionsExample;
import com.geek.cms.modules.sys.entity.example.PermissionsExample.Criteria;
import com.geek.cms.modules.sys.entity.example.PermissionsExample.Criterion;
import com.geek.cms.modules.sys.mapper.PermissionsMapper;
import com.geek.cms.plugin.grid.gridReq.GridRequest;
import com.geek.cms.utils.Converts;
import com.geek.cms.utils.StringUtil;

/**
 * 权限操作service
 * @author 路正宁
 * @time:2017年10月13日 下午4:28:12
 */
@Service
public class PermissionService extends PermissionsDao {

	@Autowired
	PermissionsMapper permissionsMapper;
	/**
	 * 查询多个权限
	 */
	@Override
	public List<Permissions> findByIds(String[] ids) {
		if(ids==null)return null;
		if(ids.length==0)return null;
		PermissionsExample example=new PermissionsExample();
		example.or().andIdIn(Converts.ArrayToListInteger(ids));
		List<Permissions> result=permissionsMapper.selectByExample(example);
		return result;
	}
	@Override
	public boolean add(Permissions t) {
		int result=permissionsMapper.insert(t);
		return isSuccess(result);
	}

	@Override
	public boolean delete(String idkey) throws SQLException {
		if(StringUtil.isBlank(idkey))return false;
		int id=Integer.parseInt(idkey);
		int result=permissionsMapper.deleteByPrimaryKey(id);
		return isSuccess(result);
	}

	@Override
	public boolean delete(PermissionsExample example) throws SQLException {
		int result=permissionsMapper.deleteByExample(example);
		return isSuccess(result);
	}

	@Override
	public boolean update(Permissions t) {
		int result=permissionsMapper.updateByPrimaryKey(t);
		return isSuccess(result);
	}

	@Override
	public Permissions load(String id) {
		if(StringUtil.isBlank(id))return null;
		int key=Integer.parseInt(id);
		return permissionsMapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Permissions> findList(GridRequest model) {
		return permissionsMapper.selectByExample(paramsToExample(model));
	}
	@Override
	public List<Permissions> findList(PermissionsExample example) {
		return permissionsMapper.selectByExample(example);
	}

	@Override
	public int maximum(GridRequest model) {
		return permissionsMapper.countByExample(paramsToExample(model));
	}

	@Override
	public int maximum(PermissionsExample example) {
		return permissionsMapper.countByExample(example);
	}
	
	private boolean isSuccess(int result) {
		if(result>0)return true;
		return false;
	}
	public PermissionsExample paramsToExample(GridRequest model) {
		PermissionsExample example=new PermissionsExample();
		if(model==null)return example;
		example.setPage(model.getSplitPage());
		//查询的字段，与查询参数对应
		String[] paramsName=model.getParamsName();
		//条件
		String[] condition=model.getCondition();
		//或与
		String orWith=model.getOrWith();
		//参数
		Object[] params=model.getParams();
		if(paramsName==null||condition==null||orWith==null||params==null)return example;
		Criteria criteria1 = example.createCriteria();
		for(int i=0;i<paramsName.length;i++) {
			if("or".equals(orWith)) {
				example.or().criteria.add(new Criterion(paramsName[i]+" "+condition[i]+" ",params[i]));
				continue;
			}
			criteria1.criteria.add(new Criterion(paramsName[i]+" "+condition[i]+" ",params[i]));
		}
		return example;
	}
}
