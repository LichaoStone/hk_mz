var searchCollapseStatus = 0 ;
$(document).ready(function() {
	searchCollapseStatus =0;
	$("#tvplayTag").select2( {
		placeholder : "请选择",
		allowClear : true,
		minimumResultsForSearch : Infinity
	});
	//获取标签下拉列表
	getTvplayTag();
	//获取电视剧下拉列表
	getDetails();
	//初始化面包屑
	var data = [{"name":"电视剧","url":basePath+"tvplay/show_tvplay_list"}];
	window.parent.breadCrumb(data);
	//上传电视剧剧头
	$("#importTvplayBtn").on("change", function(){
		var imgfile;
	    imgfile=$("#importTvplayBtn").val();
	    if(imgfile == null || imgfile == ''){
	       return false; 
	    }
	    var extImg = imgfile.substring(imgfile.lastIndexOf(".")+1,imgfile.length).toUpperCase();
	    if("XML" != extImg){
	    	toast("文件格式只能为XML",true,'error','top',400);
	        return false;                
	    }
	    $.ajax({
	        url: basePath+"tvplay/upload_tvplay",
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
				var tvplayFile = document.getElementById('importTvplayBtn');
				tvplayFile.value = ''; 
	        }
	    });
	});
	
});

/**
 * 初始化标签列表
 */
function getTvplayTag() { 
    $("#tvplayTag").select2( {
		placeholder : "请选择",
		allowClear : true,
		//minimumResultsForSearch : Infinity
	});
    $.ajax({     
        "url": basePath+'tag/get_all_tag_list', 
      //  "type": "GET",
        //"async": false,
        "data": {
        	'tagType':'tvplay'
        },
        "success": function (result) {    
            var dataList=result.data;
            $("#tvplayTag").append("<option value=''></option>");
            $.each(dataList,function(i,item){
            	 var tagId = item.tagId;
            	 var tagName = item.tagName;
            	 $("#tvplayTag").append("<option value='" + tagId + "'>" +tagName + "</option>");
            })
        }
    });
}

/**
 * 获取电视剧列表
 */
function getDetails() {
	var url = basePath+"tvplay/get_tvplay_list";
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
				"tvplayName":$("#tvplayName").val(),
				"startTime":$("#startTime").val(),
				"endTime":$("#endTime").val(),
				"tvplayTag":$("#tvplayTag").find("option:selected").text()
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
	 $("#tvplayName").val("");
	 $("#tvplayTag").val("").trigger("change");
	 $("#datePick").val("");
	 $("#startTime").val("");
     $("#endTime").val("");
     refreshDataTable();
} 	


/**操作消息*/
function showMessage(){
	toast("aaaaa",true,'error','top',400);	
	//alert(2);
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
	operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"modifytvplay('"+row.tvplayId+"')\">编辑</a>";
	operate = operate + "&nbsp;&nbsp;"; 
	operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"xiafa('"+row.tvplayId+"')\">下发</a>";
	operate = operate + "&nbsp;&nbsp;"; 
	operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"manageTvplayEpisode('"+row.tvplayId+"')\">管理子集</a>";
	return operate;
}

/**
* 电视剧名称添加超链接
* @return
*/
function setTitle(value, row, index){
	var operate = "";
	operate = "<a href='javascript:;' class='detail-a' onclick=getDetail('"+row.tvplayId+"')>"+value+"</a>";
	return operate;
} 

/**
 * setTvplayNum  导入集数/总剧集
 */
function setTvplayNum (value, row, index){
	var operate = "";
	var importNum=0;
	if(row.importNum){
		importNum=row.importNum;
	}
	operate = importNum+"/"+row.tvplayNum;
	return operate;
} 

/** 修改电视剧*/
function modifytvplay(tvplayId){
	var url = basePath + "tvplay/show_save_tvplay?tvplayId="+tvplayId ;
	$("#form").attr("action",url);
	$("#form").submit();
}

/**
* 查看电视剧详情
*/
function getDetail(tvplayId){
	var url = basePath + "tvplay/show_tvplay_detail?tvplayId="+tvplayId ;
	parent.openModal("查看",900,780, url);
} 

/** 管理子集*/
function manageTvplayEpisode(tvplayId,tvplayName){
	var url = basePath + "tvplayEpisode/show_tvplayEpisode_list?tvplayId="+tvplayId;
	$("#form").attr("action",url);
	$("#form").submit();
}

function rowIndex(value, row,index){
	return index+1 ;
}
/**
 * 导入电视剧剧头
 */
function importTvplay(){
	$("#importTvplayBtn").click();
}

/**
 * 下发剧头
 */
function pushTvplay(){
	var checkids = [];
    checkids = getIdSelections();
    var ids =  checkids.join(',');
    //JSON.stringify(checkids)
    $.ajax({     
        "url": basePath+'downward_dispatch_source', 
      //  "type": "GET",
        //"async": false,
        "data": {
        	'type':'tvplay',
        	'ids':ids
        },
        "success": function (result) {  
        	if(result.ok){
        		
        	}else{
        		toast("请选择下发剧头",true,'error','top',400);
        	}
        }
    });
}

//获取bootstrap-table checkbox选中movieId
function getIdSelections() {
    return $.map($("#dataTable").bootstrapTable('getSelections'), function(row) {
        return row.tvplayId
    })
}