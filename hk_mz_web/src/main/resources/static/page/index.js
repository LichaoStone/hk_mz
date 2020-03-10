var modalLevel=0;
$(document).ready(function(){
	$(".menu_class_click").click(function(){
		$(".menu_class_click").removeClass('k-menu__item--active');
		console.log($(this).attr("url"));
		breadCrumb([]);
		if($(this).attr("url") != null && $(this).attr("url").length > 0){
			$("#htmlContent").attr("src",basePath+$(this).attr("url"));
		}
		$(this).addClass('k-menu__item--active');
		return false ;
	});
	$(".parent_li_class").click(function(){
//		if($(this).children("li").hasClass("k-menu__item--active")){
//			
//		}
		if($(this).attr("drop") == "no"){
			$(this).attr("drop","yes");
			$(this).children("a").children(".k-menu__link-icon").children("span").addClass("xtgl_active");
		}else{
			$(this).attr("drop","no");
			$(this).children("a").children(".k-menu__link-icon").children("span").removeClass("xtgl_active");
		}
	});
})

function breadCrumb(data){
	
	var html = "" ;
	if(data.length > 0){
		var crumb = data[0] ; 
	    var head ='<div class="k-content__head k-grid__item">'+
        '<div class="k-content__head-main">'+
        ' <a style="padding-right: 0.65rem;" href="javascript:void(0)"><h3 class="k-content__head-title">'+crumb.name+'</h3></a>'+
        '  <div class="k-content__head-breadcrumbs">';
        var content = "" ;
	    for(var i =1 ; i < data.length ;i++){
	    	var bread = data[i];
	    	content +=  '    <span class="k-content__head-breadcrumb-separator"></span>'+
	        			'    <a href="javascript:void(0)" onclick="gotoUrl(this)" url="'+bread.url+'" class="k-content__head-breadcrumb-link">'+bread.name+'</a>';
        }
        var tail = '  </div> '+
				   '</div> '+
				 '</div>';
        html = head + content + tail ;
	  
	}
	$("#breadCrumb").html(html);
}

function gotoUrl(data){
	var url = $(data).attr("url") ;
	$("#htmlContent").attr("src",url);
}

/**
 * 弹出模态框
 * 
 * @param title 模态框标题
 * @param height 模态框高度
 * @param width 模态框宽度
 * @param url 链接地址
 * @param number 弹层号 从2开始，不传表示打开第一个弹层
 */
function openModal(title, height, width, url, number, helpContent, content_X, arrow_X, width_h, height_h) {
	// 判断打开哪个弹层，不传入number时，默认打开第一个弹层
	var num = "";
	if (number != null && number != "") {
		num = number;

		// 打开非第一个弹层时，需要将前一个弹层隐藏
		if (parseInt(number) > 2) {
			$("#openModal" + (parseInt(number) - 1)).modal("hide");
		} else {
			$("#openModal").modal("hide");
		}
	}

	// 设置弹出层标题
	$("#openModalHeader" + num).html(title);

	// 设置弹出层高度
	var clientHeight = document.body.clientHeight;
	if (height > clientHeight - 120) {
		height = clientHeight - 120;
	}
	$("#openModal" + num).find(".modal-body").css("height", height + "px");

	// 设置弹出层宽度
	var clientWidth = document.body.clientWidth;
	console.log(clientWidth);
	if (width > clientWidth - 10) {
		width = clientWidth - 10;
	}
	$("#openModal" + num).children(".modal-dialog").css("width", width + "px");

	// 根据连接加载页面
	$("#modalForm").attr("action", url);
	$("#modalForm").attr("target", "openFrame" + num);
	$("#modalForm").submit();

	// 帮助信息初始化
	if (helpContent != null && helpContent != "") {
		$("#title-help" + num).show();
		var cx = 50;
		if (content_X != null && content_X != "") {
			cx = cx + content_X;
		}
		var ax = 8;
		if (arrow_X != null && arrow_X != "") {
			ax = ax + arrow_X;
		}
		initHelpBlock("title-help" + num, helpContent, cx, 0, ax, 0, width_h, height_h);
	} else {
		$("#title-help" + num).hide();
	}

	
	// 打开模态框
	$("#openModal" + num).modal({
		backdrop: 'static',
		keyboard: false
	});
}

/**
 * 关闭模态框
 *@isBackIndexPage 是否直接返回首页
 				true:不再打开前一个弹层
 				空或false:打开前一个弹层
 */
function closeModal(number,handClose) {
	var closeModel_confirm='';
	if (parseInt(number) > 1) {
		closeModel_confirm  = $("#openModal" + parseInt(number)).find("#openFrame" + parseInt(number))["0"].contentWindow.closeModel_confirm;
		}else{
		closeModel_confirm  = $("#openModal").find("#openFrame")["0"].contentWindow.closeModel_confirm;
	}
	if(closeModel_confirm==true){
		if(!confirm("是否关闭当前窗口？")) {
			//选择不关闭时，终止关闭
			event.stopPropagation();
			return false;
		}
	}
    // 判断关闭哪个弹层，不传入number时，默认关闭第一个弹层  
	var num = "";
	var openModal;
	var openFlag = false;
	if (number != null && number != "") {
		num = number;
		openFlag = true;
		
		// 关闭非第一个弹层时，需要将前一个弹层打开
		if (parseInt(number) > 2) {
			openModal = $("#openModal" + (parseInt(number) - 1));
		} else {
			openModal= $("#openModal");
		}
	}
	
	
	$("#openModal" + num).modal("hide");
	// 打开前一个模态框
	if (openFlag) {
		openModal.modal("show");
	}
	//关闭层如果有上传 把上传显示出来
//	if (number == null || number == "") {
//		if(isVideoModal){
//		  $("#openModalVideo").modal("show");
//		}
//	}

	//关闭音频视频
	setTimeout(function(){
		$("#openFrame" + num).attr("src","");
	},500); 
	
	// 关闭通知页面时刷新消息数量
	if ($("#openFrame").contents().find("#ffSearch").length > 0) {
		queryWorkLogFrontCount();
	}
	
	modalLevel=modalLevel-1;
	//if(modalLevel==0){
	//	isOpenModalNow=false;
	//}
	console.log("modalLevel="+modalLevel);
	//console.log("isOpenModalNow="+isOpenModalNow);
	//console.log("isCloseModal="+isCloseModal);
	
}