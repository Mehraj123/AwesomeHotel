package com.demo.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;

import com.demo.model.LoginVM;
import com.demo.service.UserLoginService;

/***
 * Implementation of UserLoginService
 * 
 * @author Devendra.Kumar
 * @version 1.0
 *
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public String login(LoginVM loginVM, HttpServletResponse response) {
		return null;
	}

}
