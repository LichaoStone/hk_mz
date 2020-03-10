<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>资讯管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/page/news/index.js"></script>
		<script type="text/javascript" src="${basePath}/page/jquery.form.min.js"></script>
		<script>
		</script>
		<style>
			.st-header{
				margin: 20px 0 15px 20px;
				width:145px;
				height:14px;
				font-size:14px;
				font-weight:400;
				color:rgba(0,0,0,0.6);
				line-height:14px;
			}
			.st-body{
				display: flex;
				flex-direction: row;
				flex-wrap: wrap;
				padding: 0 20px; 
			}
			.st-card{
				display: flex;
			    flex-direction: column;
				align-items: center;
			    justify-content: center;
				width:130px;
				height:80px;
				margin: 0 15px 15px 0;
				background:rgba(247,248,250,1);
				border-radius:4px;
				border:1px solid rgba(231,231,243,1);
				text-align: center;
			}
			.st-title{
				display:block;
				width:100%;
				height:14px;
				font-size:14px;
				font-weight:400;
				color:rgba(38,38,38,1);
				line-height:14px;
			}
			.st-num {
				display:block;
				width:100%;
				height:14px;
				margin-top: 6px;
				font-size:12px;
				font-weight:400;
				color:rgba(38,38,38,0.6);
				line-height:14px;
			}
			.search-input-container{
				vertical-align: top;
			}
		</style>
	</head>
	<body style="background-color:#FFFFFF;">
	<div class="statistics">
		<div class="st-header">注：今日更新量/总量</div>
		<div class="st-body">
			<div class="st-card">
				<span class="st-title">全部</span>
				<span class="st-num">100/3K</span>	
			</div>
		</div>
	</div>
	<form id="form" name="form" method="post"  action="">	
	<!-- 查询栏 -->
	<div class="container-fluid containe-search">
		<div class="row">
			<div class="row-top-div">
				<span class="search-title-span">
					<label class="search-title-font">
						关键词:
					</label>
				</span>
				<span class="search-input-container">
					<input type="text" id="keywords" name="keywords" class="search-input" style="border:none;" placeholder = "请输入">
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
				<span class="search-input-container" style="width:400px">
				    	<label class="col-sm-2 col-form-label search-lable-title">时段:</label>
					    <div class="col-sm-10" >
							<div>
					        	<input type="text" id="datePick" class="form-control" placeholder = "请输入">
					        	<input type="hidden" id = "startTime" name="startTime" class="form-control" />
            	 				<input type="hidden" id = "endTime" name="endTime" class="form-control" />
				         	</div>
					    </div>
			   	</span>
			</div>
		</div>
	</div>	
	<!-- 内容栏 -->
	<div class="container-fluid container-main">
		<table id="dataTable">
			<thead>
				<tr>
					<th data-width="20" data-formatter="rowIndex" >序号</th>
					<th data-field="newsTitle" data-width="200" >资讯名称</th>
					<th data-field="classifyName" data-width="100" >分类名称</th>
					<th data-field="keyWords" data-width="200" >关键词</th>
					<th data-field="platformName" data-width="100" >来源</th>
					<th data-field="createTime" data-width="80" data-formatter="convertTime">时间</th>
					<th  data-width="80"  data-formatter="setOperate" >操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	</body>
</html>