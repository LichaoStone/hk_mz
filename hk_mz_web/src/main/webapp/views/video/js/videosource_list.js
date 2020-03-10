var searchCollapseStatus = 0 ;
$(document).ready(function() {
	// 设置查询条件是否展开
	initCollapse();
	
	//初始化时间插件
	initDateRangePicker("create_time_Search",false,true,true,null);
	
	//初始化分类下拉菜单
	getClassifySelect("classicId");
		
	//初始化作者下拉菜单
	getUserSelect("userId");
		
	//获取数据
	getDetails();
	
});

/**
 * 获取数据
 */
function getDetails() {
	var url = basePath+"/videoSource/getVideoSourceList";
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
		smartDisplay : true,									// 始终显示分页信息
		onPostBody : function (data) {
			 overwriteChekboxCss();
		 },
		responseHandler:function(result){
			return result.results;
		}
	});
}


function refresh(){
	$('#dataTable').bootstrapTable('refresh');
}


/**
 * 查询参数
 */
function queryParams(params) {
	var json = {
			"pageNumber":params.offset,
			"pageSize":params.limit,
			"videoSourceName":$("#searchName").val(),
			"userId":$("#userId").val(),
			"classifyId":$("#classicId").val(),
			"createTime":$("#create_time_Search").val()
			}
	return json;
}


function formatStatus(value, row){
	if(value == 1){
		return '启用';
	}
	return '禁用' ;
}

/**
 * 设置名称
 */
function setVideoSourceName(value,row){
	return "<a href='javascript:;' class='operate-a' onclick=\"toView('"+row.videoSourceId+"')\" >"+value+"</a>";
}


/**
 * 进入详情页
 */
function toView(videoSourceId){
	var url = basePath + "videoSource/toView?videoSourceId="+videoSourceId;
	parent.openModal("素材库",600, 800, url);
}

/**
 * 操作
 */
function setOperate(value,row){
	var operate="";
	
	//简编
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"toVideoSourceEdit('"+row.videoSourceId+"')\">简编</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	//转码
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"toTranscoding('"+row.videoSourceId+"')\">转码</a>";
	operate = operate + "&nbsp;&nbsp;";
	//下载
	operate=operate+"<a href='javascript:;' class='operate-a'  dowload >下载</a>";
	operate = operate + "&nbsp;&nbsp;";
	//删除
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"deleteVideo('"+row.videoSourceId+"')\">删除</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	return operate;
}

/**
 * 删除素材
 */
function deleteVideo(videoSourceId){
	if(confirm("是否要删除素材")){
		$.ajax( {
			type : "POST",
			url : basePath + "videoSource/modifyStatus?videoSourceId="+videoSourceId+"&status=-1",
			timeout : 3600000,
			success : function(data,textStatus) {
				    var result=$.parseJSON(data); 
				    console.log(result);
	            	if(result.success==true){
	            		//更新页面
	                	refresh();
	                	toast(result.msg,true,'succ','top',400);	
	            	}else{
	            		toast(result.msg,true,'error','top',400);	
	            	}
			},
			error : function() {
				alert("Ajax请求失败,请及时联系管理员！");
			}
		});
	}
}


/**
 * 进入上传页面
 */
function toUpload(){
	var url = basePath + "videoSource/toUpload" ;
	parent.openModal("上传管理", 850,750, url,"");
}

function toClassify(){
	var url = basePath + "videoSource/toClassify" ;
	parent.openModal("选择分类", 400,500, url,"");
}

/**
 * 进入转码列表页面
 */
function toTranscoding(){
	var url = basePath + "videoSource/toTranscoding" ;
	parent.openModal("转码列表", 800, 960, url,"");
}

/**
 * 进入回收站页面
 */
function toDustbin(){
	var url = basePath + "videoSource/toDustbin" ;
	parent.openModal("回收站", 800, 960, url,"");
}


/**
 * 进入素材视频编辑页面
 */
function toVideoSourceEdit(videoSourceId){
	window.location.href = basePath+'videoSource/toVideoSourceEdit?videoSourceId='+videoSourceId;
}
