'use strict';
var ninebox=(function(){	
	
	var POSITION={
			/**描述顺序:
			 * 		x轴-y轴
			 * 	
			**/
			"left-top":"1-1",
			"center-top":"1-2",
			"right-top":"1-3",
			"left-center":"2-1",
			"center-center":"2-2",
			"right-center":"2-3",
			"left-bottom":"3-1",
			"center-bottom":"3-2",
			"right-bottom":"3-3"
	}
	
	return{
		//初始化
		"init":function(id){
			var	innterHtml="<div id='ninebox-default' class='ninebox' >";
			    innterHtml+="<div class=\"ninebox-row\">";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_1-1\"  onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox ninebox-smallbox-selected\"></div></div>";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_1-2\"  onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_1-3\"  onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="</div>";
				
				innterHtml+="<div class=\"ninebox-row\">";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div id=\"ninebox-smallbox_2-1\" onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_2-2\" onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_2-3\" onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="</div>";
				innterHtml+="<div class=\"ninebox-row\">";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div id=\"ninebox-smallbox_3-1\" onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_3-2\" onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="<div  class=\"ninebox-cloumn\"><div  id=\"ninebox-smallbox_3-3\" onclick=\"ninebox.nineboxSelected(this)\" class=\"ninebox-smallbox\"></div></div>";
				innterHtml+="</div>";
				innterHtml+="</div>";
				$("#"+id).append(innterHtml);
				
			return null;
		},
		
		//点击九宫格触发
		"nineboxSelected":function(object){
				$("#ninebox-default").find(".ninebox-smallbox-selected").each(function(i,item){
					$("#"+item.id).removeClass("ninebox-smallbox-selected");
				});
				
				var id=$(object).attr("id");
				console.log("九宫格ID:"+id);
				
				$(".video-watermark-word").hide();
				
				if(watermark.isUpload() && watermark.getType()=="img"){//已经上传了水印图片
					 var selectedId="video_watermark_img_"+id.split("_")[1];
					 console.log("selectedId="+selectedId);
					 $("#"+selectedId).show();
				}else if(watermark.getType()=="word"){
					 var selectedId="video_watermark_word_"+id.split("_")[1];
					 console.log("selectedId="+selectedId);
					 $("#"+selectedId).show();
				}
				
				$(object).addClass("ninebox-smallbox-selected");
				
				return $(object).id;
		},
		
		//获取选中位置ID
		"getNineBoxSelectedId":function(){
			var selectedId="";
			$(".ninebox-smallbox").each(function(index,item){
				if($(item).hasClass("ninebox-smallbox-selected")){
					 selectedId=$(item).attr("id");
				}
			});
			
			return selectedId;
		},
		
		//获取选中位置
		"getPosition":function(){
			var position="";
			$(".ninebox-smallbox").each(function(index,item){
				if($(item).hasClass("ninebox-smallbox-selected")){
					var id=$(item).attr("id");
					selectedId=id.split("_")[1];
					
					if(selectedId==POSITION.left-top){
						position="left-top";
					}else if(selectedId==POSITION.center-top){
						position="center-top";
					}else if(selectedId==POSITION.right-top){
						position="right-top";
					}else if(selectedId==POSITION.left-center){
						position="left-center";
					}else if(selectedId==POSITION.center-center){
						position="center-center";
					}else if(selectedId==POSITION.right-center){
						position="right-center";
					}else if(selectedId==POSITION.left-bottom){
						position="left-bottom";
					}else if(selectedId==POSITION.center-bottom){
						position="center-bottom";
					}else if(selectedId==POSITION.right-bottom){
						position="right-bottom";
					}
				}
			});
			
			return position;
		},
		
		//设置自定义不支持浏览器执行的函数
		"setNotSupportFunction":function(fn){
			if( typeof fn ==='function'){
				fn();
			}
		}
	}
})();

