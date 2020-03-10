package com.mz.bean.synchrolog.query;

import com.mz.bean.synchrolog.vo.SynchroLogVo;

/**
 *下发日志表
 */
public class SynchroLogVoQuery extends SynchroLogVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7446093489784002258L;

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
