package com.mz.bean.tag.vo;

import com.mz.bean.tag.Tag;

/**
 *视频标签库表
 */
public class TagVo extends Tag{

	/**
	 * 
	 */
	private static final long serialVersionUID = -483844063714797792L;
	//标签
	private String tags;
	//层级数
	private String num;
	private Integer tagCount;
	//首字母
	private String word;
	public Integer getTagCount() {
		return tagCount;
	}
	public void setTagCount(Integer tagCount) {
		this.tagCount = tagCount;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	
}
