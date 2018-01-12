package com.geek.cms.modules.sys.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geek.cms.modules.sys.dao.UserDao;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.entity.example.UserExample;
import com.geek.cms.modules.sys.entity.example.UserExample.Criteria;
import com.geek.cms.modules.sys.entity.example.UserExample.Criterion;
import com.geek.cms.modules.sys.mapper.UserMapper;
import com.geek.cms.plugin.grid.splitGridReq.GridRequest;
import com.geek.cms.utils.StringUtils;

@Service
public class UserService extends UserDao {

	@Autowired
	UserMapper userMapper;
	/**
	 * 登录
	 */
	public User login(User user) {
		UserExample example=new UserExample();
		Criteria c=example.createCriteria();
		c.andAccountEqualTo(user.getAccount());
		c.andPasswordEqualTo(user.getPassword());
		List<User> list=userMapper.selectByExample(example);
		if(list!=null)
			if(list.size()>0)return list.get(0);
		return null;
	 
	}
	@Override
	public boolean add(User t) {
		int result=userMapper.insert(t);
		return isSuccess(result);
	}

	@Override
	public boolean delete(String idkey) throws SQLException {
		if(StringUtils.isBlank(idkey))return false;
		int id=Integer.parseInt(idkey);
		UserExample example=new UserExample();
		example.or().andIdEqualTo(id);
		int result=userMapper.deleteByExample(example);
		return isSuccess(result);
	}

	@Override
	public boolean delete(UserExample example) throws SQLException {
		int result=userMapper.deleteByExample(example);
		return isSuccess(result);
	}

	@Override
	public boolean update(User t) {
		UserExample example=new UserExample();
		example.or().andIdEqualTo(t.getId());
		int result=userMapper.updateByExample(t, example);
		return isSuccess(result);
	}

	@Override
	public User load(String id) {
		if(StringUtils.isBlank(id))return null;
		int key=Integer.parseInt(id);
		UserExample example=new UserExample();
		example.or().andIdEqualTo(key);
		List<User> list=userMapper.selectByExample(example);
		if(list!=null)
			if(list.size()>0)return list.get(0);
		return null;
	}

	@Override
	public List<User> findList(GridRequest model) {
		return userMapper.selectByExample(paramsToExample(model));
	}
	@Override
	public List<User> findList(UserExample example) {
		return userMapper.selectByExample(example);
	}

	@Override
	public int maximum(GridRequest model) {
		return userMapper.countByExample(paramsToExample(model));
	}

	@Override
	public int maximum(UserExample example) {
		return userMapper.countByExample(example);
	}
	
	private boolean isSuccess(int result) {
		if(result>0)return true;
		return false;
	}
	public UserExample paramsToExample(GridRequest model) {
		UserExample example=new UserExample();
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
