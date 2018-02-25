package com.demo.repository.custom;

/***
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public interface UserRegistrationCustomRepository {

	public Boolean findUserByEmailId(String email);

	public Boolean findUserByPhoneNumber(String phone);

	public Boolean findUserByUsername(String userName);

}
