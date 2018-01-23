package com.demo.security.jwt;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.demo.util.SecurityConstants;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

@Component
public class TokenProvider {

	private final Logger log = LoggerFactory.getLogger(TokenProvider.class);

	private static final String AUTHORITIES_KEY = "auth";
	private static final String USER_ID = "uid";
	private static final String MOBILE_NO = "mobn";
	private static final String USER_NAME = "usr";
	private static final String RESOURCE_ID = "resourceId";
	private static final String AUTH_CATEGORY = "authCategory";
	private static final String AUTH_CATEGORY_LIST = "authCategoryList";
	private static final String REDIRECT_URL = "redirect_url";

	private String secretKey;
	private long tokenValidityInMilliseconds;

	private CustomUserDetailsService userDetailsService;

	public TokenProvider(CustomUserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@PostConstruct
	public void init() {
		this.secretKey = SecurityConstants.SECRET;
		this.tokenValidityInMilliseconds = 1000 * SecurityConstants.EXPIRATION_TIME;
	}

	public String createToken(Authentication authentication) {
		String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));
		long now = (new Date()).getTime();
		Date validity = new Date(now + this.tokenValidityInMilliseconds);

		return Jwts.builder().setSubject(authentication.getName()).claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(validity).compact();
	}

	public Authentication getAuthentication(String token) {
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		/*Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());*/
		UserDetails principal = userDetailsService.loadUserByUsername(claims.getSubject());

		return new UsernamePasswordAuthenticationToken(principal, token);
	}

	public boolean validateToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			log.info("Invalid JWT signature.");
			log.trace("Invalid JWT signature trace: {}", e);
			throw e;
		} catch (MalformedJwtException e) {
			log.info("Invalid JWT token.");
			log.trace("Invalid JWT token trace: {}", e);
			throw e;
		} catch (JwtException e) {
			log.info("Expired JWT token.");
			log.trace("Expired JWT token trace: {}", e);
			throw e;
		} catch (IllegalArgumentException e) {
			log.info("JWT token compact of handler are invalid.");
			log.trace("JWT token compact of handler are invalid trace: {}", e);
			throw e;
		}
	}

	public String refreshToken(String token) {
		try {
			Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
			String mobileNumber = "";
			if (claims.containsKey(MOBILE_NO)) {
				mobileNumber = claims.get(MOBILE_NO).toString();
			}

			String userId = "";
			if (claims.containsKey(USER_ID)) {
				userId = claims.get(USER_ID).toString();
			}

			String userName = "";
			if (claims.containsKey(USER_NAME)) {
				userName = claims.get(USER_NAME).toString();
			}

			String resId = "";
			if (claims.containsKey(RESOURCE_ID))
				resId = claims.get(RESOURCE_ID).toString();

			String authCategory = "";
			if (claims.containsKey(AUTH_CATEGORY)) {
				authCategory = claims.get(AUTH_CATEGORY).toString();
			}

			String redirectUrl = "";
			String authCategoryList = "";
			if (claims.containsKey(AUTH_CATEGORY_LIST)) {
				authCategoryList = claims.get(AUTH_CATEGORY_LIST).toString();
			}
			if (claims.containsKey(REDIRECT_URL)) {
				redirectUrl = claims.get(REDIRECT_URL).toString();
			}
			Date validity;
			long now = (new Date()).getTime();
			validity = new Date(now + this.tokenValidityInMilliseconds);
			return Jwts.builder().setSubject(claims.getSubject()).claim(AUTHORITIES_KEY, claims.get(AUTHORITIES_KEY))
					.claim(MOBILE_NO, mobileNumber).claim(USER_ID, userId).claim(USER_NAME, userName)
					.claim(RESOURCE_ID, resId).claim(AUTH_CATEGORY, authCategory)
					.claim(AUTH_CATEGORY_LIST, authCategoryList).claim(REDIRECT_URL, redirectUrl)
					.signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(validity).compact();
		} catch (Exception e) {
			throw new JwtException(e.getMessage());
		}
	}
}
