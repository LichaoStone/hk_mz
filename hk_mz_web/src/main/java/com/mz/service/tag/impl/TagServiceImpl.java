package com.mz.service.tag.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.mz.bean.tag.Tag;
import com.mz.bean.tag.query.TagVoQuery;
import com.mz.bean.tag.vo.TagVo;
import com.mz.mapper.tag.TagMapper;
import com.mz.service.tag.TagServiceApi;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

@Service
public class TagServiceImpl implements TagServiceApi{
	
	@Resource
	private TagMapper tagMapper ;

	/**
	 * 根据查询条件获取电影列表
	 */
	@Override
	public ServiceResult<PageVo<TagVo>> getTagPage(TagVoQuery query) throws Exception {
		ServiceResult<PageVo<TagVo>> serviceResult = new ServiceResult<PageVo<TagVo>>();
		PageHelper.offsetPage(query.getOffset(), query.getPageSize());
		List<TagVo> list = tagMapper.getTagClassListByQuery(query);
		PageVo<TagVo> pageVo = new PageVo<TagVo>((Page<TagVo>) list);
		serviceResult.setData(pageVo);
		return serviceResult;
	}
	
	@Override
	public ServiceResult<List<TagVo>> fetchTagList(String  tagType) {
		// TODO Auto-generated method stub
		TagVoQuery query = new TagVoQuery();
		query.setTagType(tagType);
		List<TagVo> list = tagMapper.getTagListByQuery(query);
		List<Tag> tagList = new ArrayList<>();
		for(TagVo vo : list) {
			Tag tag = new Tag();
			BeanUtils.copyProperties(vo, tag);
			tagList.add(tag);
		}
		
		ServiceResult<List<TagVo>> serviceResult = new ServiceResult<List<TagVo>>();
		serviceResult.setData(list);
		return serviceResult;
	}
	
	/**
	 * 根据查询条件获取电影列表 不分页
	 */
	@Override
	public ServiceResult<List<TagVo>> getTagLetterListByQuery(TagVoQuery query) throws Exception {
		ServiceResult<List<TagVo>> serviceResult = new ServiceResult<List<TagVo>>();
		List<TagVo> list = tagMapper.getTagLetterListByQuery(query);
		serviceResult.setData(list);
		return serviceResult;
	}
}
