package com.itheima.aop;

import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

@Slf4j
@Component
@Aspect
public class LogAspect {
	@Autowired
	private HttpServletRequest request;
	@Autowired
	private OperateLogMapper operateLogMapper;

	@Around("@annotation(com.itheima.anno.Log)")
	public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
		// 操作用户
		String jwt = request.getHeader("token");
		Claims claims = JwtUtils.parseJwt(jwt);
		Integer operateUser = (Integer) claims.get("id");
		// 操作时间
		LocalDateTime operateTime = LocalDateTime.now();
		// 操作类名
		String className = joinPoint.getClass().getName();
		// 操作方法名
		String methodName = joinPoint.getSignature().getName();
		// 操作方法参数
		Object[] args = joinPoint.getArgs();
		String methodParams = Arrays.toString(args);
		// 操作方法返回值
		Long begin = System.currentTimeMillis();
		Object result = joinPoint.proceed();
		Long end = System.currentTimeMillis();
		String returnValue = JSONObject.toJSONString(result);
		// 操作耗时
		Long costTime = end - begin;

		// 获取操作信息
		OperateLog opLog = new OperateLog(
				null,
				operateUser,
				operateTime,
				className,
				methodName,
				methodParams,
				returnValue,
				costTime
		);
		// 记录日志
		operateLogMapper.insert(opLog);

		log.info("AOP记录操作日志，{}", opLog);

		return result;
	}
}
