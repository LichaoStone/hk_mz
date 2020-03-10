/**
 * 
 */
package com.mz.util.sql;


/**
 * 测试数据
 * @author lichao
 *
 */
public class TestData {
	public static void main(String[] args) {
		//insetUser(); //澧炲姞鐢ㄦ埛
	    insertVideoSource();
		//insertVideo();
		//insertClassify();
		//insertTag();
		//insertTranscodingLogs();
	}
	
	public static void  insetUser(){
		StringBuffer sql=new StringBuffer();
		 sql.append("insert into t_user (login_name,user_name,password,platform_id,role_id,status,create_time,sex,mobile,email) values ") ;
		 sql.append(" ( ")
		 .append("'").append("lichao").append("'")
		 .append(",'").append("鏍楄秴").append("'")
		 .append(",'").append("e10adc3949ba59abbe56e057f20f883e").append("'")
		 .append(",'").append(1).append("'")
		 .append(",'").append(1).append("'")
		 .append(",'").append(1).append("'")
		 .append(",'").append(DateUtil.getTimeToSec()).append("'")
		 .append(",'").append("1").append("'")
		 .append(",'").append("18615406262").append("'")
		 .append(",'").append("598475619@qq.com").append("'")
		 .append(" );");
		 
		 
		 try {
				Integer count=SqlSession.getSqlSession().insert(sql.toString());
				System.out.println(count);
			 } catch (Exception e) {
				System.out.println(e);
		     } 
	}
	
	
	public static void insertVideoSource(){
			StringBuffer sql=new StringBuffer();
		    sql.append("insert into t_video_source ( video_source_name,classify_id,user_id,video_url,create_time,resolution,video_bit_rate,file_size,status,is_clean,delete_time )");
			sql.append(" values ");
			sql.append(" (")
			.append("'").append("视频2").append("'")
			.append(",'").append(1).append("'")
			.append(",'").append(4).append("'")
			.append(",'").append("http://www.baidu.com").append("'")
			.append(",'").append("2019-02-03 19:00:00").append("'")
			.append(",'").append("720*720").append("'")
			.append(",'").append("201554").append("'")
			.append(",'").append("1659").append("'")
			.append(",'").append(1).append("'")
			.append(",'").append(1).append("'")
			.append(",'").append("2019-03-04 12:00:00").append("'").append(" );");
			
			try {
				SqlSession.getSqlSession().insert(sql.toString());
			}catch (Exception e) {
				System.out.println(e);
			}
	}
	
	
	
	public static void insertVideo(){
		StringBuffer sql=new StringBuffer();
	    sql.append("insert into t_video (video_name,classify_id,img_url,video_tag,user_id,standard,is_share,platform_id,create_time,video_long,video_url_480,video_url_720,video_url_1080 )");
		sql.append(" values ");
		sql.append(" (")
		.append("'").append("成品视频1").append("'")
		.append(",'").append(1).append("'")
		.append(",'").append("http://image.qk.cn").append("'")
		.append(",'").append("武侠").append("'")
		.append(",'").append(4).append("'")
		.append(",'").append("标清/高清/蓝光").append("'")
		.append(",'").append(1).append("'")
		.append(",'").append(1).append("'")
		.append(",'").append("2019-02-13 14:09:00").append("'")
		.append(",'").append("11333").append("'")
		.append(",'").append("http://video.qingk.cn/video_url_480").append("'")
		.append(",'").append("http://video.qingk.cn/video_url_720").append("'")
		.append(",'").append("http://video.qingk.cn/video_url_1080").append("'").append(" );");
		
		try {
			SqlSession.getSqlSession().insert(sql.toString());
		}catch (Exception e) {
			System.out.println(e);
		}
	}	
	
	
	public static void insertClassify(){
		StringBuffer sql=new StringBuffer();
	    sql.append("insert into t_classify (classify_name,status,create_time)");
		sql.append(" values ");
		sql.append(" (")
		.append("'").append("分类3").append("'")
		.append(",'").append(1).append("'")
		.append(",'").append("2019-02-14 15:47:00").append("'").append(" );");
		
		try {
			SqlSession.getSqlSession().insert(sql.toString());
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
	
	
	public static void insertTag(){
		//String[] str={"爱情","武侠","动作","本地","综艺","港台剧","电视剧","电影"};
		//String[] str={"爱情2","爱情3","爱情4","爱情5","爱情6","爱情7","爱情8","爱情9"};
		String[] str={"超长的标签内容测试使用"};
		for(int i=0;i<str.length;i++){
			StringBuffer sql=new StringBuffer();
		    sql.append("insert into t_tag (tag_name,status,create_time,tag_type)");
			sql.append(" values ");
			sql.append(" (")
			.append("'").append(str[i]).append("'")
			.append(",'").append(1).append("'")
			.append(",'").append("2019-02-14 15:47:00").append("'")
			.append(",'").append("video").append("'")
			.append(" );");
			
			try {
				SqlSession.getSqlSession().insert(sql.toString());
			}catch (Exception e) {
				System.out.println(e);
			}
		}
	}
	
	public static void insertTranscodingLogs(){
		StringBuffer sql=new StringBuffer();
	    sql.append("insert into t_transcode (video_source_id,video_transcode_id,standard_id,video_url,img_url,create_time,user_id,status,reason,video_name,file_size,video_long,classify_name)");
		sql.append(" values ");
		sql.append(" (")
		.append("'").append("1").append("'")
		.append(",'").append(1).append("'")
		.append(",'").append("1").append("'")
		.append(",'").append("http://open.iqiyi.com/developer/player_js/coopPlayerIndex.html").append("'")
		.append(",'").append("http://image.qingk.cn/image/k/e716c5e4961a4441938e85734188d28b.jpeg").append("'")
		.append(",'").append("2019-03-04 13:00:00").append("'")
		.append(",'").append("4").append("'")
		.append(",'").append("1").append("'")
		.append(",'").append("成功").append("'")
		.append(",'").append("转码测试视频1").append("'")
		.append(",'").append("200").append("'")
		.append(",'").append("200").append("'")
		.append(",'").append("分类1").append("'")
		.append(" );");
		
		try {
			SqlSession.getSqlSession().insert(sql.toString());
		}catch (Exception e) {
			System.out.println(e);
		}
	}
	
}

