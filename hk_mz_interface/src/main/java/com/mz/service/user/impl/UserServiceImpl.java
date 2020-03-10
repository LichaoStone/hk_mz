package com.mz.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.user.query.UserVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.mapper.user.UserMapper;
import com.mz.service.user.UserServiceApi;
import com.mz.util.MD5Util;
import com.mz.util.bean.Constants;
import com.mz.util.bean.ServiceResult;

@Service
public class UserServiceImpl implements UserServiceApi {
	
	@Resource
	private UserMapper userMapper ;

	@Override
	public ServiceResult<UserVo> checkLoginUser(String userName, String password) {
		ServiceResult<UserVo> serviceResult = new ServiceResult<UserVo>(false);
		UserVoQuery query = new UserVoQuery();
		query.setLoginName(userName);
		List<UserVo> list = userMapper.getUserListByQuery(query);
		/**
		 * 检查用户
		 */
		if (list == null || list.size() <= 0) {
			serviceResult.setComment("没有当前用户");
			return serviceResult ;
		}
		UserVo userVo = list.get(0);
		/**
		 * 检查用户状态
		 */
		if (userVo.getStatus() == Constants.USER.STATUS_FORBIDDEN) {
			serviceResult.setComment("用户被禁用");
			return serviceResult ;
		}
		/**
		 * 检查用户登录密码
		 */
		if (!MD5Util.MD5(password).equals(userVo.getPassword())) {
			serviceResult.setComment("密码不正确");
			return serviceResult ;
		}
		serviceResult.setOk(true);
		serviceResult.setData(userVo);
		serviceResult.setComment("检查成功");
		return serviceResult;
	}

	
}
