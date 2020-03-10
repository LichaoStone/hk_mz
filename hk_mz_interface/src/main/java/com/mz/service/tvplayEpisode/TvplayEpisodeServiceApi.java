package com.mz.service.tvplayEpisode;

import java.util.List;

import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.util.bean.ServiceResult;

public interface TvplayEpisodeServiceApi {
	/**
	 * 
	 * @Title: getTvplayEpisodeList  
	 * @Description: 根据ID获得剧集列表 
	 * @param: @param ids
	 * @param: @return      
	 * @return: ServiceResult<List<TvplayEpisodeVo>>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<List<TvplayEpisodeVo>> getTvplayEpisodeListByIds(String[] ids);

}
