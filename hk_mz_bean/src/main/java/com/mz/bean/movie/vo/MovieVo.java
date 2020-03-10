package com.mz.bean.movie.vo;

import java.util.List;

import com.mz.bean.movie.Movie;
import com.mz.bean.still.vo.StillVo;

/**
 *电影表
 */
public class MovieVo extends Movie{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4371540666424099750L;
	//电影资源下载地址
	private String downloadPath;
	//图片地址
	private List<StillVo> listStill;
	public String getDownloadPath() {
		return downloadPath;
	}
	public void setDownloadPath(String downloadPath) {
		this.downloadPath = downloadPath;
	}
	public List<StillVo> getListStill() {
		return listStill;
	}
	public void setListStill(List<StillVo> listStill) {
		this.listStill = listStill;
	}
	
}
