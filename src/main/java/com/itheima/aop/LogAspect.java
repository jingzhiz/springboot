package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect // 切面类
public class LogAspect {

	@Around("@annotation(com.itheima.anno.Log)")
	public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {

		Object result = joinPoint.proceed();

		return result;
	}
}
