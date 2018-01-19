package com.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.LoginVM;
import com.demo.service.UserLoginService;
import static com.demo.successcode.UserLoginSuccessCode.*;
import static com.demo.successcode.UserRegistrationSuccessCode.*;
import com.demo.util.CustomResponse;

/***
 * 
 * REST Controller for User Login
 * 
 * @author Devendra.Kumar
 * @version 1.0
 *
 */
@RestController("/login")
public class LoginController {

	private UserLoginService userLoginService;

	public LoginController(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> userRegistration(@RequestBody @Valid LoginVM loginVM) {

		/*
		 * UsernamePasswordAuthenticationToken authenticationToken = new
		 * UsernamePasswordAuthenticationToken( loginVM.getUsername(),
		 * loginVM.getPassword());
		 */
		return new ResponseEntity<>(new CustomResponse(USER_CREATED.getCode(), USER_LOGIN_SUCCESS.getMessage(),
				userLoginService.login(loginVM), null), HttpStatus.OK);

	}
}
