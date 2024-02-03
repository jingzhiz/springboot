package com.itheima.springbootweb;

import com.itheima.example.ThirdClass;
import com.itheima.controller.DeptController;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@Slf4j
@SpringBootTest
class SpringbootWebApplicationTests {
	@Autowired
	private ApplicationContext applicationContext;

	// @Test
	// void testUuid() {
	// 	for (int i = 0; i < 1000; i++) {
	// 		System.out.println(UUID.randomUUID());
	// 	}
	// }

	// @Test
	// public void testGenJWT() {
	// 	Map<String, Object> claims = new HashMap<>();
	// 	claims.put("userId", 1);
	// 	claims.put("username", "jingzhi");
	//
	// 	String jwt = Jwts.builder()
	// 			.signWith(SignatureAlgorithm.HS256, "itheima") // 算法方式以及签名
	// 			.setClaims(claims) // 添加 payload 参数
	// 			.setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000)) // 设置一小时后过期
	// 			.compact();
	// 	System.out.println(jwt);
	// }

	// @Test
	// public void testParseJWT() {
	// 	Claims claims = Jwts.parser()
	// 			.setSigningKey("itheima")
	// 			.parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJleHAiOjE3MDU4MjE3MjksInVzZXJJZCI6MSwidXNlcm5hbWUiOiJqaW5nemhpIn0.d8M3fyewVZUbD9fmutyAMa6rfwQzb0Mr_xMjvTu1M48")
	// 			.getBody();
	// 	System.out.println(claims);
	// }

	@Test
	public void testGetBean() {
		DeptController bean1 = (DeptController)applicationContext.getBean("deptController");
		log.info("根据bean的名称获取, {}", bean1);

		DeptController bean2 = (DeptController)applicationContext.getBean(DeptController.class);
		log.info("根据bean的类型获取, {}", bean2);

		DeptController bean3 = (DeptController)applicationContext.getBean("deptController", DeptController.class);
		log.info("根据bean的名称和类型获取, {}", bean3);

		ThirdClass bean4 = (ThirdClass)applicationContext.getBean("thirdClass", ThirdClass.class);
		log.info("第三方bean的注入和获取, {}", bean4);
	}
}
