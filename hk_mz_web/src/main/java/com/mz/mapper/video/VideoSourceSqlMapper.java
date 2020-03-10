package com.mz.mapper.video;
import java.util.List;


import com.mz.bean.video.VideoSourceBean;
public interface VideoSourceSqlMapper{
	List<?> getVideoSourceList(VideoSourceBean bean);
	List<?> getTranscodingList(VideoSourceBean bean);
	List<?> getDustbinList(VideoSourceBean bean);
	VideoSourceBean getDataView(VideoSourceBean bean);
	Integer clearBox(VideoSourceBean bean);
	Integer modifyStatus(VideoSourceBean bean);
}