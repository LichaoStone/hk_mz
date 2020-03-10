package com.mz.bean.classify.query;

import com.mz.bean.classify.vo.ClassifyVo;

/**
 *视频分类表
 */
public class ClassifyVoQuery extends ClassifyVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 879449939875920534L;

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
