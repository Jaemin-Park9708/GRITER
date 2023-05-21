package com.griter.util;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component 
public class JwtUtil {
	private static final String SALT = "GRITER";
	
	// Create a Token
	// 인자로 키와 밸류가 넘어왔다라고만 처리 (한가지 정보만 넣는다고 가정)
	public String createToken(String id) throws UnsupportedEncodingException {
//		String Token =
				return Jwts.builder()
				.setHeaderParam("alg", "HS256")
//				.setHeaderParam("typ", "JWT") // Header complete
//				.setHeaderParam(claimId, data)
//				.claim("userId", "ssafy")
				.claim("user", id)
				// 테스트할 때 방해
				.setExpiration(new Date(System.currentTimeMillis()+1000*60*60)) // Payload complete
				.signWith(SignatureAlgorithm.HS256, SALT.getBytes("UTF-8")) // signature complete
				.compact();
	}
	
	// 유효성 검사
	public void valid(String token) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, UnsupportedEncodingException {
		Jwts.parser().setSigningKey(SALT.getBytes("UTF-8")).parseClaimsJws(token);
	}
}
