package com.mz.service.movie.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.movie.vo.MovieVo;
import com.mz.mapper.movie.MovieMapper;
import com.mz.service.movie.MovieServiceApi;
import com.mz.util.bean.ServiceResult;
@Service
public class MovieServiceImpl implements MovieServiceApi {
	
	@Resource
	private MovieMapper movieMapper ;

	@Override
	public ServiceResult<List<MovieVo>> getMovieListByIds(String[] ids) {
		ServiceResult<List<MovieVo>> serviceResult = new ServiceResult<List<MovieVo>>(true);
		List<MovieVo> list = movieMapper.getMovieListByMovieIds(ids);
		if (list == null) {
			list = new ArrayList<MovieVo>(0);
		}
		serviceResult.setData(list);
		return serviceResult;
	}

}
