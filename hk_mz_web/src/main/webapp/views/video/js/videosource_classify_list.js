$(document).ready(function() {
	//初始化分类下拉菜单
	getClassifySelect("getClassify");
});

function cancel(){
	parent().closeModal();
}

/**
 * 上传
 */
function toUpload(){
	var classifyId=$("#getClassify").val();
	console.log("分类:"+classifyId);
	
	if(classifyId!=null&&classifyId!=""){
		var url = basePath + "videoSource/toUpload?classifyId="+classifyId;
		parent.openModal("上传管理", 850,750, url,"2");
	}else{
		toast("分类不能为空",true,'error','top',400)
	}
}