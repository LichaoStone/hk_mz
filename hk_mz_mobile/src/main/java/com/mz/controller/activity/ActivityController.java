package com.mz.controller.activity;

import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.config.web.ResponseResultBean;
import com.mz.service.active.ActivityServiceApi;
import com.mz.util.bean.Constants;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/activity")
public class ActivityController {

	@Resource
	private ActivityServiceApi activityServiceApi ;
	
	@RequestMapping("/get_activity_list")
	@ResponseResultBean
	public JsonResult getActivityList(HttpServletRequest request,
			@RequestParam("page")Integer page,
			@RequestParam("limit")Integer limit,
			@RequestParam("userId")Integer userId) {
		
		JsonResult jsonResult = new JsonResult();
		ActivityVoQuery query = new ActivityVoQuery();
		ServiceResult<PageVo<ActivityVo>> serviceResult = activityServiceApi.getActivityVoPage(query, page, limit);
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		jsonResult.setList(serviceResult.getData().getRows());
		jsonResult.setTotalCount(serviceResult.getData().getTotal());
		return jsonResult;
	}
	
	@RequestMapping("/start_push")
	@ResponseResultBean
	public JsonResult updataActivityVo(HttpServletRequest request,
			@RequestParam("activityId")Integer activityId) {
		JsonResult jsonResult = new JsonResult();
		ActivityVo vo = new ActivityVo();
		vo.setActivityId(activityId);
		vo.setPushStatus(Integer.parseInt(Constants.ACTIVITY.PUSH_STATUS_YES+""));
		vo.setPushTime(new Date());
		ServiceResult<Boolean> serviceResult = activityServiceApi.updataActivityVo(vo);
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult;
	}
}
