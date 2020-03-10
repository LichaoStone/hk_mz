<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>简编</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/common.js"></script>
		<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
		<link href="${basePath}/videojs/video-js.css" rel="stylesheet">
		<!-- 透明度滑动条 -->		
		<link href="${basePath}/slider/bootstrap-slider.css" rel="stylesheet">
		<script type="text/javascript" src="${basePath}/slider/bootstrap-slider.min.js"></script>
		
		<!-- 视频  -->
		<script src="${basePath}/videojs/video.js"  type="text/javascript"></script>
		
		<script src="${basePath}/videojs/videojs-contrib-hls.min.js"  type="text/javascript"></script>
		<!-- 色值版 -->
		<script src="${basePath}/colorpicker/paigusu.min.js"  type="text/javascript"></script>
		<script>window.HELP_IMPROVE_VIDEOJS = false;</script>
		
		<script src="${basePath}/fileinput/fileinput.min.js"  type="text/javascript"></script>
		<link href="${basePath}/fileinput/fileinput.min.css" rel="stylesheet">
		
		<!-- 视频剪切条 -->
		<link href="${basePath}/videojs/sliderclip.css" rel="stylesheet">
		<script src="${basePath}/videojs/sliderclip.js"  type="text/javascript"></script>
		
		<script src="${basePath}/videojs/videoutil.js"  type="text/javascript"></script>
		<script src="${basePath}/views/video/js/watermark.js"  type="text/javascript"></script>
		<script src="${basePath}/views/video/js/ninebox.js"  type="text/javascript"></script>
		
		<script type="text/javascript" src="${basePath}/views/video/js/videosource_edit_list.js"></script>
		<link href="${basePath}/views/video/css/videosource_edit_list.css" rel="stylesheet">
	
	<script type="text/javascript">
	        var videoSourceId="${bean.videoSourceId}";
	        var videoSourceName="${bean.videoSourceName}";
	        var videoImgUrl="${bean.imgUrl}";
			var videoUrl="${bean.videoUrl}";
			var basePath="${basePath}";
			var resolution="${bean.resolution}";
	</script>
	</head>
<body>
	<div>
		<div style="height: 593px;width:100%;">
			<!-- 视频截取区域 -->
			<div style="float:left;top;0px;left:0px;border:1px solid #D4D4D4;border-radius:2px;width:50%;">
				   
				   <!-- 视频 -->
				   <div style="height: 60%;width: 100%;border:1px solid blue;position: relative;">
					   
					    <!--   -->
					    <video id="video-clip" class="video-js vjs-default-skin"  style="width:100%;height:100%;"  controls preload="auto" poster="">
					        <source src="http://vjs.zencdn.net/v/oceans.mp4">
					   	</video>
					   	
					   	<div id="video-watermark-position" style="position: absolute;top: 5%;left:5%;">
					   		 <img id="video_watermark_img"  class="video-watermark-img"   src=""  /> 
					   	</div>
				   </div>
				 
				   
				   <!-- 视频编辑区域 -->
				   <div style="height: 40%;width: 100%;border-top:1px solid #D4D4D4;">
				      	<!-- 开始/暂停、快进和快退按钮 -->
				      	<div style="height: 30%;">
				      		<div style="float:left;line-height:3;margin-top:15px;">
				      			<div style="float:left;line-height:3;cursor: pointer;" onclick="startAndStop()"><span style="margin-left:40px;"><img  id="start_stop_img" style="width:20px;height:20px;" src="/views/video/img/video_startandstop.png" /></span></div>
				      			<div style="float:left;line-height:3;cursor: pointer;" onclick="kuaitui()"><span style="margin-left:50px;"><img style="width:20px;height:20px;" src="/views/video/img/video_kuaitui.png" /></span></div>
				      			<div style="float:left;line-height:3;cursor: pointer;" onclick="kuaijin()"><span style="margin-left:30px;"><img style="width:20px;height:20px;" src="/views/video/img/video_kuaijin.png" /></span></div>
				      		</div>
				      		
				      		<div style="float:right;">
				      			<div style="border-left:1px solid #D4D4D4;border-bottom:1px solid #D4D4D4;color:#000000;opacity: 0.85;font-size:18px;font-weight:bold;line-height:22px;font-family:Helvetica-Bold;">
				      				<input id="video_currenttime_input" readonly style="text-align:center;width:150px;height: 32px;border:none;" type="text" value="00:00:00:000" />
				      			</div>
				      			<div style="border-left:1px solid #D4D4D4;color:#000000;opacity: 0.85;font-size:18px;font-weight:bold;line-height:22px;font-family:Helvetica-Bold;">
				      				<input id="video_alltime_input" readonly style="text-align:center;width:150px;height: 32px;border:none;" type="text" value="00:00:00:000" />
				      			</div>
				      		</div>
				      	</div>
				      	
				      	
				      	<!-- 截取区域 -->
				      	<div style="height: 70%;border-top: 1px solid #D4D4D4;display:flex;">
				      		<!-- 截取 -->
				      		<div style="float:left;width:15%;text-align:center; display: flex;justify-content:center;align-items:Center;height: 100%;">
						      		<span style="font-family:PingFangSC-Medium;color:#000000;opacity:0.85;font-size:16px;line-height:16px;font-weight:bold;">截取</span>
						    </div>
						    
						    <!-- 开始结束时间 -->
						    <div style="width:15%;display: flex;">
						    	<div style="justify-content: center;align-items: Center;display: flex;">
						    		<span>
						    			<span class="video-edit-section-span">开始时间:</span>
						    			<br>
						    			<br>
						    			<span class="video-edit-section-span">结束时间:</span>
						    		</span>
						    	</div>
						    </div>
						    
						    <!-- 开始和结束具体时间 -->
						    <div style="width:25%;display: flex;text-align: center;margin-left:30px;">
						    	<div style="justify-content: center;align-items: Center;display: flex;">
						    		<span>
						    			<span class="video-edit-section-span">00:00:00.000</span>
						    			<br>
						    			<br>
						    			<span class="video-edit-section-span">00:00:00.000</span>
						    		</span>
						    	</div>
						    </div>
						    
						    <!-- 开始和结束时间图标 -->
						    <div style="width:8%;display: flex;">
						    	<div style="justify-content: center;align-items: Center;display: flex;">
						    		<span>
						    			<span><img class="bt_videoedit_time" style="height:26px;width:26px;margin-top:2px;" src="/views/video/img/bt_videoedit_time2.png" /></span>
						    			<br>
						    			<br>
						    			<span><img class="bt_videoedit_time" style="height:26px;width:26px;margin-top:2px;" src="/views/video/img/bt_videoedit_time2.png" /></span>
						    		</span>
						    	</div>
						    </div>
						    
						    <!-- 获取当前播放时间点 -->
						    <div style="width:20%;display: flex;margin-left:3px;">
						       <div style="justify-content: center;align-items: Center;display: flex;">
						    		<span>
						    			<span class="video-gettime-span">获取视频</span>
							    		<br>
							    		<span class="video-gettime-span">当前播放时间点</span>
							    		
							    		<br>
							    		<br>
							    		
							    		<span class="video-gettime-span">获取视频</span>
							    		<br>
							    		<span class="video-gettime-span">当前播放时间点</span>
						    		</span>
						    	</div>
						    </div>
						    
						    <!-- 保存和重新截取按钮 -->
						    <div style="width:20%;display: flex;">
						    	 <div id="bt_videoedit_sure" style="line-height: 2.5;justify-content:center;align-items:Center;display:none;" onclick="videoUtil.saveRecord(this)">
										<span class="search-btn-span-sure" id="search-btn1">保存</span>
								 </div>
								 
								 <div id="bt_videoedit_retailoring" style="justify-content: center;align-items: Center;display: flex;" onclick="videoUtil.retailoring()">
										<span class="search-btn-span-retailoring" id="search-btn1">重新截取</span>
								 </div>
						    </div>
				      	</div>
				      	
				   </div>
			</div>
		   
		    
			<!-- 视频记录和水印叠加区域 -->
			<div id="video-edit-div" class="video-edit-log-div" style="float:left;width:50%;height:100%;display:block;display:inline-block;padding-left:15px;">
				 <!-- 视频和水印叠加 -->
				 <div class="tab-toggle" style="height:10%;">
				 	<div id="table-tab-vido-div" onclick="watermark.toggleVideoWatermark('table-tab-vido-div')" class="table-tab table-tab-selected"><span style="font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:25px;">视频</span></div>
				 	<div id="table-tab-watermark-div" style="border-radius:0px 4px 4px 0px;" onclick="watermark.toggleVideoWatermark('table-tab-watermark-div')" class="table-tab" ><span style="font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:25px;">水印叠加</span></div>
				 </div>
				 
				 <p style="clear:both"></p><!-- 防止div漂移 -->
				 
				 <!-- 视频截取记录展示区域 -->
				 <div id="video_edit_log_div" style="overflow: auto;display:inline-block;height:88%;margin-top:-20px;">
				 	<table id="dataTable">
				 		<thead>
							<tr>
							    <th data-width="4%"  data-formatter="setIndex" data-width="10%" data-align="center">序号</th>
								<th data-field="videoSourceName" data-width="20%" data-align="left">视频名称</th>
								<th data-field="videoSection" data-width="50%" data-align="left">在成品视频中的时间</th>
								<th data-field="videoLong" data-width="20%" data-align="left">截取时长</th>
							</tr>
						</thead>
				 	
				 	</table>
				 </div>
				
				
				 <!-- 水印叠加区域 -->
				 <div id="video-edit-wartermark-div" style="display:none;">
					 
					 <!-- 按钮:图片和文字 -->
					 <div id="video_edit_watermark_radio">
					 	 <div style="float:left;" data-type="img" class="bt-radio bt-radio-selected" onclick="watermark.toggleImgWord('video_edit_watermark_radio_img')" >
					 	 	<img id="video_edit_watermark_radio_img" src="/views/video/img/bt_radio_selected.png" style="width:18px;height:18px;" />
					 	 	<span>图片</span>
					 	 </div>
					 	 
					 	 <div style="float:left;margin-left:30px;" data-type="word" class="bt-radio" onclick="watermark.toggleImgWord('video_edit_watermark_radio_word')" >
					 	 	<img id="video_edit_watermark_radio_word" src="/views/video/img/bt_radio.png" style="width:18px;height:18px;" />
					 	 	<span>文字</span>
					 	 </div>
					 	 
					 	 <!--  
					 	     <span><input type="radio" name="video_edit_watermark_radio" checked />图片</span>
					 	     <span><input type="radio" name="video_edit_watermark_radio" />文字</span>
					 	 -->
					 </div>
					 
					 
					 <p style="clear:both"></p><!-- 防止div漂移 -->
					 
					 <div id="video_edit_watermark_img_span">
							<span style="font-size:12px;font-family:PingFangSC-Regular;font-weight:400;color:#000000;opacity: 0.45;line-height:20px;">图片格式:jpg、jpeg、gif、png。图片大小:1M</span>
					 </div>
					 
					
					 <!-- 水印图片区域 -->
					 <div id="video_edit_watermark_img_box"  style="display:block;height:218px;border:1px solid #D4D4D4;margin-top:15px;" >
					 		<div style="width:100%;height: 160px;">
					 			<!-- 添加图片 -->
					 			<div style="height: 80%;width:100%;text-align:center;cursor: pointer;" onclick="addImgFile()">
					 				<div>
					 					<img id="addImgFile" src="/views/video/img/ic_img_add.png"  style="width: 60px;height: 60px;" />
					 				</div>
					 			</div>
					 		    
					 		    
					 		    <!-- 透明度滚动条 -->
					 			<div class='video-slider' style="width: 100%;border-top:1px solid #D4D4D4;">
					 				<div style="padding-left:15px;padding-right:15px;">
					 					<div>
					 						<div style="float:left;">
					 							<span style="color:#000000;opacity: 0.85;">透明度:</span>
					 						</div>
					 						
					 						<div style="float:right;">
					 							<span>
					 								<input id="transparent_img_slider_value" value="100%" style="width:44px;height:20px;text-align:center;" />
					 							</span>
					 						</div>
					 					</div>
					 					
					 					<p style="clear:both"></p><!-- 防止div漂移 -->
					 						
			 						    <div>
			 						  	   <input id="transparent_img_slider" type="text" data-slider-min="10" data-slider-max="100" data-slider-step="1" data-slider-value="55"/>
			 						    </div>
					 				</div>
					 			</div>
					 		</div>
					 		
					 </div>
					 
					 
					 <!-- 水印文字区域 -->
					 <div id="video_edit_watermark_word_box" style="display:none;">
					 	 	 <div>
							 	 <input type="text" id="video_edit_watermark_input"  oninput="wartermarkInputChange(this)" style="width: 260px;height:32px;color:black;" value="" />
							 	 <br />
							 	 <span style="color:#000000;font-size:12px;font-family:PingFangSC-Regular;font-weight:400;line-height:20px;opacity:0.45;">最少输入20个字</span>
							 </div>
							 
							 <!-- 颜色值 -->
							 <div style="border:1px solid #D4D4D4;margin-top:18px;">
								 <div style="margin-top: 18px;">
								 	  <div>
									 	 	<div style="float:left;margin-left:15px;">
									 	 		<div>
									 	 			<span style="color:#000000;opacity: 0.85;font-size:16px;font-family:PingFangSC-Regular;font-weight:400;line-height:16px;">字体颜色</span>
									 	 		</div>
									 	 		
									 	 		<div style="margin-top:10px;">
									 	 			<span style="color:#000000;opacity: 0.3;font-size:12pxfont-weight:400;font-family:PingFangSC-Regular;line-height:12px;">点击右侧色板更改色值</span>
									 	 		</div>	
									 	 	</div>
									 	 	
									 	 	<div id="color-box" style="float:right;width:44px;height: 44px;margin-right:15px;">
									 	 		<button class="paigusu" style="padding:5px 20px;background: black;border: 1px solid #ccc;border-radius:4px;height:44px;width:44px;"></button>
									 	 	</div>
								 	  </div>
							 	 </div>
							 	 
							 	 
					 			<!-- 透明度滚动条 -->
					 			<div style="width: 100%;;padding-top:50px;">
						 				<div style="padding-left:15px;padding-right:15px;">
						 					<div style="padding-top:15px;">
							 						<div style="float:left;">
							 							<span style="color:#000000;opacity: 0.85;">透明度:</span>
							 						</div>
							 						
							 						<div style="float:right;">
							 							<span>
							 								<input id="transparent_word_slider_value" value="100%" style="width:44px;height:20px;text-align: center;" />
							 							</span>
							 						</div>
						 					 </div>
						 					
						 					 <p style="clear:both"></p><!-- 防止div漂移 -->
						 						
				 						     <div style="margin-bottom:10px;">
				 						  	     <input id="transparent_word_slider" type="text" data-slider-min="10" data-slider-max="100" data-slider-step="1" data-slider-value="55"/>
				 						     </div>
						 				</div>
						 			</div>
				 			 </div>
						</div>
					
				
					<!-- 快速定位摆放的位置 -->
		 			<div style="width: 100%;height: 155px;border:1px solid #D4D4D4;margin-top:22px;">
			 				<div style="height: 11px;width:100%;padding-top:12px;margin-left:20px;">
			 					<span style="font-size:12px;font-family:PingFangSC-Regular;font-weight:400;line-height:12px;color:#000000;opacity:0.85;">快速定位摆放位置</span>
			 				</div>
			 				
			 				<!-- 九宫格位置 -->
			 				<div id="ninebox"></div>
		 			</div>
		 			
		 			
		 			<!-- 水印大小 -->
		 			<div style="width: 100%;border-left:1px solid #D4D4D4;border-right:1px solid #D4D4D4;border-bottom:1px solid #D4D4D4;">
			 				<div style="padding-left:15px;padding-right:15px;">
				 					<div style="padding-top:15px;">
				 						<div style="float:left;">
				 							<span style="color:#000000;opacity: 0.85;">水印大小:</span>
				 						</div>
				 						
				 						<div style="float:right;">
				 							<span>
				 								<input id="wartermark_slider_value" value="100%" style="width:44px;height:20px;text-align: center;" />
				 							</span>
				 						</div>
				 					</div>
				 					
				 					<p style="clear:both"></p><!-- 防止div漂移 -->
				 						
		 						    <div style="margin-bottom:10px;">
		 						  	     <input id="wartermark_slider" type="text" data-slider-min="10" data-slider-max="100" data-slider-step="1" data-slider-value="55"/>
		 						    </div>
			 				</div>
		 			</div>
		 			
		 			
		 		</div>	
			</div>
		</div>
		
		<!-- 分割线 -->
		<div style="width:100%;border:1px dashed #D4D4D4;margin-top:10px;margin-bottom:10px;"></div>
		
		<!-- 添加视频区域 -->
		<div class="video-add-show-div">
			<div>
				<span style="color:#000000;font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:14px;">视频名称</span>
				<span style="color:#000000;opacity: 0.45;font-size:14px;font-family:PingFangSC-Regular;font-weight:400;line-height:14px;">最多可新增20个视频</span>
			</div>
			
			<!-- 新添加的视频 -->
			<div style="margin-top:10px;">
					<div id="add_video_show_box" >
						<!--  
						<div  id="video_add_div_1" class="video-add-div video-add-div-selected" onclick="videoChange('video_add_div_1')">
							<div style="height: 80%;width:100%;">
								<img id="video_add_img_1" style="height:100%;width:100%;" src="https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=421324374,3028217137&fm=173&app=49&f=JPEG?w=500&h=312&s=A8D4824ED66A151F8F8079BB0300C014" />
							</div>
							<div style="height: 20%;width:100%;text-align:center;">
								<span id="video_add_span_1">${bean.videoSourceName}</span>
							</div>
						</div>
					
					    
					    <div style="float:left;margin-left:15px;margin-top:60px;margin-right:15px;">
							<span>
								<img style="height: 13px;width:15px;" src="/views/video/img/video_add_next.png"  />
							</span>
						</div>
						 -->
						 
				    </div>
				   
				      
				    <!-- 添加视频 -->
				    <div style="width:170px;height: 155px;border:2px solid #5868DD;float:left;cursor: pointer;" onclick="toAddVideo()" >
				    	 <div style="margin-top:60px;margin-left:40px;">
				    	 	<div class="add_arrow" style="float:left;"></div>
				    	 
					    	 <div style="float:left;margin-left:15px;">
					    	 	<span>添加视频</span>
					    	 </div>
				    	 </div>
				    </div>
				    
				    <!-- 导出视频按钮 -->
				    <div style="float:left;margin-left:15px;margin-top: 45px;cursor:pointer;" onclick="exportVideo()">
				    	<div style="width:80px;height:40px;border-radius:4px;background-color: #5868DD;color:#FFFFFF;text-align:center;line-height:2.5;"><span>导出视频</span></div>
				    </div>
			</div>
		</div>
	</div>
	
	<div style="display:none;">
		<input id="imgFile" name="imgFile" type="file" multiple class="file"  >
	</div>
</body>
</html>

<script type="text/javascript">
	// 效果图控件初始化
	var imgFileJson = {
			language: 'zh', // 设置语言
			uploadUrl:  'http://localhost:8080/videoSource/uploadImg', // 上传的地址,添加该参数后上传按钮为ajax提交，去掉为submit提交
			uploadAsync: true, //默认异步上传
			allowedFileExtensions : ['jpg', 'jpeg','JPG','JPEG','png'], // 接收的文件后缀
			showUpload: true, // 是否显示上传按钮
			showCaption: true, // 是否显示标题
			maxFileCount: 1,
			dropZoneEnabled:true,
			msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
			overwriteInitial: false,
			dropZoneEnabled: true,//是否显示拖拽区域
			maxFileSize: 500, // 单位为kb，如果为0表示不限制文件大小
			slugCallback: function(filename) {
				return filename.replace('(', '_').replace(']', '_');
			}
	}
	
	if(videoUrl!=null&&videoUrl!=""){
		imgFileJson['initialPreview'] = "<img src='"+videoUrl+"' class='file-preview-image'>";
	}
	
	$("#imgFile").fileinput(imgFileJson).on('filebatchselected', function (event, files) {//选中文件事件
	     	console.log("filebatchselected");
            $(this).fileinput("upload");
        }).on("fileuploaded", function (event, data, previewId, index){
            
            var arr=data.response.results.rows;
            $.each(arr,function(i,item){
            	var imgUrl=item.imgUrl
            	var imgWidth=item.imgWidth;
            	var imgHeight=item.imgHeight;
            	
            	console.log("图片宽度:"+imgWidth);
            	console.log("图片高度:"+imgHeight);
            	
            	$("#addImgFile").attr("src",basePath+imgUrl);
            	$("#addImgFile").attr("style","width:60%;height:160px;");
            	
                
            	//添加水印图片到
            	var width=resolution.split("*")[0];
            	var height=resolution.split("*")[1];
            	
            	
            	console.log("分辨率width:"+width);
            	console.log("分辨率height:"+height);
            	console.log((imgWidth/width)*100+"%");
            	console.log((imgHeight/height)*100+"%");

            	$("#video_watermark_img").attr("src",basePath+imgUrl);
            	$("#video_watermark_img").css("width",imgWidth);
            	$("#video_watermark_img").css("height",imgHeight);
            	
            	
            	//在视频区域展示水印图片效果
           		$("#video_watermark_img").show();
           		
           		//标志已经上传了水印图片
           		isUploadWatermark=true;
            });
            
	}).on('fileerror', function(event, data, msg) {//异步上传失败结果处理
		 alert("uploadError");
	});
</script>