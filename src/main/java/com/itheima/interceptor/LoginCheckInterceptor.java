package com.itheima.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.itheima.pojo.Result;
import com.itheima.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class LoginCheckInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		// 目标资源方法（Controller 方法）执行前执行，true 放行，false 不放行
		log.info("preHandle 方法执行。。。");

		String url = request.getRequestURL().toString();

		if (url.contains("login")) {
			log.info("登录操作，直接放行~~~");
			return true;
		}

		String jwt = request.getHeader("token");

		if (!StringUtils.hasLength(jwt)) {
			log.info("token为空，返回未登录信息~~~");
			Result error = Result.error("NOT_LOGIN");
			// 手动转换对象为 json
			String notLoginMessage = JSONObject.toJSONString(error);
			// res 返回信息
			response.getWriter().write(notLoginMessage);
			return false;
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
			response.getWriter().write(notLoginMessage);
			return false;
		}

		log.info("令牌合法");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
		// 目标资源方法执行（Controller 方法）后执行
		log.info("postHandle 方法执行。。。");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
		// 视图渲染完毕后执行，最后执行
		log.info("afterCompletion 方法执行。。。");
	}
}
