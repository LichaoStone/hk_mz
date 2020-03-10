package com.mz.service.tag;

import java.util.List;

import com.mz.bean.movie.Movie;
import com.mz.bean.movie.query.MovieVoQuery;
import com.mz.bean.movie.vo.MovieVo;
import com.mz.bean.still.Still;
import com.mz.bean.tag.query.TagVoQuery;
import com.mz.bean.tag.vo.TagVo;
import com.mz.util.bean.PageVo;
import com.mz.util.bean.ServiceResult;

public interface TagServiceApi {
	
	//获取电影列表
	ServiceResult<PageVo<TagVo>> getTagPage(TagVoQuery query) throws Exception;

	ServiceResult<List<TagVo>> fetchTagList(String tagType);
	
	//获取电影列表不分页
	ServiceResult<List<TagVo>> getTagLetterListByQuery(TagVoQuery query) throws Exception;

}
