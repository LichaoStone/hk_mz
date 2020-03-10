<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>提示</title>
	<%@ include file="../common/import.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<link href="${basePath}/views/video/css/common.css" rel="stylesheet">
	<style type="text/css">
		span{
			font-weight:400;
			color:#000000;
			line-height:37px;
			font-size:14px;
			font-family:PingFangSC-Regular;
		}
	</style>
</head>
<body>
	<div>
		<span style="margin-left: 15px;">请选择下载视频的标准:</span>
	</div>   
	<div id="video_show_div">
		<c:if test="${bean.videoUrl1080 !=null and bean.videoUrl1080!='' }" >
			<div onclick="selectStandard('video1080')" style="cursor: pointer;">
				<img id="video1080_img" style="width:18px;height:18px;margin-left: 15px;" src="../images/bt_danxuan.png"/><span style="margin-left:10px;">超清</span>
			</div>
		</c:if>
		
		<c:if test="${bean.videoUrl720 !=null and bean.videoUrl720!='' }" >
			<div onclick="selectStandard('video720')" style="cursor: pointer;">
				<img id="video720_img" style="width:18px;height:18px;margin-left: 15px;" src="../images/bt_danxuan.png"/><span style="margin-left:10px;">高清</span>
			</div>
		</c:if>
		
		
		<c:if test="${bean.videoUrl480 !=null and bean.videoUrl480!='' }" >
			<div onclick="selectStandard('video480')" style="cursor: pointer;">
				<img id="video480_img" style="width:18px;height:18px;margin-left: 15px;" src="../images/bt_danxuan.png"/><span style="margin-left:10px;">标清</span>
			</div>
		</c:if>
	</div>
	
	<!-- 按纽栏 -->
	<div style="text-align:-webkit-right;">
	    <div class="search-btn-span-cancel" onclick="parent.closeModal()" >
				<span  id="cancel-btn">取消</span>
		</div>
			
		<div class="search-btn-span-sure" onclick="sure()">
			   <span  id="sure-btn" style="color:#FFFFFF;">确定</span>
		</div>
	</div>
	
	<div style="display:none;">
		<a id="video480_a"  href="${bean.videoUrl480}" download >11</a>
		<a id="video720_a"  href="${bean.videoUrl720}" download >22</a>
		<a id="video1080_a" href="${bean.videoUrl1080}" download >33</a>
	</div>
</body>
</html>
<script type="text/javascript">
    //选择需要下载视频清晰度
	function selectStandard(videoId){
		if($("#"+videoId+"_img").hasClass("selected")){//选中状态
			$("#"+videoId+"_img").removeClass("selected");
			$("#"+videoId+"_img").attr("src","../images/bt_danxuan.png");
		}else{
			$("#"+videoId+"_img").attr("src","../images/bt_danxuan_xuanzhong.png");
			$("#"+videoId+"_img").addClass("selected");
		}
	}
	
	//确认按钮
	//下载视频
	function sure(){
		$("#video_show_div").find("img").each(function(i,item){
			console.log(i);
			console.log(item.id);
			
			if($("#"+item.id).hasClass("selected")){
				var downloadId=item.id.replace("_img","_a");
				console.log("下载ID:"+downloadId);
				$("#"+downloadId)[0].click();
			}
		});
		
		parent.closeModal();
	}
</script>
