var videoTagsTemp="";
$(document).ready(function() {
	if(result==1){
		parent.closeModal();
		$("#htmlContent",parent.document.body)[0].contentWindow.refresh();
		$("#htmlContent",parent.document.body)[0].contentWindow.toast(resultInfo,true,'succ','top',400);
		return false;
	}
	
	setTags();
	
	// 初始化表单验证信息
	$("#form").bootstrapValidator({
		excluded: [':disabled', ':hidden', ':not(:visible)'],
		message : '',
		feedbackIcons : {
		},
		submitHandler: function (validator,form) {
				var description=$("#description").val();
				var reg = new RegExp(",","g"); 
				var videoTags=videoTagsTemp.toString().replace(reg,"、");
				
				var isShare=1;
				if($("#isShare_0").hasClass("selected")){
					isShare=0;
				}
				
				//提交表单
			    form.attr("action", basePath+"/video/update.do?description="+description+"&videoTag="+videoTags+"&isShare="+isShare);
				validator.defaultSubmit();
		},
		fields : {
			videoName : {
				validators : {
					notEmpty : {
						message : '成品名称不能为空'
					},
					stringLength: {
						max: 40,
						message: '成品名称最多40个字符'
					}
				}
			},
			discription : {
				validators : {
					stringLength: {
						max: 50,
						message: '简介最多800个字符'
					}
				}
			},
			imgUrl:{
				validators:{
					callback:{
						message : '请上传或重新上传图片',
						callback:function(value){
							     console.log("校验图片... ...");
							     console.log(value);
								 return true;
							}	
					}
					}
				}
			}
	});
		
});

/**
 * 进去标签选择页面
 */
function toSetTags(){
	var url = basePath + "video/toSetTags?videoTag="+videoTagsTemp;
	parent.openModal("选择标签",600, 800, url,"2");
}

/**
 * 设置标签栏
 */
function setTags(){
	var reg = new RegExp("、","g");
	videoTagsTemp=videoTags.replace(reg,",");
	console.log("videoTagsTemp="+videoTagsTemp);
	
	var videoTagsArr=videoTags.split("、");
    
    var len=0;
    if(videoTagsArr!=null&&videoTagsArr.length>0){
    	 len=videoTagsArr.length;
    	 console.log("len="+len);
    }
    
    var innerHtml="";
    $.each(videoTagsArr,function(i,item){
    	console.log(i);
    	 
    	innerHtml+="<div class='video_tag_div'>"+item+"</div>";
    	 if(len==(i+1)){
    		 innerHtml+="<div class='video_tag_set' ><span style='color:#5868DD;'><a href='javascript:;' onclick='toSetTags()' >设置</a></span></div>";
    	 }
    });
    
    $("#video_tag_box").html(innerHtml);
}

/**
 * 刷新标签栏
 */
function refreshTags(tags){
	console.log("AAAAAAAAAAAAAAAAAAAA");
	console.log(tags);
	videoTagsTemp=tags;
	
	var videoTagsArr=tags.split(",");
    
    var len=0;
    if(videoTagsArr!=null&&videoTagsArr.length>0){
    	 len=videoTagsArr.length;
    	 console.log("len="+len);
    }
    
    var innerHtml="";
    $.each(videoTagsArr,function(i,item){
    	console.log(i);
    	 
    	innerHtml+="<div class='video_tag_div'>"+item+"</div>";
    	 if(len==(i+1)){
    		 innerHtml+="<div class='video_tag_set' ><span style='color:#5868DD;'><a href='javascript:;' onclick='toSetTags()' >设置</a></span></div>";
    	 }
    });
    
    $("#video_tag_box").html(innerHtml);
}

/**
 * 设置是否分享
 */
function chageIsShare(isShare){
	$("#isShare_0").attr("src","../images/bt_danxuan.png");
	$("#isShare_1").attr("src","../images/bt_danxuan.png");
	$("#isShare_0").removeClass("selected");
	$("#isShare_1").removeClass("selected");
	
	
	$("#isShare_"+isShare).attr("src","../images/bt_danxuan_xuanzhong.png");
	$("#isShare_"+isShare).addClass("selected");
}

/**
 * 重置
 */
function resetVal(){
    var descriptionTmp=$("#descriptionTmp").val();
    var imgUrlTmp=$("#imgUrlTmp").val();
    var isShareTmp=$("#isShareTmp").val();
    var videoNameTmp=$("#videoNameTmp").val();
    
    //重置是否分享
    chageIsShare(isShareTmp);
    
    $("#description").val(descriptionTmp);
    $("#imgUrlImg").val(basePath+"/"+imgUrlTmp);
    $("#videoName").val(videoNameTmp);
    
    //重置标签
    setTags();
}

function save(){
	 $("#form").bootstrapValidator('validate');//提交验证
	 if ($("#form").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码
		 	$("#form").attr("action", basePath+"/video/update.do");
		 	$("#form").submit();
     }
}