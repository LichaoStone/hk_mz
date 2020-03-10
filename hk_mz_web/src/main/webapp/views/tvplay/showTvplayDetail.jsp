<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>广告管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript">
		var copyBeginTime = "${bean.copyBeginTime}";
		var copyEndTime = "${bean.copyEndTime}";
		var showTime = "${bean.showTime}";
	</script>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript" src="${basePath}/page/Tvplay/showTvplayDetail.js"></script>
	<!--<link href="${basePath}/page/Tvplay/css/showTvplayDetail.css" rel="stylesheet"> -->
	<style>
	</style>
	
</head>
<body>
	<div class="container-fluid containe-update">
		<form id="form" role="form" method="post" class="form-horizontal" enctype="multipart/form-data">
			<input type="hidden" id="TvplayId" name="TvplayId" value="${bean.tvplayId}" />
		
			<!-- 电影名称 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					剧名:
				</label>
				<span class="display_content_height">${bean.tvplayName}</span>
			</div>
			<!-- 版权时间 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					版权时间:
				</label>
				<span class="display_content_height" id="copyrightTime"></span>
			</div>
			<!-- 首播时间 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					首播时间:
				</label>
				<span class="display_content_height" id="premiereTime"></span>
			</div>
			<!-- 集数 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					集数:
				</label>
				<span class="display_content_height">${bean.tvplayNum}</span>
			</div>
			<!-- 标签 -->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					标签:
				</label>
				<span class="display_content_height">${bean.tvplayTag}</span>
			</div>
			<!-- 导演-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					导演 :
				</label>
				<span class="display_content_height">${bean.director}</span>
			</div>
			<!-- 主演-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					主演 :
				</label>
				<span class="display_content_height">${bean.mainActor}</span>
			</div>
			<!-- 语言-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					语言 :
				</label>
				 <span class="display_content_height">${bean.language}</span>
			</div>
			<!-- 国家-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					国家 :
				</label>
				<span class="display_content_height">${bean.national}</span>
			</div>
			<!-- 简介-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					简介 :
				</label>
				<span class="display_content_height">${bean.subdiscription}</span>
			</div>
			<!-- 剧照-->
			<div class="form-group detail_line-div">
				<label for="shopName" class="input_title_label">
					剧照 :
				</label>
				<c:forEach items="${bean.listStill}" var="still" varStatus="vs">  
					<img src="http://img5.iqilu.com/c/u/2018/1115/1542249302397.jpg" class="mutiple_photo_img"></img>
				</c:forEach>
			</div>
		</form>
	</div>
</body>
</html>
