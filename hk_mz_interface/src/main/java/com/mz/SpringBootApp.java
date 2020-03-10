package com.mz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月16日 下午5:38:37
* 
*/
@SpringBootApplication
public class SpringBootApp extends SpringBootServletInitializer{

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringBootApp.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringBootApp.class, args);
	}
}
