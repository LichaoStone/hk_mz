<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>选择分类</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/videosource_classify_list.js"></script>
		<script type="text/javascript" src="${basePath}/views/video/js/common.js"></script>
		<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
		<style type="text/css">
			.video-note{
				color: #525252;
			    width: 100%;
			    height: 60px;
			    font-size: 16px;
			    font-family: PingFangSC-Regular;
			    font-weight: 400;
			    line-height: 30px;
			    text-align:center;
			}
			
			.select2-container{
				box-sizing: border-box;
			    display: inline-block;
			    margin: 0;
			    position: relative;
			    vertical-align: middle;
			    width: 90% !important;
			}
		</style>
	</head>
<body>
	<div style="position:relative;">
	    <!-- 说明 -->
		<div class="video-note">
			<span>
				上传视频文件格式要求如下:<br />
				视频文件avi、mov、rmvb、rm、FLV、mp4、3GP、小于1G
			</span>
		</div>
		
		<!-- 分类下拉菜单 -->
		<div style="margin-top:50px;text-align:center;">
			<select id="getClassify"  name="getClassify" class="search-select">
			</select>
			
			
			
			<br />
			<!-- 按钮 -->
			<div style="margin-top:20px;display: inline-block;">
				    <div style="float:left;width:80px;height:40px;">
						<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="toUpload()">
							<span class="search-btn-span-reset " id="search-btn1">上传</span>
						</a>
					</div>
					
					<div style="float:left;width:80px;height:40px;margin-left:20px;">
						<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="cancel()">
							<span class="search-btn-span-serach" id="search-btn1">取消</span>
						</a>
					</div>
			</div>
		</div>
		
		
	</div>
</body>
</html>