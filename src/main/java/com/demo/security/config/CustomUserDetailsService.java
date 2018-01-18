package com.demo.security.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entity.UserRegistration;
import com.demo.repository.UserRegistrationRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRegistrationRepository userRegistrationRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Optional<UserRegistration> optionalUsers = userRegistrationRepository.findByUsername(username);

		optionalUsers.orElseThrow(() -> new UsernameNotFoundException("Username not found"));
		return optionalUsers.map(CustomUserDetails::new).get();
	}

}
