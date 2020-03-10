package com.mz.service.movie;

import java.util.List;

import com.mz.bean.movie.vo.MovieVo;
import com.mz.util.bean.ServiceResult;

public interface MovieServiceApi {
	/**
	 * 
	 * @Title: getMovieListByMovieIds   
	 * @Description: 根据ID获得资讯列表 
	 * @param: @param ids
	 * @param: @return      
	 * @return: ServiceResult<List<MovieVo>>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<List<MovieVo>> getMovieListByIds(String[] ids);

}
