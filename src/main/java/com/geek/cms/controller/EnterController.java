package com.geek.cms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.geek.cms.modules.sys.service.SysMenuService;
import com.sdicons.json.mapper.MapperException;

/**
 * @author luzhengning
 *
 */
@Controller
@RequestMapping("/admin")
public class EnterController {
	
	/**
	 * 管理员页面
	 * @return
	 */
	@RequestMapping("/administrators")
	public ModelAndView administrators(){
		return new ModelAndView("/Admin/Administrators");
	}
	/**
	 * 管理员页面
	 * @return
	 */
	@RequestMapping("/admin")
	public ModelAndView admin(){
		return new ModelAndView("/Admin/Admin");
	}
}
