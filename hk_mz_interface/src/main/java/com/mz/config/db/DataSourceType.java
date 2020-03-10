package com.mz.config.db;
/**
* @author 半步 E-mail:renzhichaoshaer@163.com
* @version 创建时间：2017年10月15日 上午10:30:36
* 
*/
public enum DataSourceType {
	/**
	 * 读库
	 */
	read("read", "从库"),  
    write("write", "主库");  
      
    private String type;  
      
    private String name;  
  
    DataSourceType(String type, String name) {  
        this.type = type;  
        this.name = name;  
    }  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
  
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
}
