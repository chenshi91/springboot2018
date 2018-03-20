/**Created	by	chenshi  at	2018年3月20日 下午9:20:01*/
package com.girl.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @description:	HttpAspect.java
 * @packageName:	com.girl.aspect
 * @projectName:	girl
 * @revision:   	v1.0.0
 * @author:   		chenshi
 */
@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger=LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.girl.controal.BoyControal.*(..))")
	public void point(){}
	
	@Before("point()")
	public void doBefore(JoinPoint joinpoint){
		logger.info("--------------------log-------before------------");
		ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = requestAttributes.getRequest();
		logger.info("url={}"+request.getRequestURL());
		logger.info("method={}"+request.getMethod());
		logger.info("class_method={}"+joinpoint.getSignature().getDeclaringTypeName()
				+"."+joinpoint.getSignature().getName());
		logger.info("args={}"+joinpoint.getArgs());
	
	}
	
	@After("point()")
	public void doAfter(){
		logger.info("--------------------log-------after------------");
	}
	
	@AfterReturning(returning="object",pointcut="point()")
	public void doAfterReturn(Object object){
		logger.info("response={}",object);
	}
	
}
