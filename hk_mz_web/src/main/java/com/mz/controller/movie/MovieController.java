package com.mz.controller.movie;

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

import com.mz.bean.movie.Movie;
import com.mz.bean.movie.query.MovieVoQuery;
import com.mz.bean.movie.vo.MovieVo;
import com.mz.bean.still.Still;
import com.mz.controller.WebBaseController;
import com.mz.service.movie.MovieServiceApi;
import com.mz.util.DateTimeUtils;
import com.mz.util.StringUtils;
import com.mz.util.XmlParser;
import com.mz.util.bean.JsonResult;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Controller
@RequestMapping("/movie")
public class MovieController extends WebBaseController{
	
	@Resource
	private MovieServiceApi movieServiceImpl ;
	
	/**
	 * 分页展示电影列表
	 * @param mav
	 * @return
	 */
	@RequestMapping("/show_movie_list")
	public ModelAndView index(ModelAndView mav) {
		mav.setViewName("movie/movieList");
		return mav ;
	}
//	@RequestMapping("/moviePageList")
//	public ModelAndView pageList(ModelAndView mav) {
//		mav.setViewName("movie/pageList");
//		return mav ;
//	}
//	
	/**
	 * 获取列表数据
	 * @param query
	 * @return
	 */
	@RequestMapping("/get_movie_list")
	@ResponseBody
	public JsonResult getMovieList(MovieVoQuery query) {
		JsonResult jsonResult = new JsonResult(true);
		ServiceResult<PageVo<MovieVo>> serviceResult;
		try {
			serviceResult = movieServiceImpl.getMoviePage(query);
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
	@RequestMapping("/show_movie_detail")
	public ModelAndView showMovieDetail(ModelAndView mav,MovieVoQuery query) {
		ServiceResult<MovieVo> serviceResult;
		try {
			serviceResult = movieServiceImpl.getMovieById(query);
			mav.addObject("bean",serviceResult.getData());
			mav.setViewName("/movie/showMovieDetail");
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
	@RequestMapping("/show_save_movie")
	public ModelAndView showSaveUser(ModelAndView mav,MovieVoQuery query) {
		ServiceResult<MovieVo> serviceResult;
		try {
			serviceResult = movieServiceImpl.getMovieById(query);
			mav.addObject("bean",serviceResult.getData());
			mav.setViewName("/movie/showSaveMovie");
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
	@RequestMapping("/reset_modify_movie")
	@ResponseBody
	public JsonResult resetModifyMovie(HttpServletRequest request,HttpServletResponse response,MovieVoQuery query) {
		ServiceResult<MovieVo> serviceResult;
		JsonResult jsonResult = new JsonResult(true);
		try {
			serviceResult = movieServiceImpl.getMovieById(query);
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
	@RequestMapping("/update_movie")
	@ResponseBody
	public ModelAndView updateMovie(HttpServletRequest request,Movie bean){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String startTime = request.getParameter("startTime");
		String endTime = request.getParameter("endTime");
		String beanShowTime = request.getParameter("beanShowTime");
		String selectTags = request.getParameter("selectTags");
		try {
			bean.setCopyBeginTime(sdf.parse(startTime));
			bean.setCopyEndTime(sdf.parse(endTime));
			bean.setShowTime(sdf.parse(beanShowTime));
			bean.setMovieTag(selectTags);
			movieServiceImpl.update(bean);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("movie/movieList");
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/upload_movie")
	@ResponseBody
	public JsonResult uploadMovie(HttpServletRequest request,HttpServletResponse response,@RequestParam(required = true) MultipartFile imageFile) {
		ServiceResult<Integer> serviceResult;
		JsonResult jsonResult = new JsonResult(true);
		try {
			// imageFile转换为file
			File file=File.createTempFile("tmp", null);
			imageFile.transferTo(file);
			Map<String,Object> xmlMap = getMovieVoBean(file);
			Movie movie =(Movie)xmlMap.get("bean");
			List<Still> stillList = (List<Still>)xmlMap.get("imgUrlpath");
			//查询电影是否已经导入
			MovieVoQuery query = new MovieVoQuery();
			query.setSourceId(movie.getSourceId());
			serviceResult= movieServiceImpl.getMovieCountByQuery(query);
			if(serviceResult.getData()!=0){
				jsonResult.setOk(false);
				jsonResult.setMessage("电影工单已经存在");
			}else{
				serviceResult= movieServiceImpl.insertMovie(movie,stillList);
				jsonResult.setOk(true);
				jsonResult.setMessage("电影上传成功");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			jsonResult.setOk(false);
			jsonResult.setMessage("电影上传失败");
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
	public  Map<String,Object> getMovieVoBean(File file) throws DocumentException{
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
    	Movie movie = new Movie();
        for(Element element:elements){
        	String elementType = XmlParser.attrValue(element,"ElementType");
        	//获取电影基本信息
        	if("Program".equals(elementType)){
        		String id = XmlParser.attrValue(element,"ID");
        		//String Code = XmlParser.attrValue(element,"Code");
        		map = XmlParser.getAllChildText(element);
        		movie.setSourceId(id);
    			//视频名称
    			movie.setMovieName(String.valueOf(map.get("Name")));
    			//版权开始时间
    			if(!StringUtils.isEmpty(String.valueOf(map.get("LicensingWindowStart")))){
    				movie.setCopyBeginTime(DateTimeUtils.parseStr(String.valueOf(map.get("LicensingWindowStart")),DateTimeUtils.dateTimeLongString));
    			}
    			//版权结束时间 
    			if(!StringUtils.isEmpty(String.valueOf(map.get("LicensingWindowEnd")))){
    				movie.setCopyEndTime(DateTimeUtils.parseStr(String.valueOf(map.get("LicensingWindowEnd")),DateTimeUtils.dateTimeLongString));
    			}
    			//视频时长
    			movie.setMovieLong(String.valueOf(map.get("Duration")));
    			//创建时间'
    			movie.setCreateTime(new Date());
    			//上映时间 
    			if(!StringUtils.isEmpty(String.valueOf(map.get("OrgAirDate")))){
    				movie.setShowTime(DateTimeUtils.parseStr(String.valueOf(map.get("OrgAirDate")),DateTimeUtils.dateLongString));
    			}
    			//入库状态
    			movie.setStatus(0);
    			//导演
    			movie.setDirector(String.valueOf(map.get("Director")));
    			//国家
    			movie.setNational(String.valueOf(map.get("OriginalCountry")));
    			//语言
    			movie.setLanguage(String.valueOf(map.get("Language")));
    			//主演
    			movie.setMainActor(String.valueOf(map.get("ActorDisplay")));
    			//简介
    			movie.setSubdescription(StringUtils.trimStr(String.valueOf(map.get("Description"))));
    			//操作用户
    			//tvplay.setUserId(getLoginUser().getUserId());
    			xmlMap.put("bean",movie);
    		////获取电影下载地址
        	}else if("Movie".equals(elementType)){
        		map = XmlParser.getAllChildText(element);
        		xmlMap.put("downLoadPath",String.valueOf(map.get("FileURL")));
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