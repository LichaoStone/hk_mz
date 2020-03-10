package com.mz.service.news.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.bean.news.vo.NewsVo;
import com.mz.mapper.news.NewsMapper;
import com.mz.service.news.NewsServiceApi;
import com.mz.util.StringUtils;
import com.mz.util.bean.Constants;
import com.mz.util.bean.ServiceResult;
@Service
public class NewsServiceImpl implements NewsServiceApi {
	
	@Resource
	private NewsMapper newsMapper ;

	@Transactional
	@Override
	public ServiceResult<NewsVo> saveNewsVo(NewsVo newsVo) {
		ServiceResult<NewsVo> serviceResult = new ServiceResult<NewsVo>(false);
		if (StringUtils.isBlank(newsVo.getNewsTitle())) {
			serviceResult.setComment("资讯标题不能为空");
			return serviceResult ;
		}
		if (StringUtils.isBlank(newsVo.getHtmlUrl())) {
			serviceResult.setComment("资讯路径不能为空");
			return serviceResult ;
		}
		if (StringUtils.isBlank(newsVo.getImgUrl())) {
			serviceResult.setComment("资讯缩略图不能为空");
			return serviceResult ;
		}
		newsVo.setStatus(Constants.News.STATUS_ENABLE);
		int count = newsMapper.insertNews(newsVo);
		if (count > 0) {
			serviceResult.setComment("保存成功");
			return serviceResult ;
		}
		
		serviceResult.setComment("保存失败");
		return serviceResult;
	}

	@Override
	public ServiceResult<List<NewsVo>> getNewsListByNewsIds(String[] ids) {
		ServiceResult<List<NewsVo>> serviceResult = new ServiceResult<List<NewsVo>>(true);
		List<NewsVo> list = newsMapper.getNewsListByNewsIds(ids);
		if (list == null) {
			list = new ArrayList<NewsVo>(0);
		}
		serviceResult.setData(list);
		return serviceResult;
	}

}
