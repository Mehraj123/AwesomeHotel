package com.demo.security.jwt;

import java.util.Date;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
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

		return Jwts.builder().setSubject(authentication.getName()).claim("authorities", authorities)
				.signWith(SignatureAlgorithm.HS512, secretKey).setExpiration(validity).compact();
	}

	public Authentication getAuthentication(String token) {
		String newToken = "Bearer " + token;
		Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
		/*Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());*/
		UserDetails user = userDetailsService.loadUserByUsername(claims.getSubject());
		CustomUserDetails principal = new CustomUserDetails(claims.getId(), user.getUsername(), user.getPassword(), null, newToken);
		return new UsernamePasswordAuthenticationToken(principal, token, null);
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

	
}
