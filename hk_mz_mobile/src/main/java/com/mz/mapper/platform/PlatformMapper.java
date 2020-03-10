package com.mz.mapper.platform;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.platform.Platform;
import com.mz.bean.platform.vo.PlatformVo;
import com.mz.bean.platform.query.PlatformVoQuery;
@Mapper
public interface PlatformMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertPlatform(Platform bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updatePlatform(Platform bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deletePlatform(Platform bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updatePlatformBySelective(Platform bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public PlatformVo getPlatformVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getPlatformCountByQuery(PlatformVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<PlatformVo> getPlatformListByQuery(PlatformVoQuery query);
}