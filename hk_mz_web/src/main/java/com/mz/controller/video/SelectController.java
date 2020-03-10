package com.mz.controller.video;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.bean.video.SelectBean;
import com.mz.bean.video.VideoBean;
import com.mz.frame.BaseController;
import com.mz.service.video.SelectService;

@Controller
@RequestMapping("/select")
public class SelectController extends BaseController{
	private static final Logger logger = LoggerFactory.getLogger(VideoController.class);
	@Resource
	private SelectService selectService ;
	
	/**
	 * 获取分类下拉菜单数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getClassifySelect")
	@ResponseBody
	public void getClassifySelect(HttpServletRequest request,HttpServletResponse response) {
		List<?> resultList=selectService.getClassifySelect();
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList),response);
	}
	
	
	/**
	 * 获取标签下拉菜单
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getTagsSelect")
	@ResponseBody
	public void getTagsSelect(HttpServletRequest request,HttpServletResponse response,SelectBean bean) {
		List<?> resultList=selectService.getTagsSelect(bean);
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList),response);
	}
	
	
	/**
	 * 获取用户下拉菜单数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/getUserSelect")
	@ResponseBody
	public void getUserSelect(HttpServletRequest request,HttpServletResponse response,VideoBean bean) {
		List<?> resultList=selectService.getUserSelect();
		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList),response);
	}
	
}
