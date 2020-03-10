package com.mz.bean.activity.vo;

import com.mz.bean.activity.Activity;

/**
 *活动表
 */
public class ActivityVo extends Activity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8913459385326598839L;
	
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
	//录播视频URL
	private String videoUrl;
	
	private String activityTime ;
	
	private byte activityStatus ; 
	
	private String platformName;

	public String getActivityTime() {
		return activityTime;
	}

	public void setActivityTime(String activityTime) {
		this.activityTime = activityTime;
	}

	public byte getActivityStatus() {
		return activityStatus;
	}

	public void setActivityStatus(byte activityStatus) {
		this.activityStatus = activityStatus;
	}

	public Integer getVideoBackId() {
		return videoBackId;
	}

	public void setVideoBackId(Integer videoBackId) {
		this.videoBackId = videoBackId;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getVideoBitRate() {
		return videoBitRate;
	}

	public void setVideoBitRate(String videoBitRate) {
		this.videoBitRate = videoBitRate;
	}

	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	
	
}
