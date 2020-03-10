package com.mz.frame;

import java.util.HashMap;
import java.util.Map;

/**
 * 常量接口
 * @作者 栗超
 * @时间 2018年5月12日 上午10:18:36
 * @说明
 */
public abstract class Constants {
	/**
	 * 系统状态码
	 * @作者 栗超
	 * @时间 2018年5月12日 上午10:34:42
	 * @说明
	 */
    public static  class CODE{
    	/**成功**/
    	public static final Integer  SUCCESS=200;
    	/**失败**/
    	public static final Integer  FAIL=500;
    }
    
    
    /**
     * 业务逻辑码
     * @作者 栗超
     * @时间 2018年5月12日 上午10:34:55
     * @说明
     */
    public static class RET{
    	/**成功**/
    	public static final Integer  SUCCESS=200;
    	/**失败**/
    	public static final Integer  FAIL=500;
    	/**请求非法**/
    	public static final Integer  ILLEGAL=201;
    	/**请求过期失效**/
    	public static final Integer  LOSE_EFFICACY=202;
    	/**缺少参数:_timestamp或_sign**/
    	public static final Integer  MISSING_PARAMETER=203;
    	/**大屏模块名称不正确**/
    	public static final Integer  MODULE_ERROR=204;
    	/**请求ACTION行为不存在:simple,detail,localVideoCall和notice**/
    	public static final Integer  ACTION_ERROR=205;
    	/**视频通话已经被锁定**/
    	public static final Integer  VIDEO_CALL_LOCK=206;
    	/**发送消息到大屏失败**/
    	public static final Integer  SEND_MESSAGE_ERROR=207;
    	/**不允许自动更新数据**/
    	public static final Integer  NOT_ALLOW_AUTO_REFRESH_SCREEN=208;
    	/**占线...**/
    	public static final Integer  CALL_BUSSY=3001;
    	/**视频通话时长不够**/
    	public static final Integer  NO_MORE_CALLTIME=3002;
    	
    }
    
    /**
     * 访问权限验证是否开启	
     * @作者 栗超
     * @时间 2019年1月18日 上午11:12:51
     * @说明
     */
	public  static  class ACCESS_PERMISSIONS{
		/**开启**/
		public static final String  ON="ON";
		/**关闭**/
		public static final String  OFF="OFF";
	}
        
    public static final Map<Integer,Object> CODE_INFO = new HashMap<Integer,Object>();
    public static final Map<Integer,Object> RET_INFO = new HashMap<Integer,Object>();
    
    static{
    	//系统状态码信息
    	CODE_INFO.put(CODE.SUCCESS,"成功");
    	CODE_INFO.put(CODE.FAIL,"失败");
    	
    	//业务逻辑状态码信息
    	RET_INFO.put(RET.SUCCESS,"成功");
    	RET_INFO.put(RET.FAIL,"失败");
    	RET_INFO.put(RET.ILLEGAL,"请求不合法");
    	RET_INFO.put(RET.LOSE_EFFICACY,"请求过期失效");
    	RET_INFO.put(RET.MISSING_PARAMETER,"缺少参数");
    	RET_INFO.put(RET.MODULE_ERROR,"模块名称错误");
    	RET_INFO.put(RET.VIDEO_CALL_LOCK,"视频通话已经被锁定");
    	RET_INFO.put(RET.SEND_MESSAGE_ERROR,"发送消息到大屏失败,请确定大屏是否正常打开");
    	RET_INFO.put(RET.CALL_BUSSY,"正在占线...");
    	RET_INFO.put(RET.NO_MORE_CALLTIME,"剩余通话时长不足");
    	RET_INFO.put(RET.NOT_ALLOW_AUTO_REFRESH_SCREEN,"大屏已停止自动更新");
    	RET_INFO.put(RET.ACTION_ERROR,"请求ACTION行为不存在");
    }
}
