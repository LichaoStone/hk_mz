package com.mz.controller.tvplay;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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

import com.mz.bean.still.Still;
import com.mz.bean.tvplay.Tvplay;
import com.mz.bean.tvplay.query.TvplayVoQuery;
import com.mz.bean.tvplay.vo.TvplayVo;
import com.mz.controller.WebBaseController;
import com.mz.service.tvplay.TvplayServiceApi;
import com.mz.util.DateTimeUtils;
import com.mz.util.StringUtils;
import com.mz.util.XmlParser;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/tvplay")
public class TvplayController extends WebBaseController{
	
	@Resource
	private TvplayServiceApi tvplayServiceImpl ;
	
	/**
	 * 分页展示电影列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_tvplay_list")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("tvplay/tvplayList");
		return mav ;
	}
//	@RequestMapping("/TvplayPageList")
//	public ModelAndView pageList(ModelAndView mav) {
//		mav.setViewName("Tvplay/pageList");
//		return mav ;
//	}
//	
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_tvplay_list")
	@ResponseBody
	public JsonResult getTvplayList(TvplayVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<TvplayVo>> serviceResult;
		try {
			serviceResult = tvplayServiceImpl.getTvplayPage(query);
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
	@RequestMapping("/show_tvplay_detail")
	public ModelAndView showTvplayDetail(ModelAndView mav,TvplayVoQuery query) {
		ServiceResult<TvplayVo> serviceResult;
		try {
			serviceResult = tvplayServiceImpl.getTvplayById(query);
			mav.addObject("bean",serviceResult.getData());
			mav.setViewName("/tvplay/showTvplayDetail");
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
	@RequestMapping("/show_save_tvplay")
	public ModelAndView showSaveUser(ModelAndView mav,TvplayVoQuery query) {
		ServiceResult<TvplayVo> serviceResult;
		try {
			serviceResult = tvplayServiceImpl.getTvplayById(query);
			mav.addObject("bean",serviceResult.getData());
			mav.setViewName("/tvplay/showSaveTvplay");
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
	@RequestMapping("/reset_modify_tvplay")
	@ResponseBody
	public JsonResult resetModifyTvplay(HttpServletRequest request,HttpServletResponse response,TvplayVoQuery query) {
		ServiceResult<TvplayVo> serviceResult;
		JsonResult jsonResult = new JsonResult(true);
		try {
			serviceResult = tvplayServiceImpl.getTvplayById(query);
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
	@RequestMapping("/update_tvplay")
	@ResponseBody
	public ModelAndView updateTvplay(HttpServletRequest request,Tvplay bean){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String beanShowTime = request.getParameter("beanShowTime");
		String selectTags = request.getParameter("selectTags"); 
		try {
			bean.setCopyBeginTime(sdf.parse(startTime));
			bean.setCopyEndTime(sdf.parse(endTime));
			bean.setShowTime(sdf.parse(beanShowTime));
			bean.setTvplayTag(selectTags);
			tvplayServiceImpl.update(bean);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("tvplay/tvplayList");
	}
	
	/**
	 * 导入电视剧剧头信息
	 * @param request
	 * @param response
	 * @param imageFile
	 */
	@SuppressWarnings({ "unchecked"})
	@RequestMapping("/upload_tvplay")
	@ResponseBody
	public JsonResult uploadtvplay(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = true) MultipartFile imageFile) {
		ServiceResult<Integer> serviceResult;
		JsonResult jsonResult = new JsonResult(true);
		try {
			// imageFile转换为file
			File file=File.createTempFile("tmp", null);
			imageFile.transferTo(file);
			Map<String,Object> xmlMap = getTvplayVoBean(file);
			Tvplay tvplay =(Tvplay)xmlMap.get("bean");
			List<Still> stillList = (List<Still>)xmlMap.get("imgUrlpath");
			//查询电影是否已经导入
			TvplayVoQuery query = new TvplayVoQuery();
			query.setSourceId(tvplay.getSourceId());
			serviceResult= tvplayServiceImpl.getTvplayCountByQuery(query);
			if(serviceResult.getData()!=0){
				jsonResult.setOk(false);
				jsonResult.setMessage("电视剧剧头已经存在");
			}else{
				serviceResult= tvplayServiceImpl.insertTvplay(tvplay,stillList);
				jsonResult.setOk(true);
				jsonResult.setMessage("电视剧剧头上传成功");
			}
		} catch (Exception e) {
			jsonResult.setOk(false);
			jsonResult.setMessage("电视剧剧头上传失败");
			e.printStackTrace();
		}
		return jsonResult;
	}
	
	/**
	 * xml映射为bean
	 * @param tvplay
	 * @param map
	 * @return
	 * @throws DocumentException 
	 */
	public  Map<String,Object> getTvplayVoBean(File file) throws DocumentException{
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
        // 图片地址
        List<Still> picUrlList = new ArrayList<Still>();
        Tvplay tvplay = new Tvplay();
        for(Element element:elements){
        	String elementType = XmlParser.attrValue(element,"ElementType");
        	//获取电影基本信息
        	if("Series".equals(elementType)){
        		String id = XmlParser.attrValue(element,"ID");
        		//String Code = XmlParser.attrValue(element,"Code");
        		map = XmlParser.getAllChildText(element);
        		tvplay.setSourceId(id);
    			//视频名称
    			tvplay.setTvplayName(String.valueOf(map.get("Name")));
    			//版权开始时间
    			if(!StringUtils.isEmpty(String.valueOf(map.get("LicensingWindowStart")))){
    				tvplay.setCopyBeginTime(DateTimeUtils.parseStr(String.valueOf(map.get("LicensingWindowStart")),DateTimeUtils.dateTimeLongString));
    			}
    			//版权结束时间 
    			if(!StringUtils.isEmpty(String.valueOf(map.get("LicensingWindowEnd")))){
    				tvplay.setCopyEndTime(DateTimeUtils.parseStr(String.valueOf(map.get("LicensingWindowEnd")),DateTimeUtils.dateTimeLongString));
    			}
    			//创建时间'
    			tvplay.setCreateTime(new Date());
    			//上映时间 
    			if(!StringUtils.isEmpty(String.valueOf(map.get("OrgAirDate")))){
    				tvplay.setShowTime(DateTimeUtils.parseStr(String.valueOf(map.get("OrgAirDate")),DateTimeUtils.dateLongString));
    			}
    			//集数
    			tvplay.setTvplayNum(Integer.valueOf(map.get("VolumnCount")));
    			//导演
    			tvplay.setDirector(String.valueOf(map.get("Director")));
    			//国家
    			tvplay.setNational(String.valueOf(map.get("OriginalCountry")));
    			//语言
    			tvplay.setLanguage(String.valueOf(map.get("Language")));
    			//主演
    			tvplay.setMainActor(String.valueOf(map.get("ActorDisplay")));
    			//简介
    			tvplay.setSubdiscription(StringUtils.trimStr(String.valueOf(map.get("Description"))));
    			//操作用户
    			//tvplay.setUserId(getLoginUser().getUserId());
    			xmlMap.put("bean",tvplay);
        	//获取电影图片链接地址	
        	}else if("Picture".equals(elementType)){
        		map = XmlParser.getAllChildText(element);
        		Still still = new Still();
        		//顺序号
        		still.setOrderNum(Integer.valueOf(map.get("Type")));
        		//图片地址
        		still.setImgUrl(String.valueOf(map.get("FileURL")));
        		//user_id
        		//still.setUserId(getLoginUser().getUserId());
        		picUrlList.add(still);
        		xmlMap.put("imgUrlpath",picUrlList);
        	}
        }
		return xmlMap;
    }
	
	
}