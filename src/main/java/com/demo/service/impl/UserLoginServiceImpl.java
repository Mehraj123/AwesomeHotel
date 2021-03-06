package com.demo.service.impl;

import static com.demo.error.LoginExceptionSupplier.LOGIN_NOT_SUCCESSFULL;
import static com.demo.error.UserRegistrationExceptionSupplier.USER_NOT_FOUND_EXCEPTION;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.demo.entity.UserRegistration;
import com.demo.error.CustomParameterizedException;
import com.demo.model.LoginVM;
import com.demo.repository.UserRegistrationRepository;
import com.demo.security.jwt.JWTConfigurer;
import com.demo.security.jwt.TokenProvider;
import com.demo.service.UserLoginService;

/***
 * Implementation of UserLoginService
 * 
 * @author Mehraj Malik
 * @version 1.0
 *
 */
@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	private TokenProvider tokenProvider;

	private static final Logger log = LoggerFactory.getLogger(UserLoginServiceImpl.class);

	private final AuthenticationManager authenticationManager;

	private UserRegistrationRepository userRegistrationRepository;

	public UserLoginServiceImpl(AuthenticationManager authenticationManager,
			UserRegistrationRepository userRegistrationRepository,TokenProvider tokenProvider) {
		this.authenticationManager = authenticationManager;
		this.userRegistrationRepository = userRegistrationRepository;
		this.tokenProvider=tokenProvider;
	}

	@Override
	public String login(LoginVM loginVM, HttpServletResponse response) {

		try {
			UserRegistration user = userRegistrationRepository.findByUsername(loginVM.getUsername());
			if (user != null) {
				boolean rememberMe = (loginVM.isRememberMe() == null) ? false : loginVM.isRememberMe();
				// generate token
				UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
						loginVM.getUsername(), loginVM.getPassword());
				Authentication authentication = this.authenticationManager.authenticate(authenticationToken);
				SecurityContextHolder.getContext().setAuthentication(authentication);

				log.info("Login Successfull :)");
				String jwt = tokenProvider.createToken(authentication);
				response.addHeader(JWTConfigurer.AUTHORIZATION_HEADER, "Bearer " + jwt);
				response.addHeader("Access-Control-Expose-Headers", "Authorization");

				return "Login Successfull :)";

			} else {
				throw USER_NOT_FOUND_EXCEPTION.get();
			}
		} catch (CustomParameterizedException e) {
			throw e;
		} catch (Exception e) {
			throw LOGIN_NOT_SUCCESSFULL.get();
		}

	}
}
