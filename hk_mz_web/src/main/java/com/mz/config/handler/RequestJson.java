package com.mz.config.handler;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestJson {
	String value() default "_def_param_name";
	
	/**
	 * 为支持泛型，需要显示设置泛型类型
	 * @return
	 */
	Class<?>[] genericTypes() default {};

	/**
	 * 必须非空
	 * @return
	 */
	boolean required() default true;
}
