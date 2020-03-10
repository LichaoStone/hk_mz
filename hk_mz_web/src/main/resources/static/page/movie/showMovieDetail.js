$(document).ready(function() {
	//初始化日期
	initDate();
});
/**
 * 初始化日期控件的值
 */
function initDate(){
	// 版权时间空间初始化
	var startTime = formatDate(copyBeginTime);
	var endTime = formatDate(copyEndTime);
	$("#copyrightTime").html(startTime+" - "+endTime);
	//首播时间初始化
	$("#premiereTime").html(formatDate(showTime));
}

