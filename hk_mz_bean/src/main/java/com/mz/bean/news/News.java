package com.mz.bean.news;

import java.io.Serializable;
import java.util.Date;
/**
 *资讯表
 */
public class News implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8231729721628915383L;
	//资讯id
	private Integer newsId;  
	//资讯标题
	private String newsTitle;  
	//资讯图标
	private String imgUrl;  
	//html文件地址
	private String htmlUrl;  
	//来源：0抓取，其他值为对应平台回传ID
	private Integer sourceType;  
	//状态：0禁用，1启用
	private Integer status;  
	//创建时间
	private Date createTime;  
	//分类
	private Integer classifyId;  
	//关键字
	private String keyWords;  
  	
	public Integer getNewsId(){  
		return newsId;  
	}  
	public void setNewsId(Integer newsId){  
		this.newsId = newsId;  
	}  
	public String getNewsTitle(){  
		return newsTitle;  
	}  
	public void setNewsTitle(String newsTitle){  
		this.newsTitle = newsTitle;  
	}  
	public String getImgUrl(){  
		return imgUrl;  
	}  
	public void setImgUrl(String imgUrl){  
		this.imgUrl = imgUrl;  
	}  
	public String getHtmlUrl(){  
		return htmlUrl;  
	}  
	public void setHtmlUrl(String htmlUrl){  
		this.htmlUrl = htmlUrl;  
	}  
	public Integer getSourceType(){  
		return sourceType;  
	}  
	public void setSourceType(Integer sourceType){  
		this.sourceType = sourceType;  
	}  
	public Integer getStatus(){  
		return status;  
	}  
	public void setStatus(Integer status){  
		this.status = status;  
	}  
	public Date getCreateTime(){  
		return createTime;  
	}  
	public void setCreateTime(Date createTime){  
		this.createTime = createTime;  
	}  
	public Integer getClassifyId(){  
		return classifyId;  
	}  
	public void setClassifyId(Integer classifyId){  
		this.classifyId = classifyId;  
	}  
	public String getKeyWords(){  
		return keyWords;  
	}  
	public void setKeyWords(String keyWords){  
		this.keyWords = keyWords;  
	}   
}
