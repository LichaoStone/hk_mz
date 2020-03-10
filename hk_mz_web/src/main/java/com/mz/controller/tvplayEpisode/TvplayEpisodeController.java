package com.mz.controller.tvplayEpisode;

import java.io.File;
import java.text.ParseException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.mz.bean.episode.TvplayEpisode;
import com.mz.bean.episode.query.TvplayEpisodeVoQuery;
import com.mz.bean.episode.vo.TvplayEpisodeVo;
import com.mz.controller.WebBaseController;
import com.mz.service.TvplayEpisode.TvplayEpisodeServiceApi;
import com.mz.util.StringUtils;
import com.mz.util.XmlParser;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/tvplayEpisode")
public class TvplayEpisodeController extends WebBaseController{
	
	@Resource
	private TvplayEpisodeServiceApi tvplayEpisodeServiceImpl ;
	
	/**
	 * 分页展示电影列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_tvplayEpisode_list")
	public ModelAndView index(ModelAndView mav,TvplayEpisodeVoQuery query) {
		mav.addObject("bean", query);
		mav.setViewName("tvplayEpisode/tvplayEpisodeList");
		return mav ;
	}
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_tvplayEpisode_list")
	@ResponseBody
	public JsonResult getTvplayEpisodeList(TvplayEpisodeVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<TvplayEpisodeVo>> serviceResult;
		try {
			serviceResult = tvplayEpisodeServiceImpl.getTvplayEpisodePage(query);
			jsonResult.setOk(serviceResult.isOk());
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonResult ;
	}
	
	/**
	 * 跳转电影查看页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_tvplayEpisode_detail")
	public ModelAndView showTvplayEpisodeDetail(ModelAndView mav,TvplayEpisodeVoQuery query) {
		ServiceResult<TvplayEpisodeVo> serviceResult;
		try {
			serviceResult = tvplayEpisodeServiceImpl.getTvplayEpisodeById(query);
			mav.addObject("bean",serviceResult.getData());
			mav.setViewName("/tvplayEpisode/showTvplayEpisodeDetail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav ;
	}
	
	
	/**
	 * 跳转电影编辑页面
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_save_tvplayEpisode")
	public ModelAndView showSaveUser(ModelAndView mav,TvplayEpisodeVoQuery query) {
		ServiceResult<TvplayEpisodeVo> serviceResult;
		try {
			serviceResult = tvplayEpisodeServiceImpl.getTvplayEpisodeById(query);
			mav.addObject("bean",serviceResult.getData());
			mav.setViewName("/tvplayEpisode/showSaveTvplayEpisode");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav ;
	}
	/**
	 * 重置按钮还原
	 * @param mav
	 * @return
	 */
	@RequestMapping("/reset_modify_tvplayEpisode")
	@ResponseBody
	public JsonResult resetModifyTvplayEpisode(HttpServletRequest request,HttpServletResponse response,TvplayEpisodeVoQuery query) {
		ServiceResult<TvplayEpisodeVo> serviceResult;
		JsonResult jsonResult = new JsonResult(true);
		try {
			serviceResult = tvplayEpisodeServiceImpl.getTvplayEpisodeById(query);
			jsonResult.setData(serviceResult.getData());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jsonResult;
	}
	/**
	 * 修改
	 * @param request
	 * @param bean
	 * @return
	 * @throws ParseException 
	 */
	@RequestMapping("/update_tvplayEpisode")
	@ResponseBody
	public ModelAndView updateTvplayEpisode(HttpServletRequest request,TvplayEpisode bean){
		Integer tvplayId=null;
		try {
			tvplayEpisodeServiceImpl.update(bean);
			tvplayId = bean.getTvplayId();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
//		return new ModelAndView("tvplayEpisode/tvplayEpisodeList?tvplayId="+tvplayId);
		//return "redirect:tvplayEpisode/tvplayEpisodeList?tvplayId="+tvplayId);
		return new ModelAndView("redirect:/tvplayEpisode/show_tvplayEpisode_list?tvplayId="+tvplayId);
	}
	
	@RequestMapping("/upload_tvplayEpisode")
	@ResponseBody
	public JsonResult uploadTvplayEpisode(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = true) MultipartFile imageFile) {
		ServiceResult<Integer> serviceResult;
		JsonResult jsonResult = new JsonResult(true);
		String tvplayId = request.getParameter("tvplayId");
		try {
			// imageFile转换为file
			File file=File.createTempFile("tmp", null);
			imageFile.transferTo(file);
			Map<String,Object> xmlMap = getTvplayEpisodeVoBean(file,tvplayId);
			TvplayEpisode tvplayEpisode =(TvplayEpisode)xmlMap.get("bean");
			//List<Still> stillList = (List<Still>)xmlMap.get("imgUrlpath");
			//查询电影是否已经导入
			TvplayEpisodeVoQuery query = new TvplayEpisodeVoQuery();
			query.setSourceId(tvplayEpisode.getSourceId());
			serviceResult= tvplayEpisodeServiceImpl.getTvplayEpisodeCountByQuery(query);
			if(serviceResult.getData()!=0){
				jsonResult.setOk(false);
				jsonResult.setMessage("电视剧剧集已经存在");
			}else{
				serviceResult= tvplayEpisodeServiceImpl.insertTvplayEpisode(tvplayEpisode);
				jsonResult.setOk(true);
				jsonResult.setMessage("电视剧剧集上传成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			jsonResult.setOk(false);
			jsonResult.setMessage("电视剧剧集上传失败");
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	/**
	 * xml映射为bean
	 * @param movie
	 * @param map
	 * @return
	 * @throws DocumentException 
	 */
	public  Map<String,Object> getTvplayEpisodeVoBean(File file,String tvplayId) throws DocumentException{
		Map<String,Object> xmlMap = new HashMap<String,Object>();
		SAXReader reader = new SAXReader(); 
        //获取XML文档对象
		Document document;
		document = reader.read(file);
       //获取root(根)节点 
        Element root=document.getRootElement(); 
        //获取所有object的元素
        List<Element> elements = XmlParser.getNameElement(root,"Object");
        Map<String,String > map = null;
        TvplayEpisode tvplayEpisode = new TvplayEpisode();
        //剧头id
        tvplayEpisode.setTvplayId(Integer.valueOf(tvplayId));
        for(Element element:elements){
        	String elementType = XmlParser.attrValue(element,"ElementType");
        	//获取电影基本信息
        	if("Program".equals(elementType)){
        		String id = XmlParser.attrValue(element,"ID");
        		//String Code = XmlParser.attrValue(element,"Code");
        		map = XmlParser.getAllChildText(element);
        		tvplayEpisode.setSourceId(id);
    			//视频名称
        		tvplayEpisode.setEpisodeName(String.valueOf(map.get("Name")));
        		// 剧集时长 
        		tvplayEpisode.setEpisodeLong(String.valueOf(map.get("Duration")));
    			//创建时间'
    			tvplayEpisode.setCreateTime(new Date());
    			//入库状态
    			tvplayEpisode.setStatus(0);
    			//简介
    			tvplayEpisode.setSubdescription(StringUtils.trimStr(String.valueOf(map.get("Description"))));
    			//操作用户
    			//tvplay.setUserId(getLoginUser().getUserId());
    			
    		////获取电影下载地址
        	}else if("Movie".equals(elementType)){
        		map = XmlParser.getAllChildText(element);
        		xmlMap.put("downLoadPath",String.valueOf(map.get("FileURL")));
        	}
        }
        //获取第几集
        List<Element> mappElements = XmlParser.getNameElement(root,"Mapping");
        for(Element element:mappElements){
        	String elementType = XmlParser.attrValue(element,"ParentType");
        	//获取电影基本信息
        	if("Series".equals(elementType)){
        		map = XmlParser.getAllChildText(element);
    			//第几集
        		tvplayEpisode.setEpisodeNum((Integer.valueOf(map.get("Sequence"))));
        	}
        }
        xmlMap.put("bean",tvplayEpisode);
		return xmlMap;
    }
}