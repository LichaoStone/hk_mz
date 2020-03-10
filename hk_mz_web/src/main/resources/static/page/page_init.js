/**
 * 页面通用方法，单点登录验证使用
 */
$(document).ready(function() {
	//日期空间初始化
	$("#datePick").daterangepicker(
		 {
		        // autoApply: true,
		        //autoUpdateInput: true,
		        // alwaysShowCalendars: true,
	            showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
	            autoUpdateInput:false,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
	            timePicker24Hour :true,//设置小时为24小时制 默认false
	            timePicker :true,//可选中时分 默认false
		        ranges: {
		            '今天': [moment(),moment()],
		            '昨天': [moment().subtract(1, 'days'),moment().subtract(1, 'days')],
		            '近7天': [moment().subtract(7, 'days'), moment()],
		            '这个月': [moment().startOf('month'), moment().endOf('month')],
		            '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
		        },
		        locale: {
		            format: "YYYY/MM/DD HH:MM:SS",
		            separator: " - ",
		            applyLabel: "确认",
		            cancelLabel: "清空",
		            fromLabel: "开始时间",
		            toLabel: "结束时间",
		            customRangeLabel: "自定义",
		            daysOfWeek: ["日","一","二","三","四","五","六"],
		            monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
		        },
		        applyClass:  "date-btn-success"
		     }
	     ).on('cancel.daterangepicker', function(ev, picker) {
	         $("#datePick").val("");
	         $("#startTime").val("");
	         $("#endTime").val("");
	     }).on('apply.daterangepicker', function(ev, picker) {
	    	 $(".tips").css('display','none'); 
	         $("#startTime").val(picker.startDate.format('YYYY-MM-DD HH:mm:ss'));
	         $("#endTime").val(picker.endDate.format('YYYY-MM-DD HH:mm:ss'));
	         $("#datePick").val(picker.startDate.format('YYYY-MM-DD HH:mm:ss')+"-"+picker.endDate.format('YYYY-MM-DD HH:mm:ss'));
	 });
	
	//日期空间初始化
		$("#singleDatePick").daterangepicker(
			 {
			        // autoApply: true,
			        //autoUpdateInput: true,
			        // alwaysShowCalendars: true,
				 	singleDatePicker: true,//设置为单个的datepicker，而不是有区间的datepicker 默认false
		            showDropdowns: true,//当设置值为true的时候，允许年份和月份通过下拉框的形式选择 默认false
		            autoUpdateInput:false,//1.当设置为false的时候,不给与默认值(当前时间)2.选择时间时,失去鼠标焦点,不会给与默认值 默认true
		            timePicker24Hour :true,//设置小时为24小时制 默认false
		            timePicker :true,//可选中时分 默认false
			        ranges: {
			            '今天': [moment(),moment()],
			            '昨天': [moment().subtract(1, 'days'),moment().subtract(1, 'days')],
			            '近7天': [moment().subtract(7, 'days'), moment()],
			            '这个月': [moment().startOf('month'), moment().endOf('month')],
			            '上个月': [moment().subtract(1, 'month').startOf('month'), moment().subtract(1, 'month').endOf('month')]
			        },
			        locale: {
			            format: "YYYY/MM/DD HH:MM:SS",
			            separator: " - ",
			            applyLabel: "确认",
			            cancelLabel: "清空",
			            fromLabel: "开始时间",
			            toLabel: "结束时间",
			            customRangeLabel: "自定义",
			            daysOfWeek: ["日","一","二","三","四","五","六"],
			            monthNames: ["一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"]
			        },
			        applyClass:  "date-btn-success"
			     }
		     ).on('cancel.daterangepicker', function(ev, picker) {
		         $("#singleDatePick").val("");
		     }).on('apply.daterangepicker', function(ev, picker) {
		    	 $(".tips").css('display','none'); 
		         $("#singleDatePick").val(picker.startDate.format('YYYY-MM-DD HH:mm:ss'));
		 });
	
	
});
/** 日期控件单击事件*/
//$('#datePick').daterangepicker(options, function(start, end, label) { 
//    console.log('New date range selected: ' + start.format('YYYY-MM-DD') + ' to ' + end.format('YYYY-MM-DD') + ' (predefined range: ' + label + ')'); 
//}).click();

function getPageScollTop(){
	return window.scrollY?window.scrollY:window.pageYOffset?window.pageYOffset:document.documentElement.scrollTop?document.documentElement.scrollTop:document.body.scrollTop?document.body.scrollTop:10
}

/**
 * 日期格式化
 */
function formatDate(time){
    if (time == '' || time == null || time == undefined) return '';
    var dateStr = time.split(" ");
    var strGMT = dateStr[0]+" "+dateStr[1]+" "+dateStr[2]+" "+dateStr[5]+" "+dateStr[3]+" GMT+0800";
    var dateData = new Date(Date.parse(strGMT));
    var dateTime = new Date();
    dateTime.setTime(dateData);
    var year = dateTime.getFullYear();
    var month = (dateTime.getMonth()+1) < 10 ? '0'+(dateTime.getMonth()+1):(dateTime.getMonth()+1);
    var day = dateTime.getDate() < 10 ? '0'+dateTime.getDate():dateTime.getDate();
	var hour = dateTime.getHours() < 10 ? '0'+dateTime.getHours():dateTime.getHours();
	var minute = dateTime.getMinutes() < 10 ? '0'+dateTime.getMinutes():dateTime.getMinutes();
	var second = dateTime.getSeconds() < 10 ? '0'+dateTime.getSeconds():dateTime.getSeconds();
    return year+'-'+ month +'-'+day+' ' + hour+':'+minute+':'+second;
}


/**
 * 页面跳转方法封装
 * 
 * @param src
 */
function windowHref(src) {
	var url = src;
	if (url.indexOf(".do") > 0) {
		var param = url.substring(url.lastIndexOf(".do") + 3);
		if (param == "") {
			param = param + "?";
		} else {
			param = param + "&";
		}
		param = param + "userKeyForUinon="+userKeyForUinon+"&onlyOneUserLoginFlag="+onlyOneUserLoginFlag;
		url = url.substring(0, url.lastIndexOf(".do") + 3) + param;
	}
	location.href=url;
}

/**
 * 设置页面表头标题
 * 
 * @param mainHeader
 *            主标题
 * @param subHeader
 *            副标题（如果没有，可不传）
 */
function setHeaderText(mainHeader, subHeader) {
	if (mainHeader != "") {
		//$("#mainHeader").html(mainHeader);
		//$("#subHeader").html(subHeader);
		// $("#container-header-text").show();
	}
	
}

function setInitBreadCrumb(){
	parent.items=[];
	parent.items.push({title:document.title,url:window.location.href});
}

/**
 * 隐藏层
 */
function undisplay() {
	$("#loading-mask").css({display:"none"});
	$("#loading").css({display:"none"});
}
/**
 * 显示层
 */
function display() {
	$("#loading-mask").css({display:""});
	$("#loading").css({display:""});
}

/**
 * 计算加载菊花的高度值
 */
function resizeHeight() {

	// 计算带滚动条的高度
	var scrollTop=0;
	if(document.documentElement&&document.documentElement.scrollTop) {
		scrollTop=document.documentElement.scrollTop;
	} else if (document.body) {
		scrollTop=document.body.scrollTop;
	}
}

/**
 * 初始化查询条件是否展开
 */
function initCollapseStatusOld() {
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
function changeCollapseStatusOld() {

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
 * 根据条件折叠展开查询框
 */
function expandQueryBox() {
	// 收缩查询框
	if (searchCollapseStatus == '0') {
		$(".text").text("精简检索");
		$("#search-div-img").attr("src",basePath+"/images/up_point.png");
		$("#search-div").collapse("show");
		//$("#search-div").css("display","block");
		$(".search_div_btn").hide();
//		$(".search_div_btn").collapse("hide");
		$(".search-input-container").css("width","410px");
		searchCollapseStatus = "1";

		// 展开查询框
	} else if (searchCollapseStatus == '1') {
		$(".text").text("高级检索");
		$("#search-div-img").attr("src",basePath+"/images/down_point.png");
		$("#search-div").collapse("hide");
		//$("#search-div").css("display","none");
		$(".search_div_btn").show();
//		$(".search_div_btn").collapse("show");
		$(".search-input-container").css("width","485px");
		searchCollapseStatus = "0";
	}
}



/**
 * 按天获取时间
 * 
 * @param addDayCount
 *            计算天数 不传或传入0为获取当前时间
 * @param format
 *            日期格式化 默认为‘YYYY/MM/DD’
 */
function getDate(addDayCount, format) {
	var myDate;
	if (addDayCount != null) {
		myDate = moment().add(addDayCount, 'days');
	} else {
		myDate = moment();
	}

	// 设置分隔符
	var tmpFormat = "YYYY/MM/DD";
	if (format != null && format != "") {
		tmpFormat = format;
	}
	return myDate.format(tmpFormat);
}

/**
 * 按天获取时间
 * 
 * @param addDayCount
 *            计算天数 不传或传入0为获取当前时间
 * @param format
 *            日期格式化 默认为‘YYYY/MM/DD’
 */
function getDateTime(addDayCount, format) {
	var myDate;
	if (addDayCount != null) {
		myDate = moment().add(addDayCount, 'minutes');
	} else {
		myDate = moment();
	}

	// 设置分隔符
	var tmpFormat = "YYYY/MM/DD HH:mm";
	if (format != null && format != "") {
		tmpFormat = format;
	}
	return myDate.format(tmpFormat);
}

/**
 * 按月获取时间第一天或最后一天(当前月只能获取到当前日期)
 * 
 * @param dayType
 *            日期类型，0为获取第一天；1为获取最后一天 不传默认为取第一天
 * @param addMonthCount
 *            计算月数 不传或传入0为获取当前时间
 * @param format
 *            日期格式化 默认为‘YYYY/MM/DD’
 */
function getDateOfMonth(dayType,addMonthCount, format) {
	var myDate;
	if (addMonthCount != null) {
		myDate = moment().add(addMonthCount, 'months');
	} else {
		myDate = moment();
	}

	// 获取最后一天
	if (dayType != null && dayType == 1) {

		// 非本月，获取最后一天
		if (addMonthCount != null && addMonthCount != 0) {
			myDate = myDate.date(myDate.daysInMonth());

			// 本月，获取当前日期
		} else {
			myDate = myDate.date(myDate.date());
		}

		// 获取第一天
	} else {
		myDate = myDate.date(1);
	}

	// 设置分隔符
	var tmpFormat = "YYYY/MM/DD";
	if (format != null && format != "") {
		tmpFormat = format;
	}
	return myDate.format(tmpFormat);
}

/**
 * 按天获取时间
 * 
 * @param addDayCount
 *            计算天数 不传或传入0为获取当前时间
 * @param format
 *            日期格式化 默认为‘YYYY/MM/DD’
 */
function addDate(originDate, addDayCount, format) {
	var myDate;
	if (addDayCount != null) {
		myDate = moment(originDate).add(addDayCount, 'days');
	} else {
		myDate = moment(originDate);
	}

	// 设置分隔符
	var tmpFormat = "YYYY/MM/DD";
	if (format != null && format != "") {
		tmpFormat = format;
	}
	return myDate.format(tmpFormat);
}

/**
 * 重写提示
 * 
 * @param id
 *            控件id
 * @param msg
 *            提示信息
 * @return
 */
function getTip(id,msg,left){
	
	var type = $("#" + id)[0].type;
	
	var flag = false;
	
	switch (type) {
	case "text":
		
		var val = $.trim($("#"+id).val());
		
		if(null != val && val.length > 0){
			
			flag = true;
			
		}
		
		
	break;
	case "hidden":
		
		var val = $.trim($("#"+id).val());
		
		if(null != val && val.length > 0){
			
			flag = true;
			
		}
		
		
	break;
	case "checkbox":
		
		var name = $("#" + id)[0].name;
		
		if(null != name && undefined != name){
			
			var len = $("input[type='checkbox'][name='" + name + "']:checked").length;
			
			flag = len > 0 ? true : false;
			
		}
		
		
	break;
		
	case "radio":
		
		var name = $("#" + id)[0].name;
		
		if(null != name && undefined != name){
			
			var len = $("input[type='radio'][name='" + name + "']:checked").length;
			
			flag = len > 0 ? true : false;
			
		}
		
		
	break;
	
	default:
		
		var bq = $('#'+id).get(0).tagName.toLocaleLowerCase();
		
		if("textarea" == bq){
			
			var val = $.trim($("#"+id).val());
			
			if(null != val && val.length > 0){
				
				flag = true;
				
			}
			
		}
		
		break;
	}
		
	var obj = ($("#"+id).parent()).find("div[class='tips']");
	
	
	if(undefined != obj){
		
		obj.remove();
		
	}
	
	if(!(typeof left === 'number')){
		
		left = 0;
		
	}
	
	
	if(!flag){
		
		$("#"+id).parent().append("<div class=\"tips\" style = \"display:block;color:#A94442;margin-left:" + left + "px;height:24px;line-height:24px;\">" + msg + "</div>");
		
	}
	
	$("button[type='submit']").removeAttr("disabled");
	
	return flag;
	
}

/**
 * 弹框 content 显示内容 flag 是否自动关闭 true 3s后自动关闭 false 不自动关闭 默认自动关闭
 */
function Alert(content,flag){

	flag = typeof flag === 'boolean' ? flag : true;
	
	$("#Alert span:nth-child(1)").text(content);
	
	$("#Alert").show();
	$("#Alert").transition({ opacity: 1, y: '0px' }, 0, 'linear');

	var width = $("#Alert").width() * 1;
	
	if(width > 0){
			
		$("#Alert").css({'margin-left': (0 - width/2 - 23) + 'px'});
			
	}
	
	if(flag){

		 setTimeout(function(){
			 
			 setTimeout(function(){
				 
				 $("#Alert span:nth-child(1)").text("");
				 $("#Alert").hide();
				 
			 },500);
			 
			 $("#Alert").transition({ opacity: 0, y: '0px' }, 500, 'linear');
			
				
			},2500);
		
	}
	
}

/**
 * 关闭提示框
 * 
 * @return
 */
function closeAlert(){

	 setTimeout(function(){
		 
		 $("#Alert span:nth-child(1)").text("");
		 $("#Alert").hide();
		 
	 },500);
	 
	 $("#Alert").transition({ opacity: 0, y: '0px' }, 500, 'linear');
	
}

function alertMsg(msg, mode, fn) { // mode为空，即只有一个确认按钮，mode为1时有确认和取消两个按钮
	msg = msg || '';
	mode = mode || 0;
	fn = fn || '';
	var top = document.body.scrollTop || document.documentElement.scrollTop;
	var isIe = (document.all) ? true : false;
	var isIE6 = isIe && !window.XMLHttpRequest;
	var sTop = document.documentElement.scrollTop || document.body.scrollTop;
	var sLeft = document.documentElement.scrollLeft || document.body.scrollLeft;
	var winSize = function() {
		var xScroll, yScroll, windowWidth, windowHeight, pageWidth, pageHeight;
		// innerHeight获取的是可视窗口的高度，IE不支持此属性
		if (window.innerHeight && window.scrollMaxY) {
			xScroll = document.body.scrollWidth;
			yScroll = window.innerHeight + window.scrollMaxY;
		} else if (document.body.scrollHeight > document.body.offsetHeight) { // all
																				// but
																				// Explorer
																				// Mac
			xScroll = document.body.scrollWidth;
			yScroll = document.body.scrollHeight;
		} else { // Explorer Mac...would also work in Explorer 6 Strict,
					// Mozilla and Safari
			xScroll = document.body.offsetWidth;
			yScroll = document.body.offsetHeight;
		}

		if (self.innerHeight) { // all except Explorer
			windowWidth = self.innerWidth;
			windowHeight = self.innerHeight;
		} else if (document.documentElement
				&& document.documentElement.clientHeight) { // Explorer 6 Strict
															// Mode
			windowWidth = document.documentElement.clientWidth;
			windowHeight = document.documentElement.clientHeight;
		} else if (document.body) { // other Explorers
			windowWidth = document.body.clientWidth;
			windowHeight = document.body.clientHeight;
		}

		// for small pages with total height less then height of the viewport
		if (yScroll < windowHeight) {
			pageHeight = windowHeight;
		} else {
			pageHeight = yScroll;
		}

		// for small pages with total width less then width of the viewport
		if (xScroll < windowWidth) {
			pageWidth = windowWidth;
		} else {
			pageWidth = xScroll;
		}

		return {
			'pageWidth' : pageWidth,
			'pageHeight' : pageHeight,
			'windowWidth' : windowWidth,
			'windowHeight' : windowHeight
		}
	}();
	// alert(winSize.pageWidth);
	// 遮罩层
	var styleStr = 'top:0;left:0;position:absolute;z-index:10000;background:#666;width:100%;'
			+ 'height:100%;'
	styleStr += (isIe) ? "filter:alpha(opacity=60);" : "opacity:0.6;"; // 遮罩层DIV
	var shadowDiv = document.createElement('div'); // 添加阴影DIV
	shadowDiv.style.cssText = styleStr; // 添加样式
	shadowDiv.id = "shadowDiv";
	// 如果是IE6则创建IFRAME遮罩SELECT
	if (isIE6) {
		var maskIframe = document.createElement('iframe');
		maskIframe.style.cssText = 'width:100%;'
				+ 'height:100%;'
				+ 'position:absolute;visibility:inherit;z-index:-1;filter:alpha(opacity=0);';
		maskIframe.frameborder = 0;
		maskIframe.src = "about:blank";
		shadowDiv.appendChild(maskIframe);
	}
	document.body.insertBefore(shadowDiv, document.body.firstChild); // 遮罩层加入文档
	// 弹出框
	var styleStr1 = 'display:block;position:fixed;_position:absolute;height: auto;left:'
			+ (winSize.windowWidth / 2 - 200) + 'px;top:'
			+ (winSize.windowHeight / 2 - 150) + 'px;_top:'
			+ (winSize.windowHeight / 2 + top - 150) + 'px;'; // 弹出框的位置
	var alertBox = document.createElement('div');
	alertBox.id = 'alertMsg';
	alertBox.style.cssText = styleStr1;
	// 创建弹出框里面的内容P标签
	var alertMsg_info = document.createElement('P');
	alertMsg_info.id = 'alertMsg_info';
	alertMsg_info.innerHTML = msg;
	alertBox.appendChild(alertMsg_info);
	// 创建按钮
	var btn1 = document.createElement('a');
	btn1.id = 'alertMsg_btn1';
	btn1.href = 'javascript:void(0)';
	btn1.innerHTML = '<cite>确定</cite>';
	btn1.onclick = function() {
		document.body.removeChild(alertBox);
		document.body.removeChild(shadowDiv);
		if (fn != '') {
			fn();
		}
		return true;
	};
	alertBox.appendChild(btn1);
	if (mode === 1) {
		var btn2 = document.createElement('a');
		btn2.id = 'alertMsg_btn2';
		btn2.href = 'javascript:void(0)';
		btn2.innerHTML = '<cite>取消</cite>';
		btn2.onclick = function() {
			document.body.removeChild(alertBox);
			document.body.removeChild(shadowDiv);
			return false;
		};
		alertBox.appendChild(btn2);
	}
	document.body.insertBefore(alertBox, document.body.firstChild);
// document.body.appendChild(alertBox);

}

/**
 * 跳转到登录页
 */
function goLoginPage() {
	window.parent.location.href=basePath+'index.jsp';
}

/**
 * 查询列表帮助信息初始化
 * 
 * @param id
 * @param content
 * @param content_X
 * @param content_Y
 * @param arrow_X
 * @param arrow_Y
 * @param width
 * @param height
 */
function initHelpBlock(id, content, content_X, content_Y, arrow_X, arrow_Y, width, height) {

	// 添加前删除之前初始化元素
	$("#"+id).empty();
	$("#"+id).parent().find(".help-span-arrow").remove();
	$("#"+id).parent().find(".help-span-arrow-border").remove();
	$("#"+id).parent().find(".help-span-content").remove();

	// 添加帮助图标
	$("#"+id).append("<img src='"+basePath+"images/ic_help1.png'></img>");

	// 添加帮助内容
	$("#"+id).parent().append("<div type='help' class='help-span-arrow' style='display: none;'></div>");
	$("#"+id).parent().append("<div type='help' class='help-span-arrow-border' style='display: none;'></div>");
	$("#"+id).parent().append("<div type='help' class='help-span-content' style='display: none;'>"+content+"</div>");

	// 宽度自定义
	if (width != null && width != "") {
		$("#"+id).parent().find(".help-span-content").css("width", width);
	}

	// 高度自定义
	if (height != null && height != "") {
		$("#"+id).parent().find(".help-span-content").css("height", height);
	}

	// 内容x轴位置自定义
	if (content_X != null && content_X != "") {
		var content_x = $("#"+id).parent().find(".help-span-content").css("margin-left");
		$("#"+id).parent().find(".help-span-content").css("margin-left", (parseInt(content_x.substring(0, content_x.indexOf("px")))+content_X) + "px");
	}

	// 内容y轴位置自定义
	if (content_Y != null && content_Y != "") {
		var content_y = $("#"+id).parent().find(".help-span-content").css("margin-top");
		$("#"+id).parent().find(".help-span-content").css("margin-top", (parseInt(content_y.substring(0, content_y.indexOf("px")))+content_Y) + "px");
	}

	// 箭头x轴位置自定义
	if (arrow_X != null && arrow_X != "") {
		var arrow_x = $("#"+id).parent().find(".help-span-arrow").css("margin-left");
		$("#"+id).parent().find(".help-span-arrow").css("margin-left", (parseInt(arrow_x.substring(0, arrow_x.indexOf("px")))+arrow_X) + "px");
		var arrow_border_x = $("#"+id).parent().find(".help-span-arrow-border").css("margin-left");
		$("#"+id).parent().find(".help-span-arrow-border").css("margin-left", (parseInt(arrow_border_x.substring(0, arrow_border_x.indexOf("px")))+arrow_X) + "px");
	}

	// 箭头y轴位置自定义
	if (arrow_Y != null && arrow_Y != "") {
		var arrow_y = $("#"+id).parent().find(".help-span-arrow").css("margin-top");
		$("#"+id).parent().find(".help-span-arrow").css("margin-top", (parseInt(arrow_y.substring(0, arrow_y.indexOf("px")))+arrow_Y) + "px");
		var arrow_border_y = $("#"+id).parent().find(".help-span-arrow-border").css("margin-top");
		$("#"+id).parent().find(".help-span-arrow-border").css("margin-top", (parseInt(arrow_border_y.substring(0, arrow_border_y.indexOf("px")))+arrow_Y) + "px");
	}

	// 添加鼠标事件
	var popup_timeout = null;
	$("#"+id).parent().find("[type='help']").hover(function(event){
		clearTimeout(popup_timeout);
		function delay(){
			(function(e){
				$("#"+id).parent().find(".help-span-arrow").show();
				$("#"+id).parent().find(".help-span-arrow-border").show();
				$("#"+id).parent().find(".help-span-content").show();
			})(event)
		}
		popup_timeout = setTimeout(delay, 500);
	},function(event){
		clearTimeout(popup_timeout);
		function delay(){
			(function(e){
				var obj = event.toElement ? event.toElement:event.relatedTarget;
				if ($(obj).attr("type") != "help") {
					$("#"+id).parent().find(".help-span-arrow").hide();
					$("#"+id).parent().find(".help-span-arrow-border").hide();
					$("#"+id).parent().find(".help-span-content").hide();
				}
			})(event)
		}
		popup_timeout = setTimeout(delay, 500);
	});
}


/**
 * jquery选择器对id存在特殊字符处理转义
 * 
 * @param srcString
 * @returns
 */
function escapeJquery(srcString) {

	// 转义之后的结果
	var escapseResult = srcString;

	// javascript正则表达式中的特殊字符
	var jsSpecialChars = ["\\", "^", "$", "*", "?", ".", "+", "(", ")", "[", "]", "|", "{", "}"];

	// jquery中的特殊字符,不是正则表达式中的特殊字符
	var jquerySpecialChars = ["~", "`", "@", "#", "%", "&", "=", "'", "\"", ":", ";", "<", ">", ",", "/"];

	for (var i = 0; i < jsSpecialChars.length; i++) {
		escapseResult = escapseResult.replace(new RegExp("\\" + jsSpecialChars[i], "g"), "\\" + jsSpecialChars[i]);
	}
	for (var i = 0; i < jquerySpecialChars.length; i++) {
		escapseResult = escapseResult.replace(new RegExp(jquerySpecialChars[i], "g"), "\\" + jquerySpecialChars[i]);
	}
	return escapseResult;
}

/**
 * fileinput组件，将文件名中特殊字符转义
 * 
 * @param id
 * @returns
 */
function replaceForFile(id) {
	var escapseResult = id;
	var pattern = ["(", "]"];
	for (var i = 0; i < pattern.length; i++) {
		escapseResult = escapseResult.replace(new RegExp("\\" + pattern[i], "g"), "_");
	}
	return escapseResult;
}
