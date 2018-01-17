package com.demo.service;

import com.demo.model.UserRegistrationVM;
import com.demo.mv.UserRegistrationMV;

/***
 * Contract for {@code RegistrationServiceImpl}
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public interface UserRegistrationService {

	public UserRegistrationMV userRegistration(UserRegistrationVM userRegistrationVM);

}
