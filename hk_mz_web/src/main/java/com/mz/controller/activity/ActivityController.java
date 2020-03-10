package com.mz.controller.activity;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.activity.query.ActivityVoQuery;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.bean.tag.Tag;
import com.mz.bean.tag.query.TagVoQuery;
import com.mz.bean.tag.vo.TagVo;
import com.mz.controller.WebBaseController;
import com.mz.service.activity.ActivityServiceApi;
import com.mz.service.tag.TagServiceApi;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/activity")
public class ActivityController extends WebBaseController{
	
	@Resource
	private ActivityServiceApi activityServiceApi ;
	
	/**
	 * 分页展示电影列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("activity/index");
		return mav ;
	}
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_activity_list")
	@ResponseBody
	public JsonResult getActivityList(ActivityVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<ActivityVo>> serviceResult;
		try {
			serviceResult = activityServiceApi.getActivityPage(query);
			jsonResult.setOk(serviceResult.isOk());
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult ;
	}
	
	@RequestMapping("list/{activityId}")
	public ModelAndView detail(@PathVariable String activityId, ModelAndView mav) {
		mav.setViewName("activity/playback");
		mav.addObject("activityId", activityId);
		return mav;
	}
}