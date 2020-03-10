<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
	<title>订单管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="keywords" content="轻快云开放平台管理后台">
	<meta http-equiv="description" content="轻快云开放平台管理后台">
	
	<link href="/css/page_list.css" rel="stylesheet">
	<link href="bootstrap/css/bootstrap-table.css" rel="stylesheet">
	<script type="text/javascript" src="page/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="page/jquery.transit.js"></script>
	
	<script type="text/javascript" src="bootstrap/js/bootstrap.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-table.js"></script>
	<script type="text/javascript" src="bootstrap/js/bootstrap-table-zh-CN.js"></script>
	<script type="text/javascript" src="page/page_init.js"></script>
	<script type="text/javascript" src="page/pageList.js"></script>
	<script type="text/javascript">
		var appInformationKey = '' ;
		//权限控制
		//充值
		//var auditing="${loginBean.auditing}";
		//发货
		//var checkup="${loginBean.checkup}";
	</script>
</head>
	<body>
	<form id="form" name="form" method="post"  action="">
	
	<!-- 带折叠的查询页面请加入该hidden -->
	<input type="hidden" id="searchCollapseStatus" name="searchCollapseStatus" value="0"/>
	
	<!-- 查询栏 -->
	<div class="container-fluid containe-search">
		<div class="row">
			<!-- 收缩的查询栏 -->
			<div class="row-top-div">
				<select id="type" name="type" class="search-select" onchange="changeOrderType()">
					<option value="0">
						订单号
					</option>
					<option value="1">
						账号
					</option>
					<option value="2">
						收件人姓名
					</option>
				</select>
				
				<span class="search-select-input">
					<input type="text" id="searchWords" name="searchWords" class="search-main-text" placeholder = "请输入订单号">
					<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="toList1()">
						<span class="search-main-btn-span" id="search-btn-collapsed">
						</span>
					</a>
				</span>
				
				<span class="search-main-sub-btn-span">
					<a id="search-div-a" class="search-btn collapsed"  onfocus="this.blur();" onclick="changeCollapseStatus()">
						<span class="text"></span>
						<img class="search-main-img" id="search-div-img"></img>
					</a>
				</span>
				<div id="arrow" class='search-span-arrow sjh' style="display:none"></div>
			    <div id="arrow-border" class='search-span-arrow-border sjhk' style="display:none"></div>
			</div>



		<!-- 展开的查询栏 -->
			<div id="search-div" class="collapse">
				<div class="row-main-div-one" style = "border-bottom:0px;">
					<span class="search-select-title">商品归属：</span>
					<select id="appInformationKey" name="appInformationKey" class="search-select-long" >
						<option></option>
					</select>
			
					<span class="search-select-span-other">商品形态：</span>
					<select id="goodsType" name="goodsType" onchange="changeGoodsType()" class="search-select">
						<option></option>
						<option value="1">
							实物
						</option>
						<option value="2">
							优惠券
						</option>
						<option value="3">
							充值类
						</option>
					</select>
					
					<span class="search-select-span-other">订单形态：</span>
					<select id="status" name="status" class="search-select">
						<option></option>
						<option value = "未发货">未发货</option>
						<option value = "已发货">已发货</option>
						<option value = "未使用">未使用</option>
						<option value = "已使用">已使用</option>
						<option value = "已过期">已过期</option>
						<option value = "未充值">未充值</option>
						<option value = "已充值">已充值</option>
					</select>
					
				</div>
					
				<div class="row-main-div-other" style = "border-top:0px;">
						<span class="search-select-title">下单时间：</span>
						<span class="datepicker">
							<input type="text" id="searchTime" name="searchTime" class="search-datepicker" readonly="readonly" placeholder="请选择"  value="${searchTime}">
						</span>
						
						<span class="search-span pull-right">
							<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="toList1()">
								<span class="search-btn-span-serach" id="search-btn1">
									查询
								</span>
							</a>
							<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="resetVal()">
								<span class="search-btn-span-reset " id="search-btn1">
									重置
								</span>
							</a>
						</span>
				</div>
							
			</div>

		</div>
	</div>
	
	<!-- 按钮栏 -->
	<div class="container-fluid container-btn">
		
			<span style = "font-size:14px;">批量操作</span>&nbsp;&nbsp;
			<a href="javascript:void(0)" id="search" name="search" class="detail-a" data-toggle="collapse" onfocus="this.blur();" onclick="bathHandle(1);">
				充值
			</a>
	
		<span class="pull-right">
			<a href="javascript:void(0)" id="search" name="search" class="search-btn" onfocus="this.blur();" onclick="downLoad()">
				<span class="search-btn-span" id="search-btn1" style="margin-right: 0px;">
					导出
				</span>
			</a>
		</span>
	</div>

	<!-- 内容栏 -->
	<div class="container-fluid container-main">
		<table id="dataTable">
			<thead>
				<tr>
					<th data-width="4%" data-checkbox="true" data-align="center" ></th>
					<th data-width="50px;" data-align="center" data-formatter="rowIndex">序号</th>
					<th data-field="loginName" data-width="100px">登录名称</th>
					<th data-field="userName" data-width="100px">用户名称</th>
					<th data-field="createTime" data-formatter="formatDate" data-width="150px">时间</th>
					<th data-field="mobile" data-width="200px" >联系方式</th>
					<th data-field="email" data-width="80px" >邮箱</th>
					<th data-field="status" data-formatter="formatStatus" data-width="60px">状态</th>
					<th data-width="140px" data-formatter="setOperate" >操作</th>
				</tr>
			</thead>
		</table>
	</div>
	</form>
	</body>
</html>