package com.KoalaTea.aspect;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * This denotes that we are using this class as an aspect which handle some cross-cutting
 * concern. In our case, it will handle logging.
 * 
 * Note that we must still mark it as a component since @Aspect is NOT a Spring stereotype
 */
@Aspect
@Component
public class LoggingAspect {
	
	private static final Logger LOG = LogManager.getLogger(LoggingAspect.class);
	
//	@Pointcut("execution( * com.KoalaTea.web * (..))")
//	public void allWebMethodsPointCut() {}
//	
	@Pointcut("within(com.KoalaTea.service..*)")
	public void inServiceLayer() {}
	
//	@Before("allWebMethodsPointCut()")
//	public void logBeforeMethodCall(JoinPoint jp) {
//		LOG.info("The " + jp.getSignature().getName() + " method is going to be called");
//	}
	
	@AfterReturning(pointcut="inServiceLayer()", returning="returnedObject")
	public void logAfterReturning(JoinPoint jp, Object returnedObject) {
		LOG.info("The " + jp.getSignature().getName() + " method just returned " + returnedObject);
	}
	
	@AfterThrowing(pointcut="inServiceLayer()", throwing="exceptionThrown")
	public void logAfterThrowing(JoinPoint jp, Exception exceptionThrown) {
		LOG.info("The " + jp.getSignature().getName() + " method just threw " + exceptionThrown);
	}

}
