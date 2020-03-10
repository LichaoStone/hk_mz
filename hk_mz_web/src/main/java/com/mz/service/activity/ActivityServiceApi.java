package com.mz.service.activity;


import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface ActivityServiceApi {
	
	//获取电影列表
	ServiceResult<PageVo<ActivityVo>> getActivityPage(ActivityVoQuery query) throws Exception;

}
