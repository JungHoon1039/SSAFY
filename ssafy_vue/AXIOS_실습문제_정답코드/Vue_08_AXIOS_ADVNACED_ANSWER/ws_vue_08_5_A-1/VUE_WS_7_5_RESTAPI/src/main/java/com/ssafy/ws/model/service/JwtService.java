package com.ssafy.ws.model.service;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtService {
	private String signature = "VUETOKEN-SIGNATURE";
	private Long expireMin = 5L;
	
	
	public String create(Map<String, Object> map) {
		JwtBuilder jwtBuilder = Jwts.builder();
		
		// Header 설정
		jwtBuilder.setHeaderParam("typ", "JWT");
		
		// Payload 설정
		jwtBuilder.setSubject("로그인 토큰")
			.setExpiration(new Date(System.currentTimeMillis()+1000*60*expireMin)) // 유효기간 설정
			.claim("user", map) // 담고 싶은 정보 1
			.claim("greeting", "환영합니다. "+map.get("userName")); // 담고 싶은 정보 2
		
		// Signature 설정
		jwtBuilder.signWith(SignatureAlgorithm.HS256, signature.getBytes());
		
		// 마지막 직렬화 처리
		String jwt = jwtBuilder.compact();
		return jwt;
	}
	
	// 전달받은 토큰이 제대로 생성된 것인지 확인
	// 문제가 있다면 RuntimeException이 발생할 것임
	public void checkValid(String jwt) {
		// 예외가 발생하지 않으면 OK
		Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
		
	}
	
	
	// JWT Token을 분석해서, 필요 정보 반환
	public Map<String, Object> get(String jwt) {
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser().setSigningKey(signature.getBytes()).parseClaimsJws(jwt);
		} catch (final Exception e) {
			throw new RuntimeException();
		}
		
		return claims.getBody();
	}

}
