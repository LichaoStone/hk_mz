package com.mz.util.bean;

public class Constants {

	/*********************数据类型 开始**********************/
	
	
	/**
	 * 用户状态
	 * @author mayi
	 *
	 */
	public static class USER {
		/**
		 * 用户状态 禁用
		 */
		public static final byte STATUS_FORBIDDEN = 0 ;
		
		/**
		 * 用户状态 启用
		 */
		public static final byte STATUS_ENABLE = 1 ;
		/**
		 * 用户有推流权限
		 */
		public static final byte IS_PUSH_YES = 1 ;
		/**
		 * 用户没有推流权限
		 */
		public static final byte IS_PUSH_NO = 0 ;
		/**
		 * 推流权限key
		 */
		public static final int PUSH_PERMISSION_KEY = 0 ;
		/**
		 * 权限类型 菜单
		 */
		public static final String PERMISSION_TYPE_MENU = "menu" ;
		/**
		 * 权限类型 操作
		 */
		public static final String PERMISSION_TYPE_OPERATION = "operation" ;
	}
	/*********************数据类型 结束**********************/
	
	
	/**
	 * 活动状态
	 * @author mayi
	 *
	 */
	public static class ACTIVITY {
		/**
		 * 推流状态 已推流
		 */
		public static final byte PUSH_STATUS_YES = 1 ;
		/**
		 * 推流url
		 */
		public static final String PUSH_URL = "play_%1$s_%2$s" ;
		
	}
	/**
	 * 
	 * @ClassName:  News   
	 * @Description:资讯状态   
	 * @author: banbu 
	 * @date:   2019年3月5日 下午1:56:26   
	 *     
	 * @Copyright: 2019 www.haikan.com Inc. All rights reserved. 
	 * 注意：本内容仅限于山东海看网络科技有限公司内部传阅，禁止外泄以及用于其他的商业目
	 */
	public static class News {
		/**
		 * 资讯状态 禁用
		 */
		public static final int STATUS_FORBIDDEN = 0;
		/**
		 * 资讯状态 启用
		 */
		public static final int STATUS_ENABLE = 1 ;
	}
}
