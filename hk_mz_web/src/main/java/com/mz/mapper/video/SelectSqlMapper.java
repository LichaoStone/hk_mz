package com.mz.mapper.video;

import java.util.List;


import com.mz.bean.video.SelectBean;

public interface SelectSqlMapper {
	List<?> getClassifySelect();
	List<?> getTagsSelect(SelectBean bean);
	List<?> getUserSelect();
}
