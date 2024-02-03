package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect // AOP 类
@Component
public class AspectTest {
	@Pointcut("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
	// @Pointcut("execution(public void com.itheima.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
	private void pointcut() {};

	@Before("pointcut()")
	// @Before("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
	public void before() {
		log.info("方法前置执行------");
	}

	@Around("execution(* com.itheima.service.*.*(..))") // service 下所有方法
	public Object recordExecuteTime(ProceedingJoinPoint joinPoint) throws Throwable {
		log.info("可以环绕方法前后置执行------");

		// 记录开始时间
		long beginTime = System.currentTimeMillis();
		// 执行原方法
		Object result = joinPoint.proceed();
		// 记录结束时间
		long endTime = System.currentTimeMillis();

		log.info(joinPoint.getSignature() + "方法执行耗时，{}ms", endTime - beginTime);

		return result;
	}

	@After("pointcut()")
	// @After("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
	public void after() {
		log.info("方法后置执行------");
	}

	@AfterReturning("pointcut()")
	// @AfterReturning("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
	public void afterReturn() {
		log.info("方法成功执行完毕return后置执行------");
	}

	@AfterThrowing("pointcut()")
	// @AfterThrowing("execution(* com.itheima.service.impl.DeptServiceImpl.*(..))")
	public void afterThrow() {
		log.info("方法抛出异常后执行------");
	}

}
