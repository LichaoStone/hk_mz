package com.mz.bean.standard.query;

import com.mz.bean.standard.vo.StandardVo;

/**
 *转码标准表
 */
public class StandardVoQuery extends StandardVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8405001636739999221L;

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
