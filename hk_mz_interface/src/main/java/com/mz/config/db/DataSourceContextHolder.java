package com.mz.config.db;

import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月15日 上午10:34:58
* 本地线程，数据源上下文 
*/
public class DataSourceContextHolder {
	
	private static Logger log = LoggerFactory.getLogger(DataSourceContextHolder.class);
	
	/**
	 * 线程本地环境
	 */
	private static final ThreadLocal<String> LOCAL = new ThreadLocal<String>();

    public static ThreadLocal<String> getLocal() {
        return LOCAL;
    }

    /**
     * 读库
     */
    public static void setRead() {
    	LOCAL.set(DataSourceType.read.getType());
        log.info("数据库切换到读库...");
    }

    /**
     * 写库
     */
    public static void setWrite() {
    	LOCAL.set(DataSourceType.write.getType());
        log.info("数据库切换到写库...");
    }

    public static String getReadOrWrite() {
        return LOCAL.get();
    }
    
    public static void clear(){
    	LOCAL.remove();
    }
}
