package com.mz.bean.classify;

import java.io.Serializable;
import java.util.Date;
/**
 *视频分类表
 */
public class Classify implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 898424595341442209L;
	//视频分类id
	private Integer classifyId;  
	//视频分类名称
	private String classifyName;  
	//状态：0禁用，1启用
	private Integer status;  
	//创建时间
	private Date createTime;  
  	
	public Integer getClassifyId(){  
		return classifyId;  
	}  
	public void setClassifyId(Integer classifyId){  
		this.classifyId = classifyId;  
	}  
	public String getClassifyName(){  
		return classifyName;  
	}  
	public void setClassifyName(String classifyName){  
		this.classifyName = classifyName;  
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
