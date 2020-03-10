/**
 * 
 */
package com.mz.service.video.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.video.VideoBack;
import com.mz.bean.video.VideoBean;
import com.mz.frame.aspect.annotation.PaginationService;
import com.mz.mapper.video.VideoBackMapper;
import com.mz.mapper.video.VideoSqlMapper;
import com.mz.service.video.VideoService;

/**
 *@作者 lichao
 *@时间 2019-2019年1月30日 上午9:41:11
 *@说明 
 */
@Service
public class VideoServiceImpl implements VideoService{
	@Resource
	VideoSqlMapper videoSqlMapper;
	
	@Resource
	VideoBackMapper videoBackMapper;
	/* (non-Javadoc)
	 * @see com.mz.service.video.VideoService#getVideoList(com.mz.bean.video.VideoBean)
	 */
	@Override
	@PaginationService
	public List<?> getVideoList(VideoBean bean) {
		List<?> resultList=videoSqlMapper.getVideoList(bean);
		return resultList;
	}

	@Override
	public VideoBean getDataView(VideoBean bean) {
		VideoBean resultBean=videoSqlMapper.getDataView(bean);
		return resultBean;
	}

	@Override
	public List<?> getTagList() {
		List<?> resultList=videoSqlMapper.getTagList();
		return resultList;
	}

	@Override
	public List<?> getVideoListById(VideoBean bean) {
		List<?> resultList=videoSqlMapper.getVideoListById(bean);
		return resultList;
	}

	@Override
	public Integer updateVideo(VideoBean bean) throws Exception {
		return videoSqlMapper.updateVideo(bean);
	}

	@Override
	public List<?> getVideoBackList(VideoBack bean) {
		List<?> resultList=videoBackMapper.getVideoBackListByQuery(bean);
		return resultList;
	}
	
	
}