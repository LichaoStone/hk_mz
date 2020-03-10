package com.mz.frame.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.mz.frame.aspect.annotation.PaginationService;
import com.mz.frame.page.PageContext;

@Aspect
@Component
public class PaginationServiceAspectAdvice {

	@Around(value = "com.mz.frame.aspect.pointcut.SystemArchitecture.globalServiceLayer() "
			+ "&& @annotation(paginationService)")
	public Object paginationService(ProceedingJoinPoint jp,PaginationService paginationService) throws Throwable {
		PageContext context = PageContext.getContext();
		context.setPaginationService(true);
			
		Object o = null;
		try{
			o = jp.proceed();
		}catch(Throwable t){
			throw t;
		}finally{
			context.setPaginationService(false);
		}
		return o;
	}
}
