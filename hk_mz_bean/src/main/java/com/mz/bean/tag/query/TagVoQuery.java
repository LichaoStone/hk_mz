package com.mz.bean.tag.query;

import com.mz.bean.tag.vo.TagVo;

/**
 *视频标签库表
 */
public class TagVoQuery extends TagVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 670117559226048091L;

	/**
	 * 每页数据条数
	 */
	private Integer pageSize ;

	/**
	 * 当前页数 
	 */
	private Integer offset ;
	
	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
}
