package com.es.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.es.model.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	//to find e-mail exist or not
	Optional<User> findByEmail(String email);
	
	//to check username is available or not 
//	User findByUsername(String username);
	
	@Query("SELECT COUNT(U.email) FROM User U WHERE U.email =: mail ")
	public int getUserEmailCount(String email);
	
	@Query("SELECT COUNT(U.phoneNo) FROM User U WHERE U.phoneNo =: phone")
	public int getPhoneNoCount(long phone);

	
	//  @Query("SELECT COUNT(U.email) FROM RegisterUser U WHERE U.email=: mail AND U.id!=:uid") 
	 // public int isUserEmailIdExist(String mail, Integer uid);
	 
	

}
