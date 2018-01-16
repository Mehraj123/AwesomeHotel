package com.demo.repository.custom.impl;

import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.demo.entity.UserRegistration;
import com.demo.repository.custom.UserRegistrationCustomRepository;
import com.demo.util.UserConstants;

/***
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public class UserRegistrationImpl implements UserRegistrationCustomRepository {

	@Autowired
	private MongoTemplate mongoTemplate;

	/***
	 * To check if Email is unique
	 * 
	 * @author Iti Gupta
	 * 
	 */
	@Override
	public Boolean findUserByEmailId(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where(UserConstants.EMAIL).regex(Pattern.compile(email, Pattern.CASE_INSENSITIVE)));
		List<UserRegistration> users = mongoTemplate.find(query, UserRegistration.class);
		if (users.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/***
	 * To check if phone number is unique
	 * 
	 * @author Iti Gupta
	 */
	@Override
	public Boolean findUserByPhoneNumber(String phone) {
		Query query = new Query();
		query.addCriteria(
				Criteria.where(UserConstants.PHONE_NUMBER).regex(Pattern.compile(phone, Pattern.CASE_INSENSITIVE)));
		List<UserRegistration> users = mongoTemplate.find(query, UserRegistration.class);
		if (users.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

	/***
	 * To check if Username is unique
	 * 
	 * @author Iti Gupta
	 */
	@Override
	public Boolean findUserByUsername(String userName) {
		Query query = new Query();
		query.addCriteria(
				Criteria.where(UserConstants.USER_NAME).regex(Pattern.compile(userName, Pattern.CASE_INSENSITIVE)));
		List<UserRegistration> users = mongoTemplate.find(query, UserRegistration.class);
		if (users.isEmpty()) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}
	}

}
