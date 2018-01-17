package com.demo.controller;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.UserRegistrationVM;
import com.demo.service.UserRegistrationService;
import com.demo.successcode.UserRegistrationSuccessCode;
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
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
public class RegistrationController {

	private UserRegistrationService userRegistrationService;
	
	public RegistrationController(UserRegistrationService userRegistrationService) {
		this.userRegistrationService=userRegistrationService;
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> userRegistration(@RequestBody @Valid UserRegistrationVM userRegistrationVM) {

		return new ResponseEntity<>(new CustomResponse(UserRegistrationSuccessCode.USER_CREATED.getCode(),
				UserRegistrationSuccessCode.USER_CREATED.getMessage(), userRegistrationService.userRegistration(userRegistrationVM), null), HttpStatus.OK);

	}
}
