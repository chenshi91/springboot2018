/**Created	by	chenshi  at	2018年3月20日 下午11:03:58*/
package com.girl.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.girl.utils.Result;

/**
 * @description:	ExceptionHandle.java
 * @packageName:	com.girl.exception
 * @projectName:	girl
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value=Exception.class)
	@ResponseBody
	public Result handle(Exception e){
		if(e instanceof MyException){
			MyException exception=(MyException) e;
			return Result.myError(exception.getCode().intValue(),exception.getMessage());
		}
		return Result.myError(-1,e.getMessage());
	}
}
