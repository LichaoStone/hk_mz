package com.mz.controller.user;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.user.query.UserVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.service.user.UserServiceApi;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private UserServiceApi userServiceImpl ;
	/**
	 * 分页展示用户列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_user_list")
	public ModelAndView showUserList(ModelAndView mav) {
		mav.setViewName("/user/userList");
		return mav ;
	}
	/**
	 * 分页获得用户列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_user_list")
	@ResponseBody
	public JsonResult getUserList(UserVoQuery query) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<PageVo<UserVo>> serviceResult = userServiceImpl.getUserPage(query);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		return jsonResult ;
	}
	/**
	 * 跳转用户添加编辑页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_save_user")
	public ModelAndView showSaveUser(ModelAndView mav) {
		mav.setViewName("/user/showSaveUser");
		return mav ;
	}
	/**
	 * 保存用户数据
	 * @param userVo
	 * @return
	 */
	@RequestMapping("/save_user")
	@ResponseBody
	public JsonResult saveUser(UserVo userVo) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<UserVo> serviceResult = userServiceImpl.saveUserVo(userVo);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult ;
	}
	/**
	 * 删除用户数据
	 * @param userId
	 * @return
	 */
	@RequestMapping("/delete_user")
	@ResponseBody
	public JsonResult deleteUser(Integer userId) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<Boolean> serviceResult = userServiceImpl.deleteUserByUserId(userId);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult ;
	}
	
}
