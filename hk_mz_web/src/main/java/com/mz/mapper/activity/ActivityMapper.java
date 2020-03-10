package com.mz.mapper.activity;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mz.bean.activity.Activity;
import com.mz.bean.activity.vo.ActivityVo;
import com.mz.bean.activity.query.ActivityVoQuery;
@Mapper
public interface ActivityMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertActivity(Activity bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateActivity(Activity bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteActivity(Activity bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateActivityBySelective(Activity bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public ActivityVo getActivityVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getActivityCountByQuery(ActivityVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<ActivityVo> getActivityListByQuery(ActivityVoQuery query);
}