package com.geek.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.geek.cms.modules.sys.dao.PermissionsDao;
import com.geek.cms.modules.sys.dao.SysMenuDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.SysMenu;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.entity.example.PermissionsExample;
import com.geek.cms.modules.sys.entity.example.SysMenuExample;
import com.geek.cms.modules.sys.entity.example.PermissionsExample.Criteria;
import com.geek.cms.modules.sys.entity.example.PermissionsExample.Criterion;
import com.geek.cms.modules.sys.mapper.PermissionsMapper;
import com.geek.cms.modules.sys.mapper.RoleMapper;
import com.geek.cms.modules.sys.mapper.SysMenuMapper;
import com.geek.cms.modules.sys.mapper.UserMapper;
import com.geek.cms.plugin.grid.splitGridReq.GridRequest;
import com.geek.cms.plugin.grid.splitPage.SplitPage;

/**
 * 测试
 * @author luzhengning
 * 2018年1月9日 上午10:02:52
 */
@Controller
@RequestMapping("/test")
public class test {
	
	@Autowired
	SysMenuDao dao;
	
	@RequestMapping("/a")
	public void administrators(){
		SysMenuExample example=new SysMenuExample();
		/*example.setOrderByClause("sort_num DESC");
		example.or().andParentIdEqualTo(0);*/
		
		SplitPage page=new SplitPage();
		page.setTotalRow(dao.maximum(example));
		page.setPageRow(3);
		example.setPage(page);
		
		example.page.toNewPage("1");
		List<SysMenu> menu=dao.findList(example);
		
		example.page.toNewPage("2");
		List<SysMenu> menu1=dao.findList(example);
		
		example.page.toNewPage("3");
		List<SysMenu> menu2=dao.findList(example);
	}
}
