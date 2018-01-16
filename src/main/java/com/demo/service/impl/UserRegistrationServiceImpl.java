package com.demo.service.impl;

import static com.demo.error.UserRegistrationExceptionSupplier.EMAIL_NOT_UNIQUE;
import static com.demo.error.UserRegistrationExceptionSupplier.PHONE_NUMBER_NOT_UNIQUE;
import static com.demo.error.UserRegistrationExceptionSupplier.USERNAME_NOT_UNIQUE;
import static com.demo.error.UserRegistrationExceptionSupplier.USER_REGISTRATION_EXCEPTION;

import java.util.Date;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.entity.UserRegistration;
import com.demo.error.CustomParameterizedException;
import com.demo.model.UserRegistrationVM;
import com.demo.mv.UserRegistrationMV;
import com.demo.repository.UserRegistrationRepository;
import com.demo.service.UserRegistrationService;

/***
 * Implementation of {@code RegistrationService}
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserRegistrationMV userRegistration(UserRegistrationVM userRegistrationVM) {

		try {
			UserRegistration user = modelMapper.map(userRegistrationVM, UserRegistration.class);

			// set full name
			user.setFullName(user.getFirstName() + " " + user.getLastName());
			user.setRegistrationDate(new Date());
			// password encryption
			user.setPassword(passwordEncoder.encode(user.getPassword()));

			if (!userRegistrationRepository.findUserByEmailId(user.getEmail())) {
				throw EMAIL_NOT_UNIQUE.get();
			}

			if (!userRegistrationRepository.findUserByPhoneNumber(user.getPhoneNumber())) {
				throw PHONE_NUMBER_NOT_UNIQUE.get();
			}

			if (!userRegistrationRepository.findUserByUsername(user.getUsername())) {
				throw USERNAME_NOT_UNIQUE.get();
			}

			UserRegistration userRegistration = userRegistrationRepository.save(user);

			return modelMapper.map(userRegistration, UserRegistrationMV.class);
		} catch (CustomParameterizedException exception) {
			throw USER_REGISTRATION_EXCEPTION.get();
		}
	}

}
