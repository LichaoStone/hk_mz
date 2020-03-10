package com.mz.bean.permissions.query;

import com.mz.bean.permissions.vo.PermissionsVo;

/**
 *权限表
 */
public class PermissionsVoQuery extends PermissionsVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3040060564743961607L;

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
