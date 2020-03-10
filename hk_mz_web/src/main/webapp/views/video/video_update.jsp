<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>查看</title>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript" src="${basePath}/views/video/js/video_update.js"></script>
	<style type="text/css">
		.display_label{
			    width: 90px;
			    float: left;
			    position: relative;
			    font-family: "PingFangSC-Regular";
			    text-align: right;
			    font-size: 14px;
			    color: #000000;
			    font-weight: 400;
			    opacity:0.6;
		}
		.display_content{
			    display: block;
			    position: relative;
			    padding-left: 90px;
			    left: 25px;
			    font-family: "PingFangSC-Regular";
			    text-align: left;
			    font-size: 14px;
			    color: #000000;
			    font-weight: 400;
			    width: 90%;
			    word-wrap: break-word;
			    word-break: normal;
			    line-height:20px;
		}
		.form-control{
			 border: 1px solid #E7E7F3;
			 width: 80%;
    		 height: 40px;
    		 margin-top:-8px;
		}
		
		.form-control:focus{
			border: 1px solid #5868DD;
			width: 80%;
    		height: 40px;
    		margin-top:-8px;
		}
		
		.video_tag_div{
			width:105px;
			height:32px;
			border:1px solid #E7E7F3;
			line-height:2.1;
			text-align:-webkit-center;
			float:left;
			margin-right:12px;
			margin-bottom:12px;
			border-radius:2px;
		}
		
		.video_tag_set{
			width:80px;
			height:32px;
			line-height:2.1;
			text-align:-webkit-center;
			float:left;
			margin-right:12px;
		}
		
		.video_tag_box{
		}
		
		textarea{
			width:100%;
			border-radius:2px;
			border:1px solid #E7E7F3;
			font-size:14px;
			font-family:"PingFangSC-Regular";
			color:#000000;
			opacity: 0.85;
			line-height:24px;
			font-weight:400;
		}
		
		textarea:focus{
			width:100%;
			border-radius:2px;
			border:1px solid #5868DD;
			font-size:14px;
			font-family:"PingFangSC-Regular";
			color:#000000;
			opacity: 0.85;
			line-height:24px;
			font-weight:400;
		}
		
		.has-success .form-control:focus{
			border-color: #5868DD;
		}
		
		.bv-form .help-block{
			font-family: "PingFangSC-Regular";
		    font-size: 14px;
		    margin-bottom: 0;
		    margin-left:115px;
		}
		.submit-btn {
		    height: 40px;
		    width: 80px;
		    background-color: #5868DD;
		    font-family: "PingFangSC-Regular";
		    font-size: 14px;
		    color: #ffffff;
		    border: none;
		    border-radius: 4px;
		    text-align: center;
		    padding-top: 5px;
		    position: relative;
		    left:0px;
		}
		
		.submit-btn:hover{
			 background-color: #6476F4;
		}
		
		.reset-btn {
		    height: 40px;
		    width: 80px;
		    background-color: #ffffff;
		    font-family: "PingFangSC-Regular";
		    font-size: 14px;
		    color: #222222;
		    border: 1px solid #5868DD;
		    border-radius: 4px;
		    text-align: center;
		    padding-top: 5px;
		    left: 0px; 
		    position: relative;
	    }
	    
	    .reset-btn:hover{
	    	background-color: #6476F4;
	    	color:#FFFFFF;
	    }
	</style>
	<script type="text/javascript">
		var videoTags="${bean.videoTag}";
		var result="${bean.result}";
		var resultInfo="${bean.resultInfo}";
	</script>
</head>
<body>
    <div class="container-fluid containe-update">
		<form id="form" method="post" class="form-horizontal" enctype="multipart/form-data" action="">
			<input type="hidden" id="result" 	 name="result"      value="${bean.result}" />
			<input type="hidden" id="resultInfo" 	 name="resultInfo"      value="${bean.resultInfo}" />
		
			<input type="hidden" id="videoId" name="videoId" value="${bean.videoId}" />
			
			<!-- 用于重置恢复数据使用 -->
			<input type="hidden" id="descriptionTmp" name="descriptionTmp"  value="${bean.description}" />
			<input type="hidden" id="imgUrlTmp" 	 name="imgUrlTmp"       value="${bean.imgUrl}" />
			<input type="hidden" id="isShareTmp" 	 name="isShareTmp"      value="${bean.isShare}" />
			<input type="hidden" id="videoNameTmp" 	 name="videoNameTmp"      value="${bean.videoName}" />
			
			
			<div class="form-group display_row">
				<span class="display_label"><span style="color:red;">*</span>成品名称:</span>
				<input type="text" name="videoName" id="videoName" class="form-control input_text" maxLength="40" value="${bean.videoName}" />
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">素材名称:</span>
				<span class="display_content">
					${bean.videoSourceName}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">标准:</span>
				<span class="display_content">
					${bean.standard}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">分类:</span>
				<span class="display_content">
					${bean.classifyName}
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label"><span style="color:red;">*</span>缩略图:</span>
				<div class="input_msg text-alignment" style="left:15px;">
					&nbsp;
				</div>
			</div>

			<div class="form-group display_row">
				<div style="position:relative;left:115px;width:40%;margin-top:-40px;">
					<img id="imgUrlImg" src="<%=basePath %>/${bean.imgUrl}" style="width:320px;height:180px;"/>
					<input type="hidden"  id="imgUrl"  name="imgUrl"  value="${bean.imgUrl}"/>
				</div>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">标签:</span>
				<span class="display_content">
				     <!-- 标签动态生成 -->
					<div id="video_tag_box" class="video_tag_box"></div>
				</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label">共享:</span>
				<span class="display_content">
					 <c:choose>
				         <c:when test="${bean.isShare=='1'}">
					         	<span onclick="chageIsShare('1')" style="cursor:pointer;">
					         		<img id="isShare_1" selected style="width:18px;height:18px;" src="../images/bt_danxuan_xuanzhong.png"/><span style="margin-left:5px;">是</span>
					         	</span>
					         	<span style="margin-left:40px;cursor:pointer;" onclick="chageIsShare('0')" >
					         		<img id="isShare_0" style="width:18px;height:18px;" src="../images/bt_danxuan.png"/><span style="margin-left:5px;">否</span>
					         	</span>
				         	</div>
				         </c:when>
				         
				         <c:when test="${bean.isShare=='0'}">
				         	<span onclick="chageIsShare('1')" style="cursor:pointer;">
				         		<img id="isShare_1" style="width:18px;height:18px;" src="../images/bt_danxuan.png"/><span style="margin-left:5px;">是</span>
				         	</span>
				         	<span style="margin-left:40px;cursor:pointer;" onclick="chageIsShare('0')" >
				         		<img id="isShare_0" selected style="width:18px;height:18px;" src="../images/bt_danxuan_xuanzhong.png"/><span style="margin-left:5px;">否</span>
				         	</span>
				         </c:when>
				         <c:otherwise>
				             <span onclick="chageIsShare('1')" style="cursor:pointer;" >
				         		<img id="isShare_1" selected style="width:18px;height:18px;" src="../images/bt_danxuan_xuanzhong.png"/><span style="margin-left:5px;">是</span>
				         	</span>
				         	<span style="margin-left:40px;cursor:pointer;" onclick="chageIsShare('0')"  >
				         		<img id="isShare_0" style="width:18px;height:18px;" src="../images/bt_danxuan.png"/><span style="margin-left:5px;">否</span>
				         	</span>
				        </c:otherwise>
					  </c:choose>
				</span>
			</div>
			
			<div class="form-group display_row">
					<span class="display_label">描述:</span>
					<span class="display_content">
						<textarea id="description" rows="6" cols="70" maxlength="800" >${bean.description}</textarea>
					</span>
			</div>
			
			<div class="form-group display_row">
				<span class="display_label"></span>
					<span class="display_content">
							<div style="float:left;width:80px;height:40px;margin-right:20px;">
								<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="save()">
									<span class="search-btn-span-serach" id="search-btn1">保存</span>
								</a>
							 </div>
							 
							 <div style="float:left;width:80px;height:40px;">
								<a href="javascript:void(0)" id="search" name="search" class="search-btn" data-toggle="collapse" onfocus="this.blur();" onclick="resetVal()">
									<span class="search-btn-span-reset " id="search-btn1">重置</span>
								</a>
							</div>
					</span>
			</div>
		</form>
	</div>
</body>
</html>
