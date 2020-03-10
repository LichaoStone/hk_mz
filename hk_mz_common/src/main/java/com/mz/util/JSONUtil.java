package com.mz.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.annotate.JsonSerialize.Inclusion;
import org.codehaus.jackson.map.introspect.AnnotatedClass;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.map.ser.FilterProvider;
import org.codehaus.jackson.map.ser.impl.SimpleBeanPropertyFilter;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.JavaType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class JSONUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);
	
	private static ObjectMapper objectMapper = null;
	
	static {
		objectMapper = new ObjectMapper();
		//设置转换日期格式
		objectMapper.setDateFormat(new JacksonDateFormat());
		objectMapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	
	public enum Filter {
		include, exclude;
    }
	
	/**
	 * 支持转换 ‘yyyy-MM-dd HH:mm:ss’ 日期格式
	 * @author mayi
	 * getInstance
	 * @return
	 */
	public static ObjectMapper getObjectMapperForDateFormat(){
		return objectMapper;
	}
	
	/**
	 * 用于实体类的toString方法 【json string】
	 * @param object
	 * @return
	 */
	public static String toJsonString(Object object){
		ObjectMapper objectMapper = new ObjectMapper();
		String json = null;
		try {
			json = objectMapper.writeValueAsString(object);
		} catch (Exception e) {
			logger.error("转JSON异常", e);
		}
		return json;
	}

	/**
	 * 
	* @Title: toJsonString
	* @Description: 用于实体类的toString方法
	* @param obj		
	* @param inclusion
	* @param filter			排除 or 需要
	* @param filterFields	过滤的字段
	* @return
	* @author 
	 */
	public static String toJsonString(Object obj, Inclusion inclusion, Filter filter,String... filterFields) {
		if (obj == null || filter == null) {
    		return null;
		}
		ObjectMapper mapper = new ObjectMapper();
        try {
        	SimpleBeanPropertyFilter beanPropertyFilter = null;
        	if ( Filter.exclude == filter ) {
        		beanPropertyFilter = SimpleBeanPropertyFilter.serializeAllExcept(filterFields);
			}else if( Filter.include == filter ) {
				beanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept(filterFields);
			}
            mapper.setSerializationConfig(mapper.getSerializationConfig().withSerializationInclusion(inclusion)); 
            FilterProvider filters = new SimpleFilterProvider().addFilter(obj.getClass().getName(), 
            		beanPropertyFilter);
            mapper.setFilters(filters);
            mapper.setAnnotationIntrospector(new JacksonAnnotationIntrospector(){ 
                @Override 
                public Object findFilterId(AnnotatedClass ac){ 
                    return ac.getName(); 
                } 
            }); 
        } catch (Exception e) { 
            logger.debug("format obj failure.obj=" + obj); 
        }
        String json = null;
        try {
			json = mapper.writeValueAsString(obj);
		} catch (Exception e) {
			logger.error("转JSON异常", e);
		}
        return json; 
    }
	
	
	/**
	 * JSON转Map
	 * @param jsonStr
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static Map<String,Object> json2Map(String jsonStr){
		ObjectMapper objectMapper = new ObjectMapper();
		Map<String,Object> map = null;
		try {
			objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);  
			map = objectMapper.readValue(jsonStr, Map.class);
		} catch (Exception e) {
			logger.error("JSON转Map异常", e);
		}
		return map;
	}
	
	/**
	 * JSON转 指定对象
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	public static <T> T json2Object(String jsonStr,Class<T> valueType){
		ObjectMapper objectMapper = getObjectMapperForDateFormat();
		T  object = null;
		try {
			object = objectMapper.readValue(jsonStr, valueType);
		} catch (Exception e) {
			logger.error("JSON转object异常", e);
		}
		return object;
	}
	
	
	/**
	 * JSON转 指定对象
	 * @param jsonStr
	 * @param valueType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> json2List(String jsonStr,Class<T> valueType){
		ObjectMapper objectMapper = getObjectMapperForDateFormat();
		JavaType javaType = objectMapper.getTypeFactory().constructParametricType(ArrayList.class, valueType); 
		List<T> list = null;
		try {
			list = (List<T>)objectMapper.readValue(jsonStr, javaType); 
		} catch (Exception e) {
			logger.error("JSON转list异常", e);
		}
		return list;
	}
	
}
