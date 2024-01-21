package com.itheima.filter;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;

@Slf4j
@WebFilter(urlPatterns = "/*")
// @WebFilter(urlPatterns = "/login")
// @WebFilter(urlPatterns = "/emps/*")
public class AuthFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("init 初始化方法执行~~~~");
	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		log.info("doFilter 拦截方法执行~~~~");


		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String url = req.getRequestURL().toString();

		if (url.contains("login")) {
			log.info("登录操作，直接放行~~~");
			chain.doFilter(request, response);
			return;
		}

		String jwt = req.getHeader("token");

		if (!StringUtils.hasLength(jwt)) {
			log.info("token为空，返回未登录信息~~~");
			Result error = Result.error("NOT_LOGIN");
			// 手动转换对象为 json
			String notLoginMessage = JSONObject.toJSONString(error);
			// res 返回信息
			res.getWriter().write(notLoginMessage);
			return;
		}

		try {
			JwtUtils.parseJwt(jwt);
		} catch	(Exception e) {
			e.printStackTrace();
			log.info("解析令牌失败，返回未登录错误信息");
			Result error = Result.error("NOT_LOGIN");
			// 手动转换对象为 json
			String notLoginMessage = JSONObject.toJSONString(error);
			// res 返回信息
			res.getWriter().write(notLoginMessage);
			return;
		}

		log.info("令牌合法");
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		log.info("destroy 销毁方法执行~~~~");
	}
}
