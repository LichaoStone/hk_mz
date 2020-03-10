<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>视频素材库</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/videosource_list.js"></script>
		<script type="text/javascript" src="${basePath}/views/video/js/common.js"></script>
		<style type="text/css">
			.search-select{
				width: 200px;
    			height: 40px;
    			padding-left:10px;
    			border:1px solid #E7E7F3;
			}
			
			.select_img_span{
				width: 12px;
			    margin-left: -30px; 
			    height: 8px;
			    color: #E7E7F3;
			}
			.body{
				font-size:14px;
				font-family:PingFangSC-Regular;
				font-weight:400;
				color:rgba(0,0,0,0.6);
				line-height:14px;
			 }
			 .search-main-text{
				width: 405px;
			    height: 40px;
			    color: #222222;
			    font-weight: normal;
			    padding-left: 10px;
			    background-color: #fff;
			    background-image: none;
			    border: 1px solid #e7e7eb;
			 }
			 .search-main-text:focus{
			 	border:1px solid #E7E7F3;
			 	outline:0;
			 }
			 .search-main-sub-btn-span:hover{
			 	border:1px solid #E7E7F3;
			 	color:#222222;
			 }
			 .bath-btn-span{
			 	 font-weight: 400;
			     color: rgba(0,0,0,0.85);
			     line-height: 32px;
			 }
			 .operate-a{
			 	font-family:"PingFangSC-Medium";
				font-size: 14px;
				color:#5868DD; 
			 }
		</style>
		<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
	</head>
<body>
	<form id="form" name="form" method="post"  action="">	
		<div class="container-fluid containe-search">
			<div class="row">
				<!-- 收缩的查询栏 -->
				<div class="row-top-div">
				    <span style="color:#000000;">素材名称:</span>
					<span class="search-select-input">
							<input type="text" id="searchName" name="searchName" class="search-main-text"  placeholder="请输入" onfocus="this.placeholder=''" onblur="this.placeholder='请输入'"  value="${searchName}">
							<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="refresh()">
								<span class="search-main-btn-span" id="search-btn-collapsed">
									<img style="width:14px;height:14px;" src="../images/bt_search.png"/>
									<span style="vertical-align:middle;">搜索 </span>
								</span>
							</a>
					</span>
					
					<!-- 高级搜索 -->
					<span class="search-main-sub-btn-span">
						<a href="#search-div" id="search-div-a" class="search-btn collapsed" data-toggle="collapse" onfocus="this.blur();" onclick="changeCollapseStatusOld()">
							<span class="text"></span>
							<img id="search-div-img" style="width:12px;height:8px;" src="../images/select_img_arrow_close.png"></img>
						</a>
					</span>
					<div id="arrow" class='search-span-arrow search-span-arrow-right' style="display:none"></div>
					<div id="arrow-border" class='search-span-arrow-border search-span-arrow-border-right' style="display:none"></div>
				</div>
					
				<!-- 展开的查询栏 -->
				<div id="search-div" class="collapse">
					<div class="row-main-div-one">
						 <!-- 分类名称 -->
						 <span class="search-select-title">分类名称:</span>
						 <select id="classicId" name="classicId" class="search-select">
						 </select>
						 
						 <!-- 上传者 -->
						 <span class="search-select-title">上传者:</span>
						 <select id="userId" name="userId" class="search-select">
						 </select>
						 
					 </div>
						    
				    <div class="row-main-div-other">
						 <!-- 发布时间 -->
						 <span  class="search-select-title" >发布时间:</span>
						 <span class="datepicker">
							  <input type="text" id="create_time_Search" name="create_time_Search" class="search-datepicker"  placeholder="请选择" readonly="readonly" >
						 </span>
						 
						 
						<!-- 右侧：查询及充值按钮 -->
						<span class="search-span pull-right">
							<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="refresh()">
								<span class="search-btn-span-serach" id="search-btn1">搜索</span>
							</a>
							<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="resetVal()">
								<span class="search-btn-span-reset " id="search-btn1">重置</span>
							</a>
				        </span>
			        </div>
				</div>
			  </div>	
		  </div>
		   
		   
		   <!-- 操作按钮 -->
		   <span class="search-span pull-right" >
             <a href="javascript:void(0)" id="search" name="search" class="search-btn-blue" onfocus="this.blur();" style="margin-right:20px;" onclick="toClassify()">
				 <span class="search-btn-span-green" style="color:rgba(255,255,255,1);">
					上传
				</span>
			 </a>
				 
             <a href="javascript:void(0)" id="search" name="search" class="search-btn-blue" onfocus="this.blur();" style="margin-right:20px;" onclick="toTranscoding()">
				 <span class="search-btn-span-green" style="color:rgba(255,255,255,1);">
					转码列表
				</span>
			 </a>
			 
			 <a href="javascript:void(0)" id="search" name="search" class="search-btn-green" onfocus="this.blur();" onclick="toDustbin()">
				<span class="search-btn-span-green" style="width:80px;margin-right:10px;margin-bottom:10px;">
					回收站
				</span>
			 </a>
         </span>
		   
		   
		  <!-- 批量操作按钮 --> 
		  <div class="container-fluid container-btn">
		  		<span class="bath-btn-span" style="font-size: 14px;font-family:PingFangSC-Medium;font-weight:500;line-height:50px;">批量操作：</span>
			    <span id="bathDown" style="color:#5868DD;font-size: 14px;cursor: pointer;" onclick="bathTranscoding()" >转码</span>
			   <!--  
				   <div id="bathDown" style="cursor: pointer;float:left;" name="bathDown"  data-toggle="collapse" onfocus="this.blur();" onclick="bathTranscoding()">
				   </div>
			   -->
			    
		  </div>
			
		<!-- 内容栏 -->
		<div class="container-fluid container-main">
			<table id="dataTable" style="border:none;">
				<thead>
					<tr>
					    <th data-width="4%" data-checkbox="true" data-align="center" ></th>
						<th data-field="videoSourceName" data-width="100px" data-formatter="setVideoSourceName">视频名称</th>
						<th data-field="fileSize" data-width="100px">大小</th>
						<th data-field="resolution"  data-width="150px">分辨率</th>
						<th data-field="videoBitRate" data-width="100px" >码率</th>
						<th data-field="classifyName" data-width="60px">分类名称</th>
						<th data-field="userName" data-width="60px">上传者</th>
						<th data-field="createTime" data-width="60px">更新时间</th>
						<th data-width="140px" data-formatter="setOperate" >操作</th>
					</tr>
				</thead>
			</table>
	</div>
	</form>
</body>
</html>