package com.mz.mapper.episode;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mz.bean.episode.TvplayEpisode;
import com.mz.bean.episode.query.TvplayEpisodeVoQuery;
import com.mz.bean.episode.vo.TvplayEpisodeVo;
@Mapper
public interface TvplayEpisodeMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertTvplayEpisode(TvplayEpisode bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateTvplayEpisode(TvplayEpisode bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteTvplayEpisode(TvplayEpisode bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateTvplayEpisodeBySelective(TvplayEpisode bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public TvplayEpisodeVo getTvplayEpisodeVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getTvplayEpisodeCountByQuery(TvplayEpisodeVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<TvplayEpisodeVo> getTvplayEpisodeListByQuery(TvplayEpisodeVoQuery query);
	/**
	 * 根据多个剧集Id查询剧集
	 * @param newsIds
	 * @return
	 */
	public List<TvplayEpisodeVo> getEpisodeListByEpisodeIds(@Param("tvplayEpisodeIds")String[] tvplayEpisodeIds);
}