package com.mz.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mz.bean.user.User;
import com.mz.bean.user.vo.UserVo;
import com.mz.bean.user.query.UserVoQuery;
@Mapper
public interface UserMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertUser(User bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateUser(User bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteUser(User bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateUserBySelective(User bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public UserVo getUserVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getUserCountByQuery(UserVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<UserVo> getUserListByQuery(UserVoQuery query);
}