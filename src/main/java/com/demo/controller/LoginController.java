package com.demo.controller;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.LoginVM;
import com.demo.service.UserLoginService;
import com.demo.successcode.UserLoginSuccessCode;
import com.demo.util.CustomResponse;

/***
 * 
 * REST Controller for User Login
 * 
 * @author Devendra.Kumar
 * @version 1.0
 *
 */
@RestController
@RequestMapping("/authentication")
public class LoginController {

	@Autowired
	private UserLoginService userLoginService;

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CustomResponse> userLogin(@RequestBody @Valid LoginVM loginVM, HttpServletResponse response) {

		return new ResponseEntity<>(
				new CustomResponse(UserLoginSuccessCode.USER_LOGIN.getCode(),
						UserLoginSuccessCode.USER_LOGIN.getMessage(), userLoginService.login(loginVM, response), null),
				HttpStatus.OK);

	}
}
