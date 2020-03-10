package com.mz.bean.transcode.vo;

import com.mz.bean.transcode.Transcode;

/**
 *转码记录表
 */
public class TranscodeVo extends Transcode{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3864809463659911148L;
	
	private String createTimeStr;

	public String getCreateTimeStr() {
		return createTimeStr;
	}

	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	
	
}
