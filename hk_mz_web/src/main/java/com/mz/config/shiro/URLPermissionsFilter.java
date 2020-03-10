package com.mz.config.shiro;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.pagehelper.StringUtil;



public class URLPermissionsFilter extends PermissionsAuthorizationFilter{
	
	private static final Logger logger = LoggerFactory.getLogger(URLPermissionsFilter.class);

	@Override
	public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
		
		logger.debug("isAccessAllowed-----1---");
		
		String curUrl = getRequestUrl(request);
		logger.debug(curUrl);
		Subject subject = SecurityUtils.getSubject();
		if (StringUtils.equals(curUrl, "/login") 
				|| StringUtils.equals(curUrl, "/do_login") 
				|| StringUtils.equals(curUrl, "/unauthor")
				|| StringUtils.equals(curUrl, "/logout")) {
			
			logger.debug("isAccessAllowed-----4---:"+curUrl);
			return true ;
		}
		if(StringUtils.startsWith(curUrl, "/bootstrap")
				||StringUtils.startsWith(curUrl, "/css")
				||StringUtils.startsWith(curUrl, "/colorpicker")
				||StringUtils.startsWith(curUrl, "/fileinput")
				||StringUtils.startsWith(curUrl, "/images")
				||StringUtils.startsWith(curUrl, "/index/")
				||StringUtils.startsWith(curUrl, "/page")
				||StringUtils.startsWith(curUrl, "/slider")
				||StringUtils.startsWith(curUrl, "/uppy")
				||StringUtils.startsWith(curUrl, "/videojs")) {
			return true;
		}
		
		if(StringUtils.startsWith(curUrl, "/druid/")) {
			logger.debug("isAccessAllowed-----2---:"+curUrl);
			return true;
		}
		
		if(StringUtils.startsWith(curUrl, "/page")
				||StringUtils.startsWith(curUrl, "/resource")
				||StringUtils.endsWith(curUrl, "/favicon.ico")) {
			
			logger.debug("isAccessAllowed-----3---:"+curUrl);
			return true;
		}
	
		if (subject.getPrincipal() == null || 
				subject.getSession() == null ||
				subject.getSession().getAttribute("user") == null) {
        	logger.debug("用户未登陆--------");
			return false ;
		}
		
//		UserVo vo = (UserVo)subject.getSession().getAttribute("userInfo");
//		List<String> urls = vo.getPermissionUrlList();
//		if (urls == null ) {
//			return false ;
//		}
		logger.debug("isAccessAllowed-----6--:"+curUrl);
		return true ;//urls.contains(curUrl);
	}
	
	/**
	 * 获取当前URL+Parameter
	 * @param request	拦截请求request
	 * @return			返回完整URL
	 */
	@SuppressWarnings("unused")
	private String getRequestUrl(ServletRequest request) {
		HttpServletRequest req = (HttpServletRequest)request;
		String queryString = req.getQueryString();
		String url = req.getRequestURI();
		if(url.contains("/hk_mz_web")) {
			url = url.replace("/hk_mz_web", "");
		}
		if (url.contains(".do")) {
			url = url.replace(".do", "");
		}
		if (url.contains(".jsp")) {
			url = url.replaceAll(".jsp", "");
		}
		if(url.contains("//")) {
			url = url.replaceAll("//", "/");
		}
		queryString = StringUtils.isBlank(queryString)?"": "?"+queryString;
		return url;
	}
	
	 /**
     * shiro认证perms资源失败后回调方法
     * @param servletRequest
     * @param servletResponse
     * @return
     * @throws IOException
     */
    @Override
    protected boolean onAccessDenied(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
      
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        String requestedWith = httpServletRequest.getHeader("X-Requested-With");
        logger.debug("onAccessDenied--------");
        Subject subject = SecurityUtils.getSubject();
      
        if (!StringUtil.isEmpty(requestedWith)) {
        	if (subject.getPrincipal() == null || 
        			subject.getSession() == null ||
        			subject.getSession().getAttribute("userInfo") == null) {
        		
        		logger.debug("用户未登陆--------");
//        	httpServletResponse.setCharacterEncoding("UTF-8");
//            httpServletResponse.setContentType("application/json");
//            httpServletResponse.getWriter().write("{\"ok\":\"false\",\"comment\":\"登陆超时，请重新登陆\"}");
        		String url = httpServletRequest.getRequestURI();
        		if (url.contains("/hk_mz_web")) {
        			httpServletResponse.sendRedirect("/login");				
        		}else {
        			httpServletResponse.sendRedirect("/login");		
        		}
        		httpServletResponse.sendError(0);
        		return false ;
        	}
        	
        	logger.debug("权限不足--------");
        	/**
        	 * 如果是ajax返回指定格式数据
        	 */
            Map<String, Object> result = new HashMap<String, Object>();
            result.put("flag", false);
            result.put("msg", "权限不足！");
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json");
            httpServletResponse.getWriter().write("{\"ok\":\"false\",\"comment\":\"权限不足\"}");
        } else {
        	
        	logger.debug("普通请求拦截重向--------");
        	if (subject.getPrincipal() == null || 
        			subject.getSession() == null ||
        			subject.getSession().getAttribute("user") == null) {
        		
        		logger.debug("用户未登陆--------");
        		String url = httpServletRequest.getRequestURI();
        		if (url.contains("/hk_mz_web")) {
        			httpServletResponse.sendRedirect("/hk_mz_web/login");				
        		}else {
        			httpServletResponse.sendRedirect("/login");		
        		}
        		return false ;
        	}
        	/**
        	 * 普通请求拦截重向
        	 */
        	String url = httpServletRequest.getRequestURI();
    		if (url.contains("/hk_mz_web")) {
    			httpServletResponse.sendRedirect("/hk_mz_web/unauthor");				
    		}else {
    			httpServletResponse.sendRedirect("/unauthor");		
    		}
        }
        return false;
    }
}