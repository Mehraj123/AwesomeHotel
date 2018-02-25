package com.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.entity.UserRegistration;
import com.demo.repository.custom.UserRegistrationCustomRepository;

/***
 * 
 * @author Iti Gupta
 * 
 *
 */
@Repository
public interface UserRegistrationRepository
		extends MongoRepository<UserRegistration, String>, UserRegistrationCustomRepository {

	//public Optional<UserRegistration> findByUsername(String username);
	
	public UserRegistration findByUsername(String username);
}
