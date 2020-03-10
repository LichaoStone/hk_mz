<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>转码列表</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/videosource_transcoding_list.js"></script>
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
			 
			.table-tab{
	        	cursor: pointer;
	        	float:left;
	        	width:100px;
	        	height: 40px;
	        	border:1px solid #5868DD;
	        	background-color: #FFFFFF;
	        	text-align:center;
	        	padding-top:6px;
	        	color:#5868DD;
	        	border-radius:4px 0px 0px 4px;
	        }
	        
	        .table-tab-selected{
	        	background-color: #5868DD;
	        	color:#FFFFFF;
	        }
	        
	        .search-span{
	        	margin-right:0px;
	        }
		</style>
	</head>
<body>  
	<form id="form" name="form" method="post"  action="">
		  <input type="hidden" id="status" name="status" value="" />
         <div class="container-fluid container-btn">
         		<div id="btn-coding-all" onclick="changeTableTab('btn-coding-all')" class="table-tab table-tab-selected" style="margin-left:-5px;">
         			<span style="font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:25px;">全部</span>
         		</div>
				<div id="btn-coding-error" style="border-radius:0px 4px 4px 0px;" onclick="changeTableTab('btn-coding-error')" class="table-tab" >
					<span style="font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:25px;">转码失败</span>
				</div>
				 
				 
				 <div style="float:right;height:40px;line-height: 4;">
				 	<span class="search-span pull-right">
			        	最近2天转码记录
			        </span>
				 </div>
         </div>
        
		<!-- 内容栏 -->
		<div class="container-fluid container-main">
			<table id="dataTable" style="border:none;">
				<thead>
					<tr>
						<th data-field="createTimeStr" data-width="150px">时间</th>
						<th data-field="videoName" data-width="100px">视频名称</th>
						<th data-field="fileSize"  data-width="150px">大小</th>
						<th data-field="videoLong" data-width="100px" >时长</th>
						<th data-field="standardName" data-width="60px">转码标准</th>
						<th data-field="classifyName" data-width="60px">分类名称</th>
						<th data-field="status" data-width="60px" data-formatter="setStatus">状态</th>
					</tr>
				</thead>
			</table>
		</div>
	</form>
</body>
</html>