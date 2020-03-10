package com.mz.bean.movie;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 *电影表
 */
public class Movie implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -722959891512481870L;
	//电影id
	private Integer movieId;  
	//视频名称
	private String movieName;  
	//标签
	private String movieTag;  
	//转码用户id
	private Integer userId;  
	//转码标准，多个标准用"/"隔开
	private String standard;  
	//创建时间
	private Date createTime;  
	//视频时长
	private String movieLong;  
	//标清视频地址
	private String videoUrl480;  
	//高清视频地址
	private String videoUrl720;  
	//超清视频地址
	private String videoUrl1080;  
	//入库状态：0未入库，1入库中，2入库失败，3入库成功
	private Integer status;  
	//入库时间
	private Date complateTime;  
	//版权开始时间
	private Date copyBeginTime;  
	//版权结束时间
	private Date copyEndTime;  
	//上映时间
	private Date showTime;  
	//导演
	private String director;  
	//国家
	private String national;  
	//语言
	private String language;  
	//主演
	private String mainActor;  
	//简介
	private String subdescription;  
	//电影源数据id
	private String sourceId;  
  	
	public Integer getMovieId(){  
		return movieId;  
	}  
	public void setMovieId(Integer movieId){  
		this.movieId = movieId;  
	}  
	public String getMovieName(){  
		return movieName;  
	}  
	public void setMovieName(String movieName){  
		this.movieName = movieName;  
	}  
	public String getMovieTag(){  
		return movieTag;  
	}  
	public void setMovieTag(String movieTag){  
		this.movieTag = movieTag;  
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
	public Date getCreateTime(){  
		return createTime;  
	}  
	public void setCreateTime(Date createTime){  
		this.createTime = createTime;  
	}  
	public String getMovieLong(){  
		return movieLong;  
	}  
	public void setMovieLong(String movieLong){  
		this.movieLong = movieLong;  
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
	public Integer getStatus(){  
		return status;  
	}  
	public void setStatus(Integer status){  
		this.status = status;  
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getComplateTime(){  
		return complateTime;  
	}  
	public void setComplateTime(Date complateTime){  
		this.complateTime = complateTime;  
	}  
	public Date getCopyBeginTime(){  
		return copyBeginTime;  
	}  
	public void setCopyBeginTime(Date copyBeginTime){  
		this.copyBeginTime = copyBeginTime;  
	}  
	public Date getCopyEndTime(){  
		return copyEndTime;  
	}  
	public void setCopyEndTime(Date copyEndTime){  
		this.copyEndTime = copyEndTime;  
	}  
	public Date getShowTime(){  
		return showTime;  
	}  
	public void setShowTime(Date showTime){  
		this.showTime = showTime;  
	}  
	public String getDirector(){  
		return director;  
	}  
	public void setDirector(String director){  
		this.director = director;  
	}  
	public String getNational(){  
		return national;  
	}  
	public void setNational(String national){  
		this.national = national;  
	}  
	public String getLanguage(){  
		return language;  
	}  
	public void setLanguage(String language){  
		this.language = language;  
	}  
	public String getMainActor(){  
		return mainActor;  
	}  
	public void setMainActor(String mainActor){  
		this.mainActor = mainActor;  
	}  
	public String getSubdescription(){  
		return subdescription;  
	}  
	public void setSubdescription(String subdescription){  
		this.subdescription = subdescription;  
	}  
	public String getSourceId(){  
		return sourceId;  
	}  
	public void setSourceId(String sourceId){  
		this.sourceId = sourceId;  
	}  
}
