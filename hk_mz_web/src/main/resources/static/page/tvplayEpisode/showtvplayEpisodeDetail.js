$(document).ready(function() {
});

/**
 * 切换表情、高清和蓝光
 */
function changeVideoQuality(obj,flag){
	//清除选中样式
	$("#btn-video-div").find("span").each(function(i,item){
		$(this).removeClass('select_font_oper');
		$(this).addClass('unselected_font_opr');
	});
	obj.setAttribute('class','select_font_oper');
	//获取视频播放地址
	var url="";
	if(flag=='480'){
		url=$("#videoUrl480").val();
	}else if(flag=='720'){
		url=$("#videoUrl720").val();
	}else if(flag=='1080'){
		url=$("#videoUrl1080").val();
	}
	//播放视频
	document.getElementById("video").src=url ;
	document.getElementById("video").play();
} 
