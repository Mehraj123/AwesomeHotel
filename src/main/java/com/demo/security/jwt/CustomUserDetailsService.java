package com.demo.security.jwt;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.demo.entity.UserRegistration;
import com.demo.repository.UserRegistrationRepository;

/***
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	private UserRegistrationRepository userRegistrationRepository;

	public CustomUserDetailsService(UserRegistrationRepository userRegistrationRepository) {
		super();
		this.userRegistrationRepository = userRegistrationRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserRegistration user = userRegistrationRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), Collections.emptyList());
	}

}
