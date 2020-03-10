package com.mz.service.video.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.mz.bean.video.SelectBean;
import com.mz.mapper.video.SelectSqlMapper;
import com.mz.service.video.SelectService;

@Service
public class SelectServiceImpl implements SelectService{
	@Resource
	SelectSqlMapper selectSqlMapper;
	
	@Override
	public List<?> getClassifySelect() {
		return selectSqlMapper.getClassifySelect();
	}

	@Override
	public List<?> getTagsSelect(SelectBean bean) {
		return selectSqlMapper.getTagsSelect(bean);
	}

	@Override
	public List<?> getUserSelect() {
		return selectSqlMapper.getUserSelect();
	}
}
