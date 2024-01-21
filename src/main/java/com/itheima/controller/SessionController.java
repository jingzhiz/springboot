package com.itheima.controller;

import com.itheima.pojo.Result;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SessionController {
	@GetMapping("cookie1")
	public Result cookie1(HttpServletResponse response) {
		response.addCookie(new Cookie("login_username", "jingzhi"));
		return Result.success();
	}

	@GetMapping("cookie2")
	public Result cookie2(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies) {
			log.info("当前请求获取到的cookie, {}, {}", cookie.getName(), cookie.getValue());
		}
		return Result.success();
	}

	@GetMapping("session1")
	public Result session1(HttpSession session) {
		log.info("当前请求获取到的session, {}", session.hashCode());

		session.setAttribute("loginUser", "jingzhi");

		return Result.success();
	}

	@GetMapping("session2")
	public Result session2(HttpServletRequest request) {
		HttpSession session = request.getSession();

		log.info("当前请求获取到的session, {}", session.hashCode());

		Object loginUser = session.getAttribute("loginUser");

		log.info("session中存放的user, {}", loginUser);

		return Result.success();
	}
}
