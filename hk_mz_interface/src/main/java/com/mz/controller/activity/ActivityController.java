package com.mz.controller.activity;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.service.activity.ActivityServiceApi;
import com.mz.util.bean.Constants;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Resource
	private ActivityServiceApi activityServiceImpl;
	//推流地址
	@Value("${pushUrl}")
	private String pushUrl ;
	//录播地址
	@Value("${recordingBroadcastingUrl}")
	private String recordingBroadcastingUrl ;
	/**
	 * 
	 * @Title: subPlatformBackActivity   
	 * @Description: 活动回传  
	 * @param: @param activityVo
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws 
	 * @author: banbu
	 */
	@RequestMapping("/sub_platform_back_activity")
	@ResponseBody
	public JsonResult subPlatformBackActivity(ActivityVo activityVo) {
		JsonResult jsonResult = new JsonResult(false);
		if (activityVo.getActivityId() == null || activityVo.getActivityId() <= 0) {
			jsonResult.setComment("活动ID不正确");
			return jsonResult ;
		}
		if (activityVo.getPlatformId() == null || activityVo.getPlatformId() <= 0) {
			jsonResult.setComment("平台ID不能为空");
			return jsonResult ;
		}
		String pushUrl = String.format(Constants.ACTIVITY.PUSH_URL,
				 	activityVo.getActivityId(),
				 	activityVo.getPlatformId());
		activityVo.setPushUrl(pushUrl);
		ServiceResult<ActivityVo> serviceResult = activityServiceImpl.saveActivityVo(activityVo);
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		jsonResult.setData(activityVo);
		return jsonResult ;
	}
	
	/**
	 * 
	 * @Title: liveBroadcastSubPlatform   
	 * @Description: 直播地址下发接口 
	 * @param: @param activityVo
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws 
	 * @author: banbu
	 */
	@RequestMapping("/live_broadcast_sub_platform")
	@ResponseBody
	public JsonResult liveBroadcastSubPlatform(ActivityVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<List<ActivityVo>> serviceResult = activityServiceImpl.getActivityVoListByQuery(query);
		if (serviceResult.getData() != null && serviceResult.getData().size() > 0) {
			serviceResult.getData().stream().forEach(activityVo -> {
				activityVo.setPushUrl(pushUrl+activityVo.getPushUrl());
			});
		}
		jsonResult.setData(serviceResult.getData());
		return jsonResult ;
	}
	/**
	 * 
	 * @Title: recordingBroadcastSubPlatform   
	 * @Description: 录播视频下发接口
	 * @param: @param query
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws 
	 * @author: banbu
	 */
	@RequestMapping("/recording_broadcast_sub_platform")
	@ResponseBody
	public JsonResult recordingBroadcastSubPlatform(ActivityVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<List<ActivityVo>> serviceResult = activityServiceImpl.getActivityVoListByQuery(query);
		if (serviceResult.getData() != null && serviceResult.getData().size() > 0) {
			serviceResult.getData().stream().forEach(activityVo -> {
				activityVo.setPushUrl(pushUrl+activityVo.getPushUrl());
				activityVo.setPushUrl(recordingBroadcastingUrl+activityVo.getVideoUrl());
			});
		}
		jsonResult.setData(serviceResult.getData());
		return jsonResult ;
	}
}