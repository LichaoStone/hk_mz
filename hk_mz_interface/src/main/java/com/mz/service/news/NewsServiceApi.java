package com.mz.service.news;

import java.util.List;

import com.mz.bean.news.vo.NewsVo;
import com.mz.util.bean.ServiceResult;

public interface NewsServiceApi {
	/**
	 * 
	 * @Title: saveNewsVo   
	 * @Description: 保存资讯  
	 * @param: @param newsVo
	 * @param: @return      
	 * @return: ServiceResult<NewsVo>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<NewsVo> saveNewsVo(NewsVo newsVo);
	/**
	 * 
	 * @Title: getNewsListByNewsIds   
	 * @Description: 根据ID获得资讯列表 
	 * @param: @param ids
	 * @param: @return      
	 * @return: ServiceResult<List<NewsVo>>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<List<NewsVo>> getNewsListByNewsIds(String[] ids);

}
