package com.mz.config.db;
import java.lang.annotation.Documented;  
import java.lang.annotation.ElementType;  
import java.lang.annotation.Inherited;  
import java.lang.annotation.Retention;  
import java.lang.annotation.RetentionPolicy;  
import java.lang.annotation.Target;  
/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月15日 下午4:14:55
* 
*/
@Target({ElementType.METHOD, ElementType.TYPE})  
@Retention(RetentionPolicy.RUNTIME)  
@Inherited  
@Documented  
public @interface WriteDataSource {  
  
}  