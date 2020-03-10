package com.mz.config.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import com.alibaba.fastjson.JSON;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.MobileResult;
public class MobileReturnHandler implements HandlerMethodReturnValueHandler{

	@Override
	public boolean supportsReturnType(MethodParameter returnType) {
		return returnType.getParameterType() == JsonResult.class;
	}

	@Override
	public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer,
			NativeWebRequest webRequest) throws Exception {
		mavContainer.setRequestHandled(true);
		MobileResult mobileResult = new MobileResult();
		mobileResult.setResults(returnValue);
		HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        response.setContentType("text/json;charset=UTF-8");
        response.getWriter().append(JSON.toJSONString(mobileResult)).flush();
	}

}
