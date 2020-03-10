var searchCollapseStatus = 0 ;
$(document).ready(function() {
	// 设置查询条件是否展开
	$("#status").select2( {
		placeholder : "请选择",
		allowClear : true,
		minimumResultsForSearch : Infinity
	});
	getDetails();
	//初始化面包屑
	var data = [{"name":"电视剧","url":basePath+"tvplay/show_tvplay_list"},{"name":"子集列表","url": basePath + "tvplayEpisode/show_tvplayEpisode_list?tvplayId="+tvplayId}];
	window.parent.breadCrumb(data);
	//上传文件
	$("#importTvplayEpisodeBtn").on("change", function(){
		var imgfile;
	    imgfile=$("#importTvplayEpisodeBtn").val();
	    if(imgfile == null || imgfile == ''){
	       return false; 
	    }
	    var extImg = imgfile.substring(imgfile.lastIndexOf(".")+1,imgfile.length).toUpperCase();
	    if("XML" != extImg){
	    	toast("文件格式只能为XML",true,'error','top',400);
	        return false;                
	    }
	    var tvplayId = $("#tvplayId").val();
	    $.ajax({
	        url: basePath+"tvplayEpisode/upload_tvplayEpisode?tvplayId="+tvplayId,
	        type: 'POST',
	        cache: false,
	        data: new FormData($('#uploadImageForm')[0]),
	        processData: false,
	        contentType: false,
	        dataType:"json",
//		        beforeSend: function(){
//		            uploading = true;
//		        },
	        success : function(data) {
	        	if (data.ok == true) {
	            	refreshDataTable();
	            	toast(data.message,true,'succ','top',400);
	            } else {
	            	toast(data.message,true,'error','top',400);
	            }
	            //清空file的值
				var tvplayEpisodeFile = document.getElementById('importTvplayEpisodeBtn');
				tvplayEpisodeFile.value = ''; 
	        }
	    });
	});
	
});

/**
 * 获取电影列表
 */
function getDetails() {
	var tvplayId = $("#tvplayId").val();
	var url = basePath+"tvplayEpisode/get_tvplayEpisode_list?tvplayId="+tvplayId;
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
/**
 * 设置查询条件
 */
function queryParams(params) {
	var json = {"offset":params.offset,
				"pageSize":params.limit,
				"episodeName":$("#episodeName").val(),
				"startTime":$("#startTime").val(),
				"endTime":$("#endTime").val(),
				"status":$("#status").val()
				}
	return json;
}
/**
 * 根据当前页面选项，刷新列表
 */
function refreshDataTable(){
	$('#dataTable').bootstrapTable('refresh');
}

/**
* 重置查询条件
* @return
*/
function resetVal() {
	 //$("#appInformationKey").val("").trigger("change");
	 $("#episodeName").val("");
	 $("#tvplayTag").val("").trigger("change");
	 $("#datePick").val("请选择日期范围");
	 $("#startTime").val("");
     $("#endTime").val("");
     refreshDataTable();
} 	

/**
 * 根据条件折叠展开查询框
 */
function expandQueryBox() {
	// 收缩查询框
	if (searchCollapseStatus == '0') {
		$(".text").text("精简检索");
		$("#search-div-img").attr("src",basePath+"/images/up_point.png");
		$("#search-div").show();
		$("#search-div").css("display","block");
		$(".search_div_btn").hide();
		searchCollapseStatus = "1";

		// 展开查询框
	} else if (searchCollapseStatus == '1') {
		$(".text").text("高级检索");
		$("#search-div-img").attr("src",basePath+"/images/down_point.png");
		$("#search-div").hide();
		$(".search_div_btn").show();
		searchCollapseStatus = "0";
	}
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
	operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"modifyTvplayEpisode('"+row.tvplayEpisodeId+"')\">编辑</a>";
	operate = operate + "&nbsp;&nbsp;"; 
	if(row.status=="2"){
		operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"modifyStatus('"+row.shopKey+"','"+row.shopName+"','disable')\">入库</a>";
	}else if(row.status=="3"){
		operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"xiafa('"+row.shopKey+"','"+row.shopName+"','disable')\">下发</a>";
	}
	return operate;
}

/**
* 电影名称添加超链接
* @return
*/
function setTitle(value, row, index){
	var operate = "";
	operate = "<a href='javascript:;' class='detail-a' onclick=getDetail('"+row.tvplayEpisodeId+"')>"+value+"</a>";
	return operate;
} 



/** 修改电影*/
function modifyTvplayEpisode(tvplayEpisodeId){
	var url = basePath + "tvplayEpisode/show_save_tvplayEpisode?tvplayEpisodeId="+tvplayEpisodeId ;
	$("#form").attr("action",url);
	$("#form").submit();
}

/**
* 查看电影详情
*/
function getDetail(tvplayEpisodeId){
	var url = basePath + "tvplayEpisode/show_tvplayEpisode_detail?tvplayEpisodeId="+tvplayEpisodeId ;
	parent.openModal("查看",900,780, url);
} 


/**
 * 入库状态：0未入库，1入库中，2入库失败，3入库成功
 */
function formatStatus(value, row){
	if(value == 0){
		return '未入库';
	}else if(value == 1){
		return '入库中';
	}else if(value == 2){
		return '入库失败';
	}else if(value == 3){
		return '入库成功';
	}
	return '' ;
}
function rowIndex(value, row,index){
	return index+1 ;
}
/**
 * 导入电视剧剧集
 */
function importTvplayEpisode(){
	$("#importTvplayEpisodeBtn").val('');
	$("#importTvplayEpisodeBtn").click();
}

/**
 * 下发剧集
 */
function pushTvplayEpisode(){
	var checkids = [];
    checkids = getIdSelections();
    var ids =  checkids.join(',');
    //JSON.stringify(checkids)
    $.ajax({     
        "url": basePath+'downward_dispatch_source', 
      //  "type": "GET",
        //"async": false,
        "data": {
        	'type':'tvplayEpisode',
        	'ids':ids
        },
        "success": function (result) {  
        	if(result.ok){
        		
        	}else{
        		toast("请选择下发剧集",true,'error','top',400);
        	}
        }
    });
}

//获取bootstrap-table checkbox选中movieId
function getIdSelections() {
    return $.map($("#dataTable").bootstrapTable('getSelections'), function(row) {
        return row.tvplayEpisodeId
    })
}


