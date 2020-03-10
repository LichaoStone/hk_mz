package com.mz.config.db;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月13日 下午5:40:46
* 数据源配置
*/
@Configuration
public class DataSourceConfiguration {
	
	private static Logger log = LoggerFactory.getLogger(DataSourceConfiguration.class); 
	
	@Bean
	public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {  
	    return new PropertySourcesPlaceholderConfigurer();  
	} 
	@Value("${mysql.datasource.type}")
    private Class<? extends DataSource> dataSourceType;

    @Bean(name = "writeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "mysql.datasource.write")
    public DataSource writeDataSource() {
    	log.info("————————————————————write-date-source-init——————————————————————");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }

    /**
     * 有多少个从库就要配置多少个
     * @return
     */
    @Bean(name = "readDataSource")
    @ConfigurationProperties(prefix = "mysql.datasource.read01")
    public DataSource readDataSourceOne() {
    	log.info("————————————————————read-date-source-init——————————————————————");
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
    /*
    @Bean(name = "readDataSource2")
    @ConfigurationProperties(prefix = "datasource.read2")
    public DataSource readDataSourceTwo() {
        return DataSourceBuilder.create().type(dataSourceType).build();
    }
    */
}
