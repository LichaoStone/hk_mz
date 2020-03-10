package com.mz.bean.opration.query;

import com.mz.bean.opration.vo.OprationVo;

/**
 *操作类型表
 */
public class OprationVoQuery extends OprationVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7595157684645622204L;

	/**
	 * 每页数据条数
	 */
	private Integer pageSize ;

	/**
	 * 当前页数 
	 */
	private Integer offset ;
	
	private Integer roleId ;
	
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

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
}
