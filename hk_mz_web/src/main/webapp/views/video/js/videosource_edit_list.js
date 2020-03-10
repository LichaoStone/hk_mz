var object={};
var rows=[];
var rowsLog=[];
var index=0;
var videoAddCount=1;
var CHROME_VERSION = 68;
var currentEditVideoId="";//当前编辑的视频ID
var mplayer;

$(document).ready(function(){
	//初始化播放器
	mplayer=videoUtil.initplayer('video-clip',{
		hidden:false, 
		responsive:true,
		autoplay:true,
		controlBar:{
			'currentTimeDisplay': true,
			'remainingTimeDisplay':true,
			'liveDisplay':true,
			'volumePanel':{
				inline: true 		//默认是true,横着的
			}
		}
	}); 
	
	getDetails();       //获取视频截取记录数据 
	initSlider();       //初始化透明度滚动条
	initColorPicker();  //初始化调色板
	ninebox.init("ninebox");
});

/**
 * 初始化颜色板
 */
function initColorPicker(){
	$('.paigusu').paigusu({
		color : 'black', //初始色  支持两种配置方案
		//recommend : '25,38,220,1|25,38,220,1|46,49,104,1|25,38,220,1|46,49,104,1|25,38,220,1|46,49,104,1|25,38,220,1|46,49,104,1|25,38,220,1|46,49,104,1'
	    //,color : '42,0,255'
	},function(event,obj){
		console.log(obj);
		$(event).css('background','#' + obj.hex);
		$("#video_edit_watermark_input").css("color",'#' + obj.hex);
		
	});
}

/**
 * 开始和暂停
 */
function startAndStop(){
	if(videoUtil.ispaused()){//暂停状态
		videoUtil.start();
		$("#start_stop_img").attr("src","/views/video/img/video_startandstop.png");
	}else{ //播放状态
		videoUtil.pause();
		$("#start_stop_img").attr("src","/views/video/img/video_stop.png");
	}
}

/**
 * 快进
 */
function kuaijin(){
	videoUtil.getCurrenttime();
}

/**
 * 快退
 */
function kuaitui(){
	
}

/**
 * 初始化透明度，文字和图片水印大小滚动条
 */
function initSlider(){
	//初始化透明度-图片区域
	$("#transparent_img_slider").slider({
		 value:100
	});
	$("#transparent_img_slider").on('slide', function(slideEvt) {
		$("#transparent_img_slider_value").val(slideEvt.value+"%");
		$("#addImgFile").css("opacity",slideEvt.value/100);
		$(".video-watermark-img").css("opacity",slideEvt.value/100);
	});
	
	
	//初始化透明度-文字区域
	$("#transparent_word_slider").slider({
		 value:100
	});
	$("#transparent_word_slider").on('slide', function(slideEvt) {
		$("#transparent_word_slider_value").val(slideEvt.value+"%");
		$("#video_edit_watermark_input").css("opacity",slideEvt.value/100);
	});
	
	//初始化水印大小
	$("#wartermark_slider").slider({
		 value:100
	});
	
	$("#wartermark_slider").on('slide', function(slideEvt){
		$("#wartermark_slider_value").val(slideEvt.value+"%");
		
		var width=$("#video_watermark_img").css("width");
		var height=$("#video_watermark_img").css("height");
		
		
		width=width.substring(0,width.length-2);
		height=height.substring(0,width.length-2);
		
		console.log("宽度:"+width.substring(0,width.length-2));
		console.log("高度:"+height.substring(0,width.length-2));
		
		$(".video-watermark-img").css("width",width+"px");
		$(".video-watermark-img").css("height",height+"px");
	});
}

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
		queryParams : {
			"pageNumber":1,
			"pageSize":10
			}, 									// 查询条件
		cache : false, 												// 不缓存
		clickToSelect : true, 										// 单击行即可以选中
		pagination : false,											// 是否显示分页（*）
		sidePagination : "server", 									// 分 页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, 											// 初始化加载第一页，默认第一页
		pageSize : 10, 												// 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], 							// 可供选择的每页的行数（*）
		smartDisplay : true,
		responseHandler:function(result){
			//console.log(result.results);
			
			object={
				"ret":200,
				"msg":"成功",
				"total": 0,
				"rows"	:rows	
			};
			
			return object;
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
 * 添加视频
 */
function toAddVideo(){
	//判断添加视频是否超过20个
	//弹出模态框选择需要添加的视频
	console.log("已经添加的视频个数:"+videoAddCount);
	var url = basePath + "videoSource/toAddEditVideo?videoCount"+videoAddCount;
	parent.openModal("添加视频",600, 800, url);
	
}


function setIndex(value,row,index){
	return index+1;
}


function sectionTimeChange(object){
	$("#"+$(object).attr("id").replace("input","span")).text($("#"+$(object).attr("id")).val());
}


/**
 * 视频截取保存按钮
 */
function saveRecordBtn(object){
	var startTime=$("#bt_videoedit_time_start_span").text();
	var endTime=$("#bt_videoedit_time_end_span").text();
	var videoSection=startTime+"-"+endTime;
	var videoLong=endTime-startTime;
	console.log(arr);
}


/**
 * 重新裁剪
 */
function retailoring(videoSourceId){
	videoUtil.retailoring();
}

/**
 * 增加视频
 */
function addVideo(videoSourceIdArr){
	console.log("addVideo:::::::");
	console.log(videoSourceIdArr);
	//添加视频展示及视频截取记录
	videoUtil.addVideo(videoSourceIdArr);
	videoUtil.addVideoSectionLog(videoSourceIdArr);
	
	//切换视频资源
	videoUtil.switch("http://vjs.zencdn.net/v/oceans.mp4");
	
	refresh();
}

/**
 * 删除加入的视频
 * @videoId 指定删除第几个视频
 */
function deleteVideo(videoId){
	 $("#video_add_div_"+videoId).remove();
	 $("#video_add_next_"+videoId).remove();
	 videoAddCount--; //添加视频数量-1
}


/**
 * 切换视频
 */
function videoChange(id){
	//清除已选中视频样式
	$("#add_video_show_box").find(".video-add-div-selected").each(function(i,item){
		$("#"+item.id).removeClass("video-add-div-selected");
	});
	
	//添加选中视频样式
	$("#"+id).addClass("video-add-div-selected");
}

/**
 * 导出视频
 */
function exportVideo(){
	if(confirm("是否导出视频?")){
		alert("导出视频成功!");
	}else{
		return false;
	}
}


function setWartermarkWordShow(){
	$(".video-watermark-word").show();
}


/**
 * 水印文字变划监听
 */
function wartermarkInputChange(object){
	$(".video-watermark-word").hide();
	$(".video-watermark-word").text($(object).val());
	
	var id=getNineBoxSelectedId();
	$("#video_watermark_word_"+id).show();
}

/**
 * 设置水印固定样式
 */
function setWatermarkFixedCss(){
	$(".video-watermark-img").hide();
	
}


/**
 * 添加图片文件
 */
function addImgFile(){
	$("#imgFile").click();
}
