package com.mz.mapper.still;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.still.Still;
import com.mz.bean.still.vo.StillVo;
import com.mz.bean.still.query.StillVoQuery;
@Mapper
public interface StillMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertStill(Still bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateStill(Still bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteStill(Still bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateStillBySelective(Still bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public StillVo getStillVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getStillCountByQuery(StillVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<StillVo> getStillListByQuery(StillVoQuery query);
}