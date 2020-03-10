package com.mz.mapper.video;

import com.mz.bean.video.VideoBean;

import java.util.List;
public interface VideoSqlMapper{
	List<?> getVideoList(VideoBean bean);
	VideoBean getDataView(VideoBean bean);
	List<?> getTagList();
	List<?> getVideoListById(VideoBean bean);
	Integer updateVideo(VideoBean bean) throws Exception;
}