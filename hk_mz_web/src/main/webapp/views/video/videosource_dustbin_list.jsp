<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>回收站</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/videosource_dustbin_list.js"></script>
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
			 .search-btn-blue{
			 	background: rgba(88,104,221,1);
			    height: 32px;
			    width: 100px;
			    text-align: center;
			    font-size: 14px;
			    display: inline-block;
			    line-height: 32px;
			    color: rgba(255,255,255,1);
			    border-radius:0px;
			 }
			 .search-btn-span-green{
			 	 border: 1px solid rgba(88,104,221,1);
			     height: 32px;
			     width: 80px;
			     text-align: center;
			     font-size: 14px;
			     display: inline-block;
			     line-height: 32px;
			     color: #5868DD;
			     border-radius:4px;
			 }
		</style>
	</head>
<body>  
	  <div style="padding-right:24px;padding-left:24px;">
		  <div style="float:left;margin-bottom:20px;">
			 	<a href="javascript:void(0)" id="search" name="search" class="search-btn-green" onfocus="this.blur();" onclick="clearBox()" >
				 	<span class="search-btn-span-green" style="width:120px;height:40px;line-height:2.8;">
						清空回收站
					 </span>
			 	</a>
	       	</div>
	       	<div style="float:right;line-height: 2.5;"><span>最近10天删除记录</span></div>
       	</div>

		<!-- 内容栏 -->
		<div class="container-fluid container-main">
			<table id="dataTable" style="border:none;">
				<thead>
					<tr>
						<th data-field="videoSourceName" data-width="20%">视频名称</th>
						<th data-field="fileSize"  data-width="10%">大小</th>
						<th data-field="classifyName" data-width="20%" >分类名称</th>
						<th data-field="deleteTime" data-width="20%">删除时间</th>
						<th data-field="deleteTime" data-width="20%">有效期</th>
						<th data-width="140px" data-formatter="setOperate" data-width="10%">操作</th>
					</tr>
				</thead>
			</table>
		</div>
</body>
</html>