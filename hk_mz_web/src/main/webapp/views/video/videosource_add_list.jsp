<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>视频素材库</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/videosource_add_list.js"></script>
		<script type="text/javascript" src="${basePath}/views/video/js/common.js"></script>
		<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
	</head>
	<style type="text/css">
		.containe-search {
		    min-width: 0px;
		}
	</style>
	<script type="text/javascript">
		var videoCount="${bean.videoCount}";
	</script>
<body>
	<form id="form" name="form" method="post"  action="">	
		<div class="container-fluid containe-search">
			<div style="width:100%;margin-left:-15px;">
				 	 <div style="float:left;line-height:2.5;"><span>已选<span id="selectedVideoCount">0</span>个，最多可选择8个 </span></div>
				 	 <div onclick="resetVal()" style="float:right;width:80px;height:40px;background-color: #5868DD;color:#FFFFFF;border:1px solid #5868DD;text-align:center;line-height:2.5;cursor:pointer;border-radius:4px;"><span>重置</span></div>
				 	 <div onclick="save()" style="float:right;margin-right:20px;width:80px;height:40px;background-color: #FFFFFF;color:#5868DD;border:1px solid #5868DD;text-align:center;line-height:2.5;cursor:pointer;border-radius:4px;"><span>保存</span></div>
			</div>
		</div>
		
		<!-- 内容栏 -->
		<div class="container-fluid container-main">
			<table id="dataTable">
				<thead>
					<tr>
					    <th data-width="4%" data-checkbox="true" data-align="center" data-formatter="setCheckBox"></th>
						<th data-field="videoSourceName" data-width="100px" >视频名称</th>
						<th data-field="fileSize" data-width="100px">大小</th>
						<th data-field="resolution"  data-width="150px">分辨率</th>
						<th data-field="videoBitRate" data-width="100px" >码率</th>
						<th data-field="classifyId" data-width="60px">分类名称</th>
						<th data-field="userId" data-width="60px">上传者</th>
						<th data-field="createTime" data-width="60px">更新时间</th>
					</tr>
				</thead>
			</table>
		</div>
	</form>
</body>
</html>