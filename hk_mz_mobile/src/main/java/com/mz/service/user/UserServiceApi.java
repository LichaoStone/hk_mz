package com.mz.service.user;

import com.mz.bean.user.vo.UserVo;
import com.mz.util.bean.ServiceResult;

public interface UserServiceApi {
	/**
	 * 用户登录检查
	 * @param userName
	 * @param password
	 * @return
	 */
	ServiceResult<UserVo> checkLoginUser(String userName,String password);
	
	/**
	 * 根据登录名获得用户信息
	 * @param loginName
	 * @return
	 */
	ServiceResult<UserVo> getUserByLoginName(String loginName);

}
