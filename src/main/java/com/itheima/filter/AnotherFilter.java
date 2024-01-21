package com.itheima.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
public class AnotherFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) {
		log.info("Another Filter init 方法执行");
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws ServletException, IOException {
		log.info("Another Filter doFilter 方法执行");

		log.info("过滤前逻辑");
		chain.doFilter(req, res); // 放行操作
		log.info("过滤后逻辑");
	}

	@Override
	public void destroy() {
		log.info("Another Filter destroy 方法执行");
	}
}
