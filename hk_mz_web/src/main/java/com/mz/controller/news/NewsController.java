package com.mz.controller.news;


import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.httpclient.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.news.query.NewsVoQuery;
import com.mz.bean.news.vo.NewsVo;
import com.mz.bean.tag.query.TagVoQuery;
import com.mz.bean.tag.vo.TagVo;
import com.mz.controller.WebBaseController;
import com.mz.service.news.NewsServiceApi;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/news")
public class NewsController extends WebBaseController{
	@Autowired
	private  NewsServiceApi newsServiceImpl ;
	
	/**
	 * 分页展示电影列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("news/index");
		return mav ;
	}
	
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_news_list")
	@ResponseBody
	public JsonResult getNewsList(NewsVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<NewsVo>> serviceResult;
		try {
			serviceResult = newsServiceImpl.getNewsPage(query);
			jsonResult.setOk(serviceResult.isOk());
			jsonResult.setMessage(serviceResult.getMsgCode());
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult ;
	}
	
	@RequestMapping("/{newsId}")
	public ModelAndView detail(@PathVariable String newsId,ModelAndView mav) {
		NewsVo newVo =newsServiceImpl.getNewsVoById(newsId);
		mav.addObject("bean",newVo);
		mav.setViewName("news/detail");
		return mav ;
	}
	
}