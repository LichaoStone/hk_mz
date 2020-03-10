<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>用户管理</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/page/user/userList.js"></script>
		<style>
			select {
				/*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
				border: solid 1px #000;
				/*很关键：将默认的select选择框样式清除*/
				appearance:none;
				-moz-appearance:none;
				-webkit-appearance:none;
				/*将背景改为红色*/
				background:red;
				/*加padding防止文字覆盖*/
				padding-right: 14px;
			}
			/*清除ie的默认选择框样式清除，隐藏下拉箭头*/
			select::-ms-expand { display: none; }
		</style>
	</head>
	<body style="background-color: #FFFFFF;min-width: 1140px;overflow: scroll;">
	<form id="form" name="form" method="post"  action="">	
	<!-- 查询栏 -->
	<div class="container-fluid containe-search" >
		<div class="row">
			<!-- 收缩的查询栏 -->
			<div class="row-top-div">
				<span class="search-select-input">
					<input type="text" id="searchWords" name="searchWords" class="search-main-text search_input" placeholder = "请输入姓名">
					<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="refreshDataTable()">
						<div class="search_div">	
							<span id="search-btn-collapsed">
								<img src="<%=basePath %>images/search_circle.png"/>
							</span>
							<span>
								搜索
							</span>
						</div>
					</a>
				</span>
				<span class="search_select_span">
					<select id="platformId" name="platformId" class="search_select" >
						<option value="">
							请选择所属平台
						</option>
						<option value="1">
							账号
						</option>
						<option value="2">
							收件人姓名
						</option>
					</select>
					<!--  -->
					<span class="search_img_span" id="select_img" for="platformId">
						<img class="search_img" src="${basePath}/images/select@2x.png"/>
					</span>
					
				</span>
				<span class="search_select_span">
					<select id="status" name="status" class="search_select" >
						<option value="">
							状态
						</option>
						<option value="0">
							禁用
						</option>
						<option value="1">
							启用
						</option>
					</select>
					<!--  -->
					<span class="search_img_span" for="status">
						<img class="search_img" src="${basePath}/images/select@2x.png"/>
					</span>
					
				</span>
				<span class="search_select_span">
					<button type="button" onclick="addUser()" class="btn search_btn" style="color:white;" >添加</button>
				</span>
			</div>
		</div>
	</div>
	<!-- 内容栏 -->
	<div class="container-fluid container-main">
		<table id="dataTable">
			<thead>
				<tr>
					<th data-width="50px;" data-align="center" data-formatter="rowIndex">序号</th>
					<th data-field="loginName" data-width="100px">用户名</th>
					<th data-field="userName" data-width="100px">姓名</th>
					<th data-field="platformName" data-width="150px">所属平台</th>
					<th data-field="mobile" data-width="100px" >角色</th>
					<th data-field="status" data-formatter="formatStatus" data-width="60px">状态</th>
					<th data-width="140px" data-formatter="setOperate" >操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	</body>
</html>