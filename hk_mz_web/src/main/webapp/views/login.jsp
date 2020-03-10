<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
   	pageContext.setAttribute("path",path);
   	pageContext.setAttribute("basePath",basePath);
%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE>
<html>
	<head>
	<title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="keywords" content="海看媒资管理后台">
	<meta http-equiv="description" content="海看媒资管理后台">
	<script type="text/javascript" src="page/jquery-2.1.4.min.js"></script>
	<script type="text/javascript" src="page/common.js"></script>
	<script type="text/javascript" src="bootstrap/js/jquery.slideBox.js"></script>
	<link href="bootstrap/css/jquery.slideBox.css" rel="stylesheet" type="text/css" />
	<style>
		body{
			background-image: url(images/bg_login@2x.png);
			background-repeat:no-repeat; 
			background-size:100% 100%;
			-moz-background-size:100% 100%;
			background-color: #000000;
		}
		.div_main{
			width:1076px;
			height:706px;
			background:rgba(255,255,255,0.98);
			box-shadow:0px 0px 40px 0px rgba(152,146,192,0.3);
			border-radius:20px;
			position: absolute;
			left: 0;
			top: 0;
			bottom: 0;
			right: 0;
			overflow: hidden;
			margin: auto;
		}
		.image_main{
			width:538px;
			height:706px;
			display:inline-block;
		}
		.login_div{
			width:49%;
			height:100%;
			display:inline-block;
			float: right;
		}
		.logo_div{
			text-align: center;
			margin-top: 138px;
		}
		.logo_image{
			width: 186px;
			height: 94px;
		}
		.login_content_div{
			text-align: center;
			margin-top: 100px;
		}
		.login_name_span{
			display: block;
			height: 30px;
			border-bottom: 1px solid rgba(192,199,206,1);
			width: 300px;
			margin: auto;
			text-align: left;
		}
		.login_ico_span{
			text-align: center;
			vertical-align: sub;
			margin-left: 8px;
		}
		.login_ico_span{
			width:18px;
		}
		.login_input{
			padding-left: 10px;
			width: 230px;
			height: 30px;
			border: none;
			outline: none;
		}
		.login_delete_span{
			text-align: center;
			vertical-align: -webkit-baseline-middle;
			margin-left: 8px;
		}
		.login_delete_image{
			width:12px;
		}
		.login_checkbox_span{
			display:block;
		}
		.login_checkbox_parent{
			margin-left: 10px;
			width: 300px;
			display: block;
			margin-top: 10px;
		}
		.login_checkbox_lable{
			width:60px;
			height:20px;
			font-size:14px;
			font-weight:400;
			color:rgba(65,65,65,1);
			line-height:20px;
		}
	</style>
</head>
	<body>
		
		<div class="div_main">
			<div class="image_main" >
				<div class="slideBox" id="slideBox">
					<ul class="items">
						<li>
							<img style="width:538px;height:706px;"  src="images/im_login_banner01@2x.png"/>
						</li>
						<li>
							<img style="width:538px;height:706px;" src="images/im_login_banner02@2x.png"/>
						</li>
					</ul>
				</div>
			</div>
			<div class="login_div">
				<div class="logo_div">
					<img class="logo_image" src="images/ic_logo_login@2x.png" />
				</div>
				<div class="login_content_div">
					<span class="login_name_span">
						<span class="login_user_ico_span">
							<img class="login_ico_span" src="images/ic_yonghu_login01@2x.png"/>
						</span>
						<input type="text" name="loginName" id="loginName" class="login_input" />
						<span class="login_delete_span" style="display:none;"> 
							<img class="login_delete_image" src="images/bt_dl_shanchu@2x.png"/>
						</span>
					</span>
					<span style="display: block;height: 30px;border-bottom: 1px solid rgba(192,199,206,1);width: 300px;margin: auto;text-align: left; margin-top: 20px;">
						<span class="login_user_ico_span">
							<img class="login_ico_span" src="images/ic_mima_login01@2x.png"/>
						</span>
						<input type="password" name="password" id="password" style="width: 210px;" class="login_input"/>
						<span class="login_delete_span" style="display:none;">
							<img class="login_delete_image" src="images/bt_dl_shanchu@2x.png"/>
							<img class="login_delete_image" onclick="showPassword(this)" show="no" style="margin-left: 4px;" src="images/bt_dl_biyan@2x.png"/>
						</span>
					</span>
					<span class="login_checkbox_span">
						<span class="login_checkbox_parent">
							<span style="vertical-align: middle;">
								<img id="remenberUserCountImage" remenber="no" style="width:17px;height:17px;" src="images/bt_denglu_xuankuang@2x.png" />
							</span>
							<lable class="login_checkbox_lable" >记住密码</lable>
						</span>
					</span>
				</div>
				<div style="text-align: center;margin-top: 32px;">
					<img onclick="doLogin()" style = "width:287px;height:146px;" src="images/bt_login_denglu_anxia@2x.png">
				</div>
			</div>
		</div>
	</body>
	<script>
		var basePath = "${basePath}";
		$(document).ready(function(){
			$("input").focus(function(){
				if($(this).attr("name") == "loginName"){
					$(this).prev("span").children("img").attr("src","images/ic_yonghu_login02@2x.png");
				}else{
					$(this).prev("span").children("img").attr("src","images/ic_mima_login02@2x.png");
				}
				
				$(this).next("span").attr("style","display:inline-block;");
			});
			$('#slideBox').slideBox({
				hideBottomBar : true//隐藏底栏
			});
			
			$("#remenberUserCountImage").click(function(){
				if($(this).attr("remenber") == "no"){
					$(this).attr("src","images/bt_denglu_xuankuang02@2x.png");
					$(this).attr("remenber","yes")
				}else{
					$(this).attr("src","images/bt_denglu_xuankuang@2x.png");
					$(this).attr("remenber","no")
				}
				
			});
			$(".login_delete_image").click(function(){
				$(this).parent("span").prev("input").val("");
			});
		});
		function showPassword(data){
			if($(data).attr("show") == "no"){
				$(data).attr("src","images/bt_dl_zhengyan@2x.png");
				$("#password").attr("type","text");
				$(data).attr("show","yes");
			}else{
				$(data).attr("src","images/bt_dl_biyan@2x.png");
				$("#password").attr("type","password");
				$(data).attr("show","no");
			}
		}
		function test(data){
			console.log(data);
		}
		function doLogin(){
			var loginName = $("#loginName").val();
			var password = $("#password").val();
			if(loginName == null || loginName.length <= 0){
				return false ;
			}
			if(password == null || password.length <= 0){
				return false ;
			} 
		    $.ajax({
				type:"POST",
				url:basePath+'do_login',
				data:{"loginName":loginName,"password":password},
				success : function(result) {
					console.log(result);
					if(result.ok){
						window.location.href=basePath+"index";
					}
				}
		    });
			//$.MsgBox.Alert("消息", "哈哈，添加成功！");
			//$.MsgBox.Confirm("提示", "确定要进行修改吗？", test,"我是你大爷");
		}
	</script>
</html>