package com.mz.service.active.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.mapper.activity.ActivityMapper;
import com.mz.service.active.ActivityServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;


@Service
public class ActivityServiceImpl implements ActivityServiceApi{
	
	@Value("${pushUrl}")
	private String pushUrl ;
	
	@Resource
	private ActivityMapper activityMapper ;

	@Override
	public ServiceResult<PageVo<ActivityVo>> getActivityVoPage(ActivityVoQuery query, Integer page, Integer limit) {
		ServiceResult<PageVo<ActivityVo>> serviceResult = new ServiceResult<PageVo<ActivityVo>>(true);
		query.setPushUrl(pushUrl);
		PageHelper.startPage(page, limit);
		List<ActivityVo> list = activityMapper.getActivityListByQuery(query);
		Page<ActivityVo> voPage = (Page<ActivityVo>) list ;
		PageVo<ActivityVo> pageVo = new PageVo<ActivityVo>();
		pageVo.setRows(voPage.getResult());
		pageVo.setTotal(voPage.getTotal());
		serviceResult.setData(pageVo);
		serviceResult.setComment("获取成功");
		return serviceResult;
	}

	@Override
	public ServiceResult<ActivityVo> getActivityVoById(Integer activityId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public ServiceResult<Boolean> updataActivityVo(ActivityVo vo) {
		ServiceResult<Boolean> serviceResult = new ServiceResult<Boolean>(false);
		int count = activityMapper.updateActivityBySelective(vo);
		if (count <= 0) {
			serviceResult.setComment("更新失败");
			return serviceResult ;
		}
		serviceResult.setComment("成功");
		return serviceResult;
	}

	
}
