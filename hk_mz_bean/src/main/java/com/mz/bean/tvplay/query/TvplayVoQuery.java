package com.mz.bean.tvplay.query;

import com.mz.bean.tvplay.vo.TvplayVo;

/**
 *电视剧剧头表
 */
public class TvplayVoQuery extends TvplayVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5545600092557217847L;

	/**
	 * 每页数据条数
	 */
	private Integer pageSize ;

	/**
	 * 当前页数 
	 */
	private Integer offset ;
	
	/**
	 * 开始时间
	 */
	private String startTime;
	/**
	 * 结束时间
	 * @return
	 */
	private String endTime;
	
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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
