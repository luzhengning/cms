package com.geek.cms.core.shiro.token;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import com.geek.cms.modules.sys.dao.PermissionsDao;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.dao.UserDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.modules.sys.entity.Role;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.entity.example.UserExample;
import com.geek.cms.modules.sys.service.PermissionService;
import com.geek.cms.modules.sys.service.RoleService;
import com.geek.cms.modules.sys.service.UserService;
import com.geek.cms.utils.StringUtil;


/**
 * 用户登录以及返回权限角色信息
 * @author 路正宁
 * @time:2017年10月13日 下午3:26:28
 */
public class AuthorizationRealm extends AuthorizingRealm {
	@Autowired
	private UserDao userService=null;
	@Autowired
	private RoleDao roleService=null;
	@Autowired
	private PermissionsDao permissionService=null;
	/**
	 * 验证角色权限信息
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		//获取用户账号
		//String account=(String)principals.fromRealm(getName()).iterator().next();
		//AuthorizationInfo接口的简单POJO实现，将角色和权限存储为内部属性
		User user=(User)(SecurityUtils.getSubject().getPrincipal());
		if(user==null)return null;
		SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
		//获取用户角色Id 
		String[] roleIds=StringUtil.strToArray(user.getRoleId(),",");
		//查询用户角色
		List<Role> roleList=roleService.findByIds(roleIds);
		if (roleList != null) {
			//提取角色名称
			Set<String> roleNames = new HashSet<String>();
	        for (Role role : roleList) {
	            roleNames.add(role.getRoleName());
	            System.out.println("角色："+role.getRoleName());
	        }
	        // 将角色名称提供给info
	        authorizationInfo.setRoles(roleNames);
	        //设置权限
            List<Permissions> permissionList=new ArrayList<Permissions>();
            String[] permissionIds=null;
            for(int i=0;i<roleList.size();i++) {
            	permissionIds=StringUtil.strToArray(roleList.get(i).getPermissionId(), ",");
            	//查询权限
            	List<Permissions> plist=permissionService.findByIds(permissionIds);
            	if(plist==null)continue;
            	permissionList.addAll(plist);
            }
            //添加角色
            Set<String> permissionNames = new HashSet<String>(); 
            for (Permissions permission : permissionList) {
                permissionNames.add(permission.getPermissionName());
                System.out.println("权限:"+permission.getPermissionName());
            }
            // 将权限名称提供给info
            authorizationInfo.setStringPermissions(permissionNames);
            return authorizationInfo;  
        } else {  
            return null;  
        } 
	}
	/**
	 * 登录认证
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		String account = ((String)token.getPrincipal()).trim();  //得到用户名  
        String password = new String((char[])token.getCredentials()).trim(); //得到密码  
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user=userService.login(user);
        if(null!=user) {  
        	/*if(enable.equales("1")) {
        		throw new DisabledAccountException("帐号已经禁止登录！");
        	}*/
        	//登录成功
        	return new SimpleAuthenticationInfo(user, password, getName());  
        }
        UserExample example=new UserExample();
        example.or().andAccountEqualTo(user.getAccount());
        if(userService.findList(example)==null)
        {
        	throw new UnknownAccountException(); //如果用户名错误
        }else
        {
        	throw new IncorrectCredentialsException(); //如果密码错误  
        }
        
	}
	/**
     * 清空当前用户权限信息
     */
	public  void clearCachedAuthorizationInfo() {
		PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}
	/**
	 * 指定principalCollection 清除
	 */
	public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
		SimplePrincipalCollection principals = new SimplePrincipalCollection(
				principalCollection, getName());
		super.clearCachedAuthorizationInfo(principals);
	}

}
