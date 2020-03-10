package com.mz.service.activity;

import java.util.List;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.util.bean.ServiceResult;

public interface ActivityServiceApi {

	/**
	 * 
	 * @Title: saveActivityVo   
	 * @Description: 保存活动  
	 * @param: @param activityVo
	 * @param: @return      
	 * @return: ServiceResult<ActivityVo>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<ActivityVo> saveActivityVo(ActivityVo activityVo);
	/**
	 * 
	 * @Title: getActivityVoListByQuery   
	 * @Description: 获得活动列表 
	 * @param: @param query
	 * @param: @return      
	 * @return: ServiceResult<List<ActivityVo>>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<List<ActivityVo>> getActivityVoListByQuery(ActivityVoQuery query);
}
