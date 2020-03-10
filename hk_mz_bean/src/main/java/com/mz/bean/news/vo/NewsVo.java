package com.mz.bean.news.vo;

import com.mz.bean.news.News;

/**
 *资讯表
 */
public class NewsVo extends News{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2284357853651046907L;
	
	private String classifyName;
	
	private String platformName;
	
	private String sourceName;

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getPlatformName() {
		return platformName;
	}

	public void setPlatformName(String platformName) {
		this.platformName = platformName;
	}
	
}
