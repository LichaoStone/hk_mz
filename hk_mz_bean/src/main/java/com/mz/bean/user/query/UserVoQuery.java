package com.mz.bean.user.query;

import com.mz.bean.user.vo.UserVo;

/**
 *用户表
 */
public class UserVoQuery extends UserVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5986233706884319589L;
	
	/**
	 * 每页数据条数
	 */
	private Integer pageSize ;

	/**
	 * 当前页数 
	 */
	private Integer offset ;
	
	public Integer getPageSize() {
		if (pageSize == null) {
			pageSize = 10 ;
		}
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getOffset() {
		if (offset == null) {
			offset = 1 ;
		}
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}
	
}
