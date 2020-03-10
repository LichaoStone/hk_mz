package com.mz.controller.news;

import java.io.File;
import java.nio.charset.Charset;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mz.bean.news.vo.NewsVo;
import com.mz.service.news.NewsServiceApi;
import com.mz.util.FileUtil;
import com.mz.util.JSONUtil;
import com.mz.util.StringUtils;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.ServiceResult;
import com.mz.util.http.LocalHttpClient;


@Controller
@RequestMapping("/news")
public class NewsController {
	
	@Resource
	private NewsServiceApi newsServiceImpl ;
	
	@Value("${htmlPath}")
	private String htmlPath ;
	
	@Value("${imagePath}")
	private String imagePath ;
	
	protected static Header jsonHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
	
	protected static Header stringHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.TEXT_HTML.toString());
	
	protected static Header imageHeader = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.DEFAULT_BINARY.toString());
	
	@Value("${domain_url}")
	private String domain_url ;
	/**
	 * 资讯下发
	 * @param ids 资讯ID字符串 1,2,3
	 * @param platformId 平台ID
	 * @return
	 */
	@RequestMapping("/push_sub_platform")
	@ResponseBody
	public JsonResult pushSubPlatform(String ids,Integer platformId) {
		JsonResult jsonResult = new JsonResult(false) ;
		if (StringUtils.isBlank(ids)) {
			jsonResult.setComment("请选择下发资讯");
			return jsonResult ;
		}
		String[] newsIds = ids.split(",");
		ServiceResult<List<NewsVo>> serviceResult = newsServiceImpl.getNewsListByNewsIds(newsIds);
		String jsonString = JSONUtil.toJsonString(serviceResult.getData());
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
	/**
	 * 资讯回传接口
	 * @param newsVo 回传的资讯实体
	 * @return
	 */
	@RequestMapping("/sub_platform_back_news")
	@ResponseBody
	public JsonResult subPlatformBackNews(HttpServletRequest request, NewsVo newsVo) {
		JsonResult jsonResult = new JsonResult(false) ;
		if (StringUtils.isBlank(newsVo.getHtmlUrl())) {
			jsonResult.setComment("资讯Url为空");
			return jsonResult ;
		}
		if (StringUtils.isBlank(newsVo.getImgUrl())) {
			jsonResult.setComment("缩略图地址为空");
			return jsonResult ;
		}
		//获得html 内容
		String content = getHtmlContent(newsVo.getHtmlUrl());
		if (StringUtils.isBlank(content)) {
			jsonResult.setComment("资讯内容下载失败");
			return jsonResult ;
		}
		try {
			//写入html 内容
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			String filePath = createHtmlFile(rootPath,content);
			newsVo.setHtmlUrl(filePath);
			String imagePath = downLoadImage(newsVo.getImgUrl(), rootPath);
			newsVo.setImgUrl(imagePath);
		} catch (Exception e) {
			jsonResult.setComment("资源下载失败");
			e.printStackTrace();
			return jsonResult ;
		}
		ServiceResult<NewsVo> serviceResult = newsServiceImpl.saveNewsVo(newsVo);
		jsonResult.setOk(serviceResult.isOk());
		jsonResult.setComment(serviceResult.getComment());
		return jsonResult ;
	}
	/**
	 * 
	 * @Title: getHtmlContent   
	 * @Description: 获得html的内容  
	 * @param: @param url 请求路径
	 * @param: @return 返回html内容     
	 * @return: String      
	 * @throws 
	 * @author: banbu
	 */
	public String getHtmlContent(String url) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(stringHeader)
				.setUri(url)
				.build();
		String html = LocalHttpClient.executeJsonResult(httpUriRequest,String.class);
		return html ;
	}
	/**
	 * 
	 * @Title: createHtmlFile   
	 * @Description: 将html写入文件  
	 * @param: @param rootPath 根路径
	 * @param: @param content html内容
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: String      
	 * @throws 
	 * @author: banbu
	 */
	public String createHtmlFile(String rootPath,String content) throws Exception{
		String htmlName = UUID.randomUUID().toString().replaceAll("-", "")+".html";
		String filePath = htmlPath+htmlName ;
		File file = FileUtil.createFile(rootPath+htmlPath, htmlName);
		FileUtil.copyStringToFile(content, file);
		return filePath ;
	}
	/**
	 * 
	 * @Title: downLoadImage   
	 * @Description: 下载图片 
	 * @param: @param url
	 * @param: @param rootPath
	 * @param: @return
	 * @param: @throws Exception      
	 * @return: String      
	 * @throws 
	 * @author: banbu
	 */
	public String downLoadImage(String url,String rootPath) throws Exception{
		String iamgeName = UUID.randomUUID().toString().replaceAll("-", "")+".html";
		String filePath = imagePath+iamgeName ;
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(imageHeader)
				.setUri(url)
				.build();
		CloseableHttpResponse response = LocalHttpClient.executeJsonResult(httpUriRequest,CloseableHttpResponse.class);
		if (response != null) {
			File file = FileUtil.createFile(rootPath+imagePath, iamgeName);
			FileUtil.copyInputStreamToFile(response.getEntity().getContent(), file);
		}
		return filePath ;
	}
	
}
