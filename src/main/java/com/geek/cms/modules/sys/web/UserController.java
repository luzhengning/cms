package com.geek.cms.modules.sys.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.geek.cms.modules.json.Json;
import com.geek.cms.modules.json.JsonMessage;
import com.geek.cms.modules.json.JsonUtil;
import com.geek.cms.modules.sys.dao.RoleDao;
import com.geek.cms.modules.sys.dao.UserDao;
import com.geek.cms.modules.sys.entity.Permissions;
import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.service.UserService;
import com.geek.cms.plugin.grid.Page.SplitJsonModel;
import com.geek.cms.plugin.grid.Page.SplitPage;
import com.geek.cms.plugin.grid.gridReq.Grid;
import com.geek.cms.plugin.grid.gridReq.GridRequest;
import com.geek.cms.plugin.grid.gridReq.SplitGridRequestUtil;
import com.geek.cms.utils.StringUtil;
import com.geek.cms.utils.TimeUtil;
import com.sdicons.json.mapper.MapperException;

/**
 * 用户Controller
 * @author luzhengning 2017年11月21日 下午3:54:28
 */
@Controller()
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserDao userDao;
	@Autowired
	RoleDao roleDao;

	// 跳转到登录页面
	@RequestMapping("/toLoginJsp")
	public ModelAndView ToLoginJsp() {
		return new ModelAndView("/Admin/login");
	}

	/**
	 * 用户登录
	 * @param user
	 * @param session
	 * @param request
	 * @return
	 * @throws UnsupportedEncodingException
	 * @throws ServletException 
	 */
	@RequestMapping(name="asdf",value="/login")
	public ModelAndView login(@ModelAttribute("user") User user, HttpSession session, HttpServletRequest request)
			throws UnsupportedEncodingException, ServletException {
		user.setAccount("asd");
		user.setPassword("asdf");
		Map<String, String> model = new HashMap<String, String>();
		if (user != null) {
			if (user.getAccount() == null)
				return new ModelAndView("redirect:/user/toLoginJsp", model);
		}
		user.setAccount(new String(user.getAccount().getBytes("ISO-8859-1"), "UTF-8"));
		String username = user.getAccount();
		String password = user.getPassword();
		// 获取用户验证码
		String userValidationCode = request.getParameter("validationCode");
		// 获取系统验证码
		String sysValidationCode = (String) session.getAttribute("validation_code");
		// TODO 测试账号密码
		username = "15002653994";
		password = "1235";

		// 加密密码
		password = new Md5Hash(password, username).toString();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		Subject currentUser = SecurityUtils.getSubject();
		try {
			token.setRememberMe(true);
			currentUser.login(token);
			System.out.println("登录认证成功！");
			session.setAttribute("username", user.getAccount());
			currentUser.hasRole(username);
			// currentUser.isPermitted(username);
		} catch (IncorrectCredentialsException ice) {
			// 密码错误
			ModelAndView mv = new ModelAndView("redirect:/front/tologin");
			mv.addObject("message", "password error!");
			return mv;
		} catch (UnknownAccountException uae) {
			// 用户名错误
			ModelAndView mv = new ModelAndView("redirect:/front/tologin");
			mv.addObject("message", "username error!");
			return mv;
		} catch (ExcessiveAttemptsException eae) {
			// 身份过期
			ModelAndView mv = new ModelAndView("redirect:/front/tologin");
			mv.addObject("message", "times error");
			return mv;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			System.out.println("身份验证失败！");
			return new ModelAndView("redirect:/front/tologin", model);
		}
		// user = userService.(username);
		// subject.getSession().setAttribute("user", user);
		// return new ModelAndView("success");
		return new ModelAndView("redirect:/admin/administrators", model);
	}
	/**
	 * 权限表单
	 * @param request
	 * @param response
	 * @return
	 * @throws MapperException 
	 */
	@RequestMapping("/grid")
	public ModelAndView grid(HttpServletRequest request,HttpServletResponse response) throws MapperException {
		//String user=request.getParameter("user");
		//创建表格对象
		Grid grid=new Grid();
		//页名
		grid.setTitle("用户管理");
		//路径 查询普通用户
		grid.setLoadJsonUrl("/user/load");
		//编辑路径
		grid.setEditUrl("/user/form");
		//删除路径
		grid.setDeleteUrl("/user/delete");
		//要显示的列
		grid.setGridColumn(userDao.assemblySql);
		//分页初始化
		SplitPage page=new SplitPage();
		page.setTotalRow(userDao.maximum(new GridRequest()));
		page.setPageRow(10);
		grid.setPage(page);
		Map<String, Object> model=grid.getModel(grid);
		
		return new ModelAndView("/UiPlugin/grid",model);
	}
	@RequestMapping("/load")
	public void loadJson(HttpServletRequest request, HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			response.setCharacterEncoding("UTF-8");
			out=response.getWriter();
			GridRequest model=SplitGridRequestUtil.getModel(request, userDao);
			List<User> list=userDao.findList(model);
			SplitJsonModel<User> jsonModel=new SplitJsonModel<User>(list, model.getSplitPage());
			if(!StringUtil.isBlank(jsonModel)) {
				json=Json.setSuccess(json);
				json.setData(JsonUtil.objectToJsonStr(jsonModel));
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/form")
	public ModelAndView roleForm(HttpServletRequest request) throws MapperException{
		Map<String, Object> model=new HashMap<String, Object>();
		//分页
		SplitPage page=new SplitPage();
		page.setTotalRow(roleDao.maximum(new GridRequest()));
		page.setPageRow(10);
		model.put("page",page);
		model.put("pageJsonData", JsonUtil.objectToJsonStr(page));
		String id=request.getParameter("id");
		if(id==null){
			//添加权限
			model.put("submitUrl", "/user/add");
			model.put("user", new User(0));
		}else{
			//编辑权限
			User user=userDao.load(id);
			user.setRole(roleDao.findByIds(user.getRoleId().split(",")));
			model.put("user", user);
			model.put("submitUrl", "/user/edit");
		}
		return new ModelAndView("Admin/form/userForm",model);
	}
	@RequestMapping("/edit")
	public void edit(User user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			if(StringUtil.isBlank(user)) {
				json.setMsg("参数异常！");
				return;
			}
			if(userDao.update(user)){
				json=Json.setSuccess(json);
				json.setMsg("编辑成功！");
			}else{
				json=Json.setError(json);
				json.setMsg("编辑失败！");
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/add")
	public void add(User user,HttpServletRequest request,HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			if(StringUtil.isBlank(user)) {
				json.setMsg("参数异常！");
				return;
			}
			user.setRegistrationTime(TimeUtil.getTime());
			if(userDao.add(user)){
				json=Json.setSuccess(json);
				json.setMsg("保存成功！");
			}else{
				json=Json.setError(json);
				json.setMsg("保存失败！");
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws IOException{
		JsonMessage json=new JsonMessage();
		PrintWriter out=null;
		try {
			out=response.getWriter();
			String id=request.getParameter("id");
			if(userDao.delete(id)){
				json=Json.setSuccess(json);
				json.setMsg("删除成功！");
			}else{
				json=Json.setError(json);
				json.setMsg("删除失败！");
			}
		}catch(Exception ex) {
			json=Json.setException(json, ex);
		}finally {
			out.print(JsonUtil.objectToJsonStr(json));
		}
	}
	@RequestMapping("/get")
	//属于user或者admin之一;修改logical为OR 即可
	//@RequiresRoles(value={"user","13242"},logical=Logical.AND)
	public void get() {
		User user=userDao.load("1");
	}

}
