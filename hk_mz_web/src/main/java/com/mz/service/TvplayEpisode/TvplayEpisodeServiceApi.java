package com.mz.service.TvplayEpisode;

import com.mz.bean.episode.TvplayEpisode;
import com.mz.bean.episode.query.TvplayEpisodeVoQuery;
import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface TvplayEpisodeServiceApi {
	
	//获取电视剧剧集列表
	ServiceResult<PageVo<TvplayEpisodeVo>> getTvplayEpisodePage(TvplayEpisodeVoQuery query) throws Exception;
	//更具ID获取电视剧剧集信息
	ServiceResult<TvplayEpisodeVo> getTvplayEpisodeById(TvplayEpisodeVoQuery query) throws Exception;
	//获取电视剧剧集信息
	ServiceResult<Integer> update(TvplayEpisode query) throws Exception;
	//导入电视剧剧集信息
	ServiceResult<Integer> insertTvplayEpisode(TvplayEpisode query) throws Exception;
	//查询电视剧剧集是否存在
	ServiceResult<Integer> getTvplayEpisodeCountByQuery(TvplayEpisodeVoQuery query) throws Exception;

}
