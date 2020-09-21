package com.es.controller;

import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.es.model.User;
import com.es.service.IUserService;
import com.es.util.EmailUtilUserReg;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private EmailUtilUserReg emailUtil;


	@PostMapping("/processRegistration")
	public String saveUser(@ModelAttribute User user, Model model){
		Integer id = null;
		String msg = null;
		String page = null;
		
		/*//check data save or not
		if( null != errors && errors.getErrorCount() > 0) {
			
			return "RegisterUser";

		}*/
			
			//save user data into database
			id = userService.saveUser(user);

			if(id != null || id > 0) {
				//send email to user
				new Thread(new Runnable() {

					@Override
					public void run() {
						boolean flag = emailUtil.sendEmail(user.getEmail(),
								"easy Shop User Registration ",
								" Registraion successful with username :"
										+user.getEmail()+" password :"+user.getPassword()+"",
										null,null,null);
					}
				}).start();

				msg = "Registation Successful";
				model.addAttribute("successMsg", msg);

				//form backing object
				model.addAttribute("registerUser", new User());
				page = "RegisterUserSuccess";
				
			}
			else {
				msg = "Registration fail....Please try again....!";
				model.addAttribute("errorMsg", msg);
				page = "RegisterUser";

			}
		return page;
	}//saveUser() end
	
	@PostMapping("/forgetPassword")
	public String forgetPassword(@RequestParam String email,Model model) {
		String msg = null;
		String page = null;
		
		//check e-mail is exist or not
		boolean flag = userService.isEmailExist(email);
		
		if(flag) {
			
		}
		
		return "";
		
		
	}
	
	
	
	
	
	

	//Email Validation
	@GetMapping("/validateEmail")
	public @ResponseBody String validateEmail(
							@RequestParam String mail,
							@RequestParam Integer id) 
	{
		String message = null;
		
		if(id == 0 && userService.isEmailExist(mail)) {
			message = "User e-mail '"+ mail +"' is already exist";
		}
	//	else if(userService.isUserEmailCountExistForEdit(mail,id)) {
		//	message = "User e-mail '"+ mail +"' is already exist";
	//	}
		return message;
	}

	@GetMapping("/setup")
	public String doSetup(Principal p,Model model, HttpSession session) {
		String email = p.getName();
		System.out.println("E-mail------->"+email);
		
		User user = userService.findByEmail(email).get();
		model.addAttribute("userOb", user);
		return "home";
	}//
	


}//class end
