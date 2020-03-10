/**
 * 
 */
package com.mz.service.video.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mz.bean.classify.vo.ClassifyVo;
import com.mz.bean.video.VideoSourceBean;
import com.mz.mapper.classify.ClassifyMapper;
import com.mz.mapper.video.VideoSourceSqlMapper;
import com.mz.service.video.VideoSourceService;

/**
 *@作者 lichao
 *@时间 2019-2019年1月30日 上午9:41:42
 *@说明 
 */
@Service
public class VideoSourceServiceImpl implements VideoSourceService{
	@Resource
	VideoSourceSqlMapper videoSourceSqlMapper;
	
	@Resource
	ClassifyMapper classifyMapper;
	
	@Override
	@Transactional
	public List<?> getVideoSourceList(VideoSourceBean bean) {
		List<VideoSourceBean> resultList=(List<VideoSourceBean>) videoSourceSqlMapper.getVideoSourceList(bean);
		return resultList;
	}

	@Override
	public List<?> getTranscodingList(VideoSourceBean bean) {
		List<?> resultList=videoSourceSqlMapper.getTranscodingList(bean);
		return resultList;
	}

	@Override
	public List<?> getDustbinList(VideoSourceBean bean) {
		List<?> resultList=videoSourceSqlMapper.getDustbinList(bean);
		return resultList;
	}

	@Override
	public VideoSourceBean getDataView(VideoSourceBean bean) {
		VideoSourceBean resultBean=videoSourceSqlMapper.getDataView(bean);
		return resultBean;
	}

	@Override
	public Integer clearBox(VideoSourceBean bean) {
		return videoSourceSqlMapper.clearBox(bean);
	}

	@Override
	public Integer modifyStatus(VideoSourceBean bean) {
		return videoSourceSqlMapper.modifyStatus(bean);
	}

	@Override
	public ClassifyVo getClassifyNameById(ClassifyVo bean) {
		return classifyMapper.getClassifyVoById(String.valueOf(bean.getClassifyId()));
	}
}

