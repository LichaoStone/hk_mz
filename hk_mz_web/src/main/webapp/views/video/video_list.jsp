<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>视频成品库</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/video_list.js"></script>
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
			    font-family:"PingFangSC-Regular";
			 }
			 .search-main-text:focus{
			 	border:1px solid #5868DD;
			 	outline:0;
			 	margin-right:1.5px;
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
			 
			 .free-checkbox{
                    height: 12px;
                    width: 12px;
                    display: inline-block;
                    background-image: url("../images/xuankuang_xuhao.png");
                    background-repeat: no-repeat;
                    background-position: center;
                    vertical-align: middle;
                    margin-top: -4px;
                }
             input[type="radio"]:checked + .advice{
                    background-image: url('../images/liebiao_duihao_xuanzhong');
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
					<span class="select_span">
						<select id="searchNameType" name="searchNameType" class="search-select">
							<option value="videoSourceName">素材名称</option>
							<option value="videoName" >成品名称</option>
						</select>
						
						<span class="select_img_span" id="select_img">
							<img class="search_img" src="../images/select_img_arrow_close.png"/>
						</span>
					</span>
				    
				    <span style="margin-left:20px;color:#000000;">素材名称:</span>
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
						 
						 <!-- 标签 -->
						 <span class="search-select-title">标签:</span>
						 <select id="videoTag" name="videoTag" class="search-select">
						 </select>
						 
						 
						 <!-- 作者 -->
						 <span class="search-select-title">作者:</span>
						 <select id="userId" name="userId" class="search-select">
						 </select>
					 </div>
						    
				    <div class="row-main-div-other">
						 <span  class="search-select-title" >发布时间:</span>
						 <span class="datepicker">
						 	<!-- 
						 	    <input type="text" id="datePick" class="form-control">
					            <input type="hidden" id = "startTime" name="startTime" class="form-control" />
            	 			    <input type="hidden" id = "endTime" name="endTime" class="form-control" />
						    -->
							   <input type="text" id="create_time_Search" name="create_time_Search" class="search-datepicker"  placeholder="请选择"  >
						 </span>
						 
						 
						<!-- 右侧：查询及充值按钮 -->
						<span class="search-span pull-right">
							<div style="float:right;width:80px;height:40px;">
								<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="resetVal()">
									<span class="search-btn-span-reset " id="search-btn1">重置</span>
								</a>
							</div>
							
							<div style="float:right;width:80px;height:40px;margin-right:20px;">
								<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="refresh()">
									<span class="search-btn-span-serach" id="search-btn1">搜索</span>
								</a>
							</div>
							
				        </span>
			        </div>
				</div>
			  </div>	
		  </div>
		   
		   
		  <!-- 批量操作按钮 --> 
		  <div class="container-fluid container-btn">
			   <span class="bath-btn-span" style="font-size: 14px;">批量操作：</span>
			   <a href="javascript:void(0)" id="bathDown" name="bathDown"  data-toggle="collapse" onfocus="this.blur();" onclick="bathSend()">
				         下发
			   </a>
		  </div>
			
		<!-- 内容栏 -->
		<div class="container-fluid container-main">
			<table id="dataTable" style="border:none;">
				<thead>
					<tr>
					    <th data-width="4%"  data-checkbox="true" data-align="center"  data-formatter="setCheckBox" ></th>
						<th data-field="videoName" data-width="100px" data-formatter="setVideoName">视频名称</th>
						<th data-field="videoLong" data-width="60px">时长</th>
						<th data-field="standard"  data-width="80px">标准</th>
						<th data-field="classifyName" data-width="60px" >分类名称</th>
						<th data-field="videoTag" data-width="60px">标签</th>
						<th data-field="userName" data-width="60px">作者</th>
						<th data-field="isShare" data-formatter="setIsShare" data-width="60px">共享</th>
						<th data-field="createTime" data-width="120px">时间</th>
						<th data-width="140px" data-formatter="setOperate" >操作</th>
					</tr>
				</thead>
			</table>
	</div>
	</form>
</body>
</html>