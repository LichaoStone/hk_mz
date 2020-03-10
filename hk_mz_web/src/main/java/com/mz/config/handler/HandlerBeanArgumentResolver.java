package com.mz.config.handler;

import java.lang.annotation.Annotation;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.ByteArrayMultipartFileEditor;

import com.mz.util.DateTimeUtils;
import com.mz.util.EmojiFilter;
import com.mz.util.JSONUtil;
import com.mz.util.StringUtils;



@Configuration
public class HandlerBeanArgumentResolver implements HandlerMethodArgumentResolver {

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		if(parameter.hasParameterAnnotation(RequestBean.class)
			||parameter.hasParameterAnnotation(RequestJson.class)){
			return true;
		}
		return false;
	}

	@Override
	public Object resolveArgument(MethodParameter param, ModelAndViewContainer mavContainer,
			NativeWebRequest request, WebDataBinderFactory binderFactory) throws Exception {
		RequestBean requestBean = param.getParameterAnnotation(RequestBean.class);
		if (requestBean != null) {
			String _param = requestBean.value();
			if (_param.equals("_def_param_name")) {
				_param = param.getParameterName();
			}
			Class<?> clazz = param.getParameterType();
			Object object = clazz.newInstance();
			HashMap<String, String[]> paramsMap = new HashMap<String, String[]>();
			Iterator<String> itor = request.getParameterNames();
			while (itor.hasNext()) {
				String webParam = itor.next();
				String[] webValue = request.getParameterValues(webParam);
				if (webParam.startsWith(_param+".")) {
					paramsMap.put(webParam, webValue);
				}
			}
			BeanWrapper obj = new BeanWrapperImpl(object);
			obj.registerCustomEditor(Date.class, null, new CustomDateEditor(new SimpleDateFormat(DateTimeUtils.dateString), true));
			obj.registerCustomEditor(String.class, new StringTrimmerEditor(false));
			obj.registerCustomEditor(byte[].class,new ByteArrayMultipartFileEditor());
			
			for (String propName : paramsMap.keySet()) {
				String[] propVals = paramsMap.get(propName);
				
				// System.out.println(propName);
				// TODO 除了密码，其他都要做特殊字符替换处理
				if(!propName.endsWith("Password") && !propName.endsWith("password")){
					// TODO 过滤emoji表情
					boolean isEmoji = false;
					String lowerParam = _param.toLowerCase();
					if (lowerParam.contains("emoji")) {
						isEmoji = true;
					}
					for (int i = 0; i < propVals.length; i++) {
						if (!isEmoji) {
							propVals[i] = EmojiFilter.filterEmoji(propVals[i]);
						}
						propVals[i] = StringUtils.replaceHtmlCh(propVals[i]);
						
						// TODO html安全过滤(后台使用富文本编辑器的时候注意！)
						//propVals[i] = XSSFilterUtil.protectAgainstXSS(propVals[i]);
						// System.out.println(propVals[i]);
					}
				}
				
				String[] props = propName.split("\\.");
				if (props.length == 2) {
					obj.setPropertyValue(props[1], propVals);
				} else if (props.length == 3) {
					Object tmpObj = obj.getPropertyValue(props[1]);
					if (tmpObj == null) {
						obj.setPropertyValue(props[1], obj.getPropertyType(props[1]).newInstance());
					}
					obj.setPropertyValue(props[1] + "." + props[2], propVals);
				}

			}
			return object;
		}
		
		RequestJson reqJson = param.getParameterAnnotation(RequestJson.class);
		if(reqJson != null){
			Object object = getRequestJsonValue(param, request);
			WebDataBinder binder =  binderFactory.createBinder(request,object,reqJson.value());
			if(binder.getTarget() != null){
				validateIfApplicable(binder, param);
				if (binder.getBindingResult().hasErrors()) {
					if (isBindExceptionRequired(binder, param)) {
						throw new BindException(binder.getBindingResult());
					}
				}
			}else{
				if(reqJson.required()){
					return WebArgumentResolver.UNRESOLVED;
				}
			}
			
			Map<String, Object> bindingResultModel = binder.getBindingResult().getModel();
			mavContainer.removeAttributes(bindingResultModel);
			mavContainer.addAllAttributes(bindingResultModel);
			return binder.getTarget();
		}
		
		return WebArgumentResolver.UNRESOLVED;
	}

	protected Object getRequestJsonValue(MethodParameter param, NativeWebRequest request) {
		RequestJson reqJson = param.getParameterAnnotation(RequestJson.class);
		Object object = null;
		String _param = reqJson.value();
		if (_param.equals("_def_param_name")) {
			_param = param.getParameterName();
		}
		Class<?> clazz = param.getParameterType();
		Iterator<String> itor = request.getParameterNames();
		while (itor.hasNext()) {
			String webParam = itor.next();
			String[] webValue = request.getParameterValues(webParam);
			if (webValue != null 
					&& webValue.length == 1
					&& webParam.equals(_param)) {
				if (List.class.isAssignableFrom(clazz)) {
					object = JSONUtil.json2List(webValue[0], reqJson.genericTypes()[0]);
				}else if(Map.class.isAssignableFrom(clazz)){
					object = JSONUtil.json2Map(webValue[0]);
				}else{
					object = JSONUtil.json2Object(webValue[0], clazz);
				}
				break;
			}
		}
		return object;
	}

	protected void validateIfApplicable(WebDataBinder binder, MethodParameter parameter) {
		Annotation[] annotations = parameter.getParameterAnnotations();
		for (Annotation annot : annotations) {
			if (annot.annotationType().getSimpleName().startsWith("Valid")) {
				Object hints = AnnotationUtils.getValue(annot);
				binder.validate(hints instanceof Object[] ? (Object[]) hints : new Object[] {hints});
				break;
			}
		}
	}
	
	protected boolean isBindExceptionRequired(WebDataBinder binder, MethodParameter parameter) {
		int i = parameter.getParameterIndex();
		Class<?>[] paramTypes = parameter.getMethod().getParameterTypes();
		boolean hasBindingResult = (paramTypes.length > (i + 1) && Errors.class.isAssignableFrom(paramTypes[i + 1]));

		return !hasBindingResult;
	}
}