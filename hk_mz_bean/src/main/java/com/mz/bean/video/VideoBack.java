package com.mz.bean.video;

import java.io.Serializable;

import com.mz.util.bean.BaseEntity;
/**
 *录播回放视频
 */
public class VideoBack extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 6993513995528837310L;
	
	//id
	private Integer videoBackId;  
	//视频名称
	private String videoName;  
	//视频大小
	private String fileSize;  
	//分辨率
	private String resolution;  
	//码率
	private String videoBitRate;  
	//更新时间
	private String createTime;  
	//活动表id
	private Integer activityId;
	//推流URl
	private String pushUrl ;
	//录播视频URL
	private String videoUrl;
  	
	public Integer getVideoBackId(){  
		return videoBackId;  
	}  
	public void setVideoBackId(Integer videoBackId){  
		this.videoBackId = videoBackId;  
	}  
	public String getVideoName(){  
		return videoName;  
	}  
	public void setVideoName(String videoName){  
		this.videoName = videoName;  
	}  
	public String getFileSize(){  
		return fileSize;  
	}  
	public void setFileSize(String fileSize){  
		this.fileSize = fileSize;  
	}  
	public String getResolution(){  
		return resolution;  
	}  
	public void setResolution(String resolution){  
		this.resolution = resolution;  
	}  
	public String getVideoBitRate(){  
		return videoBitRate;  
	}  
	public void setVideoBitRate(String videoBitRate){  
		this.videoBitRate = videoBitRate;  
	}  
     
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getActivityId(){  
		return activityId;  
	}  
	public void setActivityId(Integer activityId){  
		this.activityId = activityId;  
	}
	public String getPushUrl() {
		return pushUrl;
	}
	public void setPushUrl(String pushUrl) {
		this.pushUrl = pushUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}  
}
