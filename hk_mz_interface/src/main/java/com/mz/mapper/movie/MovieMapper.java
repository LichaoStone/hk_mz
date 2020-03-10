package com.mz.mapper.movie;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mz.bean.movie.Movie;
import com.mz.bean.movie.query.MovieVoQuery;
import com.mz.bean.movie.vo.MovieVo;
@Mapper
public interface MovieMapper{

	/**
	 * 插入对象
	 * @param bean
	 * @return
	 */
	public int insertMovie(Movie bean);
	/**
	 * 编辑对象
	 * @param bean
	 * @return
	 */
	public int updateMovie(Movie bean);
	/**
	 * 删除对象
	 * @param bean
	 * @return
	 */
	public int deleteMovie(Movie bean);
	/**
	 * 只修改需要编辑的字段
	 * @param bean
	 * @return
	 */
	public int updateMovieBySelective(Movie bean);
	/**
	 * 根据Id获得对象
	 * @param key
	 * @return
	 */
	public MovieVo getMovieVoById(String key);
	
	/**
	 * 获得对象总数
	 * @param query
	 * @return
	 */
	
	public long getMovieCountByQuery(MovieVoQuery query);
	/**
	 * 获得对象列表
	 * @param query
	 * @return
	 */
	public List<MovieVo> getMovieListByQuery(MovieVoQuery query);
	/**
	 * 根据多个电影Id查询电影
	 * @param newsIds
	 * @return
	 */
	public List<MovieVo> getMovieListByMovieIds(@Param("movieIds")String[] movieIds);
}