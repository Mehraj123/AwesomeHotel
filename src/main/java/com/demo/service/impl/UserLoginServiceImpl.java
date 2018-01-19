package com.demo.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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

	
	private static final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public String login(LoginVM loginVM, HttpServletResponse response) {
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
				loginVM.getUsername(), loginVM.getPassword());
		try {
			Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();

			log.info("Login Successfull :)");
		return "Successfull login!";
	}catch (Exception e) {
		
		throw e;
	}

}
}

