package com.mz.service.video;

import java.util.List;

import com.mz.bean.video.SelectBean;

public interface SelectService {
	List<?> getClassifySelect();
	List<?> getTagsSelect(SelectBean bean);
	List<?> getUserSelect();
}
