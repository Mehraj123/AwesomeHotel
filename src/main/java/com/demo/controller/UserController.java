package com.demo.controller;

import static com.demo.successcode.UserRegistrationSuccessCode.USER_CREATED;
import static com.demo.successcode.UserRegistrationSuccessCode.USER_LOGIN_SUCCESS;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.LoginVM;
import com.demo.model.UserRegistrationVM;
import com.demo.service.UserLoginService;
import com.demo.service.UserRegistrationService;
import com.demo.util.CustomResponse;

/***
 * 
 * REST Controller for User Registration
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/users")
// @CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class UserController {

	private UserRegistrationService userRegistrationService;
	private UserLoginService userLoginService;

	public UserController(UserRegistrationService userRegistrationService, UserLoginService userLoginService) {
		this.userRegistrationService = userRegistrationService;
		this.userLoginService = userLoginService;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> registration(@RequestBody @Valid UserRegistrationVM userRegistrationVM) {

		return new ResponseEntity<>(new CustomResponse(USER_CREATED.getCode(), USER_CREATED.getMessage(),
				userRegistrationService.userRegistration(userRegistrationVM), null), HttpStatus.OK);

	}

	@PostMapping(value="/login", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> login(@RequestBody @Valid LoginVM loginVM) {

		/*
		 * UsernamePasswordAuthenticationToken authenticationToken = new
		 * UsernamePasswordAuthenticationToken( loginVM.getUsername(),
		 * loginVM.getPassword());
		 */
		return new ResponseEntity<>(new CustomResponse(USER_LOGIN_SUCCESS.getCode(), USER_LOGIN_SUCCESS.getMessage(),
				userLoginService.login(loginVM), null), HttpStatus.OK);

	}
}
