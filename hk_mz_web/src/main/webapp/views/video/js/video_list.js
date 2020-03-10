var searchCollapseStatus = 0 ;
$(document).ready(function() {
	// 设置查询条件是否展开
	initCollapse();
	
	//初始化时间插件
	initDateRangePicker("create_time_Search",false,true,true,null);
		
	// 初始化状态下拉框
	$("#searchNameType").select2( {
		//placeholder : "请选择",
		allowClear : false,
		minimumResultsForSearch : Infinity
	});
	$("#searchNameType").val("videoSourceName").trigger("change");
	
	
	//初始化分类下拉菜单
	getClassifySelect("classicId");
	
	//初始化标签下拉菜单
	getTagsSelect("videoTag","video");
	
	//初始化作者下拉菜单
	getUserSelect("userId");
	
	//查询数据
	getDetails();
	
});


/**
 * 获取详情数据
 */
function getDetails() {
	var url = basePath+"/video/getVideoList";;
	$("#dataTable").bootstrapTable( {
		classes : 'table table-no-bordered table-hover', 			//无边框表格
		locale : 'zh-CN', 											// 中文显示
		method : 'post',
		contentType : 'application/x-www-form-urlencoded',
		url : url, 													// 接口 URL 地址
		queryParams : queryParams, 									// 查询条件
		cache : false, 												// 不缓存
		clickToSelect : true, 										// 单击行即可以选中
		pagination : true,											// 是否显示分页（*）
		sidePagination : "server", 									// 分 页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, 											// 初始化加载第一页，默认第一页
		pageSize : 10, 												// 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], 							// 可供选择的每页的行数（*）
		smartDisplay : true ,									    // 始终显示分页信息
		onPostBody : function (data) {
			 overwriteChekboxCss();
		 },
		responseHandler:function(result){
			console.log(result.results);
			return result.results;
		}
	});
}

/**
 * 刷新页面
 */
function refresh(){
	$('#dataTable').bootstrapTable('refresh');
}

/**
 * 重置
 */
function resetVal(){
	$("#searchNameType").val("videoSourceName").trigger("change");
	$("#searchName").val("");
	$("#classicId").val("").trigger("change");
	$("#videoTag").val("").trigger("change");
	$("#userId").val("").trigger("change");
}

/**
 * 参数
 */
function queryParams(params) {
	var json = {
				"pageNumber":params.offset,
				"pageSize":params.limit,
				"searchNameType":$("#searchNameType").val(),
				"searchName":$("#searchName").val(),
				"classicId":$("#classicId").val(),
				"videoTag":$("#videoTag").val(),
				"userId":$("#userId").val()
				}
	return json;
}

/**
 * 设置操作
 */
function setOperate(value, row){
	var operate="";
	
	//修改
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"toUpdate('"+row.videoId+"')\">修改</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	//下发
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"sendVideo('"+row.videoId+"')\">下发</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	//下载
	operate=operate+"<a href='javascript:;'  class='operate-a' onclick=\"toDownVideo('"+row.videoId+"')\">下载</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	return operate;
}


/**
 * 设置视频名称
 */
function setVideoName(value, row){
	return "<a href='javascript:;' class='operate-a' onclick=\"toView('"+row.videoId+"')\" >"+value+"</a>";
}

/**
 * 进入详情页
 */
function toView(videoId){
	var url = basePath + "video/toView?videoId="+videoId;
	parent.openModal("查看",600,800,url);
}

/**
 * 进入修改页面
 */
function toUpdate(videoId){
	var url = basePath + "video/toUpdate?videoId="+videoId;
	parent.openModal("修改",600, 800, url);
}


/**
 * 下发视频
 */
function sendVideo(videoId){
	$.ajax( {
		type : "POST",
		url : basePath + "video/sendVideo",
		timeout : 3600000,
        data:{"videoId":videoId},
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

/**
 * 下载视频
 */
function toDownVideo(videoId){
	var url = basePath + "video/toDownVideo?videoId="+videoId;
	parent.openModal("提示",260,500, url);
}

/**
 * 批量下发
 */
function bathSend(){
	var keys = "";
	//var selections = $("#dataTable").bootstrapTable('getSelections');
	//if (selections === null || selections === "") {
	//	alert("未选中任何项");
	//	return;
	//}
	console.log($("#dataTable").bootstrapTable('getAllSelections'));
	
	$("#dataTable").find("tr").each(function(i,item){
		console.log(item);
	});
	
	//console.log(selections);
	//if(confirm("确认下发"+selections.length+"个视频？")) {
	//	bath(selections,keys);
	//}
}



/**
 * 批量操作
 * @param selections
 * @param keys
 * @returns {Boolean}
 */
function bath(selections,keys){
	var flag="";
	$.each(selections, function(i, row) {
		keys = keys + row.videoId+",";
	});
	
	if(flag==="0"){
		return false;
	}
	
	if(keys.length===0){
		alert("没有要处理的内容，请重新选择！");
		return false;
	}else{
		$.ajax( {
			type : "POST",
			url : basePath + "video/sendVideo",
			timeout : 3600000,
	        data:{"videoId":keys},
			success : function(data) {
				 	var result=$.parseJSON(data); 
	            	if(result.success==true){
	            		//更新页面
	                	refresh();
	                	toast(result.msg,true,'succ','top',400);	
	            	}else{
	            		toast(result.msg,true,'error','top',400);	
	            	}
			},
			error : function() {
			}
		});
	}
	
}

/**
 * 设置是否分享
 */
function setIsShare(value,row){
	var str="";
	if(value=="1"){
		str="是";
	}else{
		str="否";
	}
	
	return str;
}


function setCheckBox(value,row,index){
	return "<input id='bootstraptable_input_"+index+"' data-id='"+row.videoId+"' type='hidden' value='"+row.videoId+"'   />";
}