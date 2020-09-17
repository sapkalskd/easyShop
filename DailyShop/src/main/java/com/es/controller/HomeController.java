package com.es.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.es.model.User;


@Controller
@RequestMapping("/es")
public class HomeController {

	@GetMapping("/e")
	public String showHomePage() {
		return "home";
	}
	
	@GetMapping("/register")
	public String showUserRegistrationPage(Model model) {
		model.addAttribute("registerUser", new User());
		return "RegisterUser";
	}
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@GetMapping("/forgatePassword")
	public String showForgatePassword() {
		return "forgatePassword";
	}
	
	@GetMapping("/resetPassword")
	public String showResetPassword() {
		return "login";
	}
	
	
}
