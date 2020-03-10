package com.mz.bean.platform;

import java.io.Serializable;
import java.util.Date;
/**
 *运营平台表
 */
public class Platform implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7085642384099605376L;
	//平台id
	private Integer platformId;  
	//平台名称
	private String platformName;  
	//状态，0禁用，1启用
	private Integer status;  
	//
	private Date createTime;  
  	
	public Integer getPlatformId(){  
		return platformId;  
	}  
	public void setPlatformId(Integer platformId){  
		this.platformId = platformId;  
	}  
	public String getPlatformName(){  
		return platformName;  
	}  
	public void setPlatformName(String platformName){  
		this.platformName = platformName;  
	}  
	public Integer getStatus(){  
		return status;  
	}  
	public void setStatus(Integer status){  
		this.status = status;  
	}  
	public Date getCreateTime(){  
		return createTime;  
	}  
	public void setCreateTime(Date createTime){  
		this.createTime = createTime;  
	}  
}
