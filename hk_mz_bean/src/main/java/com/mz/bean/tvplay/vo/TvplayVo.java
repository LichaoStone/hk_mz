package com.mz.bean.tvplay.vo;

import java.util.List;

import com.mz.bean.still.vo.StillVo;
import com.mz.bean.tvplay.Tvplay;

/**
 *电视剧剧头表
 */
public class TvplayVo extends Tvplay{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1211437180650370449L;
	//图片地址
	private List<StillVo> listStill;
	public List<StillVo> getListStill() {
		return listStill;
	}
	public void setListStill(List<StillVo> listStill) {
		this.listStill = listStill;
	}
	
	
}
