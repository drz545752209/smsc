package com.hlju.mall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.hlju.mall.domain.User;
import com.hlju.mall.service.UserService;

@Controller
public class AuthController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, value = { "/register", "/register.html" })
	public ModelAndView register(User user, HttpServletRequest httpServletRequest) {
		ModelAndView mav = new ModelAndView();

		String verificationCode = (String) httpServletRequest.getSession().getAttribute("verificationCode");
		String clientVCode = httpServletRequest.getParameter("verificationCode");

		if (verificationCode.equals(clientVCode)) {
			// 验证成功
			userService.insertSelective(user);
			mav.setViewName("/login");
		} else {
			// 失败
			mav.addObject("msg", "验证码错误");
			mav.setViewName("register");
		}
		return mav;
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/login", "/login.html" })
	public String login() throws Exception {
		return "login";
	}
	
	@RequestMapping(method = RequestMethod.GET, value = { "/index", "/index.html" })
	public String toIndex() throws Exception {
		return "index";
	}
	

	@RequestMapping(method=RequestMethod.POST,value= {"/user/login"})
	public ModelAndView loginValidate(User user,HttpServletRequest res) {
		boolean isValidate=userService.hasPassword(user);
		ModelAndView mav=new ModelAndView();
		if(isValidate) {
			HttpSession session= res.getSession();
			session.setAttribute("loginName", user.getUsername());
			mav.setViewName("redirect:/index");
		}else {
			mav.setViewName("/login");
		}
		return mav;
	}

}
