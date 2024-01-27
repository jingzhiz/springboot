package com.itheima.exception;

import com.itheima.pojo.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptHandler {
	@ExceptionHandler(Exception.class) // 捕获所有异常
	public Result ex(Exception ex) {
		ex.printStackTrace(); // 打印异常调用堆栈信息
		// return Result.error(ex.getMessage());
		return Result.error("出现错误，请联系管理员!");
	}
}
