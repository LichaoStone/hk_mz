package com.mz;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.mz.config.handler.HandlerBeanArgumentResolver;
/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月16日 下午5:38:37
* 
*/

@SpringBootApplication
public class SpringBootApp extends WebMvcConfigurerAdapter {
//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(SpringBootApp.class);
//	}
	@Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        super.addArgumentResolvers(argumentResolvers);
        argumentResolvers.add(new HandlerBeanArgumentResolver());
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
}