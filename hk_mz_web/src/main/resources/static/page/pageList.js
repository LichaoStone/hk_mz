var searchCollapseStatus = 0 ;
$(document).ready(function() {
	// 设置查询条件是否展开
	console.log(1)
	//initCollapseStatus();
	console.log(2);
	$("#select_img").click(function(){
		console.log($(this).prev());
		$(this).prev().click();
	});
	getDetails();
	
});
function getDetails() {
	// 组装查询url
	var space = "/getUserList";
	
	var url = "http://127.0.0.1:8080" + space;
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
	console.log(params);
	var json = {"offset":params.offset,"pageSize":params.limit}
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
	return "" ;
}
