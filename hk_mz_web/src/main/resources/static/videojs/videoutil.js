'use strict';
var videoUtil=(function(){	
	var player;
	var nowtime;
	var alltime;
	var viewendtime;
	//添加编辑视频数量
	var videoAddCount=0;
	//当前选中的视频ID
	var currentEditVideoId;
	
	return {
		//播放器初始化
		"initplayer":function(id,option){
			var options=option || {};
			
			//初始化videojs
			player = videojs(id,options);
			
			//初始化视频截取条
			var op = {
						hidden:false, 
						responsive:true,
						autoplay:true
					}
			player.rangeslider(op);
			
			
			//加载完元数据时显示总时间
			player.on("loadedmetadata", function(){
				//设置总时长
				$("#video_alltime_input").val(player.duration());
			    
				
			});
			
			
			//快进或快退时调整当前时间
			player.on('seeked',function(){
				nowtime = this.currentTime();
				console.log('seeked:' + this.currentTime());
			});
			
			//监控视频实时播放时间
			player.on('timeupdate',function(){
				nowtime = this.currentTime();
				if(nowtime>=viewendtime){
					player.pause();
				}
				
				$("#video_currenttime_input").val(this.currentTime());
			});
			
			
			player.on('error',function(fn){
				if(this.error_.code==4){
					fn();
					console.log('你目前的浏览器不支持该播放器');
				}				
			});
			
			
			//添加视频
			videoUtil.addVideo([{
				"videoSourceId":videoSourceId,
				"videoSourceName":videoSourceName,
				"videoImgUrl":videoImgUrl,
				"videoUrl":videoUrl
			}]);
			
			return player;
		},
		
		//获取当前时间
		"getCurrenttime":function(){
			console.log('getCurrenttime' + nowtime);
			return nowtime;
		},
		
		//增加视频
		//
		"addVideo":function(arrs){
			console.log("addVideo。。。");
			console.log(arrs.length);
			$.each(arrs,function(index,item){
				videoAddCount++;//添加视频数量+1
				
				var	innerHtml="<div  id='video_add_div_"+videoAddCount+"' onclick=\"videoChange('video_add_div_"+videoAddCount+"')\" class='video-add-div' >";
						innerHtml+="<div style='height:80%;width:100%;'>";
							innerHtml+="<img id='video_add_img_"+videoAddCount+"' style='height:100%;width:100%;' src='"+item.imgUrl+"'    onerror=\"this.src='/views/video/img/video_add_default.png;this.onerror=null'\"  />";
							
							if(videoAddCount!=1){//非第一个视频才能删除
								innerHtml+="<div onclick=\"deleteVideo('"+videoAddCount+"')\" style='position: static;margin-left:155px;margin-top:-130px;cursor: pointer;'>";
									innerHtml+="<img style='height: 22px;width:22px;' src='/views/video/img/bt_delete.png'  />";
								innerHtml+="</div>";
							}
							
						
						innerHtml+="</div>";
						
						innerHtml+="<div style='height:20%;width:100%;text-align:center;'>";
								innerHtml+="<span id='video_add_span_"+videoAddCount+"' style='color:#000000;opacity:0.85;font-weight:400;line-height:14px;font-family:PingFangSC-Regular;'>"+item.videoSourceName+"</span>";
						innerHtml+="</div>";
						
					innerHtml+="</div>";
					
					innerHtml+="<div id='video_add_next_"+videoAddCount+"' style='float:left;margin-left:15px;margin-top:60px;margin-right:15px;height:155px;'>";
						innerHtml+="<span>";
							innerHtml+="<img style='height: 13px;width:15px;' src='"+item.imgUrl+"'  />";
						innerHtml+="<span>";
					innerHtml+="</div>";
					
					$("#add_video_show_box").append(innerHtml);
					
					
					currentEditVideoId=item.videoSourceId;
					
					
					videoUtil.addVideoSectionLog([{
						"videoSourceId":item.videoSourceId,
						"videoSourceName":item.videoSourceName,
						"videoImgUrl":item.imgUrl,
						"videoUrl":item.videoUrl
					}]);
			});
			
		},
		
		//获取当前时间
		"addVideoSectionLog":function(arrs){
			$.each(arrs,function(index,item){
				//添加一条记录
				$("#bt_videoedit_retailoring").show();
				$("#bt_videoedit_sure").hide();
				
				$(".bt_videoedit_time").attr("src","/views/video/img/bt_videoedit_time2.png");
				
				$("#bt_videoedit_time_start_div").hide();;
				$("#bt_videoedit_time_start_readonly_div").show();
				
				$("#bt_videoedit_time_end_div").hide();;
				$("#bt_videoedit_time_end_readonly_div").show();
				
				var value=$("#bt_videoedit_time_start_input").val();
				$("#bt_videoedit_time_start_span").text(value);
				
				var value=$("#bt_videoedit_time_end_input").val();
				$("#bt_videoedit_time_end_span").text(value);
				
				
				var videoSection=videoUtil.getVideoSection();
				var videoLong=videoUtil.getVideoLong();;
				
				//bootstrap-table数据
				rows[index]={"videoSourceName":item.videoSourceName,"videoSection":videoSection,"videoLong":videoLong,"videoSourceId":item.videoSourceId};
				//重新截取删除记录使用
				rowsLog[item.videoSourceId]={"videoSourceName":item.videoSourceName,"videoSection":videoSection,"videoLong":videoLong,"videoSourceId":item.videoSourceId};
				index++;
				
				
				//清除已选中视频样式
				$("#add_video_show_box").find(".video-add-div-selected").each(function(i,item){
					$("#"+item.id).removeClass("video-add-div-selected");
				});
				
				//添加选中视频样式
				$("#video_add_div_"+videoAddCount).addClass("video-add-div-selected");
			});
		},
		
		//获取当前时间
		"getCurrenttime":function(){
			console.log('getCurrenttime' + nowtime);
			return nowtime;
		},
		
		//获取视频截取区间
		"getVideoSection":function(){
			var values = player.getValueSlider();
			console.log("截取区间:"+values);
			var start = Math.round(values.start,2);
			var end   = Math.round(values.end,2);
			
			console.log('start' + start);
			console.log('end' + end);
			return start+"-"+end;
		},
		
		//获取视频截取长度
		"getVideoLong":function(){
			var values = player.getValueSlider();
			console.log("截取区间:"+values);
			var start = Math.round(values.start,2);
			var end   = Math.round(values.end,2);
			
			console.log('截取时长:' + (end-start));
			return end-start;
		},

		//获取总时长
		"getalltime":function(){
			var alltimes=player.duration();
			console.log('alltimes' + alltimes);
			return alltimes;
		},
				
		//获取开始时间
		"getStartTime":function(){
			return player.getValueSlider().start;
		},
				
		//获取结束时间
		"getEndTime":function(){
			return player.getValueSlider().end;
		},
		
		//开始播放
		"start":function(){
			player.play();
		},
		
		//播放暂停
		"pause":function(){
			player.pause();
		},
		
		//微调，单位为秒
		"change":function(label,time){
		   if(label=='-'){
		   		nowtime -=time;
				player.currentTime(nowtime);
		   }else if(label=='+'){
		   		nowtime +=time;
				player.currentTime(nowtime);
		   }
		},
		
		//预览
		"view":function(begin,end){
			player.currentTime(begin);
			player.play();
			viewendtime=end;
		},
		
		//切换视频源
		"switch":function(source){
			player.src(source);
		},
		
		//判断播放器是否是暂停
		"ispaused":function(){
			return player.paused();
		},
		
		//重新裁剪
		"retailoring":function(){
			$("#bt_videoedit_sure").css("display","flex");
			$("#bt_videoedit_retailoring").hide();
			
			$(".bt_videoedit_time").attr("src","/views/video/img/bt_videoedit_time.png");
			
			$("#bt_videoedit_time_start_div").css("display","flex");;
			$("#bt_videoedit_time_start_readonly_div").hide();
			
			$("#bt_videoedit_time_end_div").css("display","flex");;
			$("#bt_videoedit_time_end_readonly_div").hide();
			
			index=index-1;
			rows.splice(index,1);
			
			refresh();
		},
		
		
		//保存裁剪
		"saveRecord":function(){
			var startTime=$("#bt_videoedit_time_start_span").text();
			var endTime=$("#bt_videoedit_time_end_span").text();
			var videoSection=startTime+"-"+endTime;
			var videoLong=endTime-startTime;
			console.log(arr);
		},
		
		//设置自定义不支持浏览器执行的函数
		"setNotSupportFunction":function(fn){
			if( typeof fn ==='function'){
				fn();
			}
		}
	}
})();

