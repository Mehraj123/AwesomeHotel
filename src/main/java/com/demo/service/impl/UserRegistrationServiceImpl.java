package com.demo.service.impl;

import static com.demo.error.UserRegistrationExceptionSupplier.EMAIL_NOT_UNIQUE;
import static com.demo.error.UserRegistrationExceptionSupplier.PHONE_NUMBER_NOT_UNIQUE;
import static com.demo.error.UserRegistrationExceptionSupplier.USERNAME_NOT_UNIQUE;
import static com.demo.error.UserRegistrationExceptionSupplier.USER_FETCHED_EXCEPTION;
import static com.demo.error.UserRegistrationExceptionSupplier.USER_REGISTRATION_EXCEPTION;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.entity.UserRegistration;
import com.demo.error.CustomParameterizedException;
import com.demo.model.UserRegistrationVM;
import com.demo.mv.UserRegistrationMV;
import com.demo.repository.UserRegistrationRepository;
import com.demo.service.UserRegistrationService;
import com.demo.util.PageInfo;
import com.demo.util.PageableInfo;

/***
 * Implementation of {@code RegistrationService}
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
@Service
public class UserRegistrationServiceImpl implements UserRegistrationService {

	private static final Logger logger = LoggerFactory.getLogger(UserRegistrationServiceImpl.class);

	private ModelMapper modelMapper;

	private UserRegistrationRepository userRegistrationRepository;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserRegistrationServiceImpl(ModelMapper modelMapper, UserRegistrationRepository userRegistrationRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.modelMapper = modelMapper;
		this.userRegistrationRepository = userRegistrationRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	/**
	 * Registers a User
	 * 
	 * @param userRegistrationVM
	 *            ViewModel for {@code User}
	 * @throws USERNAME_NOT_UNIQUE
	 *             If the username is not unique
	 * @throws PHONE_NUMBER_NOT_UNIQUE
	 *             If phone number is not unique
	 * @throws EMAIL_NOT_UNIQUE
	 *             If the email is not unique
	 */
	@Override
	public UserRegistrationMV userRegistration(UserRegistrationVM userRegistrationVM) {

		try {
			UserRegistration user = modelMapper.map(userRegistrationVM, UserRegistration.class);

			// set full name
			user.setFullName(user.getFirstName() + " " + user.getLastName());
			SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			user.setRegistrationDate(sdf.format(new Date()));
			// password encryption

			user.setPassword(bCryptPasswordEncoder.encode(userRegistrationVM.getPassword()));

			if (userRegistrationRepository.findUserByEmailId(user.getEmail())) {
				if (userRegistrationRepository.findUserByPhoneNumber(user.getPhoneNumber())) {
					if (userRegistrationRepository.findUserByUsername(user.getUsername())) {
						UserRegistration userRegistration = userRegistrationRepository.save(user);
						UserRegistrationMV registrationMV = modelMapper.map(userRegistration, UserRegistrationMV.class);
						logger.info("User registration is done for {}", registrationMV.getFullName());
						return registrationMV;
					} else {
						logger.info("Username {} is already taken", user.getUsername());
						throw USERNAME_NOT_UNIQUE.get();
					}
				} else {
					logger.info("phone number {} is already taken", user.getPhoneNumber());
					throw PHONE_NUMBER_NOT_UNIQUE.get();
				}
			} else {
				logger.info("Email {} is already taken", user.getEmail());
				throw EMAIL_NOT_UNIQUE.get();
			}
		} catch (CustomParameterizedException e) {
			logger.error("--- CustomParameterizedException {} ", e);
			throw e;
		} catch (Exception e) {
			logger.error("--- Exception occured while registering demo {} ", e);
			throw USER_REGISTRATION_EXCEPTION.get();
		}
	}

	/***
	 * To get all the users
	 * 
	 * @author Iti Gupta
	 * 
	 */
	@Override
	public PageableInfo<UserRegistrationMV> getAll(Pageable pageable) {
		try {
			Page<UserRegistration> user = userRegistrationRepository.findAll(pageable);
			PageableInfo<UserRegistrationMV> pageableInfo = new PageableInfo<>();
			if (!user.getContent().isEmpty()) {
				pageableInfo.setContent(Arrays.asList(modelMapper.map(user.getContent(), UserRegistrationMV[].class)));
			} else {
				pageableInfo.setContent(Collections.emptyList());
			}
			pageableInfo.setPageInfo(modelMapper.map(user, PageInfo.class));
			return pageableInfo;
		} catch (Exception e) {
			throw USER_FETCHED_EXCEPTION.get();
		}
	}

}
