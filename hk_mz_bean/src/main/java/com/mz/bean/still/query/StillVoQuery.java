package com.mz.bean.still.query;

import com.mz.bean.still.vo.StillVo;

/**
 *电影电视剧剧照
 */
public class StillVoQuery extends StillVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -817777299057371594L;

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
