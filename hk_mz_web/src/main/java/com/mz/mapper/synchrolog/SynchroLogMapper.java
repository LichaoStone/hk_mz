package com.mz.mapper.synchrolog;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.synchrolog.SynchroLog;
import com.mz.bean.synchrolog.vo.SynchroLogVo;
import com.mz.bean.synchrolog.query.SynchroLogVoQuery;
@Mapper
public interface SynchroLogMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertSynchroLog(SynchroLog bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateSynchroLog(SynchroLog bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteSynchroLog(SynchroLog bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateSynchroLogBySelective(SynchroLog bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public SynchroLogVo getSynchroLogVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getSynchroLogCountByQuery(SynchroLogVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<SynchroLogVo> getSynchroLogListByQuery(SynchroLogVoQuery query);
}