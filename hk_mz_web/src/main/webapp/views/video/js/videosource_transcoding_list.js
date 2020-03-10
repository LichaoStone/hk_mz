var searchCollapseStatus = 0 ;
$(document).ready(function() {
	// 设置查询条件是否展开
	initCollapse();
	
	//获取数据
	getDetails();
	
});

/**
 * 获取数据
 */
function getDetails() {
	var url = basePath+"/videoSource/getTranscodingList";
	$("#dataTable").bootstrapTable( {
		classes : 'table table-no-bordered table-hover',       // 无边框表格
		locale : 'zh-CN', 									   // 中文显示
		method : 'post',
		contentType : 'application/x-www-form-urlencoded',
		url : url, 												// 接口 URL 地址
		queryParams : queryParams, 								// 查询条件
		cache : false, 											// 不缓存
		clickToSelect : true, 									// 单击行即可以选中
		pagination : true, 										// 是否显示分页（*）
		sidePagination : "server", 								// 分 页方式：client 客户端分页，server服务端分页（*）
		pageNumber : 1, 										// 初始化加载第一页，默认第一页
		pageSize : 10, 											// 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ],						    // 可供选择的每页的行数（*）
		smartDisplay : true ,									// 始终显示分页信息
		responseHandler:function(result){
			return result.results;
		}
	});
}

function queryParams(params) {
	var json = {
				"pageNumber":params.offset,
				"pageSize":params.limit,
				"status":$("#status").val()
				}
	return json;
}

/**
 * 刷新页面
 */
function refresh(){
	$('#dataTable').bootstrapTable('refresh');
}



/**
 * 切换tab页
 */
function changeTableTab(id){
	if(id=="btn-coding-all"){//全部
		$("#btn-coding-all").addClass("table-tab-selected");
		$("#btn-coding-error").removeClass("table-tab-selected");
		
		$("#status").val("");
	}else if(id=="btn-coding-error"){//失败
		$("#btn-coding-all").removeClass("table-tab-selected");
		$("#btn-coding-error").addClass("table-tab-selected");
		
		$("#status").val("error");
	}
	
	refresh();
}

/**
 * 设置状态
 */
function setStatus(value,row){
	var resHtml="";
	if(value=="sucess"){
		resHtml+="<span style='color:#19B23F;font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:50px;' >成功</span>";
	}else if(value=="error"){
		resHtml+="<span style='color:#19B23F;font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:50px;' >失败</span>";
	}else if(value=="coding"){
		resHtml+="<span style='color:#19B23F;font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:50px;' >转码中</span>";
	}
	
	return resHtml;
}