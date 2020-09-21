package com.es.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.model.User;


@Controller
@RequestMapping("/ds")
public class HomeController {

	@GetMapping("/")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showUserRegistrationPage(Model model) {
		model.addAttribute("user", new User());
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
