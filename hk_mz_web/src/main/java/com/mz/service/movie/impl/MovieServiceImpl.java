package com.mz.service.movie.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.movie.Movie;
import com.mz.bean.movie.query.MovieVoQuery;
import com.mz.bean.movie.vo.MovieVo;
import com.mz.bean.still.Still;
import com.mz.bean.still.query.StillVoQuery;
import com.mz.bean.still.vo.StillVo;
import com.mz.mapper.movie.MovieMapper;
import com.mz.mapper.still.StillMapper;
import com.mz.service.movie.MovieServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class MovieServiceImpl implements MovieServiceApi{
	
	@Resource
	private MovieMapper movieMapper ;
	@Resource
	private StillMapper stillMapper ;

	/**
	 * 根据查询条件获取电影列表
	 */
	@Override
	public ServiceResult<PageVo<MovieVo>> getMoviePage(MovieVoQuery query) throws Exception {
		ServiceResult<PageVo<MovieVo>> serviceResult = new ServiceResult<PageVo<MovieVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<MovieVo> list = movieMapper.getMovieListByQuery(query);
		PageVo<MovieVo> pageVo = new PageVo<MovieVo>((Page<MovieVo>) list);
		serviceResult.setData(pageVo);
		return serviceResult;
	}
	

	/**
	 * 根据ID查询电影信息
	 */
	@Override
	public ServiceResult<MovieVo> getMovieById(MovieVoQuery query) throws Exception {
		ServiceResult<MovieVo> serviceResult = new ServiceResult<MovieVo>();
		MovieVo movie = movieMapper.getMovieVoById(query.getMovieId().toString());
		//获取电影剧照
		List<StillVo> listStill = new ArrayList<StillVo>();
		StillVoQuery stillQuery = new StillVoQuery();
		stillQuery.setContentId(movie.getMovieId());
		stillQuery.setContentType("movie");
		listStill=stillMapper.getStillListByQuery(stillQuery);
		movie.setListStill(listStill);
		serviceResult.setData(movie);
		serviceResult.setOk(true);
		return serviceResult;
	}

	
	/**
	 * 修改电影信息
	 */
	@Override
	public ServiceResult<Integer> update(Movie query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = movieMapper.updateMovieBySelective(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}
	/**
	 * 导入电影信息
	 */
	@Override
	@Transactional
	public ServiceResult<Integer> insertMovie(Movie query,List<Still> stillList) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = movieMapper.insertMovie(query);
		for(Still still:stillList){
			//类型：movie电影，tvplay电视剧
			still.setContentType("movie");
			//所属内容id
			still.setContentId(query.getMovieId());
			//create_time
			still.setCreateTime(new Date());
			stillMapper.insertStill(still);
		}
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}


	/**
	 * 查询电影条数
	 */
	@Override
	public ServiceResult<Integer> getMovieCountByQuery(MovieVoQuery query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = (int) movieMapper.getMovieCountByQuery(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}

}
