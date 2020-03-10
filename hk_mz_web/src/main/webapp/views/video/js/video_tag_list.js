var selectedTagsArr=new Array();
$(document).ready(function() {
	getDetails();
});

/**
 * 获取详情数据
 */
function getDetails() {
	$.ajax( {
		type : "POST",
		url : basePath + "video/getTagList",
		timeout : 3600000,
		success : function(data,textStatus) {
			var list=$.parseJSON(data);
			
			var dataList=list.results.rows;
			
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
		var videoTagArr=videoTag.split(",");
		var flag=false;//未选中
		if(videoTagArr!=null&&videoTagArr.length>0){
			$.each(videoTagArr,function(index,item2){
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
	}else{
		if(selectedTagsArr!=null&&selectedTagsArr.length>0){
			if(selectedTagsArr.length>20){
				alert("每个视频最多可选择20个标签");
				return false;
			}
		}
		
		$("#"+tagId).addClass("selected");
		
		selectedTagsArr.push(tagName);
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
	parent.closeModal("2");
	$("#openFrame",parent.document.body)[0].contentWindow.refreshTags(selectedTagsArr.toString());
}