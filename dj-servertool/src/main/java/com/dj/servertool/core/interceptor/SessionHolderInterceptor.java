package com.dj.servertool.core.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import cn.stylefeng.roses.core.base.controller.BaseController;
import cn.stylefeng.roses.core.util.HttpSessionContext;

/**
 * 静态调用session的拦截器
 */
@Aspect
@Component
public class SessionHolderInterceptor extends BaseController {

	@Pointcut("execution(* com.dj.servertool.*..controller.*.*(..))")
	public void cutService() {
	}

	@Around("cutService()")
	public Object sessionKit(ProceedingJoinPoint point) throws Throwable {
		HttpSessionContext.put(super.getHttpServletRequest().getSession());
		try {
			return point.proceed();
		} finally {
			HttpSessionContext.remove();
		}
	}
}
