package com.mz.mapper.transcode;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.transcode.Transcode;
import com.mz.bean.transcode.vo.TranscodeVo;
import com.mz.bean.transcode.query.TranscodeVoQuery;
@Mapper
public interface TranscodeMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertTranscode(Transcode bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateTranscode(Transcode bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteTranscode(Transcode bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateTranscodeBySelective(Transcode bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public TranscodeVo getTranscodeVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getTranscodeCountByQuery(TranscodeVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<TranscodeVo> getTranscodeListByQuery(TranscodeVoQuery query);
}