package com.mz.service.news.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.news.query.NewsVoQuery;
import com.mz.bean.news.vo.NewsVo;
import com.mz.mapper.news.NewsMapper;
import com.mz.service.news.NewsServiceApi;
import com.mz.util.DateTimeUtils;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class NewsServiceImpl implements NewsServiceApi{
	
	@Resource
	private NewsMapper newsMapper ;

	/**
	 * 根据查询条件获取电影列表
	 */
	@Override
	public ServiceResult<PageVo<NewsVo>> getNewsPage(NewsVoQuery query) throws Exception {
		ServiceResult<PageVo<NewsVo>> serviceResult = new ServiceResult<PageVo<NewsVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<NewsVo> list = newsMapper.getNewsListByQuery(query);
		NewsVoQuery queryAll = new NewsVoQuery();
		
		List<NewsVo> newsALllist = newsMapper.getNewsListByQuery(queryAll);
		Map<String,Long> newsgroup = newsALllist.stream().collect(Collectors.groupingBy(NewsVo::getClassifyName,Collectors.counting()));//所有的分组统计
		
		Map<String, Long> newsgroupfilterByNow = newsALllist.stream().filter(v -> {
			String nowDay = DateTimeUtils.format(new Date(), DateTimeUtils.YYYY_MM_DD);
			Date nowTime = DateTimeUtils.parseStr(nowDay);
			return v.getCreateTime().after(nowTime);

		}).collect(Collectors.groupingBy(NewsVo::getClassifyName, Collectors.counting()));
	
		Long totalNews = 0L;
		Long totalNewsToday = 0L;
		Map <String, String> result = new HashMap<>();
		for(String classify : newsgroup.keySet()) {
			Long news = newsgroup.get(classify);
			totalNews += news;
			Long newsToday =  newsgroupfilterByNow.get(classify) == null ? 0 : newsgroupfilterByNow.get(classify);
			totalNewsToday += newsToday;
			String ss = newsToday + "/" + news;
			result.put(classify, ss);
		}
		result.put("全部", totalNewsToday + "/" + totalNews);
		String jsonStr = JSON.toJSONString(result);
		PageVo<NewsVo> pageVo = new PageVo<NewsVo>((Page<NewsVo>) list);
		serviceResult.setData(pageVo);
		serviceResult.setMsgCode(jsonStr);
		return serviceResult;
	}

	@Override
	public NewsVo getNewsVoById(String newsId) {
		// TODO Auto-generated method stub
		return newsMapper.getNewsVoById(newsId);
	}
	
	
}
