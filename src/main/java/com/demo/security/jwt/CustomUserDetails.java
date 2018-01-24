package com.demo.security.jwt;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {

	private static final long serialVersionUID = -4184780942996851447L;
	private  final String id;
	private  final String username;
	private  final String password;
	//private   String isLocked;
	//private   String isBlocked;
	private final  Collection<? extends GrantedAuthority> authorities;
	private final String token;
	
	
	
	public CustomUserDetails(String id, String username, String password,
			Collection<? extends GrantedAuthority> authorities, String token) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.authorities = authorities;
		this.token = token;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getId() {
		return id;
	}
	public String getToken() {
		return token;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return username;
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
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
}
