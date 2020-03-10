package com.mz.mapper.video;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mz.bean.video.VideoBack;

@Mapper
public interface VideoBackMapper {

	Integer insertVideoBack(VideoBack vo);
	
	List<VideoBack> getVideoBackListByQuery(VideoBack vo);
}
