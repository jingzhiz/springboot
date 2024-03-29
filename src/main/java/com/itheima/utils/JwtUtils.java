package com.itheima.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {
	private static String signKey = "itheima";
	private static Long expire = 43210000L;

	public static String genJwt(Map<String, Object> claims) {
		String jwt = Jwts.builder()
				.addClaims(claims)
				.signWith(SignatureAlgorithm.HS256, signKey)
				.setExpiration(new Date(System.currentTimeMillis() + expire))
				.compact();
		return jwt;
	}

	public static Claims parseJwt(String jwt) {
		Claims claims = Jwts.parser()
				.setSigningKey(signKey)
				.parseClaimsJws(jwt)
				.getBody();
		return  claims;
	}
}
