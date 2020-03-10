<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
		<title>设置标签</title>
		<%@ include file="../common/import.jsp" %>
		<script type="text/javascript" src="${basePath}/views/video/js/video_tag_list.js"></script>
		<script type="text/javascript" src="${basePath}/views/video/js/common.js"></script>
		<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
	</head>
	<script type="text/javascript">
		parent.level_editor = "2";
		var videoTag="${bean.videoTag}";
	</script>
	<style>
		.tags_show_title{
			font-size:14px;
			font-family:PingFangSC-Regular;
			font-weight:400;
			color:#000000;
			line-height:14px;
			opacity: 0.6;
		}
		.tags_show_content{
			margin-top:20px;
		}
		.tag-btn{
			float:left;
			width:105px;
			height:40px;
			border:1px solid #5868DD;
			border-radius:4px;
			font-size:14px;
			font-family:PingFangSC-Regular;
			font-weight:400;
			line-height:20px;
			color:#5868DD;
			text-align:-webkit-center;
			line-height:37px;
			margin-right:10px;
			margin-bottom:10px;
			cursor: pointer;
		}
		
		.selected{
			color:#FFFFFF;
			background-color: #5868DD;
		}
	</style>
<body>
	<div  class="container-fluid containe-update">
			<div >
				<div style="color:#000000;font-size:18px;font-family:PingFangSC-Regular;font-weight:400;line-height:16px;width:90%;">
					<div style="float:left;">已选标签:</div>
					<div  id="tags_selected_span"></div>
				</div>
				
				<p style="clear:both"></p><!-- 防止div漂移 -->
				
				<div style="margin-top:10px;">	
					<span style="font-size:14px;font-weight:400;line-height:14px;">每个视频最多可选择20个标签</span>
				</div>
			</div>
			
			<div  class="search-btn-span-sure" style="position:absolute;top:20px;left:650px;" onclick="sure()" >
				  <span  id="sure-btn" style="color:#FFFFFF;line-height:37px;">保存</span>
			</div>
		
		
		<!-- 分割线 -->
		<div style="width:100%;height:2px;border:1px solid #E7E7F3;margin-top:15px;margin-bottom:10px;"></div>
		
		
		<div style="margin-top:20px;">
			<!-- A、B、C、D、E、F -->
			<div id="tags_show_A2F" style="display:none;">
				<div id="tags_show_title_A2F" class="tags_show_title" ><span>A、B、C、D、E、F</span></div>
				<div id="tags_show_content_A2F" class="tags_show_content"></div>
			</div>
			
			<p style="clear:both"></p><!-- 防止div漂移 -->
			
			<!-- G、H、I、J、K、L-->
			<div id="tags_show_G2L" style="display:none;">
				<div id="tags_show_title_G2L" class="tags_show_title" ><span>G、H、I、J、K、L</span></div>
				<div id="tags_show_content_G2L" class="tags_show_content"></div>
			</div>
			
			<p style="clear:both"></p><!-- 防止div漂移 -->
			
			<!-- M、N、O、P、Q -->
			<div id="tags_show_M2Q" style="display:none;">
				<div id="tags_show_title_M2Q" class="tags_show_title" ><span>M、N、O、P、Q</span></div>
				<div id="tags_show_content_M2Q" class="tags_show_content"></div>
			</div>
			
			<p style="clear:both"></p><!-- 防止div漂移 -->
			
			<!-- R、S、T、U、V、W -->
			<div id="tags_show_R2W" style="display:none;">
				<div id="tags_show_title_R2W" class="tags_show_title" ><span>R、S、T、U、V、W</span></div>
				<div id="tags_show_content_R2W" class="tags_show_content"></div>
			</div>
			
			<p style="clear:both"></p><!-- 防止div漂移 -->
			
			<!-- X、Y、Z -->
			<div id="tags_show_XYZ" style="display:none;">
				<div id="tags_show_title_XYZ" class="tags_show_title" ><span>X、Y、Z</span></div>
				<div id="tags_show_content_XYZ" class="tags_show_content"></div>
			</div>
		</div>
	</div>
</body>
</html>