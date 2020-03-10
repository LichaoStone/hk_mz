<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>查看</title>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript" src="${basePath}/views/video/js/video_view.js"></script>
	<style type="text/css">

		.btn-standard{
			width: 60px;
			height: 30px;
			margin-right: 10px;
			border: 1px solid #5868DD;
			border-radius:2px;
			font-size:14px;
			font-family:PingFangSC-Regular;
			padding-left: 16px;
		    padding-right: 16px;
		    padding-top: 5px;
		    padding-bottom: 5px;
		    color:#5868DD;
		}
		
		.btn-standard-checked{
			width: 60px;
			height: 30px;
			margin-right: 10px;
			border: 1px solid #5868DD;
			border-radius:2px;
			font-size:14px;
			font-family:PingFangSC-Regular;
			padding-left: 16px;
		    padding-right: 16px;
		    padding-top: 5px;
		    padding-bottom: 5px;
		    background-color: #5868DD;
		    color:#FFFFFF;
		}
		.display_row{
		    margin-bottom: 21px;
    		display: inline-block;
   			width: 100%;
		}
		.header-text{
			width:42px;
			height:25px;
			font-size:20px;
			font-family:PingFangSC-Medium;
			font-weight:500;
			color:#000000;
			letter-spacing:1px;
			opacity: 0.85;
		}
	</style>
</head>
<body>
    <div >
		<form id="form" method="post" class="form-horizontal" enctype="multipart/form-data" action="">
			<div class="form-group display_row">
				<span class="display_label"><span style="color:red;">*</span>成品名称:</span>
				<span class="display_content">${bean.videoName}</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">素材名称:</span>
				<span class="display_content">
					${bean.videoName}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">标准:</span>
				<span class="display_content">
					${bean.standard}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">分类:</span>
				<span class="display_content">
					${bean.classifyName}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label"><span style="color:red;">*</span>缩略图:</span>
				<div class="input_msg text-alignment" style="left:15px;">
					&nbsp;
				</div>
			</div>

			<div class="form-group display_row">
				<div style="position:relative;left:120px;width:40%;margin-top:-40px;">
					<img src="<%=basePath%>/${bean.imgUrl}" style="width:320px;height:180px;"/>
				</div>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">标签:</span>
				<span class="display_content">
					${bean.videoTag}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">描述:</span>
				<span class="display_content">
					${bean.description}
				</span>
			</div>
			
			<!-- 视频 -->
			<div class="form-group display_row">
				<span class="display_label">预览:</span>
				<span class="display_content">
				    <div id="video_show_div">
					    <div id="video480" class="video_show">
							<img src="${bean.videoUrl480}" style="width:320px;height:180px;" />				    
					    </div>
						
						<div id="video720" style="display:none;" class="video_show">
							<img src="${bean.videoUrl720}" style="width:320px;height:180px;" />
						</div>
						
						<div id="video1080" style="display:none;" class="video_show">
							<img src="${bean.videoUrl1080}" style="width:320px;height:180px;" style="display:none;"/>
						</div>
						
						<div id="btn-standard-div" style="margin-top:20px;">
						    <a href="javascript:void(0)" onclick="toggleStandardClass('video480')" >
						    	<span id="video480_span"  class="btn-standard-checked" >标清</span>	
						    </a>
							
							<a href="javascript:void(0)" onclick="toggleStandardClass('video720')" >
								<span id="video720_span"  class="btn-standard" onclick="toggleStandardClass(this)" >高清</span>
							</a>
							
							<a href="javascript:void(0)" onclick="toggleStandardClass('video1080')" >
								<span id="video1080_span"  class="btn-standard" onclick="toggleStandardClass(this)" >蓝光</span>
							</a>	
						</div>
					</div>
				</span>
			</div>
		</form>
	</div>
</body>
</html>
