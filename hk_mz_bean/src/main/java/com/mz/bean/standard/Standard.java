package com.mz.bean.standard;

import java.io.Serializable;
/**
 *转码标准表
 */
public class Standard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1554778966738418309L;
	//转码标准id
	private Integer standardId;  
	//标准名称：标清、高清等
	private String standardName;  
	//分辨率
	private String resolution;  
	//视频编码
	private String videoCoding;  
	//视频码率
	private String videoBitRate;  
	//帧率
	private String frameRate;  
	//采样率
	private String samplingRate;  
	//音频编码
	private String audioCoding;  
	//音频码率
	private String audioBitRate;  
  	
	public Integer getStandardId(){  
		return standardId;  
	}  
	public void setStandardId(Integer standardId){  
		this.standardId = standardId;  
	}  
	public String getStandardName(){  
		return standardName;  
	}  
	public void setStandardName(String standardName){  
		this.standardName = standardName;  
	}  
	public String getResolution(){  
		return resolution;  
	}  
	public void setResolution(String resolution){  
		this.resolution = resolution;  
	}  
	public String getVideoCoding(){  
		return videoCoding;  
	}  
	public void setVideoCoding(String videoCoding){  
		this.videoCoding = videoCoding;  
	}  
	public String getVideoBitRate(){  
		return videoBitRate;  
	}  
	public void setVideoBitRate(String videoBitRate){  
		this.videoBitRate = videoBitRate;  
	}  
	public String getFrameRate(){  
		return frameRate;  
	}  
	public void setFrameRate(String frameRate){  
		this.frameRate = frameRate;  
	}  
	public String getSamplingRate(){  
		return samplingRate;  
	}  
	public void setSamplingRate(String samplingRate){  
		this.samplingRate = samplingRate;  
	}  
	public String getAudioCoding(){  
		return audioCoding;  
	}  
	public void setAudioCoding(String audioCoding){  
		this.audioCoding = audioCoding;  
	}  
	public String getAudioBitRate(){  
		return audioBitRate;  
	}  
	public void setAudioBitRate(String audioBitRate){  
		this.audioBitRate = audioBitRate;  
	}  
}
