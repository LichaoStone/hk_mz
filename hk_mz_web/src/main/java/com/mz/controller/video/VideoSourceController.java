/**
 * 
 */
package com.mz.controller.video;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.classify.vo.ClassifyVo;
import com.mz.bean.video.VideoSourceBean;
import com.mz.frame.BaseController;
import com.mz.frame.page.PageContext;
import com.mz.service.video.VideoSourceService;
import com.mz.util.PkCreat;
import com.mz.util.Productor;
import com.mz.util.UploadImage;


/**
 * 视频素材库
 *@作者 lichao
 *@时间 2019-2019年1月30日 上午10:26:48
 *@说明 
 */
@Controller
@RequestMapping("/videoSource")
public class VideoSourceController  extends BaseController{
	private static final String KAFKA_TRANSCODING_TOPIC="";
	private static final Logger logger = LoggerFactory.getLogger(VideoSourceController.class);
	
	@Resource
	private VideoSourceService videoSourceService;
	
	/**
	 * 进入列表页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toList")
	public ModelAndView toList(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/video/videosource_list")  ;
	}
	
	/**
	 * 获取列表页数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getVideoSourceList")
	@ResponseBody
	public void getVideoSourceList(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		String videoSourceName=request.getParameter("videoSourceName");
		String classifyId=request.getParameter("classifyId");
		String userId=request.getParameter("userId");
		String createTime=request.getParameter("createTime");
		
		logger.info("【视频素材列表页】videoSourceName="+videoSourceName+",classifyId="+classifyId+",userId="+userId+",createTime="+createTime);
		
		
		
		VideoSourceBean paraBean=new VideoSourceBean();
		if(createTime!=null&&!"".equals(createTime)){
			String[] time=createTime.split("-");
			paraBean.setBeginTime(time[0].replace("/","-"));
			paraBean.setEndTime(time[1].replace("/","-"));
		}
		
		
		paraBean.setVideoSourceName(videoSourceName);
		paraBean.setClassifyId(classifyId);
		paraBean.setUserId(userId);
		//设置分页
		PageContext pageContext=setPagination(bean.getPageNumber(),bean.getPageSize());
		List<VideoSourceBean> resultList =  (List<VideoSourceBean>) videoSourceService.getVideoSourceList(paraBean);
		
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList,pageContext.getTotalRows()),response);
	}
	
	
	/**
	 * 进入详情页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toView")
	public ModelAndView toView(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		bean=videoSourceService.getDataView(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return  new ModelAndView("/video/videosource_view",model) ;
	}
	
	
	/**
	 * 进入修改页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toUpload")
	public ModelAndView toUpload(HttpServletRequest request,HttpServletResponse response,ClassifyVo bean) {
		
		bean=videoSourceService.getClassifyNameById(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/videosource_upload_list",model) ;
	}
	

	/**
	 * 进入转码列表页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toTranscoding")
	public ModelAndView toTranscoding(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/video/videosource_transcoding_list") ;
	}
	
	/**
	 * 请求转码
	 */
	@RequestMapping("/transcoding")
	@ResponseBody
	public void transcoding(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		Productor.send(bean.getVideoSourceId(),PkCreat.getTablePk(),KAFKA_TRANSCODING_TOPIC);
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS),response);
	}
	
	
	/**
	 * 获取转码列表页数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getTranscodingList")
	@ResponseBody
	public void getTranscodingList(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		String status=request.getParameter("status");
		
		logger.info("【获取转码列表页】status="+status);
		
		bean.setStatus(status);
		//设置分页
		PageContext pageContext=setPagination(bean.getPageNumber(),bean.getPageSize());
		List<?> resultList =  videoSourceService.getTranscodingList(bean);
		
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList,pageContext.getTotalRows()),response);
	}
	
	
	/**
	 * 进入回收站列表页
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toDustbin")
	public ModelAndView toDustbin(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/video/videosource_dustbin_list");
	}
	
	
	/**
	 * 获取列表页列表数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getDustbinList")
	@ResponseBody
	public void getDustbinList(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		//设置分页
		PageContext pageContext=setPagination(bean.getPageNumber(),bean.getPageSize());
		List<?> resultList =  videoSourceService.getDustbinList(bean);
		
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList,pageContext.getTotalRows()),response);
	}
	
	
	/**
	 * 清空回收站
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/clearBox")
	@ResponseBody
	public void clearBox(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		
		videoSourceService.clearBox(bean);
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS),response);
	}
	

	/**
	 *  修改视频状态 -1删除;1正常
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/modifyStatus")
	@ResponseBody
	public void modifyStatus(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		String videoSourceId=request.getParameter("videoSourceId");
		String status=request.getParameter("status");
		
		logger.info("【还原已删除视频】videoSourceId="+videoSourceId+",status="+status);
		
		bean.setVideoSourceId(videoSourceId);
		bean.setStatus(status);
		videoSourceService.modifyStatus(bean);
		
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS),response);
	}
	
	/**
	 * 进入视频编辑页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toVideoSourceEdit")
	public ModelAndView toVideoSourceEdit(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		bean=videoSourceService.getDataView(bean);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/videosource_edit_list",model);
	}
	
	/**
	 * 进入添加视频页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toAddEditVideo")
	public ModelAndView toAddEditVideo(HttpServletRequest request,HttpServletResponse response,VideoSourceBean bean) {
		
		String videoCount=request.getParameter("videoCount");
		logger.info("videoCount:"+videoCount);
		bean.setVideoCount(videoCount);
		
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean", bean);
		return new ModelAndView("/video/videosource_add_list",model);
	}
	
	
	/**
	 * 进入选择分类页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/toClassify")
	public ModelAndView toClassify(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/video/videosource_classify_list");
	}
	
	
	/**
	 * 上传图片
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/uploadImg")
	@ResponseBody
	public void uploadImg(HttpServletRequest request,HttpServletResponse response,
			VideoSourceBean bean,
			@RequestParam(value = "imgFile", required = false) MultipartFile imgFile) {
			
		    try {
		    	if (imgFile != null && imgFile.getSize()>0) {
		    		Map<String,Object> map = UploadImage.uploadsPath(request,imgFile);
					
					List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
					list.add(map);
					sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,list),response);
				}
			} catch (Exception e) {
				logger.error("上传图片失败:",e);
			}
	}
}
