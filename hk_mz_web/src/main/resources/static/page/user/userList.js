var searchCollapseStatus = 0 ;
$(document).ready(function() {
	$(".search_img_span").click(function(){
		$(this).prev().click();
	});
	getDetails();
	var data = [{"name":"系统管理","url":""},{"name":"用户管理","url":basePath+"user/show_user_list"},{"name":"添加用户","url":basePath+"user/show_save_user"}];
	window.parent.breadCrumb(data);
});
function getDetails() {
	var url = basePath+"/getUserList";;
	$("#dataTable").bootstrapTable( {
		classes : 'table table-no-bordered table-hover', // 无边框表格
		locale : 'zh-CN', // 中文显示
		method : 'post',
		contentType : 'application/x-www-form-urlencoded',
		url : url, // 接口 URL 地址
		queryParams : queryParams, // 查询条件
		cache : false, // 不缓存
		clickToSelect : true, // 单击行即可以选中
		pagination : true, // 是否显示分页（*）
		sidePagination : "server", // 分 页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 2, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		smartDisplay : true ,// 始终显示分页信息
		responseHandler:function(result){
			return result.data;
		}
	});
}
function queryParams(params) {
	var json = {"offset":params.offset,
				"pageSize":params.limit,
				"searchWords":$("#searchWords").val(),
				"platformId":$("#platformId").val(),
				"status":$("#status").val()}
	return json;
}
function formatStatus(value, row){
	if(value == 1){
		return '启用';
	}
	return '禁用' ;
}
function rowIndex(value, row,index){
	return index+1 ;
}
function setOperate(value, row){
	var editStr = "" ;
	
	var deleteStr = "" ;
	
	return "编辑  删除" ;
}
function refreshDataTable(){
	$('#dataTable').bootstrapTable('refresh');
}
function addUser(){
	var url = basePath + "user/show_save_user" ;
	parent.openModal("添加用户", 800, 960, url,"");
}