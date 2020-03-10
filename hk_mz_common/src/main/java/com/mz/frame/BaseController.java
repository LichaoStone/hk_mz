package com.mz.frame;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.alibaba.fastjson.JSONObject;
import com.mz.frame.page.PageContext;

/**
 * controller
 * @作者 栗超
 * @时间 2019-02-15 08:55:58
 * @说明
 */
public class BaseController extends Constants{
	private static final Logger logger = Logger.getLogger(BaseController.class);
	 
	 @InitBinder 
	 public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
			if (request.getCharacterEncoding() == null || !request.getCharacterEncoding().toLowerCase().equals("utf-8")) {
				logger.info("getCharacterEncoding:" + request.getCharacterEncoding() + ":",new Exception("鎵撳嵃鍫嗘爤"));
			}
			
			request.setCharacterEncoding("utf-8");
			binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	 }
	 
	 /**
	  * 发送json
	  * @param json
	  * @param response
	  */
	 protected static void sendJson(String json,HttpServletResponse response){
		  try {
				logger.info("json===>\n" + json);
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out;
				
				out = response.getWriter();
				out.print(json);
				out.flush();
				out.close();
			} catch (IOException e) {
				logger.error("BaseController.sendJson鍑洪敊:",e);
			}
      }
	 
	 /**
	  * 获取json
	  * @param CODE
	  * @param RET
	  * @return
	  */
	 public static String getJson(int CODE,int RET) {
		 	JSONObject jsonObj = new JSONObject();  
			jsonObj.put("code",CODE);
		    
	    	JSONObject jsonObj2 = new JSONObject();
	    	jsonObj2.put("ret",RET);
	    	jsonObj2.put("msg",RET_INFO.get(RET));
	    	
	    	jsonObj.put("results",jsonObj2);
	    	logger.info("缁勮瀹屾垚杩斿洖json:" + jsonObj.toString());
	    	return jsonObj.toString();
	 }
	 
	 /**
	  * ajax返回参数json串
	  * @param CODE
	  * @param RET
	  * @return
	  */
	 public static String getAjaxJson(boolean flag,String msg) {
		 JSONObject jsonObj = new JSONObject();
		 jsonObj.put("success",flag);
		 jsonObj.put("msg",msg);
		 
		 return jsonObj.toString();
	 }
	 
	 /**
	  * 获取json串
	  * @param ret
	  * @param msg
	  * @return
	  */
	  protected static String getJson(int CODE,int RET,List<?> resultList,Integer totalRow) {
		  Map<String, Object> gridMap = new HashMap<String, Object>();
		  
	    	Map<String, Object> map = new HashMap<String, Object>();
	    	map.put("code", CODE);
	    	Map<String, Object> map1 = new HashMap<String, Object>();
	    	map1.put("ret", RET);
	    	map1.put("msg", RET_INFO.get(RET));
	    	if (resultList!=null&&resultList.size()>0) {
	    		map1.put("rows", resultList);
	    		map1.put("total",totalRow);
	    	}else{
	    		map1.put("rows", "");
	    		map1.put("total", 0);
	    	}
	    	map.put("results", map1);
	    	return net.sf.json.JSONObject.fromObject(map).toString();
	    	
	  }
	  
	  
	    /**
		  * 获取json串
		  * @param ret
		  * @param msg
		  * @return
		  */
		  protected static String getJson(int CODE,int RET,List<?> resultList) {
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("code", CODE);
		    	Map<String, Object> map1 = new HashMap<String, Object>();
		    	map1.put("ret", RET);
		    	map1.put("msg", RET_INFO.get(RET));
		    	if (resultList!=null&&resultList.size()>0) {
		    		map1.put("rows", resultList);
		    	}else{
		    		map1.put("rows", "");
		    	}
		    	map.put("results", map1);
		    	return net.sf.json.JSONObject.fromObject(map).toString();
		  }
	 
	 
	 /**
	  * 设置分页
	  * @param pageNumber
	  * @param step
	  * @return
	  */
	 public PageContext setPagination(String pageNumber,String step) {
		  	
		  	if (step==null) {
		  		step="10";
			}
		  	
		  	PageContext pageContext=PageContext.getContext();
			pageContext.setPageStartRow(Integer.parseInt(pageNumber));
			pageContext.setPageSize(Integer.parseInt(step));
			pageContext.setPaginationController(true);
			pageContext.setPaginationService(true);
			
			return pageContext;
	  }
		
		
	  public static void main(String[] args) {
	  }
}
