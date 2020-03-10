$(document).ready(function() {
	getDetails();
});

/**
 * 获取电影列表
 */
function getDetails() {
	var url = basePath+"tag/get_tag_list";
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
		pageSize : 5, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		smartDisplay : true ,// 始终显示分页信息
		responseHandler:function(result){
			return result.data;
		}
	});
}
/**
 * 设置查询条件
 */
function queryParams(params) {
	var json = {
				"offset":params.offset,
				"pageSize":params.limit,
				}
	return json;
}
/**
 * 根据当前页面选项，刷新列表
 */
function refreshDataTable(){
	$('#dataTable').bootstrapTable('refresh');
}



/**列表项操作*/
/**
* 设置操作
* @param value
* checkup：1 
* 
* @param row
* @param index
*/
function setOperate(value,row,index){
	var operate = "";
	operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"manage('"+row.tagType+"')\">管理</a>";
	return operate;
}
/**
* 管理标签
*/
function manage(tagType){
	window.location.href = `${basePath}tag/list/${tagType}`;
} 

function rowIndex(value, row,index){
	return index+1 ;
}
