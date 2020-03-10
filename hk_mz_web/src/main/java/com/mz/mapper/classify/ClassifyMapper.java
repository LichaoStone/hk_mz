package com.mz.mapper.classify;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.classify.Classify;
import com.mz.bean.classify.vo.ClassifyVo;
import com.mz.bean.classify.query.ClassifyVoQuery;
@Mapper
public interface ClassifyMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertClassify(Classify bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateClassify(Classify bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteClassify(Classify bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateClassifyBySelective(Classify bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public ClassifyVo getClassifyVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getClassifyCountByQuery(ClassifyVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<ClassifyVo> getClassifyListByQuery(ClassifyVoQuery query);
}