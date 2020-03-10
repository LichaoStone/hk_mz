package com.mz.bean.menu.query;

import com.mz.bean.menu.vo.MenuVo;

/**
 *菜单表
 */
public class MenuVoQuery extends MenuVo{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6070111154300001177L;

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
