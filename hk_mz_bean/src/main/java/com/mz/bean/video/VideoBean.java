package com.mz.bean.video;

import java.io.Serializable;

import com.mz.util.bean.BaseEntity;
/**
 *视频成品库表
 */
public class VideoBean  extends BaseEntity implements Serializable {
	private static final long serialVersionUID = -8677119705368134413L;
	
	//成品id
	private String videoId;  
	//视频名称
	private String videoName;  
	//所属分类
	private Integer classifyId;  
	//视频截图地址
	private String imgUrl;  
	//标签
	private String videoTag;  
	//转码用户id
	private Integer userId;  
	//转码标准，多个标准用"/"隔开
	private String standard;  
	//是否共享，0否，1是
	private Integer isShare;  
	//所属平台
	private Integer platformId;  
	//创建时间
	private String createTime;  
	//视频时长
	private String videoLong;  
	//标清视频地址
	private String videoUrl480;  
	//高清视频地址
	private String videoUrl720;  
	//超清视频地址
	private String videoUrl1080;
	/**描述**/
	private String description;
	
	/**用户名称**/
	private String userName;
	/**分类名称**/
	private String classifyName;
  	/**素材名称**/
	private String videoSourceName;
	/**素材库ID**/
	private String videoSourceId;
	
    
	public String getVideoId() {
		return videoId;
	}
	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}
	public String getVideoName(){  
		return videoName;  
	}  
	public void setVideoName(String videoName){  
		this.videoName = videoName;  
	}  
	public Integer getClassifyId(){  
		return classifyId;  
	}  
	public void setClassifyId(Integer classifyId){  
		this.classifyId = classifyId;  
	}  
	public String getImgUrl(){  
		return imgUrl;  
	}  
	public void setImgUrl(String imgUrl){  
		this.imgUrl = imgUrl;  
	}  
	public String getVideoTag(){  
		return videoTag;  
	}  
	public void setVideoTag(String videoTag){  
		this.videoTag = videoTag;  
	}  
	public Integer getUserId(){  
		return userId;  
	}  
	public void setUserId(Integer userId){  
		this.userId = userId;  
	}  
	public String getStandard(){  
		return standard;  
	}  
	public void setStandard(String standard){  
		this.standard = standard;  
	}  
	public Integer getIsShare(){  
		return isShare;  
	}  
	public void setIsShare(Integer isShare){  
		this.isShare = isShare;  
	}  
	public Integer getPlatformId(){  
		return platformId;  
	}  
	public void setPlatformId(Integer platformId){  
		this.platformId = platformId;  
	}  
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getVideoLong(){  
		return videoLong;  
	}  
	public void setVideoLong(String videoLong){  
		this.videoLong = videoLong;  
	}  
	public String getVideoUrl480(){  
		return videoUrl480;  
	}  
	public void setVideoUrl480(String videoUrl480){  
		this.videoUrl480 = videoUrl480;  
	}  
	public String getVideoUrl720(){  
		return videoUrl720;  
	}  
	public void setVideoUrl720(String videoUrl720){  
		this.videoUrl720 = videoUrl720;  
	}   
	public String getVideoUrl1080(){  
		return videoUrl1080;  
	}  
	public void setVideoUrl1080(String videoUrl1080){  
		this.videoUrl1080 = videoUrl1080;  
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getClassifyName() {
		return classifyName;
	}
	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}
	public String getVideoSourceName() {
		return videoSourceName;
	}
	public void setVideoSourceName(String videoSourceName) {
		this.videoSourceName = videoSourceName;
	}
	public String getVideoSourceId() {
		return videoSourceId;
	}
	public void setVideoSourceId(String videoSourceId) {
		this.videoSourceId = videoSourceId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}  
}
