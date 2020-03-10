package com.mz.service.tvplay.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.still.Still;
import com.mz.bean.still.query.StillVoQuery;
import com.mz.bean.still.vo.StillVo;
import com.mz.bean.tvplay.Tvplay;
import com.mz.bean.tvplay.query.TvplayVoQuery;
import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.mapper.still.StillMapper;
import com.mz.mapper.tvplay.TvplayMapper;
import com.mz.service.tvplay.TvplayServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class TvplayServiceImpl implements TvplayServiceApi{
	
	@Resource
	private TvplayMapper tvplayMapper ;
	@Resource
	private StillMapper stillMapper ;

	/**
	 * 根据查询条件获取电影列表
	 */
	@Override
	public ServiceResult<PageVo<TvplayVo>> getTvplayPage(TvplayVoQuery query) throws Exception {
		ServiceResult<PageVo<TvplayVo>> serviceResult = new ServiceResult<PageVo<TvplayVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<TvplayVo> list = tvplayMapper.getTvplayListByQuery(query);
		PageVo<TvplayVo> pageVo = new PageVo<TvplayVo>((Page<TvplayVo>) list);
		serviceResult.setData(pageVo);
		return serviceResult;
	}
	

	/**
	 * 根据ID查询电影信息
	 */
	@Override
	public ServiceResult<TvplayVo> getTvplayById(TvplayVoQuery query) throws Exception {
		ServiceResult<TvplayVo> serviceResult = new ServiceResult<TvplayVo>();
		TvplayVo tvplay = tvplayMapper.getTvplayVoById(query.getTvplayId().toString());
		//获取电影剧照
		List<StillVo> listStill = new ArrayList<StillVo>();
		StillVoQuery stillQuery = new StillVoQuery();
		stillQuery.setContentId(tvplay.getTvplayId());
		stillQuery.setContentType("tvplay");
		listStill=stillMapper.getStillListByQuery(stillQuery);
		tvplay.setListStill(listStill);
		serviceResult.setData(tvplay);
		serviceResult.setOk(true);
		return serviceResult;
	}

	
	/**
	 * 修改电影信息
	 */
	@Override
	public ServiceResult<Integer> update(Tvplay query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = tvplayMapper.updateTvplayBySelective(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}

	/**
	 * 导入电视剧剧头信息
	 */
	@Override
	public ServiceResult<Integer> insertTvplay(Tvplay query, List<Still> stillList) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = tvplayMapper.insertTvplay(query);
		for(Still still:stillList){
			//类型：movie电影，tvplay电视剧
			still.setContentType("tvplay");
			//所属内容id
			still.setContentId(query.getTvplayId());
			//create_time
			still.setCreateTime(new Date());
			stillMapper.insertStill(still);
		}
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}


	/**
	 * 查询剧头存在条数
	 */
	@Override
	public ServiceResult<Integer> getTvplayCountByQuery(TvplayVoQuery query) throws Exception {
		ServiceResult<Integer> serviceResult = new ServiceResult<Integer>();
		int result = (int) tvplayMapper.getTvplayCountByQuery(query);
		serviceResult.setData(result);
		serviceResult.setOk(true);
		return serviceResult;
	}

}
