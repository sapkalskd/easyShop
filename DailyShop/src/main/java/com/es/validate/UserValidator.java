package com.es.validate;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.es.model.User;
import com.es.service.IUserService;

//@Component
public class UserValidator {

	@Autowired
	private IUserService service;
	
	public Map<String, String> validate(User user){
		
		Map<String, String> errors = new HashMap<>();
		
		if(user.getFirstName() == null || user.getFirstName().isEmpty()) {
			errors.put("firstName", "Please enter First Name");
		}
		
		if(user.getLastName() == null || user.getLastName().isEmpty()) {
			errors.put("lastName", "Please enter Last Name");
		}
		
		
		if(user.getEmail() == null || user.getEmail().isEmpty()) {
			errors.put("email", "Please enter valid e-mail");
		}
		else if(service.isEmailExist(user.getEmail())) {
			errors.put("email", "E-mail already exist");
		}
		
		if(service.isPhoneNoExist(user.getPhoneNo())) {
			errors.put("phoneNo", "Phone No. is already exist.");
		}
		
		if(user.getPassword() == null || user.getPassword().isEmpty()) {
			errors.put("password", "Please enter password");
		}
		
		return errors;
		
	}
	
}
