package com.mz.config.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.mz.util.bean.MobileResult;

@RestControllerAdvice
public class ControllerExceptionHandler {
	private static Logger log = LoggerFactory.getLogger(ControllerExceptionHandler.class);
	@ExceptionHandler(value = Exception.class)
	public MobileResult defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
		log.error(req.getRequestURI()+":"+e.getMessage());
		MobileResult mobileResult = new MobileResult() ;
		mobileResult.setErrorMessage("系统异常呢");
		mobileResult.setCode("500");
		return mobileResult ;
	}

}
