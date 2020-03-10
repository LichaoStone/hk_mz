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
	</script>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript" src="${basePath}/page/tvplayEpisode/showSaveTvplayEpisode.js"></script>
	<link href="${basePath}/page/movie/css/showSaveMovie.css" rel="stylesheet">
	<style>
	</style>
	
</head>
<body>
	<div class="container-fluid containe-update">
		<form id="form" role="form" method="post" class="form-horizontal" enctype="multipart/form-data">
			<input type="hidden" id="tvplayEpisodeId" name="tvplayEpisodeId" value="${bean.tvplayEpisodeId}" />
			<input type="hidden" id="tvplayId" name="tvplayId" value="${bean.tvplayId}" />
			<!-- 剧名 -->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					剧名:
				</label>
				<span class="display_content_height">${bean.episodeName}</span>
			</div>
			<!-- 当前集数-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>当前集数 :
				</label>
				 <input type="text" name="episodeNum" id="episodeNum" class="form-control input_property_text" value="${bean.episodeNum}" />
			</div>
			<!-- 子集名称-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>子集名称 :
				</label>
				 <input type="text" name="episodeName" id="episodeName" class="form-control input_property_text" value="${bean.episodeName}" />
			</div>
			<!-- 子集简介-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					子集简介 :
				</label>
				<textarea id="subdescription" name="subdescription"  class="description_textarea"  placeholder="请输入评论内容" class="" rows="5">${bean.subdescription}</textarea>
			</div>
			<div class="form-group button_group line-div">
			    <label for="description" class="input_label"></label>
				<button class="btn submit-btn" onfocus="this.blur();" id="submit-button" type="submit" >保存</button>
				<button class="btn cancel-btn" onfocus="this.blur();" type="reset"  onclick="cancelData()">重置</button>
			</div>
		</form>
	</div>
</body>
</html>
