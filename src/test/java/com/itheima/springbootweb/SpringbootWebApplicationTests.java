package com.itheima.springbootweb;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
class SpringbootWebApplicationTests {

	@Test
	void testUuid() {
		for (int i = 0; i < 1000; i++) {
			System.out.println(UUID.randomUUID());
		}
	}

}
