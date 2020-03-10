$(document).ready(function() {
	getDetails();
});

/**
 * 获取电影列表
 */
function getDetails() {
	var url = basePath+"video/get_videoback_list";
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
			return result.results;
		}
	});
}
/**
 * 设置查询条件
 */
function queryParams(params) {
	var json = {
				"pageNumber":params.offset,
				"pageSize":params.limit,
				"activityId": activityId
				}
	return json;
}
/**
 * 根据当前页面选项，刷新列表
 */
function refreshDataTable(){
	$('#dataTable').bootstrapTable('refresh');
}



/** 列表项操作 */
/**
 * 设置操作
 * 
 * @param value
 *            checkup：1
 * 
 * @param row
 * @param index
 */
function setOperate(value,row,index){
	var operate = "";
	//简编
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"toCut('"+row+"')\">简编 </a>";
	operate = operate + "&nbsp;&nbsp;";
	
	//下发
	operate=operate+"<a href='javascript:;' class='operate-a' onclick=\"sendVideo('"+row.videoBackId+"')\">下发</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	//下载
	operate=operate+"<a href='"+row.videoUrl+";'  class='operate-a'>下载</a>";
	operate = operate + "&nbsp;&nbsp;";
	
	return operate;
}
/**
 * 管理标签
 */
function toCut(row){
	window.location.href = `${basePath}/videoSource/toVideoSourceEdit?videoBackId=${row.videoBackId}&activityId=${row.activityId}&type=videoBack`;
} 

function rowIndex(value, row,index){
	return index+1 ;
}

function convertTime(value,row,index) {
	let time = "";
	return time += resultFormatter(row.createTime);
}


function resultFormatter( timestamp){
    var oDate = new Date(timestamp),  
    oYear = oDate.getFullYear(),  
    oMonth = oDate.getMonth()+1,  
    oDay = oDate.getDate(),  
    oHour = oDate.getHours(),  
    oMin = oDate.getMinutes(),  
    oSen = oDate.getSeconds(),  
    oTime = oYear +'/'+ getzf(oMonth) +'/'+ getzf(oDay) +' '+ getzf(oHour) +':'+ getzf(oMin) +':';// 最后拼接时间
    return oTime;  
}

function getzf(num){  
	 if(parseInt(num) < 10){  
	     num = '0'+num;  
	  }  
	  return num;  
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
}
