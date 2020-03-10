package com.mz.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.permissions.query.PermissionsVoQuery;
import com.mz.bean.permissions.vo.PermissionsVo;
import com.mz.bean.user.query.UserVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.mapper.permissions.PermissionsMapper;
import com.mz.mapper.user.UserMapper;
import com.mz.service.user.UserServiceApi;
import com.mz.util.MD5Util;
import com.mz.util.bean.Constants;
import com.mz.util.bean.ServiceResult;

@Service
public class UserServiceImpl implements UserServiceApi {
	
	@Resource
	private UserMapper userMapper ;
	@Resource
	private PermissionsMapper permissionsMapper ;

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
		if (!password.equals(userVo.getPassword())) {
			serviceResult.setComment("密码不正确");
			return serviceResult ;
		}
		/**
		 * 登录用户是否有推流权限
		 */
		PermissionsVoQuery permissionsVoQuery = new PermissionsVoQuery();
		permissionsVoQuery.setRoleId(userVo.getRoleId());
		permissionsVoQuery.setSourceId(Constants.USER.PUSH_PERMISSION_KEY);
		permissionsVoQuery.setPermissionsType(Constants.USER.PERMISSION_TYPE_OPERATION);
		List<PermissionsVo> permissionsVos = permissionsMapper.getPermissionsListByQuery(permissionsVoQuery);
		userVo.setIsPush(Constants.USER.IS_PUSH_NO);
		if (permissionsVos != null && permissionsVos.size() > 0) {
			userVo.setIsPush(Constants.USER.IS_PUSH_YES);
		}
		
		serviceResult.setOk(true);
		serviceResult.setData(userVo);
		serviceResult.setComment("检查成功");
		return serviceResult;
	}

	@Override
	public ServiceResult<UserVo> getUserByLoginName(String loginName) {
		ServiceResult<UserVo> serviceResult = new ServiceResult<UserVo>(true);
		UserVoQuery query = new UserVoQuery();
		query.setLoginName(loginName);
		List<UserVo> list = userMapper.getUserListByQuery(query);
		serviceResult.setData(list.get(0));
		return serviceResult;
	}

	
}
