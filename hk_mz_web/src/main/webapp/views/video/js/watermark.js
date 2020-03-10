'use strict';
var watermark=(function(){	
	var TYPE={"IMG":"img","WORD":"word"};
	//是否长传了水印图片,默认为false
	var isUploadWatermark=false;
	var btnRadio=TYPE.IMG;
	
	return{
		//初始化
		"init":function(id,option){
			return null;
		},
		
		//水印图片是否已经上传
		"isUpload":function(){
			return isUploadWatermark;
		},
		
		//设置图片水印是否已上传
		"setUploadStatus":function(flag){
			isUploadWatermark=flag;
		},
		
		//水印类型
		"setType":function(type){
			btnRadio=type;
		},
				
		
		//获取水印类型：img图片水印,word文字水印
		"getType":function(){
			return watermark.btnRadio;
		},
		
		//切换水印TAB页(图片水印和文字水印)
		"toggleVideoWatermark":function(id){
			if(id=="table-tab-vido-div"){//视频
				$("#table-tab-vido-div").addClass("table-tab-selected");
				$("#table-tab-watermark-div").removeClass("table-tab-selected");
				
				$("#video-edit-wartermark-div").hide();
				$("#video_edit_log_div").show();
				
				refresh();
			}else if(id=="table-tab-watermark-div"){//水印
				$("#table-tab-vido-div").removeClass("table-tab-selected");
				$("#table-tab-watermark-div").addClass("table-tab-selected");
				
				$("#video-edit-wartermark-div").show();
				$("#video_edit_log_div").hide();
			}
		},
		
		"toggleImgWord":function(id){
			$("#video_edit_watermark_radio_img").attr("src","/views/video/img/bt_radio.png");
			$("#video_edit_watermark_radio_word").attr("src","/views/video/img/bt_radio.png");
			
			if(id=="video_edit_watermark_radio_img"){
				$("#video_edit_watermark_img_span").show();
				$("#video_edit_watermark_img_box").show();
				$("#video_edit_watermark_word_box").hide();
				
				
				$(".video-watermark-word").hide();
				
				//显示水印出来
				if(watermark.isUpload()){
					var selectedId=getNineBoxSelectedId();
					$("#video_watermark_img_"+selectedId).show();
				}
				
				watermark.setType(TYPE.IMG);
			}else if(id=="video_edit_watermark_radio_word"){
				$("#video_edit_watermark_img_box").hide();
				$("#video_edit_watermark_img_span").hide();
				$("#video_edit_watermark_word_box").show();
				
				//清空图片水印
				$(".video-watermark-img").hide();
				
				watermark.setType(TYPE.WORD);
			}
			
			$("#"+id).attr("src","/views/video/img/bt_radio_selected.png");
		},
		
		//设置自定义不支持浏览器执行的函数
		"setNotSupportFunction":function(fn){
			if( typeof fn ==='function'){
				fn();
			}
		}
	}
})();

