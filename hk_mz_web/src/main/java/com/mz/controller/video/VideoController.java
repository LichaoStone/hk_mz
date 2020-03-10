package com.mz.controller.video;

import java.io.BufferedReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.druid.util.IOUtils;
import com.mz.bean.tag.Tag;
import com.mz.bean.video.VideoBack;
import com.mz.bean.video.VideoBean;
import com.mz.frame.BaseController;
import com.mz.frame.aspect.annotation.PaginationController;
import com.mz.frame.page.PageContext;
import com.mz.service.video.VideoService;
import com.mz.util.HttpUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 视频成品库
 * @作者 lichao
 * @时间 2019-02-15 10:06:00
 * @说明
 * 
 */
@Controller
@RequestMapping("/video")
public class VideoController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
	
	@Resource
	private VideoService videoService ;
	
	/**
	 * 进入列表页
	 * @param model
	 * @return
	 */
	@RequestMapping("/toList")
	public ModelAndView toList(ModelAndView model) {
		model.setViewName("/video/video_list");
		return model;
	}
	
	/**
	 * 获取列表页数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getVideoList")
	@ResponseBody
	@PaginationController
	public void getVideoList(HttpServletRequest request,HttpServletResponse response,VideoBean bean) {
		String searchNameType=request.getParameter("searchNameType");
		String searchName=request.getParameter("searchName");
		String classicId=request.getParameter("classicId");
		String videoTag=request.getParameter("videoTag");
		String userId=request.getParameter("userId");
		
		logger.info("查询参数:searchNameType="+searchNameType+",searchName="+searchName+",classicId="+classicId+",videoTag="+videoTag+",userId="+userId);
		
		if("videoSourceName".equals(searchNameType)){
			bean.setVideoSourceName(searchName);
		}else if("videoName".equals(searchNameType)){
			bean.setVideoName(searchName);
		}
		
		//设置分页
		PageContext pageContext=setPagination(bean.getPageNumber(),bean.getPageSize());
		List<?> resultList = videoService.getVideoList(bean);
		
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList,pageContext.getTotalRows()),response);
	}
	
	
	/**
	 * 进入详情页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toView")
	public ModelAndView toView(ModelAndView nav,VideoBean bean) {
		bean=videoService.getDataView(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/video_view",model);
	}
	
	
	/**
	 * 进入修改页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toUpdate")
	public ModelAndView toUpdate(VideoBean bean) {
		bean=videoService.getDataView(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/video_update",model);
	}
	
	
	/**
	 * 下发视频
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/sendVideo")
	public void sendVideo(HttpServletRequest request,HttpServletResponse response,VideoBean bean){
		
		List<?> resultList=videoService.getVideoListById(bean);
		
		
		JSONArray  jsonArr=net.sf.json.JSONArray.fromObject(resultList);
		System.out.println(jsonArr);
		
		String json=jsonArr.toString();
		System.out.println(json);
		System.out.println("1111111111111111111111111");
		
		String  url="http://192.168.182.1:8080/video/receiveVideo";
		HttpUtils.reqForPost(url,json);
		
		//视频下发逻辑
		//... ...
		sendJson(getAjaxJson(true,"视频下发至xxxx成功"),response);
	}
	
	
	/**
	 * 接收视频消息测试类
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/receiveVideo")
	public void receiveVideo(HttpServletRequest request,HttpServletResponse response){
	      
	    try {

		      BufferedReader bufferedReader = request.getReader();
	          String bodyStr = IOUtils.read(bufferedReader);
	    	 
			  
			  logger.info("2222222222222");
			  logger.info(bodyStr);
			  JSONObject json=JSONObject.fromObject(bodyStr);//转化成json对象
			  logger.info(json.toString());
		} catch (Exception e) {
			logger.error("异常",e);
		}
	}
	
	
	/**
	 * 进入下载视频页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toDownVideo")
	public ModelAndView toDownVideo(HttpServletRequest request,HttpServletResponse response,VideoBean bean) {
		bean=videoService.getDataView(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/download_list",model);
	}
	
	
	
	/**
	 * 进入详情页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toSetTags")
	public ModelAndView toSetTags(HttpServletRequest request,HttpServletResponse response,VideoBean bean) {
		String videoTag=request.getParameter("videoTag");
		logger.info("videoTag="+videoTag);
		
		//bean=videoService.getDataView(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/video_tag_list",model);
	}
	
	
	/**
	 * 获取列表页数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getTagList")
	@ResponseBody
	public void getTagList(HttpServletRequest request,HttpServletResponse response,Tag bean) {
		List<?> resultList=videoService.getTagList();
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList),response);
	}
	
	
	/**
	 * 修改视频信息
	 * @param request
	 * @param response
	 * @param bean
	 * @return
	 */
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request,HttpServletResponse response,VideoBean bean) {
		String videoName=request.getParameter("videoName");
		String imgUrl=request.getParameter("imgUrl");
		String videoTag=request.getParameter("videoTag");
		String isShare=request.getParameter("isShare");
		String description=request.getParameter("description");
		
		logger.info("修改参数:videoName="+videoName+",imgUrl="+imgUrl+",videoTag="+videoTag+",isShare="+isShare+",description="+description);
		
		try {
			videoService.updateVideo(bean);	
			bean.setResult("1");
			bean.setResultInfo("修改成功");
		} catch (Exception e) {
			logger.error("修改视频信息失败",e);
			bean.setResult("0");
			bean.setResultInfo("修改视频信息失败");
		}
		
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/video_update",model);
	}
	
	
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_videoback_list")
	@ResponseBody
	public void getVideoBackList(VideoBack query,HttpServletResponse response) {
		//设置分页
		PageContext pageContext=setPagination(query.getPageNumber(), query.getPageSize());
		List<?> resultList = videoService.getVideoBackList(query);
		
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList,pageContext.getTotalRows()),response);
	}
}
