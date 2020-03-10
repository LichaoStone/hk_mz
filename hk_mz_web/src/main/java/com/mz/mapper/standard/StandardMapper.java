package com.mz.mapper.standard;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.standard.Standard;
import com.mz.bean.standard.vo.StandardVo;
import com.mz.bean.standard.query.StandardVoQuery;
@Mapper
public interface StandardMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertStandard(Standard bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateStandard(Standard bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteStandard(Standard bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateStandardBySelective(Standard bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public StandardVo getStandardVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getStandardCountByQuery(StandardVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<StandardVo> getStandardListByQuery(StandardVoQuery query);
}