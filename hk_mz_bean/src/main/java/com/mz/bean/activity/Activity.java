package com.mz.bean.activity;

import java.io.Serializable;
import java.util.Date;
/**
 *活动表
 */
public class Activity implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7718622759560905723L;
	//id
	private Integer activityId;  
	//活动标题
	private String title;  
	//所属平台
	private Integer platformId;  
	//状态：0待上线，1上线，-1下线
	private Integer status;  
	//推流状态：0未推流，1已推流，-1断流
	private Integer pushStatus;  
	//创建时间
	private Date createTime;  
	//活动id
	private String sourceActivityId;  
	//是否录播
	private Integer isPlayback;  
	//活动开始时间
	private Date beginTime;  
	//活动结束时间
	private Date endTime;  
	//推流设备：1客户端，2编码器
	private Integer equipment;  
	//推流时间
	private Date pushTime;  
	//流名
	private String pushUrl;  
	//推流及播放地址下发状态
	private Integer synchroStatus; 
	//推流质量 （0 480P 1 720P 2 1080P）
	private Byte pushStandard;
  	
	public Integer getActivityId(){  
		return activityId;  
	}  
	public void setActivityId(Integer activityId){  
		this.activityId = activityId;  
	}  
	public String getTitle(){  
		return title;  
	}  
	public void setTitle(String title){  
		this.title = title;  
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
	public Integer getPushStatus(){  
		return pushStatus;  
	}  
	public void setPushStatus(Integer pushStatus){  
		this.pushStatus = pushStatus;  
	}  
	public Date getCreateTime(){  
		return createTime;  
	}  
	public void setCreateTime(Date createTime){  
		this.createTime = createTime;  
	}  
	public String getSourceActivityId(){  
		return sourceActivityId;  
	}  
	public void setSourceActivityId(String sourceActivityId){  
		this.sourceActivityId = sourceActivityId;  
	}  
	public Integer getIsPlayback(){  
		return isPlayback;  
	}  
	public void setIsPlayback(Integer isPlayback){  
		this.isPlayback = isPlayback;  
	}  
	public Date getBeginTime(){  
		return beginTime;  
	}  
	public void setBeginTime(Date beginTime){  
		this.beginTime = beginTime;  
	}  
	public Date getEndTime(){  
		return endTime;  
	}  
	public void setEndTime(Date endTime){  
		this.endTime = endTime;  
	}  
	public Integer getEquipment(){  
		return equipment;  
	}  
	public void setEquipment(Integer equipment){  
		this.equipment = equipment;  
	}  
	public Date getPushTime(){  
		return pushTime;  
	}  
	public void setPushTime(Date pushTime){  
		this.pushTime = pushTime;  
	}  
	public String getPushUrl(){  
		return pushUrl;  
	}  
	public void setPushUrl(String pushUrl){  
		this.pushUrl = pushUrl;  
	}  
	public Integer getSynchroStatus(){  
		return synchroStatus;  
	}  
	public void setSynchroStatus(Integer synchroStatus){  
		this.synchroStatus = synchroStatus;  
	}
	public Byte getPushStandard() {
		return pushStandard;
	}
	public void setPushStandard(Byte pushStandard) {
		this.pushStandard = pushStandard;
	}  
}
