package com.mz.service.tvplayEpisode.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.mapper.episode.TvplayEpisodeMapper;
import com.mz.service.tvplayEpisode.TvplayEpisodeServiceApi;
import com.mz.util.bean.ServiceResult;
@Service
public class TvplayEpisodeServiceImpl implements TvplayEpisodeServiceApi {
	
	@Resource
	private TvplayEpisodeMapper tvplayEpisodeMapper ;


	@Override
	public ServiceResult<List<TvplayEpisodeVo>> getTvplayEpisodeListByIds(String[] ids) {
		ServiceResult<List<TvplayEpisodeVo>> serviceResult = new ServiceResult<List<TvplayEpisodeVo>>(true);
		List<TvplayEpisodeVo> list = tvplayEpisodeMapper.getEpisodeListByEpisodeIds(ids);
		if (list == null) {
			list = new ArrayList<TvplayEpisodeVo>(0);
		}
		serviceResult.setData(list);
		return serviceResult;
	}

}
