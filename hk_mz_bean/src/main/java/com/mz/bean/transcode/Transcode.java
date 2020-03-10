package com.mz.bean.transcode;

import java.io.Serializable;
import java.util.Date;
/**
 *杞爜璁板綍琛�
 */
public class Transcode implements Serializable {
	private static final long serialVersionUID = -3801811075432754409L;
	//id
	private Integer transcodeId;  
	//瑙嗛绱犳潗id
	private Integer videoSourceId;  
	//瑙嗛鎴愬搧id
	private Integer videoTranscodeId;  
	//杞爜鏍囧噯id
	private Integer standardId;  
	//杞爜鍚庣殑瑙嗛鍦板潃
	private String videoUrl;  
	//瑙嗛鎴浘鍦板潃
	private String imgUrl;  
	//杞爜鏃堕棿
	private Date createTime;  
	//鎿嶄綔鐢ㄦ埛id
	private Integer userId;  
	//杞爜鐘舵��
	private String status;  
	//澶辫触鍘熷洜
	private String reason;  
	//瑙嗛鍚嶇О
	private String videoName;  
	//瑙嗛澶у皬
	private String fileSize;  
	//瑙嗛鏃堕暱
	private String videoLong;  
	//瑙嗛鍒嗙被id
	private String classifyName;  
  	
	/**标准名称**/
	private String standardName;
	
	
	public Integer getTranscodeId(){  
		return transcodeId;  
	}  
	public void setTranscodeId(Integer transcodeId){  
		this.transcodeId = transcodeId;  
	}  
	public Integer getVideoSourceId(){  
		return videoSourceId;  
	}  
	public void setVideoSourceId(Integer videoSourceId){  
		this.videoSourceId = videoSourceId;  
	}  
	public Integer getVideoTranscodeId(){  
		return videoTranscodeId;  
	}  
	public void setVideoTranscodeId(Integer videoTranscodeId){  
		this.videoTranscodeId = videoTranscodeId;  
	}  
	public Integer getStandardId(){  
		return standardId;  
	}  
	public void setStandardId(Integer standardId){  
		this.standardId = standardId;  
	}  
	public String getVideoUrl(){  
		return videoUrl;  
	}  
	public void setVideoUrl(String videoUrl){  
		this.videoUrl = videoUrl;  
	}  
	public String getImgUrl(){  
		return imgUrl;  
	}  
	public void setImgUrl(String imgUrl){  
		this.imgUrl = imgUrl;  
	}  
	public Date getCreateTime(){  
		return createTime;  
	}  
	public void setCreateTime(Date createTime){  
		this.createTime = createTime;  
	}  
	public Integer getUserId(){  
		return userId;  
	}  
	public void setUserId(Integer userId){  
		this.userId = userId;  
	}  
	public String getStatus(){  
		return status;  
	}  
	public void setStatus(String status){  
		this.status = status;  
	}  
	public String getReason(){  
		return reason;  
	}  
	public void setReason(String reason){  
		this.reason = reason;  
	}  
	public String getVideoName(){  
		return videoName;  
	}  
	public void setVideoName(String videoName){  
		this.videoName = videoName;  
	}  
	public String getFileSize(){  
		return fileSize;  
	}  
	public void setFileSize(String fileSize){  
		this.fileSize = fileSize;  
	}  
	public String getVideoLong(){  
		return videoLong;  
	}  
	public void setVideoLong(String videoLong){  
		this.videoLong = videoLong;  
	}  
	public String getClassifyName(){  
		return classifyName;  
	}  
	public void setClassifyName(String classifyName){  
		this.classifyName = classifyName;  
	}
	public String getStandardName() {
		return standardName;
	}
	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}  
}
