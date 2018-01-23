package com.demo.security.jwt;

import java.util.Collection;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

public class CustomUserDetails implements UserDetails {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4184780942996851447L;
	private  final String id;
	private  final String username;
	private  final String password;
	private   String isLocked;
	private   String isBlocked;
	private  final String mobileNumber;
	private final  Collection<? extends GrantedAuthority> authorities;
	private final String token;
	
	public CustomUserDetails(String id,String lowercaseLogin, String password, String mobileNumber,Collection<? extends GrantedAuthority> authorities,String token) {
		this.id=lowercaseLogin;
		this.username=lowercaseLogin;
		this.password=password;
		this.authorities=authorities;
		this.mobileNumber=mobileNumber;		
		this.token=token;
	}
	
	public String getId() {
		return id;
	}



	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public String getPassword() {
		return password;
	}
	
	public boolean isLocked() {
		if (isLocked != null && isLocked.equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBlocked() {
		if (isBlocked != null && isBlocked.equalsIgnoreCase("Y")) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getIsLocked() {
		return isLocked;
	}

	public void setIsLocked(String isLocked) {
		this.isLocked = isLocked;
	}

	public String getIsBlocked() {
		return isBlocked;
	}

	public void setIsBlocked(String isBlocked) {
		this.isBlocked = isBlocked;
	}	

	public String getMobileNumber() {
		return mobileNumber;
	}

	public String getToken() {
		return token;
	}
	
	
	
}
