package com.mz.service.active;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface ActivityServiceApi {
	/**
	 * 分页获得活动列表
	 * @param query
	 * @param page
	 * @param limit
	 * @return
	 */
	ServiceResult<PageVo<ActivityVo>> getActivityVoPage(ActivityVoQuery query, Integer page , Integer limit);
	/**
	 * 根据活动id获得活动详情
	 * @param activityId
	 * @return
	 */
	ServiceResult<ActivityVo> getActivityVoById(Integer activityId);
	/**
	 * 更新活动
	 * @param vo
	 * @return
	 */
	ServiceResult<Boolean> updataActivityVo(ActivityVo vo) ;

}
