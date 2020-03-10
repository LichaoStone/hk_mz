package com.mz.bean.episode;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 *剧集表
 */
public class TvplayEpisode implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7604959735616447523L;
	//id
	private Integer tvplayEpisodeId;  
	//剧头id
	private Integer tvplayId;  
	//剧集名称
	private String episodeName;  
	/**
	 *第几集
	 */
	private Integer episodeNum;  
	//转码标准
	private String standard;  
	//创建时间
	private Date createTime;  
	//创建用户id
	private Integer userId;  
	//剧集时长
	private String episodeLong;  
	//入库时间
	private Date complateTime;  
	//入库状态：0未入库，1入库中，2入库失败，3入库成功
	private Integer status;  
	//标清地址
	private String videoUrl480;  
	//高清地址
	private String videoUrl720;  
	//超清地址
	private String videoUrl1080;  
	//剧集简介
	private String subdescription;  
	//剧集源数据id
	private String sourceId;  
  	
	public Integer getTvplayEpisodeId(){  
		return tvplayEpisodeId;  
	}  
	public void setTvplayEpisodeId(Integer tvplayEpisodeId){  
		this.tvplayEpisodeId = tvplayEpisodeId;  
	}  
	public Integer getTvplayId(){  
		return tvplayId;  
	}  
	public void setTvplayId(Integer tvplayId){  
		this.tvplayId = tvplayId;  
	}  
	public String getEpisodeName(){  
		return episodeName;  
	}  
	public void setEpisodeName(String episodeName){  
		this.episodeName = episodeName;  
	}  
	public Integer getEpisodeNum() {
		return episodeNum;
	}
	public void setEpisodeNum(Integer episodeNum) {
		this.episodeNum = episodeNum;
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
	public Integer getUserId(){  
		return userId;  
	}  
	public void setUserId(Integer userId){  
		this.userId = userId;  
	}  
	public String getEpisodeLong(){  
		return episodeLong;  
	}  
	public void setEpisodeLong(String episodeLong){  
		this.episodeLong = episodeLong;  
	}
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getComplateTime(){  
		return complateTime;  
	}  
	public void setComplateTime(Date complateTime){  
		this.complateTime = complateTime;  
	}  
	public Integer getStatus(){  
		return status;  
	}  
	public void setStatus(Integer status){  
		this.status = status;  
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
