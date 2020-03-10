package com.mz.bean.video;

import java.io.Serializable;

import com.mz.util.bean.BaseEntity;
/**
 *视频素材表
 */
public class VideoSourceBean extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 7041282363174429257L;
	//视频素材id
	private String videoSourceId;  
	//视频素材名称
	private String videoSourceName;  
	//所属分类
	private String classifyId;  
	//上传的用户id
	private String userId;  
	//视频地址
	private String videoUrl;  
	//创建时间
	private String createTime;  
	//分辨率
	private String resolution;  
	//码率
	private String videoBitRate;  
	//视频大小
	private String fileSize;  
	//状态：-1删除，1正常
	private String status;  
	//回收站是否清除：0未清除，1已清除
	private String isClean;  
	//视频删除时间
	private String deleteTime;  
	
	/**分类名称**/
	private String classifyName;
	/**用户名称**/
	private String userName;
	
	private String imgUrl;
	
	private String videoCount;
  	
	public String getVideoSourceName(){  
		return videoSourceName;  
	}  
	public void setVideoSourceName(String videoSourceName){  
		this.videoSourceName = videoSourceName;  
	}  
	public String getVideoUrl(){  
		return videoUrl;  
	}  
	public void setVideoUrl(String videoUrl){  
		this.videoUrl = videoUrl;  
	}  
    
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
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
	public String getFileSize(){  
		return fileSize;  
	}  
	public void setFileSize(String fileSize){  
		this.fileSize = fileSize;  
	}  
	public String getDeleteTime() {
		return deleteTime;
	}
	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getVideoCount() {
		return videoCount;
	}
	public void setVideoCount(String videoCount) {
		this.videoCount = videoCount;
	}
	public String getVideoSourceId() {
		return videoSourceId;
	}
	public void setVideoSourceId(String videoSourceId) {
		this.videoSourceId = videoSourceId;
	}
	public String getClassifyId() {
		return classifyId;
	}
	public void setClassifyId(String classifyId) {
		this.classifyId = classifyId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getIsClean() {
		return isClean;
	}
	public void setIsClean(String isClean) {
		this.isClean = isClean;
	}
}
