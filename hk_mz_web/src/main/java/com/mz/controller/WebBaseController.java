package com.mz.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.tag.Tag;
import com.mz.bean.tag.query.TagVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.util.HttpUtils;
import com.mz.util.StringUtils;
import com.mz.util.bean.JsonResult;


@Controller
public class WebBaseController {

	public UserVo getLoginUser() {
		UserVo vo = null ;
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser != null 
				&& currentUser.getPrincipal() != null 
				&& currentUser.getSession() != null 
				&& currentUser.getSession().getAttribute("user")!= null) {
			vo = (UserVo)currentUser.getSession().getAttribute("user");
		}
		return vo ;
	}
	/**
	 * 进入标签列表页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_tags_list")
	public ModelAndView showTagsList(HttpServletRequest request,HttpServletResponse response,TagVoQuery query) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("bean",query);
		return new ModelAndView("/common/tag_list",model);
	}
	
	/**
	 * 获取列表页数据
	 * @param request
	 * @param response
	 * @param bean
	 */
	@RequestMapping("/get_tags_list")
	@ResponseBody
	public JsonResult getTagsList(HttpServletRequest request,HttpServletResponse response,Tag bean) {
		JsonResult jsonResult = new JsonResult(true);
//		List<?> resultList=videoService.getTagList();
//		sendJson(getJson(CODE.SUCCESS,RET.SUCCESS,resultList),response);
		return jsonResult;
	}
	/**
	 * 下发资源
	 * @param request
	 * @param response
	 * @param bean
	 * @return
	 */
	@RequestMapping("/downward_dispatch_source")
	@ResponseBody
	public JsonResult downwardDispatchSource(HttpServletRequest request,HttpServletResponse response) {
		JsonResult jsonResult = new JsonResult(true);
		String type = request.getParameter("type");
		String ids = request.getParameter("ids");
//		if (StringUtils.isBlank(ids)) {
//			jsonResult.setOk(false);
//			return jsonResult ;
//		}
//		Integer platformId = 0;
//		if(getLoginUser()!=null){
//			 platformId = getLoginUser().getPlatformId();
//		}
//		String url="";
//		HttpUtils.reqForPost(url,"type="+type+"&ids="+ids+"&platformId="+platformId);
		return jsonResult;
	}
}
