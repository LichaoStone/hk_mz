<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>广告管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript">
		var htmlUrl = '${bean.htmlUrl}'
	</script>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript" src="${basePath}/page/news/detail.js"></script>
</head>
<body>
<div class="container-fluid containe-update">
		<form id="form" method="post" class="form-horizontal">
			<!-- 资讯名称 -->
			<div class="form-group detail_line-div">
				<label  class="input_title_label">
					资讯名称:
				</label>
				<span class="display_content_height">${bean.newsTitle}</span>
			</div>
			<!-- 分类名称-->
			<div class="form-group detail_line-div">
				<label  class="input_title_label">
					分类名称:
				</label>
				<span class="display_content_height">${bean.classifyName}</span>
			</div>
			<!-- 资讯来源 -->
			<div class="form-group detail_line-div">
				<label  class="input_title_label">
					资讯来源:
				</label>
				<span class="display_content_height">${bean.platformName}</span>
			</div>
			<!-- 关键字 -->
			<div class="form-group detail_line-div">
				<label class="input_title_label">
					关键字:
				</label>
				<span class="display_content_height">${bean.keyWords}</span>
			</div>
			<!-- 资讯内容 -->
			<div class="form-group detail_line-div">
				<label for="htmlUrl" class="input_title_label">
					资讯内容:
				</label>
				<span class="display_content_height" id="htmlUrl"></span>
			</div>
		</form>
	</div>
</body>
</html>