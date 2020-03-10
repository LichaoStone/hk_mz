package com.mz.mapper.tvplay;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.tvplay.Tvplay;
import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.bean.tvplay.query.TvplayVoQuery;
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
}