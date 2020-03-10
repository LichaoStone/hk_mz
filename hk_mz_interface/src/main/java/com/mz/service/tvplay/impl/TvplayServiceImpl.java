package com.mz.service.tvplay.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.mapper.tvplay.TvplayMapper;
import com.mz.service.tvplay.TvplayServiceApi;
import com.mz.util.bean.ServiceResult;
@Service
public class TvplayServiceImpl implements TvplayServiceApi {
	
	@Resource
	private TvplayMapper tvplayMapper ;

	@Override
	public ServiceResult<List<TvplayVo>> getTvplayListByIds(String[] ids) {
		ServiceResult<List<TvplayVo>> serviceResult = new ServiceResult<List<TvplayVo>>(true);
		List<TvplayVo> list = tvplayMapper.getTvplayListByTvplayIds(ids);
		if (list == null) {
			list = new ArrayList<TvplayVo>(0);
		}
		serviceResult.setData(list);
		return serviceResult;
	}

}
