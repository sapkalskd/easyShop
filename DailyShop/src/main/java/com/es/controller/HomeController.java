package com.es.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.model.User;
import com.es.util.CaptchaUtil;
import com.fasterxml.jackson.databind.Module.SetupContext;

import cn.apiclub.captcha.Captcha;


@Controller
@RequestMapping("/ds")
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showUserRegistrationPage(Model model) {
		User user = new User();
		CaptchaUtil.setupCaptcha(user);
		System.out.println("From Controller :"+user.getHidden());
		model.addAttribute("user",user);
		return "RegisterUser";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/forgetPassword")
	public String showForgatePassword() {
		return "ForgetPassword";
	}
	
	@GetMapping("/resetPassword")
	public String showResetPassword() {
		return "login";
	}
	
	
	
}
