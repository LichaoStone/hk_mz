package com.mz.mapper.video;
import java.util.List;
import com.mz.bean.video.VideoBack;
public interface VideoBackMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertVideoBack(VideoBack bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateVideoBack(VideoBack bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteVideoBack(VideoBack bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateVideoBackBySelective(VideoBack bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public VideoBack getVideoBackVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getVideoBackCountByQuery(VideoBack query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<VideoBack> getVideoBackListByQuery(VideoBack query);
}