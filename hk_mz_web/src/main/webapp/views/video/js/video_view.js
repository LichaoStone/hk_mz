/**
 * 切换表情、高清和蓝光
 */
function toggleStandardClass(obj){
	//清除选中样式
	$("#btn-standard-div").find("span").each(function(i,item){
		$("#"+item.id).removeClass('btn-standard-checked');
		$("#"+item.id).addClass('btn-standard');
		
	});
	//添加选中样式
	$("#"+obj+"_span").addClass('btn-standard-checked');
	
	
	//隐藏所有视频展示框
	$("#video_show_div").find(".video_show").each(function(i,item){
		$("#"+item.id).css('display','none');
	});
	//展示选中视频展示框
	$("#"+obj).css('display','block');
} 