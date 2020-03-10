<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>广告管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<script type="text/javascript">
		var copyBeginTime = "${bean.copyBeginTime}";
		var copyEndTime = "${bean.copyEndTime}";
		var showTime = "${bean.showTime}";
	</script>
	<%@ include file="../common/import.jsp" %>
	<script type="text/javascript">
		var copyBeginTime = "${bean.copyBeginTime}";
		var tags="${bean.movieTag}";
		var movieId="${bean.movieId}";
		var tagType ="movie";
	</script>
	<script type="text/javascript" src="${basePath}/page/movie/showSaveMovie.js"></script>
	<script type="text/javascript" src="${basePath}/page/tags.js"></script>
	<link href="${basePath}/css/tags.css" rel="stylesheet">
	<!-- link href="${basePath}/page/movie/css/showSaveMovie.css" rel="stylesheet">-->
	<style>
	</style>

</head>
<body>
	<div class="container-fluid containe-update">
		<form id="form" role="form" method="post" class="form-horizontal" enctype="multipart/form-data">
			<input type="hidden" id="movieId" name="movieId" value="${bean.movieId}" />
			<input type="hidden" id="selectTags" name="selectTags" value="" />
			<!-- 电影名称 -->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>电影名称:
				</label>
				 <input type="text" name="movieName" id="movieName" class="form-control input_property_text" maxLength="10"  value="${bean.movieName}" />
			</div>
			<!-- 版权时间 -->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>版权时间:
				</label>
				<div style="display:inline-block;width: 51%;padding-left:10px;">
		        	<input type="text" id="datePick"  class="date-input-css search-datepicker-img" placeholder="请选择">
		        	<input type="hidden" id = "startTime" name="startTime" class="form-control" />
         	 		<input type="hidden" id = "endTime" name="endTime" class="form-control" />
	         	</div>
			</div>
			<!--  放映年份 -->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font> 放映年份:
				</label>
				<div style="display:inline-block;width: 51%;padding-left:10px;">
		        	<input type="text" id="singleDatePick" class="date-input-css search-datepicker-img" placeholder="请选择">
	         	</div>
			</div>
			<!--  标签 -->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font> 标签:
				</label>
				<div style="display:inline-block;width: 51%;padding-left:10px;">
					<div id="tags" style="display:flex;flex-flow:wrap "></div>
	         	</div>
			</div>
			<!-- 导演-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>导演 :
				</label>
				 <input type="text" name="director" id="director" class="form-control input_property_text" value="${bean.director}" />
			</div>
			<!-- 主演-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>主演 :
				</label>
				 <input type="text" name="mainActor" id="mainActor" class="form-control input_property_text"  value="${bean.mainActor}" />
			</div>
			<!-- 语言-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					语言 :
				</label>
				 <input type="text" name="language" id="language" class="form-control input_property_text" value="${bean.language}" />
			</div>
			<!-- 国家-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					国家 :
				</label>
				 <input type="text" name="national" id="national" class="form-control input_property_text" value="${bean.national}" />
			</div>
			<!-- 简介-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>简介 :
				</label>
				<textarea id="subdescription" name="subdescription"  class="description_textarea"  placeholder="请输入评论内容" class="" rows="5" >${bean.subdescription}</textarea>
			</div>
			<!-- 剧照-->
			<div class="form-group line-div">
				<label for="shopName" class="input_title_label">
					<font color="red">*</font>剧照 :
				</label>
				<c:forEach items="${bean.listStill}" var="still" varStatus="vs">  
					<img src="http://img5.iqilu.com/c/u/2018/1115/1542249302397.jpg" class="mutiple_photo_img"></img>
				</c:forEach>
			</div>
			
			<!--  
			<div class="form-group">
				<label for="advTime" class="input_label"><font color="red">*</font> 起止时间:</label>
				<div class="text-position" >
					<span class="datepicker">
						<input type="text" id="advTime" name="advTime" class="search-datepicker" placeholder="请选择" readonly="readonly" value="">
					</span>
				</div>
			</div>
			<div class="form-group">
				<label for="imgFile" class="input_label"><font color="red">*</font> 图片:</label>
				<div class= "input_file" style="width:40%;" id="imgFilediv"name="imgFilediv">
					<input id="imgFile" name="imgFile" type="file" class="file" >				
				</div>
			</div>
			<div class="form-group input_msg_div">
				<label class="input_label"></label>
				<span class="input_msg">
					图片大小不能超过500k，建议尺寸640*300，支持jpg、  jpeg格式
				</span>
			</div>
			-->
			<div class="form-group button_group line-div">
			    <label for="description" class="input_label"></label>
				<button class="btn submit-btn" onfocus="this.blur();" id="submit-button" type="submit" >保存</button>
				<button class="btn cancel-btn" onfocus="this.blur();" type="button"   onclick="cancelData();">重置</button>
			</div>
		</form>
	</div>
</body>
</html>
