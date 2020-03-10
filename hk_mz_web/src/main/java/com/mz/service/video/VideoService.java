/**
 * 
 */
package com.mz.service.video;

import java.util.List;

import com.mz.bean.video.VideoBack;
import com.mz.bean.video.VideoBean;


/**
 *@作者 lichao
 *@时间 2019-2019年1月30日 上午9:40:25
 *@说明 
 */
public interface VideoService {
	List<?> getVideoList(VideoBean bean);
	VideoBean getDataView(VideoBean bean);
	List<?> getTagList();
	List<?> getVideoListById(VideoBean bean);
	Integer updateVideo(VideoBean bean) throws Exception;
	
	
	List<?> getVideoBackList(VideoBack bean);
}

