package com.mz.mapper.tag;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.tag.Tag;
import com.mz.bean.tag.vo.TagVo;
import com.mz.bean.tag.query.TagVoQuery;
@Mapper
public interface TagMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertTag(Tag bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateTag(Tag bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteTag(Tag bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateTagBySelective(Tag bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public TagVo getTagVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getTagCountByQuery(TagVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<TagVo> getTagListByQuery(TagVoQuery query);
}