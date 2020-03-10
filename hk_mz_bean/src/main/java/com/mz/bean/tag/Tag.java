package com.mz.bean.tag;

import java.io.Serializable;
import java.util.Date;
/**
 *视频标签库表
 */
public class Tag implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9079459126115685096L;
	//标签id
	private Integer tagId;  
	//标签内容
	private String tagName;  
	//状态：0禁用，1启用
	private Integer status;  
	//创建时间
	private Date createTime;  
	//标签类型：video视频、movie电影、tvplay剧集
	private String tagType;  
  	
	
	public Integer getTagId(){  
		return tagId;  
	}  
	public void setTagId(Integer tagId){  
		this.tagId = tagId;  
	}  
	public String getTagName(){  
		return tagName;  
	}  
	public void setTagName(String tagName){  
		this.tagName = tagName;  
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
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}  
	
}
