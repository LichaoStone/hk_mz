package com.mz.bean.platform.query;

import com.mz.bean.platform.vo.PlatformVo;

/**
 *运营平台表
 */
public class PlatformVoQuery extends PlatformVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3868682416792222680L;

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
