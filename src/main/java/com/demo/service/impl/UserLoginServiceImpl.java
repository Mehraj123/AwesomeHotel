package com.demo.service.impl;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.demo.model.LoginVM;
import com.demo.security.config.JWTConfigurer;
import com.demo.security.config.TokenProvider;
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

	private final AuthenticationManager authenticationManager;
	
	private final TokenProvider tokenProvider;

	public UserLoginServiceImpl(TokenProvider tokenProvider, AuthenticationManager authenticationManager) {
		this.tokenProvider = tokenProvider;
		this.authenticationManager = authenticationManager;
	}
	
	@Override
	public String login(LoginVM loginVM, HttpServletResponse response) {
		try {
			UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
					loginVM.getUsername(), loginVM.getPassword());

			Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
			SecurityContextHolder.getContext().setAuthentication(authentication);

			boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
			String jwt = tokenProvider.createToken(authentication, rememberMe);
			response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
			response.addHeader("Access-Control-Expose-Headers", "Authorization");
		} catch (AuthenticationException exception) {
			throw exception;
		}
		return null;
	}

}
