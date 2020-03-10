package com.mz.mapper.tvplay;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mz.bean.tvplay.Tvplay;
import com.mz.bean.tvplay.query.TvplayVoQuery;
import com.mz.bean.tvplay.vo.TvplayVo;
@Mapper
public interface TvplayMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertTvplay(Tvplay bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateTvplay(Tvplay bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteTvplay(Tvplay bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateTvplayBySelective(Tvplay bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public TvplayVo getTvplayVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getTvplayCountByQuery(TvplayVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<TvplayVo> getTvplayListByQuery(TvplayVoQuery query);
	/**
	 * 根据多个电视剧Id查询电视剧
	 * @param newsIds
	 * @return
	 */
	public List<TvplayVo> getTvplayListByTvplayIds(@Param("tvplayIds")String[] tvplayIds);
}