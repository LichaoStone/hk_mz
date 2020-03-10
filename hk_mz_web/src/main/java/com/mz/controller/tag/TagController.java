package com.mz.controller.tag;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.tag.Tag;
import com.mz.bean.tag.query.TagVoQuery;
import com.mz.bean.tag.vo.TagVo;
import com.mz.controller.WebBaseController;
import com.mz.service.tag.TagServiceApi;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/tag")
public class TagController extends WebBaseController{
	
	@Resource
	private TagServiceApi tagServiceImpl ;
	
	/**
	 * 分页展示电影列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("tag/index");
		return mav ;
	}
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_tag_list")
	@ResponseBody
	public JsonResult getTagList(TagVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<TagVo>> serviceResult;
		try {
			serviceResult = tagServiceImpl.getTagPage(query);
			jsonResult.setOk(serviceResult.isOk());
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult ;
	}
	
	@RequestMapping("list/{tagType}")
	public ModelAndView detail(@PathVariable String tagType, ModelAndView mav) {
		mav.setViewName("tag/detail");
		mav.addObject("tagType", tagType);
		return mav;
	}
	
	@PostMapping("/list/{tagType}")
	@ResponseBody
	public JsonResult getTagDetailList(@PathVariable String tagType) {
		JsonResult jsonResult = new JsonResult(true);
		
		ServiceResult<List<TagVo>> serviceResult;
		try {
			serviceResult = tagServiceImpl.fetchTagList(tagType);
			jsonResult.setOk(true);
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult ;
	}
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_all_tag_list")
	@ResponseBody
	public JsonResult getAllTagList(TagVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<List<TagVo>> serviceResult;
		try {
			serviceResult = tagServiceImpl.getTagLetterListByQuery(query);
			jsonResult.setOk(serviceResult.isOk());
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult ;
	}
	
	
}