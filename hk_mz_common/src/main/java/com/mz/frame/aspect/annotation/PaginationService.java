package com.mz.frame.aspect.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 分页注解
 * 用于控制数据分页
 * @作者 栗超
 * @时间 2019年02月15日 上午8:55:20
 * @说明
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PaginationService {
	/**
	 * 前端组件的类型
	 * @return
	 */
	String webTableType() default "dataTables";
}

