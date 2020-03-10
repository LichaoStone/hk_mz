package com.mz.controller;

import java.nio.charset.Charset;
import java.util.List;

import javax.annotation.Resource;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.bean.movie.vo.MovieVo;
import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.service.movie.MovieServiceApi;
import com.mz.service.tvplay.TvplayServiceApi;
import com.mz.service.tvplayEpisode.TvplayEpisodeServiceApi;
import com.mz.util.JSONUtil;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.ServiceResult;
import com.mz.util.http.LocalHttpClient;


@Controller
public class BaseController {
	
	@Resource
	private MovieServiceApi movieServiceImpl ;
	@Resource
	private TvplayServiceApi tvplayServiceImpl ;
	@Resource
	private TvplayEpisodeServiceApi tvplayEpisodeServiceImpl ;
	
	protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
	
	@Value("${domain_url}")
	private String domain_url ;
	/**
	 * 资讯下发
	 * @param ids 资讯ID字符串 1,2,3
	 * @param platformId 平台ID
	 * @return
	 */
	@RequestMapping("/downward_sub_platform")
	@ResponseBody
	public JsonResult downwardSubPlatform(String type,String ids,Integer platformId) {
		JsonResult jsonResult = new JsonResult(false) ;
		String[] idList = ids.split(",");
		String jsonString ="";
		if("movie".equals(type)){
			ServiceResult<List<MovieVo>> serviceResult = movieServiceImpl.getMovieListByIds(idList);
			jsonString = JSONUtil.toJsonString(serviceResult.getData());
		}else if("tvplay".equals(type)){
			ServiceResult<List<TvplayVo>> serviceResult = tvplayServiceImpl.getTvplayListByIds(idList);
			jsonString = JSONUtil.toJsonString(serviceResult.getData());
		}else if("tvplayEpisode".equals(type)){
			ServiceResult<List<TvplayEpisodeVo>> serviceResult = tvplayEpisodeServiceImpl.getTvplayEpisodeListByIds(idList);
			jsonString = JSONUtil.toJsonString(serviceResult.getData());
		}
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(domain_url + "/api/news/publish")
				.addParameter("_timestamp", "")
				.addParameter("_sign", "")
				.setEntity(new StringEntity(jsonString,Charset.forName("utf-8")))
				.build();
		jsonResult = LocalHttpClient.executeJsonResult(httpUriRequest,JsonResult.class);
		return jsonResult ;
	}
}
