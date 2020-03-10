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

}
