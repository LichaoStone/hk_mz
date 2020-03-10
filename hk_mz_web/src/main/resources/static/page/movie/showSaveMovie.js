$(document).ready(function() {
	//初始化日期
	initDate();
	//初始化电影数据库中的标签
	initColumnTags(tags,'movie','');
	//初始化面包屑
	var data = [{"name":"电影","url":basePath+"movie/show_movie_list"},{"name":"修改","url":basePath + "movie/show_save_movie?movieId="+movieId}];
	window.parent.breadCrumb(data);
	// 初始化表单验证信息
	$("#form").bootstrapValidator({
		excluded: [':disabled', ':hidden', ':not(:visible)'],
		message : '',
		feedbackIcons : {
		},
		submitHandler: function (validator,form,submitButton) {
			//上映时间
			var beanShowTime = $("#singleDatePick").val();
			//版权开始时间
			var startTime = $("#startTime").val();
			//版权结束时间
			var endTime = $("#endTime").val();
		    form.attr("action", basePath+"/movie/update_movie.do?startTime="+startTime+"&endTime="+endTime+"&beanShowTime="+beanShowTime);
		    var isCheck = subCheck();
		    if(!isCheck){
				$("#submit-button").removeAttr("disabled");
			}else{
				validator.defaultSubmit();
			}
		},
		fields : {
			movieName : {
				validators : {
					notEmpty : {
						message : '电影名称不能为空'
					}
				}
			},
			director : {
				validators : {
					notEmpty : {
						message : '导演不能为空'
					}
				}
			},
			mainActor : {
				validators : {
					notEmpty : {
						message : '主演不能为空'
					}
				}
			},
			subdescription : {
				validators : {
					notEmpty : {
						message : '简介不能为空'
					}
				}
			}
			
		}
	});
});

/**
 * 重置按钮校验
 */
function cancelData(){
	var movieId =  $("#movieId").val() ;
	$.ajax({
		type:"POST",
		url:basePath +'movie/reset_modify_movie.do',
		data:{'movieId':movieId},
		success : function(result) {
			// 解析数据
//			var resultdata=$.parseJSON(result);
			if (result.ok == true) {
				//电影名称
				$("#movieName").val(result.data.movieName);
				//导演 
				$("#director").val(result.data.director);
				//主演
				$("#mainActor").val(result.data.mainActor);
				//语言
				$("#language").val(result.data.language);
				//国家
				$("#national").val(result.data.national);
				//简介
				$("#subdescription").val(result.data.subdescription);
				//初始化标签
				initColumnTags(result.data.movieTag,'movie','');
				resetForm();
				} else {
					Alert("操作失败!");
				}
		},
		error : function(result){
			// // alert("ajax请求失败。");
		}
	});
	//初始化日期
	initDate();
	
}
function saveData(){
	var paramJson = {} ;
	var copyBeginTime = $("#copyBeginTime").val();
	paramJson.copyBeginTime = copyBeginTime ;
	console.log(paramJson);
	$.ajax({
		type:"POST",
		url:basePath +'movie/save_movie.do',
		data:{"bean":JSON.stringify(paramJson)},
		success : function(result) {
			console.log(result);
			console.log(1);
		},
		error : function(result){
			// // alert("ajax请求失败。");
		}
	});
}

/**
 * 重置校验
 */
function resetForm(){
	$("#form").data('bootstrapValidator').resetForm();
	$(".tips").css('display','none'); 
}

function subCheck(){
	var flag = true;
	//验证时间
	var datePick = $("#datePick").val();
	if(datePick == null || datePick==''){
		flag = getTip("datePick","起止时间不能为空!");
		return flag;
	}
	var singleDatePick = $("#singleDatePick").val();
	if(singleDatePick == null || singleDatePick==''){
		flag = getTip("singleDatePick","首播时间不能为空!");
		return flag;
	}
	var selectTags = $("#selectTags").val();
	if(selectTags == null || selectTags==''){
		flag = getTip("tags","标签不能为空!");
		return flag;
	}
	return flag;
}
/**
 * 初始化日期控件的值
 */
function initDate(){
	// 版权时间空间初始化
	var startTime = formatDate(copyBeginTime);
	var endTime = formatDate(copyEndTime);
	$("#startTime").val(startTime);
	$("#endTime").val(endTime);
	$("#datePick").val(startTime+" 至 "+endTime);
	//首播时间初始化
	$("#singleDatePick").val(formatDate(showTime));
}


