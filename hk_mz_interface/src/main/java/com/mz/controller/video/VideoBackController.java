package com.mz.controller.video;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.bean.video.VideoBack;
import com.mz.service.video.VideoBackServiceApi;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/video_back")
public class VideoBackController {

	@Resource
	private VideoBackServiceApi videoBackServiceImpl ;
	/**
	 * 
	 * @Title: saveVideoBack   
	 * @Description: 录播视频保存  
	 * @param: @param videoBack
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws 
	 * @author: banbu
	 */
	@RequestMapping("/save_video_back")
	@ResponseBody
	public JsonResult saveVideoBack(VideoBack videoBack) {
		JsonResult jsonResult = new JsonResult(false);
		ServiceResult<Boolean> serviceResult = videoBackServiceImpl.saveVideoBack(videoBack);
		jsonResult.setComment(serviceResult.getComment());
		jsonResult.setOk(serviceResult.isOk());
		return jsonResult ;
	}
	
//	@RequestMapping("/get_video_back_list")
//	@ResponseBody
//	public JsonResult getVideoBackList(VideoBack videoBack) {
//		JsonResult jsonResult = new JsonResult(false);
//		ServiceResult<Boolean> serviceResult = videoBackServiceImpl.saveVideoBack(videoBack);
//		jsonResult.setComment(serviceResult.getComment());
//		jsonResult.setOk(serviceResult.isOk());
//		return jsonResult ;
//	}
	
	
}
