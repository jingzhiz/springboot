package com.itheima.springbootweb;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// @SpringBootTest
class SpringbootWebApplicationTests {

	// @Test
	// void testUuid() {
	// 	for (int i = 0; i < 1000; i++) {
	// 		System.out.println(UUID.randomUUID());
	// 	}
	// }

	@Test
	public void testGenJWT() {
		Map<String, Object> claims = new HashMap<>();
		claims.put("userId", 1);
		claims.put("username", "jingzhi");

		String jwt = Jwts.builder()
				.signWith(SignatureAlgorithm.HS256, "itheima") // 算法方式以及签名
				.setClaims(claims) // 添加 payload 参数
				.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置一小时后过期
				.compact();
		System.out.println(jwt);
	}

	@Test
	public void testParseJWT() {
		Claims claims = Jwts.parser()
				.setSigningKey("itheima")
				.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDU4MjE3MjksInVzZXJJZCI6MSwidXNlcm5hbWUiOiJqaW5nemhpIn0.d8M3fyewVZUbD9fmutyAMa6rfwQzb0Mr_xMjvTu1M48")
				.getBody();
		System.out.println(claims);
	}

}
