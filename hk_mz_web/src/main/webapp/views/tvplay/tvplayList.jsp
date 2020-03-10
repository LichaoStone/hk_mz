<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/page/tvplay/tvplayList.js"></script>
		<script>
		</script>
		<style>
		</style>
	</head>
	<body style="background-color:#FFFFFF;">
	<form id="form" name="form" method="post"  action="">	
	<!-- 查询栏 -->
	<div class="container-fluid containe-search">
		<div class="row">
			<!-- 收缩的查询栏 -->
			<div class="row-top-div" style="">
				<span class="search-title-span" style="width:42px;">
					<lable class="search-title-font" >
						剧名:
					</lable>
				</span>
				<span class="search-input-container">
					<input type="text" id="tvplayName" name="tvplayName" class="search-input" style="border:none;" placeholder = "请输入">
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
				<span class="senior-btn">
					<a href="#" id="search-div-a" class="search-btn collapsed" data-toggle="collapse" onfocus="this.blur();" onclick="expandQueryBox()">
						<div class="senior_div_btn">	
							<span class="text">
								高级检索
							</span>
							<span id="search-btn-collapsed">
								<img id="search-div-img" src="<%=basePath %>images/down_point.png"/>
							</span>
						</div>
						<!-- <span class="text"></span>
						<img class="search-main-img" id="search-div-img"></img> -->
					</a>
				</span>
			</div>
			<!-- 展开的查询栏 -->
			<div id="search-div" class="collapse mutiple-search-div-container">
				<div class="row-div-one">
				<!-- 
					<div class="form-group" style="display:inline-block;">
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
			   	 -->
			   		<div class="form-group" style="display:inline-block;">
				    	<label class="col-sm-3 col-form-label search-lable-title" style="width:50px;">标签:</label>
					    <div class="col-sm-9" style="height:40px;">
							<select id="tvplayTag" name="tvplayTag" class="search-select" style="width:200px;" >
								<!--  <option></option>
								<option value="0">未入库</option>
								<option value="1">入库中</option>
								<option value="2">入库失败</option>
								<option value="3">入库成功</option>
								-->
							</select>
					    </div>
			   		</div>
			   		<div class="form-group" style="display:inline-block;">
				    	<label class="col-sm-3 col-form-label search-lable-title" style="width:50px;">时段:</label>
					    <div class="col-sm-9" style="height:40px;width:350px;">
							<div>
					        	<input type="text" id="datePick" class="date-input-css search-datepicker-img" placeholder="请选择">
					        	<input type="hidden" id = "startTime" name="startTime" class="form-control" />
            	 				<input type="hidden" id = "endTime" name="endTime" class="form-control" />
				         	</div>
					    </div>
			   		</div>
			   		<span class="search-span pull-right">
						<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="refreshDataTable()">
							<span class="search-btn-span-new" id="search-btn1">搜索</span>
						</a>
						<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="resetVal()">
							<span class="search-span-reset-btn" id="search-btn1">重置</span>
						</a>
			        </span>
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
		<a href="javascript:void(0)" id="search" name="search" class="detail-a" data-toggle="collapse" onfocus="this.blur();" onclick="pushTvplay();" style="line-height:40px;">
				下发
		</a>
		<span class="pull-right import-movie-btn" onclick="importTvplay();" >
			<lable class="import-movie-font">
				导入剧头
			</lable>
		</span>
	</div>
	<input type="file" form="uploadImageForm" name="imageFile" id="importTvplayBtn" multiple="multiple" style="display:none;"/>
	<!-- 内容栏 -->
	<div class="container-fluid container-main">
		<table id="dataTable">
			<thead>
				<tr>
					<th data-width="4%" data-checkbox="true" data-align="center" ></th>
					<th data-field="tvplayName" data-width="100px" data-formatter="setTitle">剧名</th>
					<th data-field="tvplayNum" data-width="100px" data-formatter="setTvplayNum" >导入集数/总剧集</th>
					<th data-field="complateNum" data-width="100px">入库集数</th>
					<th data-field="tvplayTag" data-width="100px">标签</th>
					<th data-field="createTime" data-width="150px">导入时间</th>
					<th data-width="140px" data-field="tvplayId"  data-formatter="setOperate" >操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	<form id="uploadImageForm" action="${basePath}movie/upload_movie" method="post" enctype="multipart/form-data">
	</form>
	</body>
</html>