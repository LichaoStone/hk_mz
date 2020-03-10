package com.mz.bean.tvplay;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
/**
 *电视剧剧头表
 */
public class Tvplay implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1006085188671603928L;
	//id
	private Integer tvplayId;  
	//电视剧名称
	private String tvplayName;  
	//版权开始时间
	private Date copyBeginTime;  
	//版权到期时间
	private Date copyEndTime;  
	//首播时间
	private Date showTime;  
	//集数
	private Integer tvplayNum;  
	//标签
	private String tvplayTag;  
	//导演
	private String director;  
	//国家
	private String national;  
	//语言
	private String language;  
	//主演
	private String mainActor;  
	//简介
	private String subdiscription;  
	//导入集数
	private Integer importNum;  
	//入库集数
	private Integer complateNum;  
	//创建时间
	private Date createTime;  
	//操作用户
	private Integer userId;  
	//电视剧源数据id
	private String sourceId;  
	//类型：电视剧、综艺（待定）
	private String type;  
  	
	public Integer getTvplayId(){  
		return tvplayId;  
	}  
	public void setTvplayId(Integer tvplayId){  
		this.tvplayId = tvplayId;  
	}  
	public String getTvplayName(){  
		return tvplayName;  
	}  
	public void setTvplayName(String tvplayName){  
		this.tvplayName = tvplayName;  
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
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
	public Date getShowTime(){  
		return showTime;  
	}  
	public void setShowTime(Date showTime){  
		this.showTime = showTime;  
	}  
	public Integer getTvplayNum(){  
		return tvplayNum;  
	}  
	public void setTvplayNum(Integer tvplayNum){  
		this.tvplayNum = tvplayNum;  
	}  
	public String getTvplayTag(){  
		return tvplayTag;  
	}  
	public void setTvplayTag(String tvplayTag){  
		this.tvplayTag = tvplayTag;  
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
	public String getSubdiscription(){  
		return subdiscription;  
	}  
	public void setSubdiscription(String subdiscription){  
		this.subdiscription = subdiscription;  
	}  
	public Integer getImportNum(){  
		return importNum;  
	}  
	public void setImportNum(Integer importNum){  
		this.importNum = importNum;  
	}  
	public Integer getComplateNum(){  
		return complateNum;  
	}  
	public void setComplateNum(Integer complateNum){  
		this.complateNum = complateNum;  
	} 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
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
	public String getSourceId(){  
		return sourceId;  
	}  
	public void setSourceId(String sourceId){  
		this.sourceId = sourceId;  
	}  
	public String getType(){  
		return type;  
	}  
	public void setType(String type){  
		this.type = type;  
	}  
}
