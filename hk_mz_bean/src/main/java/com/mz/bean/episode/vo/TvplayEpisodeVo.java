package com.mz.bean.episode.vo;

import com.mz.bean.episode.TvplayEpisode;

/**
 *剧集表
 */
public class TvplayEpisodeVo extends TvplayEpisode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3984973017193957144L;
	/**
	 * 电视剧名称
	 */
	private String tvplayName;
	/**
	 * 标签
	 */
	private String tvplayTag;  
	
	public String getTvplayName() {
		return tvplayName;
	}
	public void setTvplayName(String tvplayName) {
		this.tvplayName = tvplayName;
	}
	public String getTvplayTag() {
		return tvplayTag;
	}
	public void setTvplayTag(String tvplayTag) {
		this.tvplayTag = tvplayTag;
	}  
	
}
