package com.mz.service.tvplay;

import java.util.List;

import com.mz.bean.still.Still;
import com.mz.bean.tvplay.Tvplay;
import com.mz.bean.tvplay.query.TvplayVoQuery;
import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface TvplayServiceApi {
	
	//获取电视剧剧头列表
	ServiceResult<PageVo<TvplayVo>> getTvplayPage(TvplayVoQuery query) throws Exception;
	//更具ID获取电视剧剧头信息
	ServiceResult<TvplayVo> getTvplayById(TvplayVoQuery query) throws Exception;
	//获取电视剧剧头信息
	ServiceResult<Integer> update(Tvplay query) throws Exception;
	//导入电视剧剧头信息
	ServiceResult<Integer> insertTvplay(Tvplay query,List<Still> still) throws Exception;
	//查询电视剧剧头是否存在
	ServiceResult<Integer> getTvplayCountByQuery(TvplayVoQuery query) throws Exception;

}
