package com.demo.util;

public final class SecurityConstants {

	private SecurityConstants() {
	}
	
	 public static final String SECRET = "SecretKeyToGenJWTs";
	    public static final long EXPIRATION_TIME = 40; // 1 day
	    public static final String TOKEN_PREFIX = "Bearer ";
	    public static final String HEADER_STRING = "Authorization";
	    public static final String SIGN_UP_URL = "/users";

}
