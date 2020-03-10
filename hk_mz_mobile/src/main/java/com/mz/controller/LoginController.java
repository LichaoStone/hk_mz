package com.mz.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mz.bean.user.vo.UserVo;
import com.mz.config.web.ResponseResultBean;
import com.mz.service.user.UserServiceApi;
import com.mz.util.StringUtils;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.ServiceResult;

@Controller
//@RequestMapping("/jkplatform/v1/user")
public class LoginController {
	
	@Resource
	private UserServiceApi userServiceImpl ;
	/**
	 * 登录接口
	 * @param request
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping("/login")
	@ResponseResultBean
	public JsonResult login(HttpServletRequest request,
			@RequestParam("userName")String userName,
			@RequestParam("password")String password) {
		JsonResult jsonResult = new JsonResult(false);
		if (StringUtils.isBlank(userName)) {
			jsonResult.setComment("用户名不能为空");
			return jsonResult ;
		}
		if (StringUtils.isBlank(password)) {
			jsonResult.setComment("密码不能为空");
			return jsonResult ;
		}
		ServiceResult<UserVo> serviceResult = userServiceImpl.checkLoginUser(userName, password);
		if (!serviceResult.isOk()) {
			jsonResult.setOk(serviceResult.isOk());
			jsonResult.setComment(serviceResult.getComment());
			return jsonResult ;
		}
		UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
		token.setRememberMe(true);
		SecurityUtils.getSubject().getSession().setAttribute("user", serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		jsonResult.setData(serviceResult.getData());
		return jsonResult ;
	}
	@RequestMapping("/loginOut")
	@ResponseResultBean
	public JsonResult loginOut(HttpServletRequest request) {
		JsonResult jsonResult = new JsonResult(false);
		Subject currentUser = SecurityUtils.getSubject();
		if (currentUser != null 
				&& currentUser.getPrincipal() != null) {
			currentUser.logout();
		}
		jsonResult.setOk(true);
		jsonResult.setComment("退出成功");
		return jsonResult ;
	}
	@RequestMapping("/index")
	public JsonResult index(HttpServletRequest request) {
		JsonResult jsonResult = new JsonResult(false);
		
		jsonResult.setOk(true);
		jsonResult.setComment("退出成功");
		return jsonResult ;
	}
}
