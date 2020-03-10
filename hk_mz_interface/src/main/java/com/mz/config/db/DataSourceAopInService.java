package com.mz.config.db;

import org.aspectj.lang.annotation.Aspect;  
import org.aspectj.lang.annotation.Before;  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.context.annotation.EnableAspectJAutoProxy;  
import org.springframework.core.PriorityOrdered;  
import org.springframework.stereotype.Component;    
/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月15日 下午4:10:50
* 在service层觉得数据源   
* 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行 
* 如果一旦开始切换到写库，则之后的读都会走写库 
*/
@Aspect  
@EnableAspectJAutoProxy(exposeProxy=true,proxyTargetClass=true)  
@Component
public class DataSourceAopInService implements PriorityOrdered{
	@SuppressWarnings("unused")
	private static Logger log = LoggerFactory.getLogger(DataSourceAopInService.class);  
    
	  
    @Before("execution(* com.mz.service..*.*(..)) "  
            + " and @annotation(com.mz.config.db.ReadDataSource) ")  
    public void setReadDataSourceType() {  
        //如果已经开启写事务了，那之后的所有读都从写库读  
        if(!DataSourceType.write.getType().equals(DataSourceContextHolder.getReadOrWrite())){  
            DataSourceContextHolder.setRead();  
        }  
          
    }  
      
    @Before("execution(* com.mz.service..*.*(..)) "  
            + " and @annotation(com.mz.config.db.WriteDataSource) ")  
    public void setWriteDataSourceType() {  
        DataSourceContextHolder.setWrite();  
    }  
      
    @Override  
    public int getOrder() {  
        /** 
         * 值越小，越优先执行 
         * 要优于事务的执行 
         * 在启动类中加上了@EnableTransactionManagement(order = 10)  
         */  
        return 1;  
    }  
}
