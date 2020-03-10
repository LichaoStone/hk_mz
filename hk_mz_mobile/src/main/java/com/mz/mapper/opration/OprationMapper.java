package com.mz.mapper.opration;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.opration.Opration;
import com.mz.bean.opration.vo.OprationVo;
import com.mz.bean.opration.query.OprationVoQuery;
@Mapper
public interface OprationMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertOpration(Opration bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateOpration(Opration bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteOpration(Opration bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateOprationBySelective(Opration bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public OprationVo getOprationVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getOprationCountByQuery(OprationVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<OprationVo> getOprationListByQuery(OprationVoQuery query);
}