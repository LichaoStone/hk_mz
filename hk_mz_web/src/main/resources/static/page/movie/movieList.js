var searchCollapseStatus = 0 ;
$(document).ready(function() {
	// 设置查询条件是否展开
	//initCollapseStatus();
	$("#select_img").click(function(){
		console.log($(this).prev());
		$(this).prev().click();
	});
	
	var searchCollapseStatus =0;
	$("#status").select2( {
		placeholder : "请选择",
		allowClear : true,
		minimumResultsForSearch : Infinity
	});
	//获取标签下拉列表
	getMovieTag();
	//获取电影列表
	getDetails();
	//初始化面包屑
	var data = [{"name":"电影","url":basePath+"movie/show_movie_list"}];
	window.parent.breadCrumb(data);
	//上传文件
	$("#importMovieBtn").on("change", function(){
		var imgfile;
	    imgfile=$("#importMovieBtn").val();
	    if(imgfile == null || imgfile == ''){
	       return false; 
	    }
	    var extImg = imgfile.substring(imgfile.lastIndexOf(".")+1,imgfile.length).toUpperCase();
	    if("XML" != extImg){
	    	toast("文件格式只能为XML",true,'error','top',400);
	        return false;                
	    }
	    $.ajax({
	        url: basePath+"movie/upload_movie",
	        type: 'POST',
	        cache: false,
	        data: new FormData($('#uploadImageForm')[0]),
	        processData: false,
	        contentType: false,
	        dataType:"json",
//	        beforeSend: function(){
//	            uploading = true;
//	        },
	        success : function(data) {
	        	if (data.ok == true) {
	            	refreshDataTable();
	            	toast(data.message,true,'succ','top',400);
	            } else {
	            	toast(data.message,true,'error','top',400);
	            }
	            //清空file的值
				var movieFile = document.getElementById('importMovieBtn');
				movieFile.value = ''; 
	        }
	    });
	});
	
});

/**
 * 初始化标签列表
 */
function getMovieTag() { 
    $("#movieTag").select2( {
		placeholder : "请选择",
		allowClear : true,
		//minimumResultsForSearch : Infinity
	});
    $.ajax({     
        "url": basePath+'tag/get_all_tag_list', 
      //  "type": "GET",
        //"async": false,
        "data": {
        	'tagType':'movie'
        },
        "success": function (result) {    
            var dataList=result.data;
            $("#movieTag").append("<option value=''></option>");
            $.each(dataList,function(i,item){
            	 var tagId = item.tagId;
            	 var tagName = item.tagName;
            	 $("#movieTag").append("<option value='" + tagId + "'>" +tagName + "</option>");
            })
        }
    });
}

/**
 * 获取电影列表
 */
function getDetails() {
	var url = basePath+"movie/get_movie_list";
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
				"startTime":$("#startTime").val(),
				"endTime":$("#endTime").val(),
				"movieName":$("#movieName").val(),
				"status":$("#status").val(),
				"movieTag":$("#movieTag").find("option:selected").text()
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
	 $("#movieName").val("");
	 $("#status").val("").trigger("change");
	 $("#movieTag").val("").trigger("change");
	 $("#datePick").val("");
	 $("#startTime").val("");
     $("#endTime").val("");
     refreshDataTable();
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
	operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"modifyMovie('"+row.movieId+"')\">编辑</a>";
	operate = operate + "&nbsp;&nbsp;"; 
	if(row.status==1 || row.status==2){
		operate = operate+"<a href='javascript:;' class='operate-a' onclick=\"modifyStatus('"+row.movieId+"','"+row.shopName+"','disable')\">下发</a>";

	}
	return operate;
}

/**
* 电影名称添加超链接
* @return
*/
function setTitle(value, row, index){
	var time = row.copyBeginTime
	var operate = "";
	operate = "<a href='javascript:;' class='detail-a' onclick=getDetail('"+row.movieId+"')>"+value+"</a>";
	return operate;
} 



/** 修改电影*/
//function modifyMovie(movieId){
//	var url = basePath + "movie/show_save_movie?movieId="+movieId ;
//	parent.openModal("添加用户", 800, 960, url,"");
//}
/** 修改电影*/
function modifyMovie(movieId){
	var url = basePath + "movie/show_save_movie?movieId="+movieId ;
	$("#form").attr("action",url);
	$("#form").submit();
}

/**
* 查看电影详情
*/
function getDetail(movieId){
	var url = basePath + "movie/show_movie_detail?movieId="+movieId ;
	parent.openModal("电影详情",900,780, url);
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
 * 导入电影
 */
function importMovie(){
	$("#importMovieBtn").val('');
	$("#importMovieBtn").click();
}

/**
 * 下发电影
 */
function pushMovie(){
	var checkids = [];
    checkids = getIdSelections();
    var ids =  checkids.join(',');
    //JSON.stringify(checkids)
    $.ajax({     
        "url": basePath+'downward_dispatch_source', 
      //  "type": "GET",
        //"async": false,
        "data": {
        	'type':'movie',
        	'ids':ids
        },
        "success": function (result) {  
        	if(result.ok){
        		
        	}else{
        		toast("请选择下发电影",true,'error','top',400);
        	}
        }
    });
}

//获取bootstrap-table checkbox选中movieId
function getIdSelections() {
    return $.map($("#dataTable").bootstrapTable('getSelections'), function(row) {
        return row.movieId
    })
}
