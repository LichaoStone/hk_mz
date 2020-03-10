package com.mz.service.activity.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.mapper.activity.ActivityMapper;
import com.mz.service.activity.ActivityServiceApi;
import com.mz.util.bean.ServiceResult;
@Service
public class ActivityServiceImpl implements ActivityServiceApi {

	@Resource
	private ActivityMapper activityMapper ;
	
	@Transactional
	@Override
	public ServiceResult<ActivityVo> saveActivityVo(ActivityVo activityVo) {
		ServiceResult<ActivityVo> serviceResult = new ServiceResult<ActivityVo>(false);
		int count = activityMapper.insertActivity(activityVo);
		if (count > 0) {
			serviceResult.setOk(true);
			serviceResult.setComment("保存成功！");
			return serviceResult ;
		}
		serviceResult.setComment("保存失败");
		return serviceResult;
	}

	@Override
	public ServiceResult<List<ActivityVo>> getActivityVoListByQuery(ActivityVoQuery query) {
		ServiceResult<List<ActivityVo>> serviceResult = new ServiceResult<List<ActivityVo>>(true);
		List<ActivityVo> list = activityMapper.getActivityListByQuery(query);
		if (list == null) {
			list = new ArrayList<ActivityVo>(0);
		}
		serviceResult.setData(list);
		return serviceResult;
	}

}
