<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/page/activity/index.js"></script>
		<script type="text/javascript" src="${basePath}/page/jquery.form.min.js"></script>
		<script>
		</script>
		<style>
		</style>
	</head>
	<body style="background-color:#FFFFFF;">
	<form id="form" name="form" method="post"  action="">	
	<!-- 查询栏 
	<div class="container-fluid containe-search">
		<div class="row">
			<div class="row-top-div" style="">
				<span class="search-title-span">
					<lable class="search-title-font">
						电影名称:
					</lable>
				</span>
				<span class="search-input-container">
					<input type="text" id="movieName" name="movieName" class="search-input" style="border:none;" placeholder = "请输入">
					<a href="javascript:void(0)" id="search" name="search" class="search-link_btn" data-toggle="collapse" onfocus="this.blur();" onclick="refreshDataTable()">
						<div class="search_div_btn">	
							<span id="search-btn-collapsed" >
								<img src="<%=basePath %>images/search_circle.png"/>
							</span>
							<span>
								搜索
							</span>
						</div>
					</a> 
				</span>
			</div>
		</div>
	</div>	-->	
	<!-- 内容栏 -->
	<div class="container-fluid container-main">
		<table id="dataTable">
			<thead>
				<tr>
					<th  data-width="20" data-formatter="rowIndex">行号</th>
					<th data-field="title" data-width="20" >活动名称</th>
					<th data-field="activityId" data-width="200">活动ID</th>
					<th data-field="activityTime" data-width="400" data-formatter="convertTime">活动时间</th>
					<th data-field="platformName" data-width="200" >所属平台</th>
					<th data-field="equipment"  data-width="200" data-formatter="convertEquipment">推流设备</th>
					<th data-field="isPlayback" data-width="200" data-formatter="convertIsPlaybackt">录播</th>
					<th  data-width="200"  data-formatter="setOperate" >录播管理</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	</body>
</html>