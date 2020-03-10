package com.mz.config.web;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	
	@Override
    public void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
        MobileReturnHandler mobileReturnHandler=new MobileReturnHandler();
        returnValueHandlers.add(mobileReturnHandler);
        super.addReturnValueHandlers(returnValueHandlers);
    }
}
