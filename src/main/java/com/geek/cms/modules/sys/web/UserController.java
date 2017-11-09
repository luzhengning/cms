package com.geek.cms.modules.sys.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresGuest;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.subject.Subject;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geek.cms.modules.sys.entity.User;
import com.geek.cms.modules.sys.service.UserService;

/**
 * 用户调用接口
 * @author 路正宁
 * 
 */
@Controller
@RequestMapping("/user")
public class UserController {
	private UserService userService=new UserService();
	//跳转至登录页面
	@RequestMapping("/toLoginJsp")
	public ModelAndView ToLoginJsp() {
		return new ModelAndView("/Admin/login");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user,HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException {
		// TODO 登录测试
		user.setAccount("asd");
		user.setPassword("asdf");
		Map<String, String> model=new HashMap<String, String>();
		if(user!=null){
			if(user.getAccount()==null)
				return new ModelAndView( "redirect:/user/toLoginJsp",model);
		}
		user.setAccount(new String(user.getAccount().getBytes("ISO-8859-1"),"UTF-8"));
		String username = user.getAccount();
        String password = user.getPassword();
        //用户输入的验证码
        String userValidationCode = request.getParameter("validationCode");
        //系统验证码
        String sysValidationCode = (String)session.getAttribute("validation_code");
        // TODO 测试用户名和密码
        username="15002653994";
        password="1235";
       
        
        //List<currentUser> users = userService.getAllUsers();
        password=new Md5Hash(password,username).toString();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        //String userID = (String) currentUser.getPrincipal();  
        //session.setAttribute("USERNAME", userID);  
        try { 
        	token.setRememberMe(true);
            currentUser.login(token);
            System.out.println("认证成功");
            session.setAttribute("username", user.getAccount());
            currentUser.hasRole(username); 
            //currentUser.isPermitted(username);  
        } catch (IncorrectCredentialsException ice) {
            // 捕获密码错误异常
            ModelAndView mv = new ModelAndView("redirect:/front/tologin");
            mv.addObject("message", "password error!");
            return mv;
        } catch (UnknownAccountException uae) {
            // 捕获未知用户名异常
            ModelAndView mv = new ModelAndView("redirect:/front/tologin");
            mv.addObject("message", "username error!");
            return mv;
        } catch (ExcessiveAttemptsException eae) {
            // 捕获错误登录过多的异常
            ModelAndView mv = new ModelAndView("redirect:/front/tologin");
            mv.addObject("message", "times error");
            return mv;
        } catch (AuthenticationException e) {
            e.printStackTrace();
            System.out.println("认证失败");
            return new ModelAndView( "redirect:/front/tologin",model);
        }
        //user = userService.(username);
        //subject.getSession().setAttribute("user", user);
        //return new ModelAndView("success");
        return new ModelAndView( "redirect:/admin/administrators",model);
	}
	int ticket=2;  
	@RequiresGuest
	@RequestMapping("/test")
	public void test() {
		//简单的解决办法
				synchronized(this){
					if(ticket>0){
						System.out.println("你买到票");
						ticket--;
					}else{
						System.out.println("你咩有买到票");
					}
				}
	}
}
