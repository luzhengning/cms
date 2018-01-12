package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.example.RoleExample;
import com.geek.cms.modules.sys.entity.example.RoleExample.Criteria;
import com.geek.cms.modules.sys.entity.example.RoleExample.Criterion;
import com.geek.cms.modules.sys.mapper.RoleMapper;
import com.geek.cms.plugin.grid.splitGridReq.GridRequest;
import com.geek.cms.utils.Converts;
import com.geek.cms.utils.StringUtils;

@Service
public class RoleService extends RoleDao {

	@Autowired
	RoleMapper roleMapper;
	/**
	 * 查询多个角色
	 */
	@Override
	public List<Role> findByIds(String[] ids) {
		RoleExample example=new RoleExample();
		example.or().andIdIn(Converts.ArrayToListInteger(ids));
		List<Role> result=roleMapper.selectByExample(example);
		return result;
	}

	@Override
	public boolean add(Role t) {
		int result=roleMapper.insert(t);
		return isSuccess(result);
	}

	@Override
	public boolean delete(String idkey) throws SQLException {
		if(StringUtils.isBlank(idkey))return false;
		int id=Integer.parseInt(idkey);
		int result=roleMapper.deleteByPrimaryKey(id);
		return isSuccess(result);
	}

	@Override
	public boolean delete(RoleExample example) throws SQLException {
		int result=roleMapper.deleteByExample(example);
		return isSuccess(result);
	}

	@Override
	public boolean update(Role t) {
		int result=roleMapper.updateByPrimaryKey(t);
		return isSuccess(result);
	}

	@Override
	public Role load(String id) {
		if(StringUtils.isBlank(id))return null;
		int key=Integer.parseInt(id);
		return roleMapper.selectByPrimaryKey(key);
	}

	@Override
	public List<Role> findList(GridRequest model) {
		return roleMapper.selectByExample(paramsToExample(model));
	}
	@Override
	public List<Role> findList(RoleExample example) {
		return roleMapper.selectByExample(example);
	}

	@Override
	public int maximum(GridRequest model) {
		return roleMapper.countByExample(paramsToExample(model));
	}

	@Override
	public int maximum(RoleExample example) {
		return roleMapper.countByExample(example);
	}
	
	private boolean isSuccess(int result) {
		if(result>0)return true;
		return false;
	}
	public RoleExample paramsToExample(GridRequest model) {
		RoleExample example=new RoleExample();
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
