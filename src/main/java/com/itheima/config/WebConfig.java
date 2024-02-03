package com.itheima.config;

import com.itheima.example.ThirdClass;
import com.itheima.interceptor.LoginCheckInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration // 配置类
public class WebConfig implements WebMvcConfigurer {
	@Autowired
	private LoginCheckInterceptor loginCheckInterceptor;
	public void addInterceptors(InterceptorRegistry registry) {
		// 注册拦截器
		registry.addInterceptor(loginCheckInterceptor)
				.addPathPatterns("/**") // 不分层级的拦截
				.excludePathPatterns("/login");
	}

	// 声明第三方 bean
	@Bean // 将方法的返回值交给 IOC 容器管理
	public ThirdClass thirdClass() {
		return new ThirdClass();
	}
}
