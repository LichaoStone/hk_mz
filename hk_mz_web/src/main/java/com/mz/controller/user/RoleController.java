package com.mz.controller.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.role.query.RoleVoQuery;
import com.mz.bean.role.vo.RoleVo;
import com.mz.service.user.RoleServiceApi;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Resource
	private RoleServiceApi roleServiceImpl ;
	
	/**
	 * 分页展示角色列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_role_list")
	public ModelAndView showUserList(ModelAndView mav) {
		mav.setViewName("/user/roleList");
		return mav ;
	}
	/**
	 * 分页获得用户列表
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_role_list")
	@ResponseBody
	public JsonResult getRoleList(RoleVoQuery query) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<PageVo<RoleVo>> serviceResult = roleServiceImpl.getRolePageByQuery(query);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		return jsonResult ;
	}
	/**
	 * 展示角色的保存页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_save_role")
	public ModelAndView showSaveRole(ModelAndView mav) {
		mav.setViewName("/user/saveRole");
		return mav ;
	}
	/**
	 * 保存角色
	 * @param roleVo
	 * @return
	 */
	@RequestMapping("/save_role")
	@ResponseBody
	public JsonResult saveRole(RoleVo roleVo) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<RoleVo> serviceResult = roleServiceImpl.saveRole(roleVo);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult ;
	}
	/**
	 * 删除角色
	 * @param roleId
	 * @return
	 */
	@RequestMapping("/delete_role")
	@ResponseBody
	public JsonResult deleteRole(Integer roleId) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<Boolean> serviceResult = roleServiceImpl.deleteRoleById(roleId);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult ;
	}
	
	/**
	 * 获得全部角色
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_all_role_list")
	@ResponseBody
	public JsonResult getAllRoleList(RoleVoQuery query) {
		JsonResult jsonResult = new JsonResult() ;
		ServiceResult<List<RoleVo>> serviceResult = roleServiceImpl.getRoleListByQuery(query);
		jsonResult.setData(serviceResult.getData());
		jsonResult.setOk(serviceResult.isOk());
		return jsonResult ;
	}
}
