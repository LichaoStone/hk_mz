package com.mz.service.movie;

import java.util.List;

import com.mz.bean.movie.Movie;
import com.mz.bean.movie.query.MovieVoQuery;
import com.mz.bean.movie.vo.MovieVo;
import com.mz.bean.still.Still;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface MovieServiceApi {
	
	//获取电影列表
	ServiceResult<PageVo<MovieVo>> getMoviePage(MovieVoQuery query) throws Exception;
	//更具ID获取电影信息
	ServiceResult<MovieVo> getMovieById(MovieVoQuery query) throws Exception;
	//获取电影信息
	ServiceResult<Integer> update(Movie query) throws Exception;
	//导入电影信息
	ServiceResult<Integer> insertMovie(Movie query,List<Still> still) throws Exception;
	//查询电影是否存在
	ServiceResult<Integer> getMovieCountByQuery(MovieVoQuery query) throws Exception;
	

}
