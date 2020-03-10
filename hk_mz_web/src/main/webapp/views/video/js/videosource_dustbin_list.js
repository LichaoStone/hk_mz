$(document).ready(function() {
	//获取数据
	getDetails();
	
});

/**
 * 获取数据
 */
function getDetails() {
	var url = basePath+"/videoSource/getDustbinList";
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
		sidePagination : "server", 								// 分 页方式：client客户端分页，server服务端分页（*）
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
				"pageSize":params.limit
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
 * 设置操作
 */
function setOperate(value,row){
	var operate="";
	
	//还原
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"restoreVideo('"+row.videoSourceId+"')\">还原</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	return operate;
}

/**
 * 还原视频
 */
function restoreVideo(videoSourceId){
	console.log("videoSourceId:"+videoSourceId);
	if(confirm("是否还原视频?")){
		$.ajax( {
			type : "POST",
			url : basePath + "videoSource/modifyStatus?videoSourceId="+videoSourceId+"&status=1",
			timeout : 3600000,
			success : function(data,textStatus) {
				var list=$.parseJSON(data);
				
				refresh();
				toast("清空回收站成功",true,'succ','top',400);
			},
			error : function() {
				alert("Ajax请求失败,请及时联系管理员！");
			}
		});
		
	}
}

/**
 * 清空回收站
 */
function clearBox(){
	if(confirm("是否清空回收站?")){
		$.ajax( {
			type : "POST",
			url : basePath + "videoSource/clearBox",
			timeout : 3600000,
			success : function(data,textStatus) {
				var list=$.parseJSON(data);
				
				toast("清空回收站成功",true,'succ','top',400);
				
				refresh();
			},
			error : function() {
				alert("Ajax请求失败,请及时联系管理员！");
			}
		});
		
	}
}