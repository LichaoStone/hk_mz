var selectedTagsArr=new Array();
/**
 * 页面通用方法，单点登录验证使用
 */
$(document).ready(function() {
	getDetails();
});

/**
 * 标签初始化
 * tags:属于标签
 * type:video视频、movie电影、tvplay剧集'
 * num:层级数
 */
function initColumnTags(tags,type,num){
	//去掉错误提示消息
	if(tags!=''){
		$(".tips").css('display','none'); 
	}
	var tagsArr=tags.split("、");
	//选中的标签赋值
	$("#selectTags").val(tags);
	$("#tags").empty();
    var innerHtml="";
    var len=0;
    if(tagsArr!=null&&tagsArr.length>0){
    	len=tagsArr.length;
   }
    $.each(tagsArr,function(i,item){
    	if(item!=''){
    		innerHtml+="<div class='tag-div'>"+item+"</div>";
    	}
    	 if(len==(i+1)){
    		 innerHtml+="<div class='tag-set-div' ><span style='color:#5868DD;'><a href='javascript:;' onclick=initAllTags('"+tags+"','"+type+"','"+num+"')>设置</a></span></div>";
    	 }
    });
    $("#tags").html(innerHtml);
}

/**
 * 进去标签选择页面
 */
function initAllTags(tags,type,num){
	var url = basePath + "show_tags_list?tags="+tags+"&tagType="+type;
	parent.openModal("选择标签",1000, 789, url,num);
}

/**
 * 获取详情数据
 */
function getDetails() {
	$.ajax( {
		type : "POST",
		url : basePath + "tag/get_all_tag_list",
		data:{'tagType':tagType},
		timeout : 3600000,
		success : function(result,textStatus) {
			//var list=$.parseJSON(data);
			//console.log(list.results.rows);
			
//			var dataList=list.results.rows;
			var dataList=result.data;
			//组织html数据
			insertHtml(dataList);
		},
		error : function() {
			alert("Ajax请求失败,请及时联系管理员！");
		}
	});
}

/**
 * 组装数据
 */
function insertHtml(dataList){
	$.each(dataList,function(i,item){
		var word=item.word;
		var insertHtml="";
		
		//默认选中的标签
		var tagsArr=tags.split("、");
		var flag=false;//未选中
		if(tagsArr!=null&&tagsArr.length>0){
			$.each(tagsArr,function(index,item2){
				console.log(item.tagName);
				console.log(item2);
				if(item.tagName==item2){
					flag=true;//已选中
					selectedTagsArr.push(item2);
				}
			});
		}
		
		if(flag){
			insertHtml+="<div id='"+item.tagId+"' class='tag-btn selected' onclick=\"tagChecked('"+item.tagId+"','"+item.tagName+"')\"><span>"+item.tagName+"</span></div>";
		}else{
			insertHtml+="<div id='"+item.tagId+"' class='tag-btn' onclick=\"tagChecked('"+item.tagId+"','"+item.tagName+"')\"><span>"+item.tagName+"</span></div>";
		}
		
		if(word=="A"||word=="B"||word=="C"||word=="D"||word=="E"||word=="F"){
			$("#tags_show_A2F").show();
			$("#tags_show_content_A2F").append(insertHtml);
		}else if(word=="G"||word=="H"||word=="I"||word=="J"||word=="K"||word=="L"){
			$("#tags_show_G2L").show();
			$("#tags_show_content_G2L").append(insertHtml);
		}else if(word=="M"||word=="N"||word=="O"||word=="P"||word=="Q"){
			$("#tags_show_M2Q").show();
			$("#tags_show_content_M2Q").append(insertHtml);
		}else if(word=="R"||word=="S"||word=="T"||word=="U"||word=="V"||word=="W"){
			$("#tags_show_R2W").show();
			$("#tags_show_content_R2W").append(insertHtml);
		}else if(word=="X"||word=="Y"||word=="Z"){
			$("#tags_show_XYZ").show();
			$("#tags_show_content_XYZ").append(insertHtml);
		}
	})
	
	
	insertSelectedTag();
} 

/**
 * 选中标签
 */
function tagChecked(tagId,tagName){
	if($("#"+tagId).hasClass("selected")){
		$("#"+tagId).removeClass("selected");
		
		selectedTagsArr.remove(tagName);
		console.log("map==>");
		console.log(selectedTagsArr);
	}else{
		if(selectedTagsArr!=null&&selectedTagsArr.length>0){
			if(selectedTagsArr.length>20){
				//alert("每个视频最多可选择20个标签");
				toast("每个视频最多可选择20个标签",true,'error','top',400);
				return false;
			}
		}
		
		$("#"+tagId).addClass("selected");
		
		selectedTagsArr.push(tagName);
		console.log("map==>");
		console.log(selectedTagsArr);
	}
	
	//插入选中的标签内容
	insertSelectedTag();
}

/**
 * 插入选中的标签内容
 */
function insertSelectedTag(){
	var innerHtml="";
	var i=0;
	for(var j = 0,len = selectedTagsArr.length; j < len; j++){
		if(i==0){
			innerHtml+="<div style='float:left;margin-bottom:10px;margin-left:10px;'><span>"+selectedTagsArr[j]+"</span></div>";
		}else{
			innerHtml+="<div style='float:left;margin-bottom:10px;'><span>、"+selectedTagsArr[j]+"</span></div>";
		}
		
		i++;
	}
	
	$("#tags_selected_span").html(innerHtml);
}

/**
 * 确定
 */
function sure(){
	parent.closeModal(num);
	var reg = new RegExp(",","g");//g,表示全部替换。
	var selectTags = selectedTagsArr.toString().replace(reg,"、");
	if(num=='' || num=='1'){
		$("#htmlContent",parent.document.body)[0].contentWindow.initColumnTags(selectTags,tagType,num);
	}else if(num=='2'){
		$("#openFrame",parent.document.body)[0].contentWindow.initColumnTags(selectTags,type,num);
	}
}
