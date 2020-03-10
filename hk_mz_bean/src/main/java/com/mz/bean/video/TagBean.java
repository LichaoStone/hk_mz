package com.mz.bean.video;

import java.io.Serializable;

import com.mz.util.bean.BaseEntity;
/**
 * @author lichao
 */
public class TagBean extends BaseEntity implements Serializable{
	private static final long serialVersionUID = 1L;
	
	//标签id
	private Integer tagId;  
	//标签内容
	private String tagName;  
	
	/**
	 * 标签类型:
	 * 		video视频
	 * 		movie电影
	 * 		tvplay剧集
	 */
	private String tagType;  
	
	/**
	 * 用于标签排序:
	 * 	  A、B、C、D、E...
	 */
	private String word;
	
	public Integer getTagId() {
		return tagId;
	}
	public void setTagId(Integer tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public String getTagType() {
		return tagType;
	}
	public void setTagType(String tagType) {
		this.tagType = tagType;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
}
