package com.mz.service.user.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.menu.query.MenuVoQuery;
import com.mz.bean.menu.vo.MenuVo;
import com.mz.bean.opration.query.OprationVoQuery;
import com.mz.bean.user.User;
import com.mz.bean.user.query.UserVoQuery;
import com.mz.bean.user.vo.UserVo;
import com.mz.mapper.menu.MenuMapper;
import com.mz.mapper.opration.OprationMapper;
import com.mz.mapper.user.UserMapper;
import com.mz.service.user.UserServiceApi;
import com.mz.util.MD5Util;
import com.mz.util.StringUtils;
import com.mz.util.bean.Constants;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class UserServiceImpl implements UserServiceApi {
	
	@Resource
	private UserMapper userMapper ;
	@Resource
	private MenuMapper menuMapper ;
	@Resource
	private OprationMapper oprationMapper ;

	@Override
	public ServiceResult<PageVo<UserVo>> getUserPage(UserVoQuery query) {
		ServiceResult<PageVo<UserVo>> serviceResult = new ServiceResult<PageVo<UserVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<UserVo> list = userMapper.getUserListByQuery(query);
		PageVo<UserVo> pageVo = new PageVo<UserVo>((Page<UserVo>) list);
		serviceResult.setData(pageVo);
		return serviceResult;
	}

	@Override
	public ServiceResult<UserVo> checkLoginUser(UserVo userVo) {
		ServiceResult<UserVo> serviceResult = new ServiceResult<UserVo>(false);
		UserVoQuery query = new UserVoQuery();
		query.setLoginName(userVo.getLoginName());
		List<UserVo> list = userMapper.getUserListByQuery(query);
		if (list == null || list.isEmpty()) {
			serviceResult.setComment("系统不存在当前用户");
			return serviceResult ;
		}
		UserVo loginUser = list.get(0);
		if (loginUser.getStatus() == Constants.USER.STATUS_FORBIDDEN) {
			serviceResult.setComment("当前用户被禁用");
			return serviceResult ;
		}
		if (!MD5Util.MD5(userVo.getPassword()).equals(loginUser.getPassword())) {
			serviceResult.setComment("用户密码不正确");
			return serviceResult ;
		}
		MenuVoQuery menuVoQuery = new MenuVoQuery();
		menuVoQuery.setRoleId(loginUser.getRoleId());
		List<MenuVo> menuVos = menuMapper.getUserMenuListByQuery(menuVoQuery);
		loginUser.setMenuVos(menuVos);
		OprationVoQuery oprationVoQuery = new OprationVoQuery();
		List<String> oprationUrls = oprationMapper.getOprationUrlList(oprationVoQuery);
		loginUser.setOprationUrls(oprationUrls);
		serviceResult.setOk(true);
		serviceResult.setData(loginUser);
		return serviceResult;
		
	}

	@Override
	@Transactional
	public ServiceResult<UserVo> saveUserVo(UserVo userVo) {
		ServiceResult<UserVo> serviceResult = new ServiceResult<UserVo>(false);
		UserVoQuery query = new UserVoQuery();
		query.setLoginName(userVo.getLoginName());
		query.setUserId(userVo.getUserId());
		List<UserVo> list = userMapper.checkUserLoginName(query);
		if (list != null && list.size() >0) {
			serviceResult.setComment("存在相同登录名用户");
			return serviceResult ;
		}
		int count = 0 ;
		if (StringUtils.isNotBlank(userVo.getPassword())) {
			userVo.setPassword(MD5Util.MD5(userVo.getPassword()));
		}
		if (userVo.getUserId() == null) {
			count = userMapper.insertUser(userVo);
		}else {
			count = userMapper.updateUserBySelective(userVo);
		}
		serviceResult.setData(userVo);
		if (count > 0) {
			serviceResult.setOk(true);
			serviceResult.setComment("保存成功");
			return serviceResult ;
		}
		serviceResult.setComment("保存失败");
		return serviceResult ;
	}

	@Override
	@Transactional
	public ServiceResult<Boolean> deleteUserByUserId(Integer userId) {
		ServiceResult<Boolean> serviceResult = new ServiceResult<Boolean>(false);
		User user = new User();
		user.setUserId(userId);
		int count = userMapper.deleteUser(user);
		if (count > 0) {
			serviceResult.setOk(true);
			serviceResult.setData(true);
			serviceResult.setComment("删除成功");
			return serviceResult ;
		}
		serviceResult.setData(false);
		serviceResult.setComment("删除失败");
		return serviceResult ;
	}

	@Override
	public ServiceResult<UserVo> getUserByLoginName(String loginName) {
		ServiceResult<UserVo> serviceResult = new ServiceResult<UserVo>(false);
		UserVoQuery query = new UserVoQuery() ;
		query.setLoginName(loginName);
		List<UserVo> list = userMapper.getUserListByQuery(query);
		if (list.size() > 0) {
			serviceResult.setData(list.get(0));
			serviceResult.setOk(true);
			return serviceResult  ;
		}
		serviceResult.setComment("没有获得用户登录信息");
		return serviceResult;
	}
	
	
}
