<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>查看</title>
	<%@ include file="../common/import.jsp" %>
	<!-- 视频  -->
	<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
	<link href="${basePath}/videojs/video-js.css" rel="stylesheet">
	<script src="${basePath}/videojs/video.js"  type="text/javascript"></script>
	<script src="${basePath}/videojs/videojs-contrib-hls.min.js"  type="text/javascript"></script>
	<script type="text/javascript">
		var player;
		$(document).ready(function() {
			 player = videojs("video-clip",{
				hidden:true, 
					responsive:true,
					autoplay:true,
					controlBar:{
						'currentTimeDisplay': true,
						'remainingTimeDisplay':true,
						'liveDisplay':true,
						'volumePanel':{
							inline: false 		//默认是true,横着的
						}
					}
			});
			
			
			//加载完元数据时显示总时间
			player.on("loadedmetadata", function(){
				//设置总时长
				$("#all_time").text(player.duration());
			    //设置当前播放时间点
			    $("#current_time").text(player.currentTime());
			});
			
			
			//监控视频实时播放时间
			player.on('timeupdate',function(){
				 //设置当前播放时间点
			    $("#current_time").text(player.currentTime());
			});
		});
		
		//开始
		function start(){
			console.log("start... ...");
			$("#video_stop_img").hide();
			$("#video_start_img").show();
			player.play();
		}
		
		//暂停
		function stop(){
		    console.log("stop... ...");
		    $("#video_start_img").hide();
		    $("#video_stop_img").show();
			player.pause();
		}
		
		function download(){
			$("#video_download").click();
		}
	</script>
</head>

<body>
    <div class="container-fluid containe-update">
		<form id="form" method="post" class="form-horizontal" enctype="multipart/form-data" action="">
			<div class="form-group display_row">
				<span class="display_label">成品名称:</span>
				<span class="display_content">${bean.videoSourceName}</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">视频格式:</span>
				<span class="display_content">${bean.videoSourceName}</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">分辨率:</span>
				<span class="display_content">${bean.resolution}</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">码率:</span>
				<span class="display_content">${bean.videoBitRate}</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">大小:</span>
				<span class="display_content">${bean.fileSize}</span>
			</div>
			 
			<div class="form-group display_row">
				<span class="display_label">预览:</span>
				<span class="display_content">
						<video id="video-clip" class="video-js vjs-default-skin" style="object-fit:contain;height: 207px;width:370px;" >
							<source src="http://vjs.zencdn.net/v/oceans.mp4" >
						</video>
						
						<div style="width:370px;height: 35px;line-height:2.2;border:1px solid #E7E7F3;">
								<div style="margin-left: 10px;float:left;">
									<img id="video_start_img" onclick="stop()" style="height:12px;width:12px;margin-top:10px;cursor: pointer;" src="/views/video/img/video_startandstop.png" />
									<img id="video_stop_img" onclick="start()" style="height:12px;width:12px;display:none;margin-top:10px;cursor: pointer;" src="/views/video/img/video_stop.png" />
								</div>
								
								<div style="float:left;margin-left:10px;">
									<span id="current_time" style="color:#000000;opacity: 0.6;">0:00</span>
									<span style="color:#000000;opacity: 0.6;">/</span>
									<span id="all_time" style="color:#000000;opacity: 0.6;">00:00:00</span>
								</div>
								
								<div style="float:right;">
									<img style="height:12px;width:12px;margin-right:16px;cursor: pointer;" src="/views/video/img/video_voice.png" />
									<img onclick="download()" style="height:12px;width:12px;margin-right:20px;cursor: pointer;" src="/views/video/img/video_download.png" />
								</div>
								
								<a id="video_download" href="http://vjs.zencdn.net/v/oceans.mp4" download style="display:none;"></a>
						</div>
				</span>
			</div>
			
		</form>
	</div>
</body>
</html>
