//选中的视频个数
var addVideoCount=0;
$(document).ready(function() {
	//查询数据
	getDetails();
	
});


/**
 * 获取详情数据
 */
function getDetails() {
	var url = basePath+"/videoSource/getVideoSourceList";;
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
		smartDisplay : true ,										// 始终显示分页信息
		onPostBody : function () {
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
	//取消选择
}

/**
 * 保存
 */
function save(){
	var resStr=[];
	$("#dataTable").find("tr").each(function(i,item){
		console.log(item);
		
		if($(item).hasClass("selected")){
			console.log("第"+i+"次执行");
			var dataIndex=$(item).attr("data-index");
			
			var videoSourceId=$("#bootstraptable_input_"+dataIndex).attr("data-id");
			var videoSourceName=$("#bootstraptable_input_"+dataIndex).attr("data-name");
			var videoImgUrl=$("#bootstraptable_input_"+dataIndex).attr("data-img");
			var videoUrl=$("#bootstraptable_input_"+dataIndex).attr("data-url");
			
    			resStr.push({
					"videoSourceId":videoSourceId,
					"videoSourceName":videoSourceName,
					"videoImgUrl":videoImgUrl,
					"videoUrl":videoUrl
				});
		}
	});
	
	if(resStr!=null){
		if(resStr.length>8){
			alert("最多选择8个视频");
			return false;
		}else{
			addVideoCount=resStr.length;
		}
	}
	
	console.log("选中的ID:"+resStr.length);
	console.log("addVideoCount:"+addVideoCount);
	console.log("videoCount:"+videoCount);
	if((parseInt(addVideoCount)+parseInt(videoCount))>20){
		alert("最多只能添加20个视频");
		return false;
	}else{
		$("#htmlContent",parent.document.body)[0].contentWindow.addVideo(resStr);
		//$("#htmlContent",parent.document.body)[0].contentWindow.toast("添加视频成功",true,'succ','top',400);
		parent.closeModal();
	}
	
}

/**
 * 参数
 */
function queryParams(params) {
	return {
			"pageNumber":params.offset,
			"pageSize":params.limit
		   };
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
	console.log("data-id:"+row.videoSourceId);
	console.log("data-name:"+row.videoSourceName);
	console.log("data-img:"+row.imgUrl);
	console.log("data-url:"+row.videoUrl);
	
	
	return "<input  data-id='"+row.videoSourceId+"' data-name='"+row.videoSourceName+"'  data-img='"+row.imgUrl+"'  id='bootstraptable_input_"+index+"' type='hidden' value='"+row.videoSourceId+"'   />";
}