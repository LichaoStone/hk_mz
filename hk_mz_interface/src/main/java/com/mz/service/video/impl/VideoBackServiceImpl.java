package com.mz.service.video.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.bean.video.VideoBack;
import com.mz.mapper.activity.ActivityMapper;
import com.mz.mapper.video.VideoBackMapper;
import com.mz.service.video.VideoBackServiceApi;
import com.mz.util.DateTimeUtils;
import com.mz.util.bean.ServiceResult;
@Service
public class VideoBackServiceImpl implements VideoBackServiceApi{

	@Resource
	private VideoBackMapper videoBackMapper ;
	@Resource
	private ActivityMapper activityMapper ;
	@Override
	@Transactional
	public ServiceResult<Boolean> saveVideoBack(VideoBack videoBack) {
		ServiceResult<Boolean> serviceResult = new ServiceResult<Boolean>(false);
		ActivityVoQuery query = new ActivityVoQuery();
		query.setPushUrl(videoBack.getPushUrl());
		List<ActivityVo> list = activityMapper.getActivityListByQuery(query);
		
		if (list == null || list.size() <= 0) {
			serviceResult.setComment("没有对应的活动");
			return serviceResult ;
		}
		ActivityVo activityVo = list.get(0);
		videoBack.setActivityId(activityVo.getActivityId());
		videoBack.setVideoName(videoBack.getVideoName());
		videoBack.setCreateTime(DateTimeUtils.format(new Date(), DateTimeUtils.YYYY_MM_DD_HH_mm_ss));
		int count = videoBackMapper.insertVideoBack(videoBack);
		if (count > 0) {
			serviceResult.setComment("保存成功");
			serviceResult.setOk(true);
			return serviceResult ;
		}
		serviceResult.setComment("保存失败");
		return serviceResult;
	}
	@Override
	public ServiceResult<List<VideoBack>> getVideoBackListByQuery(VideoBack videoBack) {
		ServiceResult<List<VideoBack>> serviceResult = new ServiceResult<List<VideoBack>>(true);
		List<VideoBack> list = videoBackMapper.getVideoBackListByQuery(videoBack);
		if (list == null) {
			list = new ArrayList<VideoBack>(0);
		}
		serviceResult.setData(list);
		return serviceResult;
	}
	

}
