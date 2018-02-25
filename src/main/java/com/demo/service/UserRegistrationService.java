package com.demo.service;

import org.springframework.data.domain.Pageable;

import com.demo.model.UserRegistrationVM;
import com.demo.mv.UserRegistrationMV;
import com.demo.util.PageableInfo;

/***
 * Contract for {@code UserRegistrationServiceImpl}
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
public interface UserRegistrationService {

	public UserRegistrationMV userRegistration(UserRegistrationVM userRegistrationVM);

	public PageableInfo<UserRegistrationMV> getAll(Pageable pageable);

}
