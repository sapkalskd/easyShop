package com.es.service;

import java.util.Optional;

import com.es.model.User;

public interface IUserService {

	Integer saveUser(User user);

	void updateUser(User user);

	void deleteUser(Integer id);

	Optional<User> getOneUser(Integer id);

	boolean isUserExist(Integer id);

	boolean isEmailExist(String email);

	boolean isPhoneNoExist(long phone);

	Optional<User> findByEmail(String email);

//	boolean isUserEmailCountExistForEdit(String mail, Integer id); 



}
