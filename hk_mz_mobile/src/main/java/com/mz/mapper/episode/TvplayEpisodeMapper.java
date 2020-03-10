package com.mz.mapper.episode;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.episode.TvplayEpisode;
import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.bean.episode.query.TvplayEpisodeVoQuery;
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
}