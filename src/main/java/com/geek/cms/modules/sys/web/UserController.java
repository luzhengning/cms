package com.geek.cms.modules.sys.web;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
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
	@RequestMapping("/toLoginJsp")
	public ModelAndView ToLoginJsp() {
		return new ModelAndView("/Admin/login");
	}
	
	@RequestMapping("/login")
	public ModelAndView login(@ModelAttribute("user") User user,HttpSession session) throws UnsupportedEncodingException {
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
        return new ModelAndView( "redirect:/a/index",model);
	}
}
