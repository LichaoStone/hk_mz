/**
 * 
 */
package com.mz.service.video;

import java.util.List;

import com.mz.bean.classify.vo.ClassifyVo;
import com.mz.bean.video.VideoSourceBean;

/**
 *@作者 lichao
 *@时间 2019-2019年1月30日 上午9:40:50
 *@说明 
 */
public interface VideoSourceService {
	List<?> getVideoSourceList(VideoSourceBean bean);
	List<?> getTranscodingList(VideoSourceBean bean);
	List<?> getDustbinList(VideoSourceBean bean);
	VideoSourceBean getDataView(VideoSourceBean bean);
	Integer clearBox(VideoSourceBean bean);
	Integer modifyStatus(VideoSourceBean bean);
	ClassifyVo getClassifyNameById(ClassifyVo bean);
}


