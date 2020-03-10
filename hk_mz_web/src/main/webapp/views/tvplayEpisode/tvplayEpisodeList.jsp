<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/page/tvplayEpisode/tvplayEpisodeList.js"></script>
		<script>
			var tvplayId = "${bean.tvplayId}";
			var tvplayName = "${bean.tvplayName}"
		</script>
		<style>
		</style>
	</head>
	<body style="background-color:#FFFFFF;">
	<form id="form" name="form" method="post"  action="">	
	<input type="hidden" id="tvplayId" name="tvplayId" value="${bean.tvplayId}">
	<!-- 查询栏 -->
	<div class="container-fluid containe-search">
		<div class="row">
			<!-- 收缩的查询栏 -->
			<div class="row-top-div" style="padding-bottom:0px;">
				<span class="search-title-span">
					<lable class="search-title-font">
						子集名称:
					</lable>
				</span>
				<span class="search-input-container" style="vertical-align:top;">
					<input type="text" id="episodeName" name="episodeName" class="search-input" style="border:none;" placeholder = "请输入">
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
				<div style="display:inline-block;">
			    	<label class="col-sm-3 col-form-label search-lable-title">入库状态:</label>
				    <div class="col-sm-9" style="height:40px;">
						<select id="status" name="status" class="search-select" style="width:200px;" >
							<option></option>
							<option value="0">未入库</option>
							<option value="1">入库中</option>
							<option value="2">入库失败</option>
							<option value="3">入库成功</option>
						</select>
				    </div>
		   		</div>
		   		<div style="display:inline-block;">
			    	<label class="col-sm-3 col-form-label search-lable-title" style="width:50px;">时段:</label>
				    <div class="col-sm-9" style="height:40px;width:350px;">
						<div>
				        	<input type="text" id="datePick" class="form-control" placeholder="请选择">
				        	<input type="hidden" id = "startTime" name="startTime" class="form-control" />
           	 				<input type="hidden" id = "endTime" name="endTime" class="form-control" />
			         	</div>
				    </div>
		   		</div>
			</div>
		</div>
	</div>
	<!-- 按钮栏 -->
	<div style="padding:0px 30px 10px 30px;">
		<span class="batch-title-span">
			<lable class="search-title-font">
				批量操作:
			</lable>
		</span>
		<a href="javascript:void(0)" id="search" name="search" class="detail-a" data-toggle="collapse" onfocus="this.blur();" onclick="pushTvplayEpisode();" style="line-height:40px;">
				下发
		</a>
		<span class="pull-right import-tvplayEpisode-btn">
			<!-- <lable class="import-tvplayEpisode-font">
				导入子集
			</lable>
			 -->
			<a href="javascript:void(0)" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="importTvplayEpisode()">
				<span class="search-btn-span-new">导入子集</span>
			</a>
		</span>
	</div>
	<input type="file" form="uploadImageForm" name="imageFile" id="importTvplayEpisodeBtn" multiple="multiple" style="display:none;"/>
	<!-- 内容栏 -->
	<div class="container-fluid container-main">
		<table id="dataTable">
			<thead>
				<tr>
					<th data-width="4%" data-checkbox="true" data-align="center" ></th>
					<th data-field="tvplayName" data-width="100px">剧名</th>
					<th data-field="episodeNum" data-width="50px">集数</th>
					<th data-field="episodeName" data-width="100px" data-formatter="setTitle">子集名称</th>
					<th data-field="episodeLong" data-width="100px">时长</th>
					<th data-field="standard" data-width="100px">标准</th>
					<th data-field="status" data-formatter="formatStatus" data-width="60px">入库状态</th>
					<th data-field="complateTime"  data-width="150px">入库时间</th>
					<th data-width="140px"data-field="tvplayEpisodeId"  data-formatter="setOperate" >操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	<form id="uploadImageForm" action="${basePath}movie/upload_movie" method="post" enctype="multipart/form-data">
	</form>
	</body>
</html>