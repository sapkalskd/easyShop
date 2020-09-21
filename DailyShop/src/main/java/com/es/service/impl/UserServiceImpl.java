package com.es.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.es.model.User;
import com.es.repository.UserRepository;
import com.es.service.IUserService;

@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserRepository repository;

	@Override
	@Transactional
	public Integer saveUser(User user) {

		return repository.save(user).getId();
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		repository.save(user);

	}

	@Override
	@Transactional
	public void deleteUser(Integer id) {
		repository.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> getOneUser(Integer id) {

		return repository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isUserExist(Integer id) {

		return repository.existsById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isEmailExist(String email) {	
		return repository.getUserEmailCount(email) > 0 ? true : false;
	}

	@Override
	@Transactional(readOnly = true)
	public boolean isPhoneNoExist(long phone) {
		return repository.getPhoneNoCount(phone) > 0 ? true :false;

	}

	/*
	@Override
	@Transactional(readOnly = true) 
	public boolean isUserEmailCountExistForEdit(String mail, Integer id) { 
		return repository.isUserEmailIdExist(mail,id) > 0 ?true : false; 
	}
	 */

	@Override
	public Optional<User> findByEmail(String email) {
		return repository.findByEmail(email);
	}
	
	/**
	 * To Check one time password to reset password
	 */
	@Override
	public long getOneTimePassword(long number) {
		// TODO Auto-generated method stub
		return 0;
	}
}
