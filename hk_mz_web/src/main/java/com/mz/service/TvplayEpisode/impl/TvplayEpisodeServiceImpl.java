package com.mz.service.TvplayEpisode.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.episode.TvplayEpisode;
import com.mz.bean.episode.query.TvplayEpisodeVoQuery;
import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.mapper.episode.TvplayEpisodeMapper;
import com.mz.service.TvplayEpisode.TvplayEpisodeServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class TvplayEpisodeServiceImpl implements TvplayEpisodeServiceApi{
	
	@Resource
	private TvplayEpisodeMapper tvplayEpisodeMapper ;

	/**
	 * 根据查询条件获取电影列表
	 */
	@Override
	public ServiceResult<PageVo<TvplayEpisodeVo>> getTvplayEpisodePage(TvplayEpisodeVoQuery query) throws Exception {
		ServiceResult<PageVo<TvplayEpisodeVo>> serviceResult = new ServiceResult<PageVo<TvplayEpisodeVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<TvplayEpisodeVo> list = tvplayEpisodeMapper.getTvplayEpisodeListByQuery(query);
		PageVo<TvplayEpisodeVo> pageVo = new PageVo<TvplayEpisodeVo>((Page<TvplayEpisodeVo>) list);
		serviceResult.setData(pageVo);
		return serviceResult;
	}
	

	/**
	 * 根据ID查询电影信息
	 */
	@Override
	public ServiceResult<TvplayEpisodeVo> getTvplayEpisodeById(TvplayEpisodeVoQuery query) throws Exception {
		ServiceResult<TvplayEpisodeVo> serviceResult = new ServiceResult<TvplayEpisodeVo>();
		TvplayEpisodeVo TvplayEpisode = tvplayEpisodeMapper.getTvplayEpisodeVoById(query.getTvplayEpisodeId().toString());
		serviceResult.setData(TvplayEpisode);
		serviceResult.setOk(true);
		return serviceResult;
	}

	
	/**
	 * 修改电影信息
	 */
	@Override
	public ServiceResult<Integer> update(TvplayEpisode query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = tvplayEpisodeMapper.updateTvplayEpisodeBySelective(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}

	/**
	 * 导入电视剧剧集信息
	 */
	@Override
	@Transactional
	public ServiceResult<Integer> insertTvplayEpisode(TvplayEpisode query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = tvplayEpisodeMapper.insertTvplayEpisode(query);
		tvplayEpisodeMapper.updateTvplayNum(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}


	/**
	 * 查询剧集存在条数
	 */
	@Override
	public ServiceResult<Integer> getTvplayEpisodeCountByQuery(TvplayEpisodeVoQuery query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = (int) tvplayEpisodeMapper.getTvplayEpisodeCountByQuery(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}

}
