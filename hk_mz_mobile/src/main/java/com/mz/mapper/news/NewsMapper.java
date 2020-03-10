package com.mz.mapper.news;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
import com.mz.bean.news.News;
import com.mz.bean.news.vo.NewsVo;
import com.mz.bean.news.query.NewsVoQuery;
@Mapper
public interface NewsMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertNews(News bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateNews(News bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteNews(News bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateNewsBySelective(News bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public NewsVo getNewsVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getNewsCountByQuery(NewsVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<NewsVo> getNewsListByQuery(NewsVoQuery query);
}