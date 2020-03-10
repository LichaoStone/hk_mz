package com.mz.bean.activity.query;

import com.mz.bean.activity.vo.ActivityVo;

/**
 *活动表
 */
public class ActivityVoQuery extends ActivityVo{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5963904108054081746L;
	

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
