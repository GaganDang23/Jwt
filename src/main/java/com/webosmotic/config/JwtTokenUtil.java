package com.webosmotic.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 374570330815768385L;
	
	public static final long JWT_TOKEN_VALIDITY=5 * 60 * 60;
	
	@Value("${jwt.secret}")
	private String secret;
	
	public String getUsernameFromToken(String token) {
		return getClaimFromToken(token , Claims::getSubject);
	}
	
	public Date getExpirationDatefromToken(String token) {
		return getClaimFromToken(token, Claims::getExpiration);
	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);
	}
	
	
	private Claims getAllClaimsFromToken(String token) {
		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		
	}
	
	private boolean isTokenExpired(String token) {
	final	 Date expiration = getExpirationDatefromToken(token);
	return expiration.before(new Date());
	}
	
	public String genrateToken(UserDetails userDetails) {
		HashMap<String, Object> claim = new HashMap<String, Object>();
		return doGenrateToken(claim,userDetails.getUsername());
	}

	
	private String doGenrateToken(HashMap<String, Object> claims, String subject) {
		// TODO Auto-generated method stub
		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + JWT_TOKEN_VALIDITY * 1000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}
	
	
	public Boolean validateToken(String token, UserDetails details) {
		final String username = getUsernameFromToken(token);
		return (username.equals(details.getUsername()) && !isTokenExpired(token));
	}
	
	
}
