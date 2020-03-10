
/**
 * 初始化查询条件是否展开
 */
function initCollapse() {
	// 收缩查询框
	if (searchCollapseStatus == '0') {
		$("#search-btn-collapsed").show();
		$("#search-btn-collapsed-space").show();
		$("#searchCollapseStatus").val(searchCollapseStatus);
		$("#search-div-a").collapse("hide");
		$("#search-div").collapse("hide");
		$("#arrow").css("display","none");
		$("#arrow-border").css("display","none");
		$("#search-div-img").attr("src",basePath+"images/shuaixuan_xiajiantou.png");
		$("#search-div input").attr("disabled",true);
		$("#search-div select").prop("disabled", true);
		searchCollapseStatus = "1";

		// 展开查询框
	} else if (searchCollapseStatus == '1') {
		$("#search-btn-collapsed").hide();
		$("#search-btn-collapsed-space").hide();
		$("#searchCollapseStatus").val(searchCollapseStatus);
		$("#search-div-a").collapse("show");
		$("#search-div").collapse("show");
		$("#arrow").css("display","");
		$("#arrow-border").css("display","");
		$("#search-div-img").attr("src",basePath+"images/shuaixuan_shangjiantou.png");
		$("#search-div input").attr("disabled",false);
		$("#search-div select").prop("disabled", false);
		searchCollapseStatus = "0";
	}
	setTimeout("$('#search-div-a').css('display', 'block')", 500);
}
/**
 * 根据条件折叠展开查询框
 */
function changeCollapse() {
	// 收缩查询框
	if (searchCollapseStatus == '0') {
		$("#search-btn-collapsed").show();
		$("#search-btn-collapsed-space").show();
		$("#arrow").css("display","none");
		$("#arrow-border").css("display","none");
		$("#search-div-img").attr("src",basePath+"../images/select_img_arrow_close.png");
		$("#searchCollapseStatus").val(searchCollapseStatus);
		$("#search-div input").attr("disabled",true);
		$("#search-div select").prop("disabled", true);
		searchCollapseStatus = "1";

		// 展开查询框
	} else if (searchCollapseStatus == '1') {
		$("#search-btn-collapsed").hide();
		$("#search-btn-collapsed-space").hide();
		$("#arrow").css("display","");
		$("#arrow-border").css("display","");
		$("#search-div-img").attr("src",basePath+"images/select_img_arrow_open.png");
		$("#searchCollapseStatus").val(searchCollapseStatus);
		$("#search-div input").attr("disabled",false);
		$("#search-div select").prop("disabled", false);
		searchCollapseStatus = "0";
	}
}


/**
 * 数组indexOf 
 */
Array.prototype.indexOf = function (val) {
    for (var i = 0; i < this.length; i++) {
        if (this[i] == val) return i;
    }
    return -1;
};

/**
 * 数组remove 
 */
Array.prototype.remove = function (val) {
    var index = this.indexOf(val);
    if (index > -1) {
        this.splice(index, 1);
    }
};




/**
 * 获取用户下拉菜单数据
 * @param selectId 下拉菜单ID
 */
function getUserSelect(selectId){
	$.ajax( {
		type : "POST",
		url : basePath + "select/getUserSelect",
		timeout : 3600000,
		success : function(data,textStatus) {
			    var result=$.parseJSON(data); 
			    console.log(result);
			    
			    var htmlData=result.results.rows;
			    console.log(htmlData);
			    
			    var innerHtml="<option value='' >请选择</option>";
			    $.each(htmlData,function(i,item){
			    	 innerHtml+="<option value='"+item.id+"' >"+item.name+"</option>";
			    });
			    console.log("innerHtml="+innerHtml);
			    
			    
			    $("#"+selectId).html(innerHtml);
			    
				//下拉菜单：作者
				$("#"+selectId).select2( {
					placeholder : "请选择",
					allowClear : true
				});
		},
		error : function() {
			alert("Ajax请求失败,请及时联系管理员！");
		}
	});
}


/**
 * 获取分类下拉菜单数据
 * @param selectId 下拉菜单ID
 */
function getClassifySelect(selectId){
	$.ajax( {
		type : "POST",
		url : basePath + "select/getClassifySelect",
		timeout : 3600000,
		success : function(data,textStatus) {
			    var result=$.parseJSON(data); 
			    console.log(result);
			    
			    var htmlData=result.results.rows;
			    console.log(htmlData);
			    
			    var innerHtml="<option value='' >请选择</option>";
			    $.each(htmlData,function(i,item){
			    	 innerHtml+="<option value='"+item.id+"' >"+item.name+"</option>";
			    });
			    console.log("innerHtml="+innerHtml);
			    
			   
			    $("#"+selectId).html(innerHtml);
			    
			    
				$("#"+selectId).select2( {
					placeholder : "请选择",
					allowClear : true
				});
		},
		error : function() {
			alert("Ajax请求失败,请及时联系管理员！");
		}
	});
}


/**
 * 获取分类下拉菜单数据
 * @param selectId 下拉菜单ID
 * @param type 类型:视频标签：video,电视剧标签：tvplay,电影标签：movie
 */
function getTagsSelect(selectId,type){
	$.ajax( {
		type : "POST",
		url : basePath + "select/getTagsSelect?type="+type,
		timeout : 3600000,
		success : function(data,textStatus) {
			    var result=$.parseJSON(data); 
			    console.log(result);
			    
			    var htmlData=result.results.rows;
			    console.log(htmlData);
			    
			    var innerHtml="<option value='' >请选择</option>";
			    $.each(htmlData,function(i,item){
			    	 innerHtml+="<option value='"+item.id+"' >"+item.name+"</option>";
			    });
			    console.log("innerHtml="+innerHtml);
			    
			   
			    $("#"+selectId).html(innerHtml);
			    
			    // 下拉框：标签
				$("#"+selectId).select2( {
					placeholder : "请选择",
					allowClear : true
				});
		},
		error : function() {
			alert("Ajax请求失败,请及时联系管理员！");
		}
	});
}


function overwriteChekboxCss(){
	 //改变复选框样式
     $("#dataTable").find("input:checkbox").each(function(i,item){
	    console.log("item");
	    console.log(item);
	    
         var $check = $(this);
         if ($check.attr("id") && $check.next("label")) {
            return;
     	  }
 		
 		var   $label = "<img id='"+item.name+"_"+i+"'  data-id='"+i+"' name='"+item.name+"' data-index='"+i+"' style='width:18px;height:18px;' src='../images/xuankuang_xuhao.png' onclick=\"selectedTr('"+item.name+"_"+i+"')\" />";

	 	 $check.parent().append($label);
	 	 $check.remove();
	 	 
	 	 
	 	 
	 	 //var name = $check.attr("name");
	     //var id = name + "-" + i;
	     //var $label = $('<label for="'+ id +'"><img style=\"width:18px;height:18px;\" src=\"../images/xuankuang_xuhao.png\" /></label>');
	     //$check.attr("id", id).parent().addClass("bella-checkbox").append($label);
	     //liebiao_duihao_xuanzhong.png
 	})  
}
 
/**
 * 选择行
 */
function selectedTr(id){
	console.log(id);
	var name=$("#"+id).attr("name");
	console.log(name);
	
	if(name=="btSelectAll"){//全选
		$(".bs-checkbox").find("img").each(function(i,item){
			console.log(item);
			
			if($("#btSelectAll_0").hasClass("selected")){
				$(item).attr("src","../images/xuankuang_xuhao.png");
			}else{
				$(item).attr("src","../images/liebiao_duihao_xuanzhong.png");
			}
		});
		
		
		if($("#btSelectAll_0").hasClass("selected")){
			$("#btSelectAll_0").removeClass("selected");
		}else{
			$("#btSelectAll_0").addClass("selected");
		}
	}else{
		if($("#"+id).parent().parent().hasClass("selected")){
			$("#"+id).attr("src","../images/xuankuang_xuhao.png");
			$("#"+id).parent().parent().removeClass("selected");
			
			$("#btSelectAll_0").removeClass("selected");
			$("#btSelectAll_0").attr("src","../images/xuankuang_xuhao.png");
		}else{
			$("#"+id).attr("src","../images/liebiao_duihao_xuanzhong.png");
			$("#"+id).parent().parent().addClass("selected");
		}
		
	}
	
}

/**
 * 通用方法封装
 * <i>bootstrap-table插件拓展</i>
 * @author zhangyaomin
 */
(function ($) {
 
    /**
     *
     * @param selector jQuery选择器
     * @param options
     */
    $.initBootstrapTable = function (selector, options) {
        var defaults = {
            method: "get",
            dataType: "json",             // 返回格式（*）
            columns : [],
            detailView : false,           // 显示详情模式
            pagination: true,             // 是否显示分页（*）
            pageSize: 10,                 // 每页的记录行数（*）
            pageNumber: 1,                // 初始化加载第一页，默认第一页
            pageList: [10, 25, 50],       // 可供选择的每页的行数（*）
            search: false,                 // 是否显示搜索框功能
            singleSelect: false,          // 是否禁止多选
            iconSize: 'outline',          // 图标大小：undefined默认的按钮尺寸 xs超小按钮sm小按钮lg大按钮
            toolbar: '#tableToolbar',     // 指定工作栏
            sidePagination: "server",     // 启用服务端分页
            showRefresh: false,            // 是否显示刷新按钮
            showColumns: true,            // 是否显示隐藏某列下拉框
            showToggle: true,             // 是否显示详细视图和列表视图的切换按钮
            cache: false,                 // 是否使用缓存
            showFooter: false,            // 是否显示列脚
            showRefresh: false,            // 是否显示刷新按钮
 
            queryParams: function(params) {
                return {
                    // 传递参数查询参数
                    pageNo: (params.offset / params.limit) + 1,
                    limit:   params.limit
                };
            },
            responseHandler: function (result) {
                return {
                    total : result.total, //总页数,前面的key必须为"total"
                    rows : result.data //行数据，前面的key要与之前设置的dataField的值一致.
                };
            }
        };
        defaults = $.extend(true, defaults, options);
        defaults.onPostBody = function () {
            //改变复选框样式
            $(selector).find("input:checkbox").each(function (i) {
                var $check = $(this);
                if ($check.attr("id") && $check.next("label")) {
                    return;
                }
                var name = $check.attr("name");
                var id = name + "-" + i;
                var $label = $('<label for="'+ id +'"></label>');
                $check.attr("id", id).parent().addClass("bella-checkbox").append($label);
            });
            if ($.isFunction(options.onPostBody)) {
                options.onPostBody();
            }
        };
        $(selector).bootstrapTable(defaults);
    }
})(jQuery);




/**
 * 初始化时间选择器(日期区间选择)
 * 
 * @param datePickerId
 *            String 控件id
 * @param maxDate
 *            boolean 是否需要限制截止时间为当天 默认为true
 * @param timePicker
 *            boolean 是否需要显示时间 默认为false
 * @param ranges
 *            boolean 是否需要显示快捷区间选择 默认为true
 * @param dateLimit
 *            int 是否需要限制日期区间 默认为空，表示不限制;数字表示开始时间与截止时间相差天数
 * @param minDate
 *            boolean 是否设置最小时间为当前时间，默认（false）不设置,为true的时候，当前日期之前的时间不允许选择
 */
function initDateRangePicker(datePickerId, maxDate, timePicker, ranges, dateLimit,minDate){
	// 初始化时间选择器用到的json串
	var json = {
				showDropdowns: true,
				linkedCalendars: false,
				autoUpdateInput: false,
				timePicker: true,
				timePicker24Hour: true,
				maxDate: getDate(),
				applyClass: 'btn-datepicker-apply',
				locale: {
					format: 'YYYY/MM/DD HH:mm',
					separator: '-',
					applyLabel: '确定',
					cancelLabel: '清除',
					customRangeLabel: '自定义',
					daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
					monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
				},
				ranges: {
					"今天": [getDate()+' 00:00', getDate()+' 23:59'],
					"昨天": [getDate(-1)+' 00:00', getDate(-1)+' 23:59'],
					"最近7天": [getDate(-6)+' 00:00', getDate()+' 23:59'],
					"最近30天": [getDate(-29)+' 00:00', getDate()+' 23:59'],
					"本月": [getDateOfMonth()+' 00:00', getDateOfMonth(1)+' 23:59']
				}};

	// 不限制截止时间
	if (maxDate == false) {
		delete json['maxDate'];
	}
	
	// 不需要显示时间
	var format = "YYYY/MM/DD HH:mm";
	if (timePicker == null || timePicker == false) {
		delete json['timePicker'];
		delete json['timePicker24Hour'];
		format = "YYYY/MM/DD";
		json['locale'] = {
						    format: format,
							separator: '-',
							applyLabel: '确定',
							cancelLabel: '清除',
							customRangeLabel: '自定义',
							daysOfWeek: ['日', '一', '二', '三', '四', '五', '六'],
							monthNames: ['1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12']
						};
		json['ranges'] = {
						"今天": [getDate(), getDate()],
						"昨天": [getDate(-1), getDate(-1)],
						"最近7天": [getDate(-6), getDate()],
						"最近30天": [getDate(-29), getDate()],
						"本月": [getDateOfMonth(), getDateOfMonth(1)]
						};
	}

	// 不显示日期快捷选择
	if (ranges == false) {
		delete json['ranges'];
	}

	// 需要限制日期区间
	if (dateLimit != null) {
		json['dateLimit'] = {'days':dateLimit};
	}
	
	if (minDate) {
		var date = new Date();
		var year=date.getFullYear(); //获取完整的年份(4位)
		var month=date.getMonth()+1; //获取当前月份(0-11,0代表1月)
		var date=date.getDate(); //获取当前日(1-31)
		if(month<10){
			month="0"+month;
		}
		
		if(date<10){
			date="0"+date;
		}
		var minDateData=year+"/"+month+"/"+date+" 00:00";
		console.log(minDateData);
		json['minDate'] = minDateData;
		
		//var maxDateData=year+"/"+month+"/"+date+" 23:59";
		//json['maxDate'] = maxDateData;
	}
	
	
	// 初始化时间选择器
	$("#" + datePickerId).daterangepicker(json);
	$("#" + datePickerId).on('apply.daterangepicker', function(ev, picker) {
		$(this).val(picker.startDate.format(format) + '-' + picker.endDate.format(format));
	}).on('cancel.daterangepicker', function(ev, picker) {
		$(this).val('');
	});
	$(".datepicker-i").click(function() {
		$(this).parent().find("input").focus();
		$(this).parent().find("input").click();
	});
}