package com.example.demo;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Book;

/**
* Author - RUMAZUMD
* CreatedDate - 11 jun. 2021
* 
**/
@Aspect
@Configuration
public class CrossCuttingAspects {
	private Logger logger = LoggerFactory.getLogger(this.getClass()); 
	
	@Before("execution(* com.example.demo.service.*.*(..))")
	public void before(JoinPoint joinPoint) {
		logger.info("Intercepting {}",joinPoint);
	}
	@AfterReturning(value = "execution(* com.example.demo.service.*.*(..))",returning = "result" )
	public void afterReturn(JoinPoint joinPoint, List<Book> result) {
		int listSize=result.size();
		logger.info("Intercepting after return {} with the list size {}",joinPoint, listSize);
		
	}

}
