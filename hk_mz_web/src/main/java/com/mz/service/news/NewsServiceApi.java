package com.mz.service.news;

import com.mz.bean.news.query.NewsVoQuery;
import com.mz.bean.news.vo.NewsVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface NewsServiceApi {
	
	//获取电影列表
	ServiceResult<PageVo<NewsVo>> getNewsPage(NewsVoQuery query) throws Exception;

	NewsVo getNewsVoById(String newsId);
}
