package com.mz.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONArray;
import com.mz.bean.user.query.UserVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.service.user.UserServiceApi;
import com.mz.util.StringUtils;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
public class LoginController {
	
	@Resource
	private UserServiceApi userServiceImpl ;
	@Resource
	private RedisTemplate<String, Object> redisTemplate ;
	
	@RequestMapping("/index")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("index");
		return mav ;
	}
	@RequestMapping("/pageList")
	public ModelAndView pageList(ModelAndView mav) {
		mav.setViewName("pageList");
		return mav ;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(ModelAndView mav) {
		mav.setViewName("login");
		return mav ;
	}
	
	@RequestMapping("/do_login")
	@ResponseBody
	public JsonResult doLogin(String loginName,String password) {
		JsonResult jsonResult = new JsonResult(false);
		if (StringUtils.isBlank(loginName)) {
			jsonResult.setComment("用户名不能为空");
			return jsonResult ;
		}
		if (StringUtils.isBlank(password)) {
			jsonResult.setComment("用户密码不能为空");
			return jsonResult ;
		}
		UserVo userVo = new UserVo() ;
		userVo.setLoginName(loginName);
		userVo.setPassword(password);
		ServiceResult<UserVo> serviceResult = userServiceImpl.checkLoginUser(userVo);
		if (!serviceResult.isOk()) {
			jsonResult.setComment(serviceResult.getComment());
			jsonResult.setOk(serviceResult.isOk());
			return jsonResult ;
		}
		UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
		token.setRememberMe(true);
		SecurityUtils.getSubject().login(token);
		SecurityUtils.getSubject().getSession().setAttribute("user", serviceResult.getData());
		String userJsoinString = JSONArray.toJSONString(serviceResult.getData());
		SecurityUtils.getSubject().getSession().setAttribute("userJsoinString", userJsoinString);
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult ;
	}
	
	@RequestMapping("/getUserList")
	@ResponseBody
	public JsonResult getUserList(UserVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<UserVo>> serviceResult = userServiceImpl.getUserPage(query);
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setData(serviceResult.getData());
		return jsonResult ;
	}
	
}