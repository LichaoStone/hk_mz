<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/page/tag/index.js"></script>
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
					<th data-field="tagType" data-width="33%" >标签所属</th>
					<th data-field="tagCount" data-width="33%">标签数量</th>
					<th  data-width="33%"  data-formatter="setOperate" >操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	</body>
</html>