package com.mz.service.activity.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.mapper.activity.ActivityMapper;
import com.mz.service.activity.ActivityServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class ActivityServiceImpl implements ActivityServiceApi {
	@Resource
	private ActivityMapper activityMapper ;
	
	@Override
	public ServiceResult<PageVo<ActivityVo>> getActivityPage(ActivityVoQuery query) throws Exception {
		ServiceResult<PageVo<ActivityVo>> serviceResult = new ServiceResult<PageVo<ActivityVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<ActivityVo> list = activityMapper.getActivityListByQuery(query);
		PageVo<ActivityVo> pageVo = new PageVo<ActivityVo>((Page<ActivityVo>) list);
		serviceResult.setData(pageVo);
		return serviceResult;
	}


}
