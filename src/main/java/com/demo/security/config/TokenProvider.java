package com.demo.security.config;

import org.springframework.security.core.Authentication;

public class TokenProvider {

	public String createToken(Authentication authentication, Boolean rememberMe) {
		return null;
	}
	
	public boolean validateToken(String authToken) {
		/*try {
			Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException exception) {
			log.info("Invalid JWT signature.");
			log.trace("Invalid JWT signature trace: {}", exception);			
		} catch (MalformedJwtException exception) {
			log.info("Invalid JWT token.");
			log.trace("Invalid JWT token trace: {}", exception);			
		} catch (ExpiredJwtException exception) {
			log.info("Expired JWT token.");
			log.trace("Expired JWT token trace: {}", exception);			
		} catch (UnsupportedJwtException exception) {
			log.info("Unsupported JWT token.");
			log.trace("Unsupported JWT token trace: {}", exception);		
		} catch (IllegalArgumentException exception) {
			log.info("JWT token compact of handler are invalid.");
			log.trace("JWT token compact of handler are invalid trace: {}", exception);			
		}*/
		return false;
	}
	
	public Authentication getAuthentication(String token){
		return null;	
	}
}
