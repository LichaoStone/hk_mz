package com.mz.service.video;

import java.util.List;

import com.mz.bean.video.VideoBack;
import com.mz.util.bean.ServiceResult;

public interface VideoBackServiceApi {

	/**
	 * 
	 * @Title: saveVideoBack   
	 * @Description: 录播视频保存  
	 * @param: @param videoBack
	 * @param: @return      
	 * @return: ServiceResult<Boolean>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<Boolean> saveVideoBack(VideoBack videoBack);
	/**
	 * 
	 * @Title: getVideoBackListByQuery   
	 * @Description: 获得录播视频列表  
	 * @param: @param videoBack
	 * @param: @return      
	 * @return: ServiceResult<List<VideoBack>>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<List<VideoBack>> getVideoBackListByQuery(VideoBack videoBack);
}
