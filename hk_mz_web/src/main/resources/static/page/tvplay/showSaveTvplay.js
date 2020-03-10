$(document).ready(function() {
	//初始化日期
	initDate();
	//初始化电视剧数据库中的标签
	initColumnTags(tags,'tvplay','');
	//初始化面包屑
	var data = [{"name":"电视剧","url":basePath+"tvplay/show_tvplay_list"},{"name":"修改","url":basePath + "tvplay/show_save_tvplay?tvplayId="+tvplayId}];
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
		    form.attr("action", basePath+"/tvplay/update_tvplay.do?startTime="+startTime+"&endTime="+endTime+"&beanShowTime="+beanShowTime);
		    var isCheck = subCheck();
		    if(!isCheck){
				$("#submit-button").removeAttr("disabled");
			}else{
				validator.defaultSubmit();
			}
//		    var appInformationKey = $('#appInformationKey').val();
//			var loginName  = $('#loginName').val();
//			var shopKey  = $('#shopKey').val();
//			validator.defaultSubmit();
//			$.ajax({
//				type:"POST",
//				url:url,	
//				timeout:3600000,
//				async:false,
//				success : function(result) {
//					// 解析数据
//					var resultdata=$.parseJSON(result);
//					if(!resultdata.result){
//						Alert("该商家账号已经存在，请重新设置！");
//					}else{
//						validator.defaultSubmit();
//					}
//				}
//			});
		},
		fields : {
			tvplayName : {
				validators : {
					notEmpty : {
						message : '电影名称不能为空'
					}
				}
			},
			tvplayNum : {
				validators : {
					notEmpty : {
						message : '集数不能为空'
					},
					regexp: {
						regexp:   /^[0-9]*[1-9][0-9]*$/,
						message: '集数只能为大于0的正整数'
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
			subdiscription : {
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
	var tvplayId =  $("#tvplayId").val() ;
	$.ajax({
		type:"POST",
		url:basePath +'tvplay/reset_modify_tvplay.do',
		data:{'tvplayId':tvplayId},
		success : function(result) {
			// 解析数据
			//var resultdata=$.parseJSON(result);
			if (result.ok == true) {
				//剧照
				$("#tvplayName").val(result.data.tvplayName);
				//集数
				$("#tvplayNum").val(result.data.tvplayNum);
				//导演 
				$("#director").val(result.data.director);
				//主演
				$("#mainActor").val(result.data.mainActor);
				//语言
				$("#language").val(result.data.language);
				//国家
				$("#national").val(result.data.national);
				//简介
				$("#subdiscription").val(result.data.subdiscription);
				//初始化标签
				initColumnTags(result.data.tvplayTag,'tvplay','');
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
	$("#datePick").val(startTime+" - "+endTime);
	//首播时间初始化
	$("#singleDatePick").val(formatDate(showTime));
}

