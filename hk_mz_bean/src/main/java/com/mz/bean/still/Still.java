package com.mz.bean.still;

import java.io.Serializable;
import java.util.Date;
/**
 *电影电视剧剧照
 */
public class Still implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 674786847548074868L;
	//id
	private Integer stillId;  
	//类型：movie电影，tvplay电视剧
	private String contentType;  
	//所属内容id
	private Integer contentId;  
	//图片地址
	private String imgUrl;  
	//顺序号
	private Integer orderNum;  
	//
	private Date createTime;  
	//
	private Integer userId;  
  	
	public Integer getStillId(){  
		return stillId;  
	}  
	public void setStillId(Integer stillId){  
		this.stillId = stillId;  
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
	public String getImgUrl(){  
		return imgUrl;  
	}  
	public void setImgUrl(String imgUrl){  
		this.imgUrl = imgUrl;  
	}  
	public Integer getOrderNum(){  
		return orderNum;  
	}  
	public void setOrderNum(Integer orderNum){  
		this.orderNum = orderNum;  
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
}
