package com.mz.bean.synchrolog;

import java.io.Serializable;
import java.util.Date;
/**
 *下发日志表
 */
public class SynchroLog implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1313145156733765992L;
	//id
	private Integer synchroLogId;  
	//同步时间
	private Date createTime;  
	//内容类型：video,news,activity,movie,tvplay
	private String contentType;  
	//对应的视频或者资讯的id
	private Integer contentId;  
	//操作用户
	private Integer userId;  
	//下发的平台
	private Integer platformId;  
	//
	private Integer status;  
	//
	private String faildReason;  
  	
	public Integer getSynchroLogId(){  
		return synchroLogId;  
	}  
	public void setSynchroLogId(Integer synchroLogId){  
		this.synchroLogId = synchroLogId;  
	}  
	public Date getCreateTime(){  
		return createTime;  
	}  
	public void setCreateTime(Date createTime){  
		this.createTime = createTime;  
	}  
	public String getContentType(){  
		return contentType;  
	}  
	public void setContentType(String contentType){  
		this.contentType = contentType;  
	}  
	public Integer getContentId(){  
		return contentId;  
	}  
	public void setContentId(Integer contentId){  
		this.contentId = contentId;  
	}  
	public Integer getUserId(){  
		return userId;  
	}  
	public void setUserId(Integer userId){  
		this.userId = userId;  
	}  
	public Integer getPlatformId(){  
		return platformId;  
	}  
	public void setPlatformId(Integer platformId){  
		this.platformId = platformId;  
	}  
	public Integer getStatus(){  
		return status;  
	}  
	public void setStatus(Integer status){  
		this.status = status;  
	}  
	public String getFaildReason(){  
		return faildReason;  
	}  
	public void setFaildReason(String faildReason){  
		this.faildReason = faildReason;  
	}  
}
