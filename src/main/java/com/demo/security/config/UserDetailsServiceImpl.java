package com.demo.security.config;

import static java.util.Collections.emptyList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entity.UserRegistration;
import com.demo.repository.UserRegistrationRepository;

/***
 * 
 * @author Iti Gupta
 * @version 1.0
 *
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private UserRegistrationRepository userRegistrationRepository;

	public UserDetailsServiceImpl(UserRegistrationRepository userRegistrationRepository) {
		this.userRegistrationRepository = userRegistrationRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserRegistration user = userRegistrationRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}
		return new User(user.getUsername(), user.getPassword(), emptyList());
	}

}
