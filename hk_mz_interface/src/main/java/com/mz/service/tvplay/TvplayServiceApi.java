package com.mz.service.tvplay;

import java.util.List;

import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.util.bean.ServiceResult;

public interface TvplayServiceApi {
	/**
	 * 
	 * @Title: getTvplayListByTvplayIds   
	 * @Description: 根据ID获得资讯列表 
	 * @param: @param ids
	 * @param: @return      
	 * @return: ServiceResult<List<TvplayVo>>      
	 * @throws 
	 * @author: banbu
	 */
	public ServiceResult<List<TvplayVo>> getTvplayListByIds(String[] ids);

}
