package com.mz.bean.transcode.query;

import com.mz.bean.transcode.vo.TranscodeVo;

/**
 *转码记录表
 */
public class TranscodeVoQuery extends TranscodeVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3554646750529286407L;

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
