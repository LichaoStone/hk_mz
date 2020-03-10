<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>广告管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link href="${basePath}/page/tvplayEpisode/css/showtvplayEpisodeDetail.css" rel="stylesheet">
	<script type="text/javascript">
	</script>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript" src="${basePath}/page/tvplayEpisode/showtvplayEpisodeDetail.js"></script>
	<style>
	</style>
</head>
<body>
	<div class="container-fluid containe-update">
		<form id="form" role="form" method="post" class="form-horizontal" enctype="multipart/form-data">
			<input type="hidden" id="videoUrl480" name="videoUrl480" value="${bean.videoUrl480}" />
			<input type="hidden" id="videoUrl720" name="videoUrl720" value="${bean.videoUrl720}" />
			<input type="hidden" id="videoUrl1080" name="videoUrl1080" value="${bean.videoUrl1080}" />
			<!-- 剧名 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					剧名:
				</label>
				<span class="display_content_height">${bean.tvplayName}</span>
			</div>
			<!-- 当前集数 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					当前集数:
				</label>
				<span class="display_content_height">${bean.episodeNum}</span>
			</div>
			<!-- 子集名称 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					子集名称:
				</label>
				<span class="display_content_height" id="episodeName">${bean.episodeName}</span>
			</div>
			<!-- 子集简介-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					简介 :
				</label>
				<span class="display_content_height">${bean.subdescription}</span>
			</div>
			<!-- 预览-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					预览 :
				</label>
				<video id="video"controls="controls" autoplay="autoplay" style="padding-left:10px;width:368px;height:207px;" >
					  <source src="http://vjs.zencdn.net/v/oceans.mp4" type="video/mp4" />
				</video>
				<div id="btn-video-div" style="padding-left:100px;margin-top:10px;">
					<span class="select_font_oper" onclick="changeVideoQuality(this,'480')" >标清</span>
					<span class="unselected_font_opr" style="margin-left:10px;" onclick="changeVideoQuality(this,'720')" >高清</span>
					<span class="unselected_font_opr" style="margin-left:10px;" onclick="changeVideoQuality(this,'1080')" >蓝光</span>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
