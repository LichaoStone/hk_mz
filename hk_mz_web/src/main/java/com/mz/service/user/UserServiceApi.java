package com.mz.service.user;

import com.mz.bean.user.query.UserVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface UserServiceApi {
	/**
	 * 分页获得用户数据
	 * @param query
	 * @return
	 */
	ServiceResult<PageVo<UserVo>> getUserPage(UserVoQuery query);
	/**
	 * 检查登录用户
	 * @param userVo
	 * @return
	 */
	ServiceResult<UserVo> checkLoginUser(UserVo userVo);
	/**
	 * 保存用户
	 * @param userVo
	 * @return
	 */
	ServiceResult<UserVo> saveUserVo(UserVo userVo);
	/**
	 * 删除用户
	 * @param userId
	 * @return
	 */
	ServiceResult<Boolean> deleteUserByUserId(Integer  userId);
	/**
	 * 
	 * @Title: getUserByLoginName   
	 * @Description: 根据登录名获得用户信息 
	 * @param: @param loginName
	 * @param: @return      
	 * @return: ServiceResult<UserVo>      
	 * @throws 
	 * @author: banbu
	 */
	ServiceResult<UserVo> getUserByLoginName(String loginName);
}
